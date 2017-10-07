package converge;

import java.io.*;
import java.util.*;

/**
 * The Event.java file is used to implement the Event class that stores the information needed
 * for an event to be created.
 *
 * @author Vivek Tallavajhala
 * @since 2017-09-15
 */
public class Event {
	
	String m_eventName = "";
	String m_hostName = "";
	Vector<Vector<String>> m_datesAndTimes = new Vector();
	Vector<String> m_tasks = new Vector();
	Vector<Vector<String>> m_attendees = new Vector();
	
	public Event() {}
	
	public Event(String eventName, String hostName, Vector<Vector<String>> datesAndTimes, Vector<String> tasks, Vector<Vector<String>> attendees)
	{
		m_eventName = eventName;
		m_hostName = hostName;
		m_datesAndTimes = datesAndTimes;
		m_tasks = tasks;
		m_attendees = attendees;
	}
	
	public String getEventName() {
		return m_eventName;
	}
	
	public String getHostName() {
		return m_hostName;
	}

	public Vector<Vector<String>> getDatesAndTimes() {
		return m_datesAndTimes;
	}
	
	public Vector<String> getTasks() {
		return m_tasks;
	}
	
	public Vector<Vector<String>> getAttendees() {
		return m_attendees;
	}
	
	public void viewAllEvents() {
		
	}
}