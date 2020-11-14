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
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("studentId", getStudentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("age", getAge());
		attributes.put("email", getEmail());
		attributes.put("assignment_status", getAssignment_status());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String assignment_status = (String)attributes.get("assignment_status");

		if (assignment_status != null) {
			setAssignment_status(assignment_status);
		}
	}

	/**
	 * Returns the age of this student.
	 *
	 * @return the age of this student
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the assignment_status of this student.
	 *
	 * @return the assignment_status of this student
	 */
	@Override
	public String getAssignment_status() {
		return model.getAssignment_status();
	}

	/**
	 * Returns the company ID of this student.
	 *
	 * @return the company ID of this student
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this student.
	 *
	 * @return the create date of this student
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this student.
	 *
	 * @return the email of this student
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this student.
	 *
	 * @return the group ID of this student
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this student.
	 *
	 * @return the name of this student
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	@Override
	public long getStudentId() {
		return model.getStudentId();
	}

	/**
	 * Returns the user ID of this student.
	 *
	 * @return the user ID of this student
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this student.
	 *
	 * @return the user name of this student
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this student.
	 *
	 * @return the user uuid of this student
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this student.
	 *
	 * @return the uuid of this student
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
	 * Sets the age of this student.
	 *
	 * @param age the age of this student
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the assignment_status of this student.
	 *
	 * @param assignment_status the assignment_status of this student
	 */
	@Override
	public void setAssignment_status(String assignment_status) {
		model.setAssignment_status(assignment_status);
	}

	/**
	 * Sets the company ID of this student.
	 *
	 * @param companyId the company ID of this student
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this student.
	 *
	 * @param createDate the create date of this student
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this student.
	 *
	 * @param email the email of this student
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this student.
	 *
	 * @param groupId the group ID of this student
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this student.
	 *
	 * @param modifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this student.
	 *
	 * @param name the name of this student
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	@Override
	public void setStudentId(long studentId) {
		model.setStudentId(studentId);
	}

	/**
	 * Sets the user ID of this student.
	 *
	 * @param userId the user ID of this student
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this student.
	 *
	 * @param userName the user name of this student
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this student.
	 *
	 * @param userUuid the user uuid of this student
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this student.
	 *
	 * @param uuid the uuid of this student
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
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}