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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Events}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Events
 * @generated
 */
public class EventsWrapper
	extends BaseModelWrapper<Events> implements Events, ModelWrapper<Events> {

	public EventsWrapper(Events events) {
		super(events);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventName", getEventName());
		attributes.put("eventDescription", getEventDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		String eventDescription = (String)attributes.get("eventDescription");

		if (eventDescription != null) {
			setEventDescription(eventDescription);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	 * Returns the company ID of this events.
	 *
	 * @return the company ID of this events
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this events.
	 *
	 * @return the create date of this events
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the end date of this events.
	 *
	 * @return the end date of this events
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the event description of this events.
	 *
	 * @return the event description of this events
	 */
	@Override
	public String getEventDescription() {
		return model.getEventDescription();
	}

	/**
	 * Returns the event ID of this events.
	 *
	 * @return the event ID of this events
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the event name of this events.
	 *
	 * @return the event name of this events
	 */
	@Override
	public String getEventName() {
		return model.getEventName();
	}

	/**
	 * Returns the group ID of this events.
	 *
	 * @return the group ID of this events
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this events.
	 *
	 * @return the modified date of this events
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this events.
	 *
	 * @return the primary key of this events
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this events.
	 *
	 * @return the start date of this events
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the user ID of this events.
	 *
	 * @return the user ID of this events
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this events.
	 *
	 * @return the user name of this events
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this events.
	 *
	 * @return the user uuid of this events
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this events.
	 *
	 * @return the uuid of this events
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this events.
	 *
	 * @param companyId the company ID of this events
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this events.
	 *
	 * @param createDate the create date of this events
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the end date of this events.
	 *
	 * @param endDate the end date of this events
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the event description of this events.
	 *
	 * @param eventDescription the event description of this events
	 */
	@Override
	public void setEventDescription(String eventDescription) {
		model.setEventDescription(eventDescription);
	}

	/**
	 * Sets the event ID of this events.
	 *
	 * @param eventId the event ID of this events
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the event name of this events.
	 *
	 * @param eventName the event name of this events
	 */
	@Override
	public void setEventName(String eventName) {
		model.setEventName(eventName);
	}

	/**
	 * Sets the group ID of this events.
	 *
	 * @param groupId the group ID of this events
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this events.
	 *
	 * @param modifiedDate the modified date of this events
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this events.
	 *
	 * @param primaryKey the primary key of this events
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this events.
	 *
	 * @param startDate the start date of this events
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the user ID of this events.
	 *
	 * @param userId the user ID of this events
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this events.
	 *
	 * @param userName the user name of this events
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this events.
	 *
	 * @param userUuid the user uuid of this events
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this events.
	 *
	 * @param uuid the uuid of this events
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EventsWrapper wrap(Events events) {
		return new EventsWrapper(events);
	}

}