package converge;

import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;

public class AddEvent{

	
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
	int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

	String startAvailability;
	String endAvailability;

	Scanner scan = new Scanner(System.in);
	
	Vector<Vector<String>> datesAndTimes;
	Vector<String> tasks;
	Vector<Vector<String>> attendees;
	
	Vector<String> tempDay; //vector that stores all times for a specific day
	
	boolean subsequentDate;

	/**
	 * Method runs the user interaction allowing the admin to create an event.
	 * @throws IOException On invalid user input
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
	 * This method requests the Admin's event date and stores it in an integer array.
	 *
	 * @return an integer array that stores the date in the format mm/dd/yyyy.
	 */
	private void getDatesAndTimes(Vector<Vector<String>> datesAndTimes) {
		boolean moreDates = true; //boolean that checks if user wants to add more dates
		String addAnotherDay;
		subsequentDate = false;

		while(moreDates) {
			clearPrint("Enter event date (mm/dd/yyyy)");
			String tempDate = scan.nextLine();

			while(!checkDate(tempDate)) {
				clearPrint("Error! Invalid date.\n\nEnter event date(mm/dd/yyyy)");
				tempDate = scan.nextLine();
			}
				
			int monthInt = Integer.parseInt(tempDate.substring(0,2));
			int dayInt = Integer.parseInt(tempDate.substring(3,5));
			int yearInt = Integer.parseInt(tempDate.substring(6,10));

			while((yearInt < currentYear) || (yearInt == currentYear && monthInt < currentMonth + 1) || (yearInt == currentYear && monthInt == currentMonth + 1 && dayInt < currentDay)) {
				clearPrint("Error! Cannot create an event in the past.\n\nEnter event date(mm/dd/yyyy)");
				tempDate = scan.nextLine();
				
				while(!checkDate(tempDate)) {
					clearPrint("Error! Invalid date.\n\nEnter event date(mm/dd/yyyy)");
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
			
			while(!(addAnotherDay.charAt(0) == 'y' || addAnotherDay.charAt(0) == 'n')) {
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
	 * This method checks if a given date is real
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
	 * This method checks if given date is a valid leap year
	 * @return true if date is valid, false if not
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
	 * This method takes in a day and prompts user to input times for that day
	 * @return Vector<String> containing times
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
			
			while(addAnotherTime.charAt(0) != 'y' && addAnotherTime.charAt(0) != 'n') {
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
	 * This method prompts user to input tasks their event requires
	 * @return string vector containing tasks
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
				
				while(addAnotherTask.charAt(0) != 'y' && addAnotherTask.charAt(0) != 'n') {
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
	 * This method is used to clearly print a string for better looking output.
	 *
	 * @param text The string that will get clearly printed.
	 * @throws IOException On input error.
	 */
	private void clearPrint(String text)
	{
		clearScreen();
		System.out.println(text);
	}

	/**
	 * This method clears the output of whatever has been previously displayed.
	 */
	private void clearScreen()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println("\n");
		}
	}
}