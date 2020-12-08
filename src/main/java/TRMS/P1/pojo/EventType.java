package TRMS.P1.pojo;

public class EventType {
	
	private int eventTypeId; 
	private String eventTypesName;
	private double eventTypePercentage;
	

	public EventType(int eventTypeId, String eventTypesName, double eventTypePercentage) {
		super();
		this.eventTypeId = eventTypeId;
		this.eventTypesName = eventTypesName;
		this.eventTypePercentage = eventTypePercentage;
	}


	public EventType() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the eventTypesName
	 */
	public String getEventTypesName() {
		return eventTypesName;
	}


	/**
	 * @param eventTypesName the eventTypesName to set
	 */
	public void setEventTypesName(String eventTypesName) {
		this.eventTypesName = eventTypesName;
	}


	/**
	 * @return the eventTypePercentage
	 */
	public double getEventTypePercentage() {
		return eventTypePercentage;
	}


	/**
	 * @param eventTypePercentage the eventTypePercentage to set
	 */
	public void setEventTypePercentage(double eventTypePercentage) {
		this.eventTypePercentage = eventTypePercentage;
	}


	@Override
	public String toString() {
		return "EventType [eventTypeId=" + eventTypeId + ", eventTypesName=" + eventTypesName + ", eventTypePercentage="
				+ eventTypePercentage + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventTypeId;
		long temp;
		temp = Double.doubleToLongBits(eventTypePercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((eventTypesName == null) ? 0 : eventTypesName.hashCode());
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
		EventType other = (EventType) obj;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (Double.doubleToLongBits(eventTypePercentage) != Double.doubleToLongBits(other.eventTypePercentage))
			return false;
		if (eventTypesName == null) {
			if (other.eventTypesName != null)
				return false;
		} else if (!eventTypesName.equals(other.eventTypesName))
			return false;
		return true;
	}
	

}
