package TRMS.P1.pojo;

public class Event {
	
	private static int eventCount;
	private int eventId;
	private int eventTypeId; 
	private String name;
	private String description;
	private String startDate;
	private String endDate;
	private String location;
	private int gradingFormatId;
	private String employeeGrade;
	private int gradeId;
	
	
	
	
	public Event(int eventTypeId, String name, String description, String startDate, String endDate,
			String location, int gradingFormatId, String employeeGrade, int gradeId) {
		super();
		Event.eventCount++;
		this.eventId = Event.eventCount;
		this.eventTypeId = eventTypeId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.gradingFormatId = gradingFormatId;
		this.employeeGrade = employeeGrade;
		this.gradeId = gradeId;
	}



	public Event(int eventTypeId, String name, String description, String startDate, String endDate,
			String location, int gradingFormatId) {
		super();
		this.eventTypeId = eventTypeId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.gradingFormatId = gradingFormatId;
	}
	
	
	
	public Event(String employeeGrade) {
		super();
		this.employeeGrade = employeeGrade;
	}


	public Event(int eventTypeId) {
		super();
		this.eventTypeId = eventTypeId;
	}



	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the eventCount
	 */
	public static int getEventCount() {
		return eventCount;
	}



	/**
	 * @param eventCount the eventCount to set
	 */
	public static void setEventCount(int eventCount) {
		Event.eventCount = eventCount;
	}



	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}



	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	/**
	 * @return the eventTypeId
	 */
	public int getEventTypeId() {
		return eventTypeId;
	}



	/**
	 * @param eventTypeId the eventTypeId to set
	 */
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}



	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}



	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}



	/**
	 * @return the gradingFormatId
	 */
	public int getGradingFormatId() {
		return gradingFormatId;
	}



	/**
	 * @param gradingFormatId the gradingFormatId to set
	 */
	public void setGradingFormatId(int gradingFormatId) {
		this.gradingFormatId = gradingFormatId;
	}



	/**
	 * @return the employeeGrade
	 */
	public String getEmployeeGrade() {
		return employeeGrade;
	}



	/**
	 * @param employeeGrade the employeeGrade to set
	 */
	public void setEmployeeGrade(String employeeGrade) {
		this.employeeGrade = employeeGrade;
	}



	/**
	 * @return the gradeId
	 */
	public int getGradeId() {
		return gradeId;
	}



	/**
	 * @param gradeId the gradeId to set
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}



	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventTypeId=" + eventTypeId + ", name=" + name + ", description="
				+ description + ", startDate=" + startDate + ", endDate=" + endDate + ", location=" + location
				+ ", gradingFormatId=" + gradingFormatId + ", employeeGrade=" + employeeGrade + ", gradeId=" + gradeId
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeGrade == null) ? 0 : employeeGrade.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + eventId;
		result = prime * result + eventTypeId;
		result = prime * result + gradeId;
		result = prime * result + gradingFormatId;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeGrade == null) {
			if (other.employeeGrade != null)
				return false;
		} else if (!employeeGrade.equals(other.employeeGrade))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (gradeId != other.gradeId)
			return false;
		if (gradingFormatId != other.gradingFormatId)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	

}
