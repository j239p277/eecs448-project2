package converge;

import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;

/**
 * Controls event creation, prompting the user for all required information, then creates an event obejct containing given information.
 * @since 2017-10-8
 */

public class AddEvent{

	/**
	 * int representing current year
	 */
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	/**
	 * int representing current month
	 */
	int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
	/**
	 * int representing current day of the month
	 */
	int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	/**
	 * temporary string representing start time for a slot of availability
	 */
	String startAvailability;
	/**
	 * temporary string representing end time for a slot of availability
	 */
	String endAvailability;
	/**
	 * instance of Scanner object that allows for user input
	 */
	Scanner scan = new Scanner(System.in);
	/**
	 * temporary 2d string vector containing dates the event takes place over and the times on each date
	 */
	Vector<Vector<String>> datesAndTimes;
	/**
	 * temporary string vector that contains the tasks for the new event
	 */
	Vector<String> tasks;
	/**
	 * temporary 2d vector containing the names and availabilities of each attendee
	 */
	Vector<Vector<String>> attendees;
	/**
	 * temporary string vector that stores all times the event takes place on a specific
	 */
	Vector<String> tempDay;
	/**
	 * boolean that simply changes prompt for all dates after the first
	 */
	boolean subsequentDate;

	/**
	 * Begins user interaction, prompts user for all information required to make an event. Stores given information in a new event object in the eventsVector
	 * @param eventsVector dynamic data structure containing all event objects
	 */
	public void start(Vector<Event> eventsVector) {
		datesAndTimes = new Vector();
		tasks = new Vector();
		attendees = new Vector();
		
		clearPrint("Enter event name:");
		String eventName = scan.nextLine(); //get event name
		while(eventName.length() == 0) {
			clearPrint("Error! Event name cannot be blank\n\nEnter event name:");
			eventName = scan.nextLine();
		}

		clearPrint("Enter host name:");
		String hostName = scan.nextLine(); //get host name
		while(hostName.length() == 0) {
			clearPrint("Error! Host name cannot be blank\n\nEnter host name:");
			hostName = scan.nextLine();
		}

		getDatesAndTimes(datesAndTimes);
		getTasks(tasks);
		constructAttendeesVector(attendees, hostName, datesAndTimes);
		
		eventsVector.addElement(new Event(eventName, hostName, datesAndTimes, tasks, attendees));
	}
	
	/**
	 * Prompts user to input the days and times over which the event takes place
	 *
	 * @param datesAndTimes dynamic data structure containing all dates and times that an event takes place over
	 */
	private void getDatesAndTimes(Vector<Vector<String>> datesAndTimes) {
		boolean moreDates = true; //boolean that checks if user wants to add more dates
		String addAnotherDay;
		subsequentDate = false;

		while(moreDates) {
			clearPrint("Enter event date (mm/dd/yyyy)");
			String tempDate = scan.nextLine();

			while(!checkDate(tempDate)) {
				clearPrint("Error! Invalid date.\n\nEnter event date (mm/dd/yyyy)");
				tempDate = scan.nextLine();
			}
				
			int monthInt = Integer.parseInt(tempDate.substring(0,2));
			int dayInt = Integer.parseInt(tempDate.substring(3,5));
			int yearInt = Integer.parseInt(tempDate.substring(6,10));

			while((yearInt < currentYear) || (yearInt == currentYear && monthInt < currentMonth + 1) || (yearInt == currentYear && monthInt == currentMonth + 1 && dayInt < currentDay)) {
				clearPrint("Error! Cannot create an event in the past.\n\nEnter event date (mm/dd/yyyy)");
				tempDate = scan.nextLine();
				
				while(!checkDate(tempDate)) {
					clearPrint("Error! Invalid date.\n\nEnter event date (mm/dd/yyyy)");
					tempDate = scan.nextLine();
				}
				
				monthInt = Integer.parseInt(tempDate.substring(0,2));
				dayInt = Integer.parseInt(tempDate.substring(3,5));
				yearInt = Integer.parseInt(tempDate.substring(6,10));
			}
			
			tempDay = new Vector();
			getTimes(tempDate);
			datesAndTimes.addElement(tempDay);
			
			clearPrint("Would you like to add another day? Enter: 'y' or 'n' (Without quotes)");
			addAnotherDay = scan.nextLine();
			
			while(addAnotherDay.length() == 0 || addAnotherDay.charAt(0) != 'y' && addAnotherDay.charAt(0) != 'n') {
				clearPrint("Error! Invalid input\n\nWould you like to add another day? Enter: 'y' or 'n' (Without quotes)");
				addAnotherDay = scan.nextLine();
			}
			
			if(addAnotherDay.charAt(0) == 'n') {
				moreDates = false;
			} else {
				subsequentDate = true;
			}
		}
	}
	/**
	 * Checks if a given date is real
	 * @param input a string representing a date
	 * @return true if given date is an authentic date, false if not
	 */

