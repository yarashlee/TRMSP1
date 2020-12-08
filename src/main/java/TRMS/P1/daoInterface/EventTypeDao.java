package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.EventType;

public interface EventTypeDao {
	
	public EventType readEventType(int eventTypeId);

	public List<EventType> readAllEventTypes();

}
