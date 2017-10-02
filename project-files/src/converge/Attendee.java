package converge;
import java.util.*;

/**
 * The Attendee.java file implements the class Attendee that store's the attendee's information
 * needed to join an event.
 * 
 * @author Vivek Tallavajhala
 * @since 2017-09-14
 */
public class Attendee {
	//Declare local variables
	/**
	 * Represents the username of the attendee as a String.
	 */
	String userName;
	/**
	 * Represents the availability of the attendee as a Vector of integers 0-47
	 * each representing a specific 30 minute block of the day.
	 */
	Vector<Integer> availability = new Vector<Integer>();
	
	//Constructor methods
	/**
	 * default constructor for the Attendee class.
	 */
	public Attendee() {}
	/**
	 * Parameterized constructor that initializes the name and availability of the attendee.
	 * 
	 * @param name String the represents the attendee's name
	 * @param input Vector of integers that represents the attendee's availability.
	 */
	public Attendee(String name, Vector<Integer> input)
	{
		userName = name;
		availability = input;
	}
	/**
	 * Method that gets attendee's username.
	 * 
	 * @return A string representing the attendee's username.
	 */
	public String getName()
	{
		return userName;
	}
	/**
	 * Method that get's attendee's availability.
	 * 
	 * @return A vector of integers representing the attendee's availability.
	 */
	public Vector<Integer> getAvailability()
	{
		return availability;
	}
	/**
	 * Sets the attendee's username.
	 * 
	 * @param name A string containing the attendee's username.
	 */
	public void setName(String name)
	{
		userName = name;
	}
}