	private boolean checkDate(String input) {
			if(input.length() != 10) { //given date is not correct length
					return false;
			} else if(input.charAt(2) != '/' || input.charAt(5) != '/') { //given date is not formatted correctly
					return false;
			} else {
					String month = input.substring(0,2);
					String day = input.substring(3,5);
					String year = input.substring(6,10);

					int monthInt;
					int dayInt;
					int yearInt;

					try {
						monthInt = Integer.parseInt(month); //if they enter anything but numbers, return false
						dayInt = Integer.parseInt(day);
						yearInt = Integer.parseInt(year);
					} catch (Exception e) {
						return false;
					}

					if(monthInt < 1 || monthInt > 12) { //valid month check
						return false;
					}

					if(dayInt < 1) {
						return false;
					}


					if(monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12) {
					 	if(dayInt > 31) {
							return false;
					 	}
					} else if(monthInt == 2) {
						return checkLeapYear(yearInt, dayInt);
					} else {
						if(dayInt > 30) {
							return false;
						}
					}

					return true;

			}
	}

	/**
	 * Checks if given date is a valid leap day
	 * @param year integer representing a year
	 * @param day integer representing a day of the month
	 * @return true if given date is a valid leap day, false if not
	 */
	private boolean checkLeapYear(int year, int day) {
	 	if(day < 1) {
			return false;
		} else {
			if(year % 4 == 0) {
					if(year % 100 == 0) {
							if(year % 400 == 0) {
								return day <= 29;
							}
							return day <= 28;
					}
					return day <= 29;
			}
			return day <= 28;
		}
	}
	
	/**
	 * Prompts user to input all times the event takes place during for a given day
	 * @param day string representing a day
	 */
	private void getTimes(String day) {
		boolean moreTimes = true; //boolean that checks if user wants to add more times to a certain date
		boolean validInput = false;
		String modeInput = "";
		String copyTimesInput = "";
		boolean differentTimeSameDay = false;
		
		if(subsequentDate) {
			clearPrint("Would you like to copy times from original date? Enter: 'y' or 'n' (Without quotes)");
			copyTimesInput = scan.nextLine();
			
			while(copyTimesInput.charAt(0) != 'y' && copyTimesInput.charAt(0) != 'n') {
				clearPrint("Error! Invalid input\n\nWould you like to copy times from original date? Enter: 'y' or 'n' (Without quotes)");
				copyTimesInput = scan.nextLine();
			}
			
			if(copyTimesInput.charAt(0) == 'y') {
				int numberOfTimes = datesAndTimes.elementAt(0).size() - 1;
				
				tempDay.addElement(day);
				
				for(int i = 1; i <= numberOfTimes; i++) {
					tempDay.addElement(datesAndTimes.elementAt(0).elementAt(i));
				}
				
			} else {
				subsequentDate = false;
				getTimes(day);
			}
		} else {
		
		clearPrint("Would you like to use 12 hour mode or 24 hour mode? (12/24)");
		
		modeInput = scan.nextLine();
		
		while(!validInput) {
			try {
				if(Integer.parseInt(modeInput) != 12 && Integer.parseInt(modeInput) != 24) {
					throw new Exception();
				} else {
					validInput = true;
				}
				
			} catch (Exception e) {
				clearPrint("Error! Invalid input\n\nWould you like to use 12 hour mode or 24 hour mode? (12/24)");
				modeInput = scan.nextLine();
			}
		}
		
		String addAnotherTime;
		
		do {
			if(Integer.parseInt(modeInput) == 12) {
				clearPrint("Enter your starting availability. Format: 3:00AM or 3:00PM");
				startAvailability = scan.nextLine();
				
				while(TimeConverter.twelveHourtoInt(startAvailability) == 50) {
					clearPrint("Error! Invalid input\n\nEnter your starting availability. Format: 3:00AM or 3:00PM");
					startAvailability = scan.nextLine();
				}
				
				clearPrint("Enter your ending availability. Format: 3:00AM or 3:00PM");
				endAvailability = scan.nextLine();
				
				while(TimeConverter.twelveHourtoInt(endAvailability) == 50 || TimeConverter.twelveHourtoInt(endAvailability) < TimeConverter.twelveHourtoInt(startAvailability)) {
					clearPrint("Error! The input time is invalid\n\nEnter your ending availability. Format: 3:00AM or 3:00PM");
					endAvailability = scan.nextLine();
				}
				
				if(!differentTimeSameDay) {
					tempDay.addElement(day);
				}
				
				for(int i = TimeConverter.twelveHourtoInt(startAvailability); i <= TimeConverter.twelveHourtoInt(endAvailability); i++) {
					tempDay.addElement(Integer.toString(i));
				}
			} else {
				clearPrint("Enter your starting availability. Format: 3:00 or 15:00");
				startAvailability = scan.nextLine();
				
				while(TimeConverter.twentyFourHourtoInt(startAvailability) == 50) {
					clearPrint("Error! Invalid input\n\nEnter your starting availability. Format: 3:00 or 15:00");
					startAvailability = scan.nextLine();
				}
				
				clearPrint("Enter your ending availability. Format: 3:00 or 15:00");
				endAvailability = scan.nextLine();
				
				while(TimeConverter.twentyFourHourtoInt(endAvailability) == 50 || TimeConverter.twentyFourHourtoInt(endAvailability) < TimeConverter.twentyFourHourtoInt(startAvailability)) {
					clearPrint("Error! The input time is invalid\n\nEnter your ending availability. Format: 3:00 or 15:00");
					endAvailability = scan.nextLine();
				}
				
				if(!differentTimeSameDay) {
					tempDay.addElement(day);
				}
				
				for(int i = TimeConverter.twentyFourHourtoInt(startAvailability); i <= TimeConverter.twentyFourHourtoInt(endAvailability); i++) {
					tempDay.addElement(Integer.toString(i));
				}
			}
			
			clearPrint("Would you like to add another slot of availability? Enter: 'y' or 'n' (Without quotes)");
			addAnotherTime = scan.nextLine();
			
			while(addAnotherTime.length() == 0 || addAnotherTime.charAt(0) != 'y' && addAnotherTime.charAt(0) != 'n') {
				clearPrint("Error! Invalid input\n\nWould you like to add another slot of availability? Enter: 'y' or 'n' (Without quotes)");
				addAnotherTime = scan.nextLine();
			}
			
			if(addAnotherTime.charAt(0) == 'y') {
				differentTimeSameDay = true;
			} else {
				differentTimeSameDay = false;
			}
			
		} while(addAnotherTime.charAt(0) == 'y');}
	}
	
