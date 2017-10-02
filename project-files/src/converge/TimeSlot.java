package converge;

/**
 * The TimeSlot.java file is used to implement the TimeSlot class that stores the information needed
 * for an time slot to be created.
 * 
 * @author Jan Polzer
 * @since 2017-10-01
 */
public class TimeSlot {
	/**
	 * int used to store the month of the time slot.
	 */
	int ts_month;
	/**
	 * int used to store the day of the time slot.
	 */
	int ts_day;
	/**
	 * int used to store the year of the time slot.
	 */
	int ts_year;
	/**
	 * int used to store an integer corresponding to the time slot.
	 */
	int ts_availability;
	
	public TimeSlot(Integer month, Integer day, Integer year, Integer availability) {
		this.ts_month = month;
		this.ts_day = day;
		this.ts_year = year;
		this.ts_availability = availability;
	}
	/**
	 * method that sets the month of the time slot
	 * 
	 * @param month an integer that represents the month of the time slot.
	 */
	public int getMonth() {
		return ts_month;
	}
	/**
	 * method that gets the month of the time slot.
	 * 
	 * @return an integer illustrating the month of the time slot.
	 */
	public void setMonth(int ts_month) {
		this.ts_month = ts_month;
	}
	/**
	 * method that gets the day of the time slot.
	 * 
	 * @return an integer representing the day of the time slot.
	 */
	public int getDay() {
		return ts_day;
	}
	/**
	 * method that sets the day of the time slot.
	 * 
	 * @param day an integer that represents the day of the time slot.
	 */
	public void setDay(int ts_day) {
		this.ts_day = ts_day;
	}
	/**
	 * method to set the year of the time slot.
	 * 
	 * @param year integer that represents the year of the time slot.
	 */
	public int getYear() {
		return ts_year;
	}
	/**
	 * method to set the year of the time slot.
	 * 
	 * @param year integer that represents the year of the time slot.
	 */
	public void setYear(int ts_year) {
		this.ts_year = ts_year;
	}
	/**
	/**
	 * method to set the availability of the time slot.
	 * 
	 * @param year integer that represents the year of the time slot.
	 */
	public int getAvailability() {
		return ts_availability;
	}
	/**
	 * method to set the availability integer of the time slot.
	 * 
	 * @param year integer that represents the year of the time slot.
	 */
	public void setAvailability(int ts_availability) {
		this.ts_availability = ts_availability;
	}
}
