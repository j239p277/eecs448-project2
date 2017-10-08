package converge;

import java.io.*;
import java.util.*;

/**
 * Implementation of event object. Stores all information about the event.
 * @since 2017-10-8
 */
 
public class Event {
	
	/**
	 * name of the event
	 */
	String m_eventName = "";
	/**
	 * name of the person who created the event
	 */
	String m_hostName = "";
	/**
	 * 2d string vector that holds the dates and respective times that an event takes place during
	 */
	Vector<Vector<String>> m_datesAndTimes = new Vector<Vector<String>>();
	/**
	 * string vector that holds the tasks an event requires
	 */
	Vector<String> m_tasks = new Vector<String>();
	/**
	 * 2d string vector that holds the names, availabilities, and tasks for each attendee
	 */
	Vector<Vector<String>> m_attendees = new Vector<Vector<String>>();
	/**
	 * Event object constructor
	 * @param eventName name of event
	 * @param hostName name of hostName
	 * @param datesAndTimes 2d string vector representing dates and times
	 * @param tasks string vector containing tasks that need to be done
	 * @param attendees 2d string vector containing list of attendees, availabilities, and tasks
	 */
	public Event(String eventName, String hostName, Vector<Vector<String>> datesAndTimes, Vector<String> tasks, Vector<Vector<String>> attendees)
	{
		m_eventName = eventName;
		m_hostName = hostName;
		m_datesAndTimes = datesAndTimes;
		m_tasks = tasks;
		m_attendees = attendees;
	}
	/**
	 * @return name of event
	 */
	public String getEventName() {
		return m_eventName;
	}
	/**
	 * @return name of host
	 */
	public String getHostName() {
		return m_hostName;
	}
	/**
	 * @return 2d string vector representing dates and times
	 */
	public Vector<Vector<String>> getDatesAndTimes() {
		return m_datesAndTimes;
	}
	/**
	 * @return string vector representing tasks
	 */
	public Vector<String> getTasks() {
		return m_tasks;
	}
	/**
	 * @return 2d string vector representing
	 */
	public Vector<Vector<String>> getAttendees() {
		return m_attendees;
	}
	/**
	 * Adds tasks to task vector
	 * @param task string representing task that needs to be added
	 */
	public void addTask(String task)
	{
		this.m_tasks.add(task);
	}
	/**
	 * Adds attendees to event
	 * @param temp string vector containing information about attendee
	 */
	public void addAttendee(Vector<String> temp) {
		this.m_attendees.add(temp);
	}
	/**
	 * Gets name of attendee
	 * @param attendeeIndex int representing a specific attendee
	 * @return name of attendee
	 */
	public String getAttendeeName(int attendeeIndex) {
		String name = "Name error";
		name = this.getAttendees().get(attendeeIndex).get(0);
		return name;	
	}
}