package com.docs.assignment.web.model;

public class EventsModel {
	
	
	private String startDate;
	private String endDate;
	private String eventName;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	@Override
	public String toString() {
		return "EventsModel [startDate=" + startDate + ", endDate=" + endDate + ", eventName=" + eventName + "]";
	}
	
}
