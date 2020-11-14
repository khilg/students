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

package com.docs.assignment.student.service.persistence;

import com.docs.assignment.student.exception.NoSuchEventsException;
import com.docs.assignment.student.model.Events;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the events service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventsUtil
 * @generated
 */
@ProviderType
public interface EventsPersistence extends BasePersistence<Events> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventsUtil} to access the events persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eventses
	 */
	public java.util.List<Events> findByUuid(String uuid);

	/**
	 * Returns a range of all the eventses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @return the range of matching eventses
	 */
	public java.util.List<Events> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the eventses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns an ordered range of all the eventses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the first events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the last events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the last events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the eventses before and after the current events in the ordered set where uuid = &#63;.
	 *
	 * @param eventId the primary key of the current events
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	public Events[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Removes all the eventses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eventses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEventsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByUUID_G(String uuid, long groupId)
		throws NoSuchEventsException;

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the events where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the events that was removed
	 */
	public Events removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventsException;

	/**
	 * Returns the number of eventses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eventses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	public java.util.List<Events> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @return the range of matching eventses
	 */
	public java.util.List<Events> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns an ordered range of all the eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the eventses before and after the current events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventId the primary key of the current events
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	public Events[] findByUuid_C_PrevAndNext(
			long eventId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Removes all the eventses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the eventses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching eventses
	 */
	public java.util.List<Events> findByGroupId(long groupId);

	/**
	 * Returns a range of all the eventses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @return the range of matching eventses
	 */
	public java.util.List<Events> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the eventses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns an ordered range of all the eventses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching eventses
	 */
	public java.util.List<Events> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first events in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the first events in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the last events in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	public Events findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Returns the last events in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	public Events fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns the eventses before and after the current events in the ordered set where groupId = &#63;.
	 *
	 * @param eventId the primary key of the current events
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	public Events[] findByGroupId_PrevAndNext(
			long eventId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Events>
				orderByComparator)
		throws NoSuchEventsException;

	/**
	 * Removes all the eventses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of eventses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching eventses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the events in the entity cache if it is enabled.
	 *
	 * @param events the events
	 */
	public void cacheResult(Events events);

	/**
	 * Caches the eventses in the entity cache if it is enabled.
	 *
	 * @param eventses the eventses
	 */
	public void cacheResult(java.util.List<Events> eventses);

	/**
	 * Creates a new events with the primary key. Does not add the events to the database.
	 *
	 * @param eventId the primary key for the new events
	 * @return the new events
	 */
	public Events create(long eventId);

	/**
	 * Removes the events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the events
	 * @return the events that was removed
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	public Events remove(long eventId) throws NoSuchEventsException;

	public Events updateImpl(Events events);

	/**
	 * Returns the events with the primary key or throws a <code>NoSuchEventsException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the events
	 * @return the events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	public Events findByPrimaryKey(long eventId) throws NoSuchEventsException;

	/**
	 * Returns the events with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the events
	 * @return the events, or <code>null</code> if a events with the primary key could not be found
	 */
	public Events fetchByPrimaryKey(long eventId);

	/**
	 * Returns all the eventses.
	 *
	 * @return the eventses
	 */
	public java.util.List<Events> findAll();

	/**
	 * Returns a range of all the eventses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @return the range of eventses
	 */
	public java.util.List<Events> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the eventses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eventses
	 */
	public java.util.List<Events> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator);

	/**
	 * Returns an ordered range of all the eventses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eventses
	 * @param end the upper bound of the range of eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of eventses
	 */
	public java.util.List<Events> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the eventses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of eventses.
	 *
	 * @return the number of eventses
	 */
	public int countAll();

}