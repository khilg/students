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

package com.docs.assignment.student.model.impl;

import com.docs.assignment.student.model.Events;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Events in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventsCacheModel implements CacheModel<Events>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventsCacheModel)) {
			return false;
		}

		EventsCacheModel eventsCacheModel = (EventsCacheModel)obj;

		if (eventId == eventsCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventName=");
		sb.append(eventName);
		sb.append(", eventDescription=");
		sb.append(eventDescription);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Events toEntityModel() {
		EventsImpl eventsImpl = new EventsImpl();

		if (uuid == null) {
			eventsImpl.setUuid("");
		}
		else {
			eventsImpl.setUuid(uuid);
		}

		eventsImpl.setEventId(eventId);
		eventsImpl.setGroupId(groupId);
		eventsImpl.setCompanyId(companyId);
		eventsImpl.setUserId(userId);

		if (userName == null) {
			eventsImpl.setUserName("");
		}
		else {
			eventsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventsImpl.setCreateDate(null);
		}
		else {
			eventsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventsImpl.setModifiedDate(null);
		}
		else {
			eventsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventName == null) {
			eventsImpl.setEventName("");
		}
		else {
			eventsImpl.setEventName(eventName);
		}

		if (eventDescription == null) {
			eventsImpl.setEventDescription("");
		}
		else {
			eventsImpl.setEventDescription(eventDescription);
		}

		if (startDate == Long.MIN_VALUE) {
			eventsImpl.setStartDate(null);
		}
		else {
			eventsImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eventsImpl.setEndDate(null);
		}
		else {
			eventsImpl.setEndDate(new Date(endDate));
		}

		eventsImpl.resetOriginalValues();

		return eventsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventName = objectInput.readUTF();
		eventDescription = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventName);
		}

		if (eventDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventDescription);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public String uuid;
	public long eventId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String eventName;
	public String eventDescription;
	public long startDate;
	public long endDate;

}