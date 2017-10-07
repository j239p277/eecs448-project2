package converge;

import java.util.*;


/**
 * The Event.java file is used to implement the Event class that stores the information needed
 * for an event to be created.
 *
 * @author Vivek Tallavajhala
 * @since 2017-09-15
 */
public class Event {
	
	private String m_eventName = "";
	private String m_hostName = "";
	private Vector<Vector<String>> m_datesAndTimes = new Vector<Vector<String>>();
	private Vector<String> m_tasks = new Vector<String>();
	private Vector<Vector<String>> m_attendees = new Vector<Vector<String>>();
	
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
	
	public void addDatesAndTimes(Vector<String> temp) {
		this.m_datesAndTimes.add(temp);
	}
	
	public void addTask(String task)
	{
		this.m_tasks.add(task);
	}
	
	public void addttendee(Vector<String> temp) {
		this.m_attendees.add(temp);
	}
	
	// Prints info for this event
	public void viewEvent() {
		System.out.println("Event: " + this.getEventName());
		System.out.println("Host: " + this.getHostName());
		for (int i = 0; i<m_datesAndTimes.size(); i++) {	// TODO ADD TIMES
			System.out.println("Times: " + this.getDate(i));
		}
		for (int i = 0; i<m_attendees.size(); i++) {
			System.out.println("Attendees: " + this.getAttendeeName(i));
		}
			System.out.println("Tasks: " + this.getTasks());
	}
    
    // Returns a date string from the event's DatesAndTimes vector
    public String getDate(int datesAndTimesIndex) {
        String date = "Date error";
        date = this.getDatesAndTimes().get(datesAndTimesIndex).get(0);
        return date;
    }
    
    // Returns a name from the event's Attendees vector
    public String getAttendeeName(int attendeeIndex) {
        String name = "Name error";
        name = this.getAttendees().get(attendeeIndex).get(0);
        return name;	
    }
}
