/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.docs.assignment.student.service.impl;

import com.docs.assignment.student.model.Events;
import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.base.EventsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the events local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.docs.assignment.student.service.EventsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.docs.assignment.student.model.Events",
	service = AopService.class
)
public class EventsLocalServiceImpl extends EventsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.docs.assignment.student.service.EventsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.docs.assignment.student.service.EventsLocalServiceUtil</code>.
	 */
	
	public Events addEvent(long userId, String eventName, String eventDescription, 
			String startDate, String endDate, ServiceContext serviceContext) throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		long eventId = counterLocalService.increment();
		
		Events event = eventsPersistence.create(eventId);
		
		event.setGroupId(groupId);
		event.setCompanyId(user.getCompanyId());
		event.setUserId(userId);
		event.setUserName(user.getFullName());
		event.setCreateDate(serviceContext.getCreateDate(now));
		event.setModifiedDate(serviceContext.getModifiedDate(now));
		event.setExpandoBridgeAttributes(serviceContext);
		
		event.setEventName(eventName);
		event.setEventDescription(eventDescription);
		Date startDatenow = null;
		Date endDatenow = null;
		try {
			 startDatenow=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDate);
			 endDatenow=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		event.setStartDate(startDatenow);
		event.setEndDate(endDatenow);
		System.out.println(startDatenow);
		System.out.println(endDatenow);
		return super.addEvents(event);
		
	}
	
public Events deleteEvent(long id) throws PortalException {
		
		Events event = eventsPersistence.findByPrimaryKey(id);
		
		eventsPersistence.remove(event);
		
		return event;
	}

	public List<Events> getEventsByGroupId(long groupId){
			
			return eventsPersistence.findByGroupId(groupId);
		}
	
	public List<Events> getAllEvents(){
		
		return eventsPersistence.findAll();
	}
}