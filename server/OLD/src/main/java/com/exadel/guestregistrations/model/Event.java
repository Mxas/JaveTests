package com.exadel.guestregistrations.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	@Document(collection = "events")
	public class Event {
		@Id
		private String id;
		private String officeId;
		private Date beginningDay;
		private Date endingDay;
		private String beginningTime;
		private String endingTime;
		private String eventType;
		private String description;
		private List<String> invitedList;
		private List<String> arrivedList;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getOfficeId() {
			return officeId;
		}

		public void setOfficeId(String officeId) {
			this.officeId = officeId;
		}

		public Date getBeginningDay() {
			return beginningDay;
		}

		public void setBeginningDay(Date beginningDay) {
			this.beginningDay = beginningDay;
		}

		public Date getEndingDay() {
			return endingDay;
		}

		public void setEndingDay(Date endingDay) {
			this.endingDay = endingDay;
		}

		public String getBeginningTime() {
			return beginningTime;
		}

		public void setBeginningTime(String beginningTime) {
			this.beginningTime = beginningTime;
		}

		public String getEndingTime() {
			return endingTime;
		}

		public void setEndingTime(String endingTime) {
			this.endingTime = endingTime;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<String> getInvitedList() {
			return invitedList;
		}

		public void setInvitedList(List<String> invitedList) {
			this.invitedList = invitedList;
		}

		public List<String> getArrivedList() {
			return arrivedList;
		}

		public void setArrivedList(List<String> arrivedList) {
			this.arrivedList = arrivedList;
		}
		
}