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

package com.docs.assignment.student.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.docs.assignment.student.service.http.EventsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventsSoap implements Serializable {

	public static EventsSoap toSoapModel(Events model) {
		EventsSoap soapModel = new EventsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventId(model.getEventId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventName(model.getEventName());
		soapModel.setEventDescription(model.getEventDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static EventsSoap[] toSoapModels(Events[] models) {
		EventsSoap[] soapModels = new EventsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventsSoap[][] toSoapModels(Events[][] models) {
		EventsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventsSoap[] toSoapModels(List<Events> models) {
		List<EventsSoap> soapModels = new ArrayList<EventsSoap>(models.size());

		for (Events model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventsSoap[soapModels.size()]);
	}

	public EventsSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventName() {
		return _eventName;
	}

	public void setEventName(String eventName) {
		_eventName = eventName;
	}

	public String getEventDescription() {
		return _eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		_eventDescription = eventDescription;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private String _uuid;
	private long _eventId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _eventName;
	private String _eventDescription;
	private Date _startDate;
	private Date _endDate;

}