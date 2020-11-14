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

package com.docs.assignment.student.service;

import com.docs.assignment.student.model.Events;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Events. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EventsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventsLocalServiceUtil} to access the events local service. Add custom service methods to <code>com.docs.assignment.student.service.impl.EventsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Events addEvent(
			long userId, String eventName, String eventDescription,
			String startDate, String endDate, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the events to the database. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Events addEvents(Events events);

	/**
	 * Creates a new events with the primary key. Does not add the events to the database.
	 *
	 * @param eventId the primary key for the new events
	 * @return the new events
	 */
	@Transactional(enabled = false)
	public Events createEvents(long eventId);

	/**
	 * Deletes the events from the database. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Events deleteEvents(Events events);

	/**
	 * Deletes the events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the events
	 * @return the events that was removed
	 * @throws PortalException if a events with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Events deleteEvents(long eventId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.docs.assignment.student.model.impl.EventsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.docs.assignment.student.model.impl.EventsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Events fetchEvents(long eventId);

	/**
	 * Returns the events matching the UUID and group.
	 *
	 * @param uuid the events's UUID
	 * @param groupId the primary key of the group
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Events fetchEventsByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Events> getAllEvents();

	/**
	 * Returns the events with the primary key.
	 *
	 * @param eventId the primary key of the events
	 * @return the events
	 * @throws PortalException if a events with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Events getEvents(long eventId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Events> getEventsByGroupId(long groupId);

	/**
	 * Returns the events matching the UUID and group.
	 *
	 * @param uuid the events's UUID
	 * @param groupId the primary key of the group
	 * @return the matching events
	 * @throws PortalException if a matching events could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Events getEventsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the eventses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.docs.assignment.student.model.impl.EventsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @return the range of eventses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Events> getEventses(int start, int end);

	/**
	 * Returns all the eventses matching the UUID and company.
	 *
	 * @param uuid the UUID of the eventses
	 * @param companyId the primary key of the company
	 * @return the matching eventses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Events> getEventsesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of eventses matching the UUID and company.
	 *
	 * @param uuid the UUID of the eventses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching eventses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Events> getEventsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator);

	/**
	 * Returns the number of eventses.
	 *
	 * @return the number of eventses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Events updateEvents(Events events);

}