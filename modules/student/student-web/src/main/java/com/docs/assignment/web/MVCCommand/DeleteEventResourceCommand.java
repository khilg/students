package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.student.service.EventsLocalService;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
		property= {
				"javax.portlet.name="+ StudentPortletKeys.STUDENT,
                "mvc.command.name=/delete/event",
		},
		service = MVCResourceCommand.class
		)
public class DeleteEventResourceCommand implements MVCResourceCommand {

	@Reference
	private EventsLocalService _eventLocalService;
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String id = ParamUtil.getString(resourceRequest,"id");
		System.out.println("DeleteResource");
		try {
			_eventLocalService.deleteEvent(Long.parseLong(id));
		} catch (NumberFormatException | PortalException e) {
			e.printStackTrace();
		}
		
				return false;
		
	}
}
