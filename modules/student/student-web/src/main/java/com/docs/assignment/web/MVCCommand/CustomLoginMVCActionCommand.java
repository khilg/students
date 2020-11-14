package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.CookieNotSupportedException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Peter Fellwock
 */
@Component(
	property = {
		"javax.portlet.name=" + StudentPortletKeys.FAST_LOGIN,
		"javax.portlet.name=" + StudentPortletKeys.LOGIN,
		 "service.ranking:Integer=2200",
		"mvc.command.name=/login/login"
	},
	service = MVCActionCommand.class
)
public class CustomLoginMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		_log.info("CustomLoginMVCActionCommand :: doProcessAction");
		/*
		 * if (PropsValues.AUTH_LOGIN_DISABLED) { actionResponse.sendRedirect(
		 * themeDisplay.getPathMain() + PropsValues.AUTH_LOGIN_DISABLED_PATH);
		 * 
		 * return; }
		 */
		/*if (actionRequest.getRemoteUser() != null) {
			actionResponse.sendRedirect(themeDisplay.getPathMain());

			return;
		}*/

		try {
			login(themeDisplay, actionRequest, actionResponse);

			boolean doActionAfterLogin = ParamUtil.getBoolean(
				actionRequest, "doActionAfterLogin");

			if (doActionAfterLogin) {
				LiferayPortletResponse liferayPortletResponse =
					_portal.getLiferayPortletResponse(actionResponse);

				PortletURL renderURL = liferayPortletResponse.createRenderURL();

				renderURL.setParameter(
					"mvcRenderCommandName", "/login/login_redirect");

				actionRequest.setAttribute(
					WebKeys.REDIRECT, renderURL.toString());
			}
		}
		catch (Exception e) {
			if (e instanceof AuthException) {
				Throwable cause = e.getCause();

				if (cause instanceof PasswordExpiredException ||
					cause instanceof UserLockoutException) {

					SessionErrors.add(actionRequest, cause.getClass(), cause);
				}
				else {
					if (_log.isInfoEnabled()) {
						_log.info("Authentication failed");
					}

					SessionErrors.add(actionRequest, e.getClass());
				}
			}
			else if (e instanceof CompanyMaxUsersException ||
					 e instanceof CookieNotSupportedException ||
					 e instanceof NoSuchUserException ||
					 e instanceof PasswordExpiredException ||
					 e instanceof UserEmailAddressException ||
					 e instanceof UserIdException ||
					 e instanceof UserLockoutException ||
					 e instanceof UserPasswordException ||
					 e instanceof UserScreenNameException ) {
				SessionErrors.add(actionRequest, e.getClass(), e);
			}else if (e instanceof UsnNotFoundException) {
				_log.info("Thrown Exception "+e.getClass());
				SessionErrors.add(actionRequest, "UsnNotFoundException");
			}
			else {
				_log.error(e, e);

				_portal.sendError(e, actionRequest, actionResponse);

				return;
			}

			postProcessAuthFailure(actionRequest, actionResponse);

			hideDefaultErrorMessage(actionRequest);
		}
	}

	protected String getCompleteRedirectURL(
		HttpServletRequest httpServletRequest, String redirect) {

		HttpSession session = httpServletRequest.getSession();

		Boolean httpsInitial = (Boolean)session.getAttribute(
			WebKeys.HTTPS_INITIAL);

		String portalURL = null;

		if (/*
			 * PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS &&
			 * !PropsValues.SESSION_ENABLE_PHISHING_PROTECTION &&
			 */
			(httpsInitial != null) && !httpsInitial.booleanValue()) {

			portalURL = _portal.getPortalURL(httpServletRequest, false);
		}
		else {
			portalURL = _portal.getPortalURL(httpServletRequest);
		}

		return portalURL.concat(redirect);
	}

	protected void login(
			ThemeDisplay themeDisplay, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		HttpServletRequest httpServletRequest =
			_portal.getOriginalServletRequest(
				_portal.getHttpServletRequest(actionRequest));

		if (!themeDisplay.isSignedIn()) {
			HttpServletResponse httpServletResponse =
				_portal.getHttpServletResponse(actionResponse);

			String login = ParamUtil.getString(actionRequest, "login");
			_log.info("Login email ID :: "+login);
			String password = actionRequest.getParameter("password");
			String usn = ParamUtil.getString(actionRequest, "usn");
			boolean rememberMe = ParamUtil.getBoolean(
				actionRequest, "rememberMe");

			String portletId = _portal.getPortletId(actionRequest);

			PortletPreferences portletPreferences =
				PortletPreferencesFactoryUtil.getStrictPortletSetup(
					themeDisplay.getLayout(), portletId);

			String authType = portletPreferences.getValue("authType", null);

			User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), login);
	        
	        String expandoValue = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),User.class.getName(), 
	        		ExpandoTableConstants.DEFAULT_TABLE_NAME ,"usn",user.getUserId(),DEFAULT_DATA); //test is the default data value.
	        
	        if(usn.equalsIgnoreCase(expandoValue)) {
			_authenticatedSessionManager.login(
				httpServletRequest, httpServletResponse, login, password,
				rememberMe, authType);
			
	        }else {
	        	throw new UsnNotFoundException();
	        }
		}

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			if (!themeDisplay.isSignedIn()) {
				LiferayPortletResponse liferayPortletResponse =
					_portal.getLiferayPortletResponse(actionResponse);

				String portletId = _portal.getPortletId(actionRequest);

				PortletURL actionURL = liferayPortletResponse.createActionURL(
					portletId);

				actionURL.setParameter(
					ActionRequest.ACTION_NAME, "/login/login");
				actionURL.setParameter(
					"saveLastPath", Boolean.FALSE.toString());
				actionURL.setParameter("redirect", redirect);

				actionRequest.setAttribute(
					WebKeys.REDIRECT, actionURL.toString());

				return;
			}

			redirect = _portal.escapeRedirect(redirect);

			if (Validator.isNotNull(redirect) &&
				!redirect.startsWith(Http.HTTP)) {

				redirect = getCompleteRedirectURL(httpServletRequest, redirect);
			}
		}

		String mainPath = themeDisplay.getPathMain();

		if (/*PropsValues.PORTAL_JAAS_ENABLE*/Validator.isNotNull(redirect)) {
			if (Validator.isNotNull(redirect)) {
				redirect = mainPath.concat(
					"/portal/protected?redirect="
				).concat(
					URLCodec.encodeURL(redirect)
				);
			}
			else {
				redirect = mainPath.concat("/portal/protected");
			}

			actionResponse.sendRedirect(redirect);
		}
		else {
			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
			else {
				boolean doActionAfterLogin = ParamUtil.getBoolean(
					actionRequest, "doActionAfterLogin");

				if (doActionAfterLogin) {
					return;
				}

				actionResponse.sendRedirect(mainPath);
			}
		}
	}

	protected void postProcessAuthFailure(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(actionRequest);

		String portletName = liferayPortletRequest.getPortletName();

		Layout layout = (Layout)actionRequest.getAttribute(WebKeys.LAYOUT);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			actionRequest, liferayPortletRequest.getPortlet(), layout,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			portletURL.setParameter("redirect", redirect);
		}

		String login = ParamUtil.getString(actionRequest, "login");

		if (Validator.isNotNull(login)) {
			SessionErrors.add(actionRequest, "login", login);
		}

		if (portletName.equals(StudentPortletKeys.LOGIN)) {
			portletURL.setWindowState(WindowState.MAXIMIZED);
		}
		else {
			portletURL.setWindowState(actionRequest.getWindowState());
		}

		actionResponse.sendRedirect(portletURL.toString());
	}

	private static final Log _log = LogFactoryUtil.getLog(
			CustomLoginMVCActionCommand.class);

	@Reference
	private AuthenticatedSessionManager _authenticatedSessionManager;

	@Reference
	private Portal _portal;
	
	private String DEFAULT_DATA = "test";

}