package com.custom.login;

import com.custom.login.constants.MyCustomLoginPortletKeys;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "javax.portlet.name=MyLoginPortlet",
                "javax.portlet.name=" + MyCustomLoginPortletKeys.MYCUSTOMLOGIN,
                "mvc.command.name=/login/login"
        },
        service = MVCActionCommand.class
)
public class MyLoginMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest,
                                   ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        HttpServletRequest request = PortalUtil.getOriginalServletRequest(
                PortalUtil.getHttpServletRequest(actionRequest));

        HttpServletResponse response = PortalUtil.getHttpServletResponse(
                actionResponse);

        String login = ParamUtil.getString(actionRequest, "login");
        String usn = ParamUtil.getString(actionRequest, "usn");
        String password = actionRequest.getParameter("password");
        boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
        String authType = CompanyConstants.AUTH_TYPE_EA;
        
        User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), login);
        
        String expandoValue = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),User.class.getName(), 
        		ExpandoTableConstants.DEFAULT_TABLE_NAME ,"usn",user.getUserId(),StringPool.BLANK);
        
        
    	  if(usn.equalsIgnoreCase(expandoValue)){
    		  AuthenticatedSessionManagerUtil.login(
                request, response, login, password, rememberMe, authType);

    	  }else {
    		  AuthenticatedSessionManagerUtil.login(
    	                request, response, login, password, rememberMe, authType);
    	  }
        actionResponse.sendRedirect(themeDisplay.getPathMain());
    }

}