	/**
	 * Prompts user to input all tasks the event requires
	 * @param tasks dynamic data structure storing the tasks
	 */
	
	private void getTasks(Vector<String> tasks) {
		boolean moreTasks = true;
		boolean firstTask = true;
		String addAnotherTask = "";
		String taskInput;
		
		while(moreTasks) {
			
			if(firstTask) {
				clearPrint("Would you like to add a task for this event? Enter: 'y' or 'n' (Without quotes)");
				addAnotherTask = scan.nextLine();
				
				while(addAnotherTask.length() == 0 || addAnotherTask.charAt(0) != 'y' && addAnotherTask.charAt(0) != 'n') {
					clearPrint("Error! Invalid input\n\nWould you like to add a task for this event? Enter: 'y' or 'n' (Without quotes)");
					addAnotherTask = scan.nextLine();
				}
				
			} else {
				clearPrint("Would you like to add another task for this event? Enter: 'y' or 'n' (Without quotes)");
				addAnotherTask = scan.nextLine();
				
				while(addAnotherTask.charAt(0) != 'y' && addAnotherTask.charAt(0) != 'n') {
					clearPrint("Error! Invalid input\n\nWould you like to add another task for this event? Enter: 'y' or 'n' (Without quotes)");
					addAnotherTask = scan.nextLine();
				}
			}
			
			if(addAnotherTask.charAt(0) == 'y') {
				clearPrint("What is the task?");
				taskInput = scan.nextLine();
				
				while(taskInput.length() == 0) {
					clearPrint("Error! Task input cannot be blank\n\nWhat is the task?");
					taskInput = scan.nextLine();
				}
				
				tasks.addElement(taskInput);
			} else {
				moreTasks = false;
			}
		}
	}
	
	/**
	 * Constructs dynamic data structure that will contain all attendees for an event, places event host in list of attendees
	 * @param attendees dynamic data structure that will hold information about the availability of every attendees
	 * @param hostName name of the event host
	 * @param datesAndTimes dynamic data structure containing the dates and times over which an event takes place
	 */
	
	private void constructAttendeesVector(Vector<Vector<String>> attendees, String hostName, Vector<Vector<String>> datesAndTimes) {
		Vector<String> tempHost = new Vector();
		tempHost.addElement(hostName);
		
		for(int i = 0; i < datesAndTimes.size(); i++) {
			
			for(int j = 0; j < datesAndTimes.elementAt(i).size(); j++) {
				tempHost.addElement(datesAndTimes.elementAt(i).elementAt(j));
			}
		}
		
		attendees.addElement(tempHost);
	}
	
	/**
	 * Clearly prints a string for better looking output.
	 * @param text The string that will get clearly printed.
	 */
	private void clearPrint(String text)
	{
		clearScreen();
		System.out.println(text);
	}

	/**
	 * Clears terminal window
	 */
	private void clearScreen()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println("\n");
		}
	}
}