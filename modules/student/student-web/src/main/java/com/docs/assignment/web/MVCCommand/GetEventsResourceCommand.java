package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.student.model.Events;
import com.docs.assignment.student.service.EventsLocalService;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
                "mvc.command.name=/get/events",
		},
		service = MVCResourceCommand.class
		)
public class GetEventsResourceCommand implements MVCResourceCommand{
	
	@Reference
	private EventsLocalService _eventLocalService;
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("/get/events");
		 
		 try {
			 PrintWriter writer = null;
			 JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			 
			 List<Events> eventsList = _eventLocalService.getEventsByGroupId(20124);
			// List<Events> eventsList = _eventLocalService.getAllEvents();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			 for(Events e : eventsList) {
				 JSONObject jsonObject  = JSONFactoryUtil.createJSONObject();
				 jsonObject.put("title", e.getEventName());
				 jsonObject.put("start", sdf.format(e.getStartDate()));
				 jsonObject.put("end", sdf.format(e.getEndDate()));
				 jsonObject.put("description", e.getEventDescription());
				 jsonArray.put(jsonObject);
			 }
			 System.out.println(jsonArray);
			 resourceResponse.setContentType("application/json");
			  writer = resourceResponse.getWriter();
			  writer.print(jsonArray);
			  writer.close();
			 
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
 
		return false;
	}

}
