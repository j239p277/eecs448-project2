package converge;

public class EventDate {
	int month;
	/**
	 * int used to store the day of the DayAndTime.
	 */
	int day;
	/**
	 * int used to store the year of the DayAndTime.
	 */
	int year;
	public EventDate() {}
	public EventDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDateString() {
		return (String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
	}
}
