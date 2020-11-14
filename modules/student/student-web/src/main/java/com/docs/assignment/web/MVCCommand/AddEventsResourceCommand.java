package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.student.model.Events;
import com.docs.assignment.student.service.EventsLocalService;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
		property= {
				"javax.portlet.name="+ StudentPortletKeys.STUDENT,
                "mvc.command.name=/add/event",
		},
		service = MVCResourceCommand.class
		)
public class AddEventsResourceCommand implements MVCResourceCommand {

	
	@Reference
	private EventsLocalService _eventLocalService;
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		System.out.println("AddEventsServeResource");
		 String startDate = ParamUtil.getString(resourceRequest,"startDate");
		 String endDate = ParamUtil.getString(resourceRequest,"endDate");
		 String eventName = ParamUtil.getString(resourceRequest,"eventName");
		 String eventDescription = ParamUtil.getString(resourceRequest,"eventDescription");
		 
		 System.out.println(startDate +" "+endDate+" "+ eventName);
		 try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			            Events.class.getName(), resourceRequest);
			String startDateRep = startDate.replace("T", " ");
			String endDateRep = endDate.replace("T", " ");
			
			_eventLocalService.addEvent(serviceContext.getUserId(),eventName, eventDescription, 
					startDateRep, endDateRep, serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		 
		 PrintWriter writer = null;
		 
		 try {
			 
		 	writer = resourceResponse.getWriter();
			writer.print("success");
			writer.close();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return false;
		
	}

}
