package converge;

import java.util.Vector;

/**
 * The DateAndTime.java file is used to implement the DateAndTime class that stores the information needed
 * for an DayAndTime to be created.
 * 
 * @author Team "Team"
 * @since 2017-10-02
 */

public class DateAndTimes {
	/**
	 * int used to store the month of the DayAndTime.
	 */
//	int dt_month;
//	/**
//	 * int used to store the day of the DayAndTime.
//	 */
//	int dt_day;
//	/**
//	 * int used to store the year of the DayAndTime.
//	 */
//	int dt_year;
	/**
	 * vector of ints used to store times for each date.
	 */
	EventDate dt_date;
	Vector<Integer>  dt_availability = new Vector<Integer>();;
	//Constructor methods
	/**
	 * default constructor for the DateAndTimes class.
	 */
	public DateAndTimes() {}
	
	public DateAndTimes(EventDate date, Vector<Integer> availability) {
//		this.dt_month = month;
//		this.dt_day = day;
//		this.dt_year = year;
		this.dt_date = date;
		this.dt_availability = availability;
	}
//	/**
//	 * method that sets the month of the DayAndTime.
//	 * 
//	 * @param month an integer that represents the month of the DayAndTime.
//	 */
//	public int getMonth() {
//		return dt_month;
//	}
//	/**
//	 * method that gets the month of the DayAndTime.
//	 * 
//	 * @return an integer illustrating the month of the DayAndTime.
//	 */
//	public void setMonth(int dt_month) {
//		this.dt_month = dt_month;
//	}
//	/**
//	 * method that gets the day of the DayAndTime.
//	 * 
//	 * @return an integer representing the day of the DayAndTime.
//	 */
//	public int getDay() {
//		return dt_day;
//	}
//	/**
//	 * method that sets the day of the DayAndTime.
//	 * 
//	 * @param day an integer that represents the day of the DayAndTime.
//	 */
//	public void setDay(int dt_day) {
//		this.dt_day = dt_day;
//	}
//	/**
//	 * method to set the year of the DayAndTime.
//	 * 
//	 * @param year integer that represents the year of the DayAndTime.
//	 */
//	public int getYear() {
//		return dt_year;
//	}
//	/**
//	 * method to set the year of the DayAndTime.
//	 * 
//	 * @param year integer that represents the year of the DayAndTime.
//	 */
//	public void setYear(int dt_year) {
//		this.dt_year = dt_year;
//	}
	/**
	 * method that gets the availability vector of the DayAndTime.
	 * 
	 * @return vector of ints used to store times for each date.
	 */
	public Vector<Integer> getAvailability() {
		return dt_availability;
	}
	/**
	 * method to set the availability vector of the DayAndTime.
	 * 
	 * @param vector of ints used to store times for each date.
	 */
	public void setAvailability(Vector<Integer> dt_availability) {
		this.dt_availability = dt_availability;
	}
	public EventDate getDate() {
		return dt_date;
	}
	public void setDate(EventDate dt_date) {
		this.dt_date = dt_date;
	}
	
}
