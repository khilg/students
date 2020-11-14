package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+StudentPortletKeys.STUDENT,
			"mvc.command.name=/filter/byEmail",
			"mvc.command.name=/search/byName"

		},
		service = MVCActionCommand.class
	)
public class FilterActionCommand extends BaseMVCActionCommand{

	Log log = LogFactoryUtil.getLog(FilterActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String filterEmail = ParamUtil.getString(actionRequest, "filterEmail");
		String searchedName = ParamUtil.getString(actionRequest, "searchName");
        log.info("EmailId from view.jsp :: filterEmail : "+filterEmail);
		log.info("SearchedName from view.jsp :: searchedName : "+searchedName);
        
        actionResponse.setRenderParameter(
                "filterEmail", filterEmail);
		actionResponse.setRenderParameter(
				"searchedName", searchedName);
		
	}

}
