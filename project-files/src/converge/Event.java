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
	/**
	 * String used to store the name of the event.
	 */
	String a_eventName;
	/**
	 * String used to store the name of the event creator.
	 */
	String a_eventCreator;
	/**
	 * int used to store the month of the event.
	 */
	int a_month;
	/**
	 * int used to store the day of the event.
	 */
	int a_day;
	/**
	 * int used to store the year of the event.
	 */
	int a_year;
	/**
	 * int used to store the availability of the event.
	 */
	int a_availability;
	/**
	 * TimwSlot used to store the month, day, year, and availability of the event.
	 */
	TimeSlot timeslot = new TimeSlot(a_month, a_day, a_year, a_availability);
	/**
	 * Vector of attendees used to store all the attendees able to go to the event
	 * along with all their information specified in the attendee class.
	 */
	Vector<Attendee> a_attendees = new Vector<Attendee>();
	/**
	 * Vector of integers used to store the admins availability.
	 */
	Vector<TimeSlot> a_adminAvailability = new Vector<TimeSlot>();
	/**
	 * Default constructor for the Event class.
	 */
	public Event() {}
	/**
	 * Parameterized constructor that sets the name, month, day, year, attendees information,
	 * and admin availability of the event.
	 * 
	 * @param eventName string that stores the name of the event
	 * @param month int that stores the month of the event
	 * @param day int that stores the day of the event
	 * @param year int that stores the year of the event
	 * @param attendees vector of attendees holding the information of all the attendees
	 * able to attend the event.
	 * @param adminAvailability vector of integers storing the availability of the admin.
	 */
	public Event(String eventName, String eventCreator, Vector<Attendee> attendees, Vector<TimeSlot> adminAvailability )
	{
		a_eventName = eventName;
		a_eventCreator = eventCreator;
//		a_month = month;
//		a_day = day;
//		a_year = year;
		a_attendees = attendees;
		a_adminAvailability = adminAvailability;

	}
	/**
	 * method that prints all information of the event
	 */
	public void print()
	{
		System.out.println(a_eventName);
//		System.out.println(a_month);
//		System.out.println(a_day);
//		System.out.println(a_year);
		System.out.println(a_adminAvailability);
		for (int i = 0; i < a_attendees.size(); i++)
		{
			Attendee a = a_attendees.get(i);
			System.out.println(a.getName() + a.getAvailability());
		}
	}
	/**
	 * Method that returns the admin's username.
	 * 
	 * @return A string that is the Admin's username.
	 */
	public String getAdminName()
	{
		return a_attendees.get(0).getName();
	}
	/**
	 * method that sets the name of the event.
	 * 
	 * @param eventName string that represents the name of the event.
	 */
	public void setEventName(String eventName)
	{
		a_eventName = eventName;
	}
	/**
	 * method that gets the event name.
	 * 
	 * @return A string that is the name of the event.
	 */
	public String getEventName()
	{
		return a_eventName;
	}
	/**
	 * method that sets the month of the event
	 * 
	 * @param month an integer that represents the month of the event.
	 */
	public void setMonth(int month)
	{
		a_month = month;
	}
	/**
	 * method that gets the month of the event.
	 * 
	 * @return an integer illustrating the month of the event.
	 */
	public int getMonth()
	{
		return a_month;
	}
	/**
	 * method that sets the day of the event.
	 * 
	 * @param day an integer that represents the day of the event.
	 */
	public void setDay(int day)
	{
		a_day = day;
	}
	/**
	 * method that gets the day of the event.
	 * 
	 * @return an integer representing the day of the event.
	 */
	public int getDay()
	{
		return a_day;
	}
	/**
	 * method to set the year of the event.
	 * 
	 * @param year integer that represents the year of the event.
	 */
	public void setYear(int year)
	{
		a_year = year;
	}
	/**
	 * method that gets the year of the event.
	 * 
	 * @return an integer that represents the year of the event.
	 */
	public int getYear()
	{
		return a_year;
	}
	/**
	 * method that adds an attendee to the attendee vector.
	 * 
	 * @param a the attendee being added to the attendee vector.
	 */
	public void addAttendee(Attendee a)
	{
		a_attendees.add(a);
	}
	/**
	 * method that exports the event information to a file. 
	 * 
	 * @throws IOException on bad input
	 */
	public void exportEvent() throws IOException
	{
		//Export file to .event file in /event_log/ directory
		String filename = "event_log/" + a_eventName.replaceAll("\\s+","") + ".event";
		FileWriter writer = new FileWriter(filename);

		//Output name and date accordingly
		writer.write(a_eventName + "\n");

		//Output the admin availability vector
		for (int i = 0; i < a_adminAvailability.size(); i++)
		{
//			writer.write(a_attendees.get(i).getName() + " " + a_month + " " + a_day + " " + a_year + " " + a_adminAvailability.get(i) + "\n");
		}

		//Iterate through attendees lines
		for (int i = 0; i < a_attendees.size(); i++)
		{
			//Output the name and availability of the attendee
//			writer.write(a_attendees.get(i).getName() + "\n");
			for (int j = 0; j < a_attendees.get(i).getAvailability().size(); j++)
			{
				writer.write(a_attendees.get(i).getName() + " " + a_month + " " + a_day + " " + a_year + " " + a_attendees.get(i).getAvailability().get(j).getAvailability() + "\n");
			}
		}

		//Close FileWriter
		writer.flush();
		writer.close();
	}
	/**
	 * method that gets the admin's availability.
	 * 
	 * @return a vector that stores the admin's availability.
	 */
	public Vector<TimeSlot> getAvailability()
	{
		return a_adminAvailability;
	}
	/**
	 * method that looks at the vector of integer for the admin's availability and prints 
	 * its corresponding 12 hour time string.
	 */
	public void get12HourAvailability() {
		for(int i= 0; i < a_adminAvailability.size(); i++) {
		
			if(a_adminAvailability.elementAt(i).getAvailability() == 0) {
				System.out.println("12:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 1) {
				System.out.println("12:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 2) {
				System.out.println("1:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 3) {
				System.out.println("1:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 4) {
				System.out.println("2:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 5) {
				System.out.println("2:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 6) {
				System.out.println("3:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 7) {
				System.out.println("3:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 8) {
				System.out.println("4:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 9) {
				System.out.println("4:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 10) {
				System.out.println("5:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 11) {
				System.out.println("5:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 12) {
				System.out.println("6:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 13) {
				System.out.println("6:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 14) {
				System.out.println("7:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 15) {
				System.out.println("7:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 16) {
				System.out.println("8:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 17) {
				System.out.println("8:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 18) {
				System.out.println("9:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 19) {
				System.out.println("9:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 20) {
				System.out.println("10:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 21) {
				System.out.println("10:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 22) {
				System.out.println("11:00AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 23) {
				System.out.println("11:30AM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 24) {
				System.out.println("12:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 25) {
				System.out.println("12:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 26) {
				System.out.println("1:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 27) {
				System.out.println("1:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 28) {
				System.out.println("2:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 29) {
				System.out.println("2:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 30) {
				System.out.println("3:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 31) {
				System.out.println("3:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 32) {
				System.out.println("4:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 33) {
				System.out.println("4:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 34) {
				System.out.println("5:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 35) {
				System.out.println("5:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 36) {
				System.out.println("6:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 37) {
				System.out.println("6:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 38) {
				System.out.println("7:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 39) {
				System.out.println("7:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 40) {
				System.out.println("8:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 41) {
				System.out.println("8:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 42) {
				System.out.println("9:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 43) {
				System.out.println("9:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 44) {
				System.out.println("10:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 45) {
				System.out.println("10:30PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 46) {
				System.out.println("11:00PM ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 47) {
				System.out.println("11:30PM ");
			}
		}
	}
	/**
	 * method that looks at the vector of integer for the admin's availability and prints 
	 * its corresponding 24 hour time string.
	 */
	public void get24HourAvailability() {
		for(int i= 0; i < a_adminAvailability.size(); i++) {

			if(a_adminAvailability.elementAt(i).getAvailability() == 0) {
				System.out.println("00:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 1) {
				System.out.println("00:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 2) {
				System.out.println("1:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 3) {
				System.out.println("1:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 4) {
				System.out.println("2:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 5) {
				System.out.println("2:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 6) {
				System.out.println("3:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 7) {
				System.out.println("3:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 8) {
				System.out.println("4:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 9) {
				System.out.println("4:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 10) {
				System.out.println("5:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 11) {
				System.out.println("5:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 12) {
				System.out.println("6:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 13) {
				System.out.println("6:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 14) {
				System.out.println("7:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 15) {
				System.out.println("7:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 16) {
				System.out.println("8:00");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 17) {
				System.out.println("8:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 18) {
				System.out.println("9:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 19) {
				System.out.println("9:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 20) {
				System.out.println("10:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 21) {
				System.out.println("10:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 22) {
				System.out.println("11:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 23) {
				System.out.println("11:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 24) {
				System.out.println("12:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 25) {
				System.out.println("12:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 26) {
				System.out.println("13:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 27) {
				System.out.println("13:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 28) {
				System.out.println("14:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 29) {
				System.out.println("14:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 30) {
				System.out.println("15:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 31) {
				System.out.println("15:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 32) {
				System.out.println("16:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 33) {
				System.out.println("16:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 34) {
				System.out.println("17:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 35) {
				System.out.println("17:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 36) {
				System.out.println("18:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 37) {
				System.out.println("18:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 38) {
				System.out.println("19:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 39) {
				System.out.println("19:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 40) {
				System.out.println("20:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 41) {
				System.out.println("20:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 42) {
				System.out.println("21:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 43) {
				System.out.println("21:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 44) {
				System.out.println("22:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 45) {
				System.out.println("22:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 46) {
				System.out.println("23:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability() == 47) {
				System.out.println("23:30 ");
			}
		}
	}
}

