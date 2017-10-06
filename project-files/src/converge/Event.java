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
	 * String used to store the name of the event.
	 */
	String a_adminName;
	/**
	 * Vector of Attendees used to store the attendees.
	 */
	Vector<Attendee> a_attendees = new Vector<Attendee>();
	/**
	 * Vector of integers used to store the admins availability.
	 */
	Vector<Vector<String>> a_adminAvailability = new Vector<Vector<String>>();
	/**
	 * Vector of integers used to store the admin's requested tasks.
	 */
	Vector<String> a_adminTaskList = new Vector<String>();
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
	 * @param tasks vector of attendees holding the information of all the attendees
	 * tasks.
	 * @param adminAvailability vector of integers storing the availability of the admin.
	 */
	public Event(String eventName )
//	public Event(String eventName, String adminName, Vector<Attendee> attendees, Vector<Vector<String>> adminAvailability, Vector<String> tasks )
	{
		a_eventName = eventName;
//		a_adminName = adminName;
//		a_attendees = attendees;
//		a_adminAvailability = adminAvailability;
//		a_adminTaskList = tasks;

	}
	/**
	 * method that prints all information of the event
	 */
	public void print()
	{
		System.out.println(a_eventName);
		System.out.println(a_adminName);
		System.out.println(a_adminAvailability);
		System.out.println(a_adminTaskList);
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
	public void setAdminName(String a_adminName) {
		this.a_adminName = a_adminName;
	}
	public Vector<Attendee> getAttendees() {
		return a_attendees;
	}
	public void setAttendees(Vector<Attendee> a_attendees) {
		this.a_attendees = a_attendees;
	}
	public Vector<Vector<String>> getAdminAvailability() {
		return a_adminAvailability;
	}
	public void setAdminAvailability(Vector<Vector<String>> a_adminAvailability) {
		this.a_adminAvailability = a_adminAvailability;
	}
	public Vector<String> getAdminTaskList() {
		return a_adminTaskList;
	}
	public void setAdminTaskList(Vector<String> a_adminTaskList) {
		this.a_adminTaskList = a_adminTaskList;
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
	public void addAdminAvailability(Vector<String> dt)
	{
		a_adminAvailability.add(dt);
	}
	public void addTask(String t)
	{
		a_adminTaskList.add(t);
	}
	
	/**
	 * method that exports the event information to a file.
	 *
	 * @throws IOException on bad input
	 */
	public void writeEventToFile() throws IOException
	{

//		File file = new File("events.txt");
//		file.createNewFile();
		
		//Export file to .event file in /bin/ directory
		String fileName = "bin/" + a_eventName.replaceAll("\\s+","") + ".event";
		FileWriter prewrite = new FileWriter(fileName, true);
		BufferedWriter writer = new BufferedWriter(prewrite);

		//Output name and date accordingly
		writer.write(a_eventName);
		writer.newLine();
		writer.write(a_adminName);
		writer.newLine();
//		writer.write(a_adminAvailability.);

		//Output the admin availability vector
		for (int i = 0; i < a_adminAvailability.size(); i++)
		{
			writer.write(a_adminAvailability.get(i) + " ");
		}
		writer.newLine();

		//Iterate through attendees lines
		for (int i = 0; i < a_attendees.size(); i++)
		{
			//Output the name and availability of the attendee
			writer.write(a_attendees.get(i).getName() + " ");
			for (int j = 0; j < a_attendees.get(i).getAvailability().size(); j++)
			{
				writer.write(a_attendees.get(i).getAvailability().get(j) + " ");
			}
			writer.newLine();
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
	public Vector<Vector<String>> getAvailability()
	{
		return a_adminAvailability;
	}
	/**
	 * method that gets the admin's tasks.
	 *
	 * @return a vector that stores the admin's tasks.
	 */
	public Vector<String> getTasks()
	{
		return a_adminTaskList;
	}
	/**
	 * method that looks at the vector of integer for the admin's availability and prints
	 * its corresponding 12 hour time string.
	 */
	public void get12HourAvailability() {
//		for(int i= 0; i < a_adminAvailability.size(); i++) {
//
//			if(a_adminAvailability.elementAt(i)  == 0) {
//				System.out.println("12:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i)  == 1) {
//				System.out.println("12:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i)  == 2) {
//				System.out.println("1:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 3) {
//				System.out.println("1:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 4) {
//				System.out.println("2:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 5) {
//				System.out.println("2:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 6) {
//				System.out.println("3:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 7) {
//				System.out.println("3:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 8) {
//				System.out.println("4:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 9) {
//				System.out.println("4:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 10) {
//				System.out.println("5:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 11) {
//				System.out.println("5:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 12) {
//				System.out.println("6:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 13) {
//				System.out.println("6:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 14) {
//				System.out.println("7:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 15) {
//				System.out.println("7:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 16) {
//				System.out.println("8:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 17) {
//				System.out.println("8:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 18) {
//				System.out.println("9:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 19) {
//				System.out.println("9:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 20) {
//				System.out.println("10:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 21) {
//				System.out.println("10:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 22) {
//				System.out.println("11:00AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 23) {
//				System.out.println("11:30AM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 24) {
//				System.out.println("12:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 25) {
//				System.out.println("12:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 26) {
//				System.out.println("1:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 27) {
//				System.out.println("1:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 28) {
//				System.out.println("2:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 29) {
//				System.out.println("2:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 30) {
//				System.out.println("3:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 31) {
//				System.out.println("3:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 32) {
//				System.out.println("4:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 33) {
//				System.out.println("4:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 34) {
//				System.out.println("5:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 35) {
//				System.out.println("5:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 36) {
//				System.out.println("6:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 37) {
//				System.out.println("6:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 38) {
//				System.out.println("7:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 39) {
//				System.out.println("7:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 40) {
//				System.out.println("8:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 41) {
//				System.out.println("8:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 42) {
//				System.out.println("9:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 43) {
//				System.out.println("9:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 44) {
//				System.out.println("10:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 45) {
//				System.out.println("10:30PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 46) {
//				System.out.println("11:00PM ");
//			}
//			else if(a_adminAvailability.elementAt(i) == 47) {
//				System.out.println("11:30PM ");
//			}
//		}
	}
	/**
	 * method that looks at the vector of integer for the admin's availability and prints
	 * its corresponding 24 hour time string.
	 */
	public void get24HourAvailability() {
			for(int i= 0; i < a_adminAvailability.size(); i++) {

			if(Integer.parseInt(a_adminAvailability.elementAt(i)) == 0) {
				System.out.println("00:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 1) {
				System.out.println("00:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 2) {
				System.out.println("1:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 3) {
				System.out.println("1:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 4) {
				System.out.println("2:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 5) {
				System.out.println("2:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 6) {
				System.out.println("3:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 7) {
				System.out.println("3:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 8) {
				System.out.println("4:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 9) {
				System.out.println("4:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 10) {
				System.out.println("5:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 11) {
				System.out.println("5:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 12) {
				System.out.println("6:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 13) {
				System.out.println("6:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 14) {
				System.out.println("7:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 15) {
				System.out.println("7:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 16) {
				System.out.println("8:00");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 17) {
				System.out.println("8:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 18) {
				System.out.println("9:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 19) {
				System.out.println("9:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 20) {
				System.out.println("10:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 21) {
				System.out.println("10:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 22) {
				System.out.println("11:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 23) {
				System.out.println("11:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 24) {
				System.out.println("12:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 25) {
				System.out.println("12:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 26) {
				System.out.println("13:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 27) {
				System.out.println("13:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 28) {
				System.out.println("14:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 29) {
				System.out.println("14:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 30) {
				System.out.println("15:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 31) {
				System.out.println("15:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 32) {
				System.out.println("16:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 33) {
				System.out.println("16:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 34) {
				System.out.println("17:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 35) {
				System.out.println("17:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 36) {
				System.out.println("18:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 37) {
				System.out.println("18:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 38) {
				System.out.println("19:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 39) {
				System.out.println("19:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 40) {
				System.out.println("20:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 41) {
				System.out.println("20:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 42) {
				System.out.println("21:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 43) {
				System.out.println("21:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 44) {
				System.out.println("22:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 45) {
				System.out.println("22:30 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 46) {
				System.out.println("23:00 ");
			}
			else if(a_adminAvailability.elementAt(i).getAvailability().elementAt(i) == 47) {
				System.out.println("23:30 ");
			}
		}
	}
}