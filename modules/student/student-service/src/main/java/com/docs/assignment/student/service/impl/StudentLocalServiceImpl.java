/*
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

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.docs.assignment.student.service.StudentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.docs.assignment.student.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.docs.assignment.student.service.StudentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.docs.assignment.student.service.StudentLocalServiceUtil</code>.
	 */
	
	public Student addStudent(long userId, String name, String email, int age, String assignment_status,
			ServiceContext serviceContext) throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		long studentId = counterLocalService.increment();
		Student student = studentPersistence.create(studentId);
		
		student.setGroupId(groupId);
		student.setCompanyId(user.getCompanyId());
		student.setUserId(userId);
		student.setUserName(user.getFullName());
		student.setCreateDate(serviceContext.getCreateDate(now));
		student.setModifiedDate(serviceContext.getModifiedDate(now));
		student.setExpandoBridgeAttributes(serviceContext);
		
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		student.setAssignment_status(assignment_status);
		
		return super.addStudent(student);
	}
	
	public Student updateStudent(long userId, long studentId, String name, String email, int age, String assignment_status,
			ServiceContext serviceContext) throws PortalException {
		
		
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		
		Student student = studentPersistence.findByPrimaryKey(studentId);
		
		student.setCompanyId(user.getCompanyId());
		student.setUserId(userId);
		student.setUserName(user.getFullName());
		student.setModifiedDate(serviceContext.getModifiedDate(now));
		student.setExpandoBridgeAttributes(serviceContext);
		
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		student.setAssignment_status(assignment_status);
		
		studentPersistence.update(student);
		
		return student;
	}
	
	public Student deleteStudent(long studentId) throws PortalException {
		
		Student student = studentPersistence.findByPrimaryKey(studentId);
		
		studentPersistence.remove(student);
		
		return student;
	}
	
	public List<Student> getStudentsByGroupId(long groupId){
		
		return studentPersistence.findByGroupId(groupId);
	}
	
	public List<Student> getStudentsByEmail(String email){
		
		return studentPersistence.findByEmail(email);
	}
	
	public int getStudentsCount(long groupId) {
		return studentPersistence.countByGroupId(groupId);
	}
	
	public List<Student> getStudentsByGroupId(long groupId,int start, int end, 
			OrderByComparator<Student> obc) {
		return studentPersistence.findByGroupId(groupId, start, end, obc);
	}
	
	public List<Student> findByUserNameEmail(String userName, String email)
			  throws SystemException {
				return studentFinder.findByUsernameEmail(userName, email);
	}
	public List<Student> findByName(String name)
			throws SystemException {
		return studentFinder.findByName(name);
	}
	public void deleteAllStudents()
			throws SystemException {
		studentPersistence.removeAll();
	}
	public List<Student> getAllStudents(){
		return studentPersistence.findAll();
	}
	
}