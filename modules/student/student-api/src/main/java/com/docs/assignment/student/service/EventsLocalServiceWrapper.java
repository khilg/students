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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventsLocalService
 * @generated
 */
public class EventsLocalServiceWrapper
	implements EventsLocalService, ServiceWrapper<EventsLocalService> {

	public EventsLocalServiceWrapper(EventsLocalService eventsLocalService) {
		_eventsLocalService = eventsLocalService;
	}

	@Override
	public com.docs.assignment.student.model.Events addEvent(
			long userId, String eventName, String eventDescription,
			String startDate, String endDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.addEvent(
			userId, eventName, eventDescription, startDate, endDate,
			serviceContext);
	}

	/**
	 * Adds the events to the database. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was added
	 */
	@Override
	public com.docs.assignment.student.model.Events addEvents(
		com.docs.assignment.student.model.Events events) {

		return _eventsLocalService.addEvents(events);
	}

	/**
	 * Creates a new events with the primary key. Does not add the events to the database.
	 *
	 * @param eventId the primary key for the new events
	 * @return the new events
	 */
	@Override
	public com.docs.assignment.student.model.Events createEvents(long eventId) {
		return _eventsLocalService.createEvents(eventId);
	}

	@Override
	public com.docs.assignment.student.model.Events deleteEvent(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.deleteEvent(id);
	}

	/**
	 * Deletes the events from the database. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was removed
	 */
	@Override
	public com.docs.assignment.student.model.Events deleteEvents(
		com.docs.assignment.student.model.Events events) {

		return _eventsLocalService.deleteEvents(events);
	}

	/**
	 * Deletes the events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the events
	 * @return the events that was removed
	 * @throws PortalException if a events with the primary key could not be found
	 */
	@Override
	public com.docs.assignment.student.model.Events deleteEvents(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.deleteEvents(eventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _eventsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _eventsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _eventsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.docs.assignment.student.model.Events fetchEvents(long eventId) {
		return _eventsLocalService.fetchEvents(eventId);
	}

	/**
	 * Returns the events matching the UUID and group.
	 *
	 * @param uuid the events's UUID
	 * @param groupId the primary key of the group
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public com.docs.assignment.student.model.Events fetchEventsByUuidAndGroupId(
		String uuid, long groupId) {

		return _eventsLocalService.fetchEventsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.docs.assignment.student.model.Events>
		getAllEvents() {

		return _eventsLocalService.getAllEvents();
	}

	/**
	 * Returns the events with the primary key.
	 *
	 * @param eventId the primary key of the events
	 * @return the events
	 * @throws PortalException if a events with the primary key could not be found
	 */
	@Override
	public com.docs.assignment.student.model.Events getEvents(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.getEvents(eventId);
	}

	@Override
	public java.util.List<com.docs.assignment.student.model.Events>
		getEventsByGroupId(long groupId) {

		return _eventsLocalService.getEventsByGroupId(groupId);
	}

	/**
	 * Returns the events matching the UUID and group.
	 *
	 * @param uuid the events's UUID
	 * @param groupId the primary key of the group
	 * @return the matching events
	 * @throws PortalException if a matching events could not be found
	 */
	@Override
	public com.docs.assignment.student.model.Events getEventsByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.getEventsByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<com.docs.assignment.student.model.Events> getEventses(
		int start, int end) {

		return _eventsLocalService.getEventses(start, end);
	}

	/**
	 * Returns all the eventses matching the UUID and company.
	 *
	 * @param uuid the UUID of the eventses
	 * @param companyId the primary key of the company
	 * @return the matching eventses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.docs.assignment.student.model.Events>
		getEventsesByUuidAndCompanyId(String uuid, long companyId) {

		return _eventsLocalService.getEventsesByUuidAndCompanyId(
			uuid, companyId);
	}

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
	@Override
	public java.util.List<com.docs.assignment.student.model.Events>
		getEventsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.docs.assignment.student.model.Events> orderByComparator) {

		return _eventsLocalService.getEventsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of eventses.
	 *
	 * @return the number of eventses
	 */
	@Override
	public int getEventsesCount() {
		return _eventsLocalService.getEventsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _eventsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param events the events
	 * @return the events that was updated
	 */
	@Override
	public com.docs.assignment.student.model.Events updateEvents(
		com.docs.assignment.student.model.Events events) {

		return _eventsLocalService.updateEvents(events);
	}

	@Override
	public EventsLocalService getWrappedService() {
		return _eventsLocalService;
	}

	@Override
	public void setWrappedService(EventsLocalService eventsLocalService) {
		_eventsLocalService = eventsLocalService;
	}

	private EventsLocalService _eventsLocalService;

}