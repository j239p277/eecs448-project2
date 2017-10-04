package converge;

import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * The AddEvent.java file will be used to implement the Admin Mode for the Converge Application
 *
 * @author Vivek Tallavajhala
 * @since 2017-09-15
 */
public class AddEvent{
	/**
	 * integer used to track the user's choice input.
	 */
	int choice;

	/**
	 * integer used to track the current year.
	 */
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	/**
	 * integer used to track the current month.
	 */
	int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

	/**
	 * integer used to track the current day.
	 */
	int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

	/**
	 * string used to store the starting availability of the admin.
	 */
	String startAvailability;

	/**
	 * string used to store the ending availability of the admin.
	 */
	String endAvailability;

	/**
	 * vector that hold integers 0-47 that each represent time availability in 30
	 * minute periods throughout the day.
	 */
	Vector<Integer> timeVec = new Vector<Integer>() ;
	{
	for (int i = 0; i < 48; i++)
		{
			timeVec.addElement(i);
		}
	}

	/**
	 * attendee object created for the admin.
	 */
	Attendee admin = new Attendee();

	/**
	 * Event object initialized to later store all admin event information.
	 */
	Event adminEvent = new Event();

	/**
	 * Scanner object initialized to handle user interaction.
	 */
	Scanner userInput = new Scanner(System.in);
	
	Vector<Vector<String>> datesAndTimes = new Vector();

	/**
	 * Method runs the user interaction allowing the admin to create an event.
	 * @throws IOException On invalid user input
	 */
	public void start() throws IOException
	{
		clearPrint("Enter event name:");
		String eventName = userInput.nextLine(); //get event name
		while(eventName.length() == 0) {
			clearPrint("Error! Event name cannot be blank\nEnter event name:");
			eventName = userInput.nextLine();
		}

		clearPrint("Enter host name:");
		String hostName = userInput.nextLine(); //get host name
		while(hostName.length() == 0) {
			clearPrint("Error! Host name cannot be blank\nEnter host name:");
			hostName = userInput.nextLine();
		}

		getDatesAndTimes();
		
		System.out.println(datesAndTimes);
		//now the variable "days" holds number of days for this event
		
		//Vector<String> tasks = getTasks();
		
		
		//NOW WRITE TO FILE
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
		for (int i = 0; i < 100; i++)
		{
			System.out.println("\n");
		}
	}
	
	Vector<String> tempDay; //vector that stores all times for a specific day

	int days;
	
	boolean subsequentDate;
	
	/**
	 * This method requests the Admin's event date and stores it in an integer array.
	 *
	 * @return an integer array that stores the date in the format mm/dd/yyyy.
	 */
	private void getDatesAndTimes()
	{
		boolean moreDates = true; //boolean that checks if user wants to add more dates
		days = 0; //number of days the event takes place
		String addAnotherDay;
		subsequentDate = false;

		while(moreDates) {
			clearPrint("Enter event date (mm/dd/yyyy)");
			String tempDate = userInput.nextLine();

			while(!checkDate(tempDate)) {
				clearPrint("Error! Invalid date.\nEnter event date(mm/dd/yyyy)");
				tempDate = userInput.nextLine();
			}
				
			int monthInt = Integer.parseInt(tempDate.substring(0,2));
			int dayInt = Integer.parseInt(tempDate.substring(3,5));
			int yearInt = Integer.parseInt(tempDate.substring(6,10));

			while((yearInt < currentYear) || (yearInt == currentYear && monthInt < currentMonth + 1) || (yearInt == currentYear && monthInt == currentMonth + 1 && dayInt < currentDay)) {
				clearPrint("Error! Cannot create an event in the past.\nEnter event date(mm/dd/yyyy)");
				tempDate = userInput.nextLine();
				
				while(!checkDate(tempDate)) {
					clearPrint("Error! Invalid date.\nEnter event date(mm/dd/yyyy)");
					tempDate = userInput.nextLine();
				}
				
				monthInt = Integer.parseInt(tempDate.substring(0,2));
				dayInt = Integer.parseInt(tempDate.substring(3,5));
				yearInt = Integer.parseInt(tempDate.substring(6,10));
			}
			
			tempDay = new Vector();
			getTimes(tempDate);
			datesAndTimes.addElement(tempDay);
			days++;
			
			clearPrint("Would you like to add another day? Enter: 'y' or 'n' (Without quotes)");
			addAnotherDay = userInput.nextLine();
			
			while(!(addAnotherDay.charAt(0) == 'y' || addAnotherDay.charAt(0) == 'n')) {
				clearPrint("Error! Invalid input\nWould you like to add another day? Enter: 'y' or 'n' (Without quotes)");
				addAnotherDay = userInput.nextLine();
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
		
		if(subsequentDate) {
			clearPrint("Would you like to copy times from original date? Enter: 'y' or 'n' (Without quotes)");
			copyTimesInput = userInput.nextLine();
			
			while(copyTimesInput.charAt(0) != 'y' && copyTimesInput.charAt(0) != 'n') {
				clearPrint("Error! Invalid input\nWould you like to copy times from original date? Enter: 'y' or 'n' (Without quotes)");
				copyTimesInput = userInput.nextLine();
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
		
		modeInput = userInput.nextLine();
		
		while(!validInput) {
			try {
				if(Integer.parseInt(modeInput) != 12 && Integer.parseInt(modeInput) != 24) {
					throw new Exception();
				} else {
					validInput = true;
				}
				
			} catch (Exception e) {
				clearPrint("Error! Invalid input\nWould you like to use 12 hour mode or 24 hour mode? (12/24)");
				modeInput = userInput.nextLine();
			}
		}
		
		String addAnotherTime;
		
		do {
			if(Integer.parseInt(modeInput) == 12) {
				clearPrint("Enter your starting availability. Format: 3:00AM or 3:00PM");
				startAvailability = userInput.nextLine();
				
				while(twelveHourtoInt(startAvailability) == 50) {
					clearPrint("Error! Invalid input\nEnter your starting availability. Format: 3:00AM or 3:00PM");
					startAvailability = userInput.nextLine();
				}
				
				clearPrint("Enter your ending availability. Format: 3:00AM or 3:00PM");
				endAvailability = userInput.nextLine();
				
				while(twelveHourtoInt(endAvailability) == 50 || twelveHourtoInt(endAvailability) < twelveHourtoInt(startAvailability)) {
					clearPrint("Error! The input time is invalid\nEnter your ending availability. Format: 3:00AM or 3:00PM");
					endAvailability = userInput.nextLine();
				}
				
				tempDay.addElement(day);
				
				for(int i = twelveHourtoInt(startAvailability); i <= twelveHourtoInt(endAvailability); i++) {
					tempDay.addElement(Integer.toString(i));
				}
			} else {
				clearPrint("Enter your starting availability. Format: 3:00 or 15:00");
				startAvailability = userInput.nextLine();
				
				while(twentyFourHourtoInt(startAvailability) == 50) {
					clearPrint("Error! Invalid input\nEnter your starting availability. Format: 3:00 or 15:00");
					startAvailability = userInput.nextLine();
				}
				
				clearPrint("Enter your ending availability. Format: 3:00 or 15:00");
				endAvailability = userInput.nextLine();
				
				while(twentyFourHourtoInt(endAvailability) == 50 || twentyFourHourtoInt(endAvailability) < twentyFourHourtoInt(startAvailability)) {
					clearPrint("Error! The input time is invalid\nEnter your ending availability. Format: 3:00 or 15:00");
					endAvailability = userInput.nextLine();
				}
				
				tempDay.addElement(day);
				
				for(int i = twentyFourHourtoInt(startAvailability); i <= twentyFourHourtoInt(endAvailability); i++) {
					tempDay.addElement(Integer.toString(i));
				}
			}
			
			clearPrint("Would you like to add another slot of availability? Enter: 'y' or 'n' (Without quotes)");
			addAnotherTime = userInput.nextLine();
			
			while(addAnotherTime.charAt(0) != 'y' && addAnotherTime.charAt(0) != 'n') {
				clearPrint("Error! Invalid input\nWould you like to add another slot of availability? Enter: 'y' or 'n' (Without quotes)");
				addAnotherTime = userInput.nextLine();
			}
			
		} while(addAnotherTime.charAt(0) == 'y');}
	}
	
	int numberOfTasks;
	
	/**
	 * This method prompts user to input tasks their event requires
	 * @return string vector containing tasks
	 */
	
	/*private Vector<String> getTasks() {
		boolean moreTasks = true;
		numberOfTasks = 0;
		while(moreTasks) {
			
		}
	}*/
	/**
	 * This is a method that will take in ints placed in the availability vectors
	 * and will convert it into its corresponding time string for 12 hour mode.
	 *
	 * @param i This is the integer value given to the method.
	 * @return A string representing the integers corresponding time string.
	 */
	public String twelveHourConversion(int i)
	{
		if(i==0)
		{
			return "12:00AM";
		}
		else if(i==1)
		{
			return "12:30AM";
		}
		else if(i==2)
		{
			return "1:00AM";
		}
		else if(i==3)
		{
			return "1:30AM";
		}
		else if(i==4)
		{
			return "2:00AM";
		}
		else if(i==5)
		{
			return "2:30AM";
		}
		else if(i==6)
		{
			return "3:00AM";
		}
		else if(i==7)
		{
			return "3:30AM";
		}
		else if(i==8)
		{
			return "4:00AM";
		}
		else if(i==9)
		{
			return "4:30AM";
		}
		else if(i==10)
		{
			return "5:00AM";
		}
		else if(i==11)
		{
			return "5:30AM";
		}
		else if(i==12)
		{
			return "6:00AM";
		}
		else if(i==13)
		{
			return "6:30AM";
		}
		else if(i==14)
		{
			return "7:00AM";
		}
		else if(i==15)
		{
			return "7:30AM";
		}
		else if(i==16)
		{
			return "8:00AM";
		}
		else if(i==17)
		{
			return "8:30AM";
		}
		else if(i==18)
		{
			return "9:00AM";
		}
		else if(i==19)
		{
			return "9:30AM";
		}
		else if(i==20)
		{
			return "10:00AM";
		}
		else if(i==21)
		{
			return "10:30AM";
		}
		else if(i==22)
		{
			return "11:00AM";
		}
		else if(i==23)
		{
			return "11:30AM";
		}
		else if(i==24)
		{
			return "12:00PM";
		}
		else if(i==25)
		{
			return "12:30PM";
		}
		else if(i==26)
		{
			return "1:00PM";
		}
		else if(i==27)
		{
			return "1:30PM";
		}
		else if(i==28)
		{
			return "2:00PM";
		}
		else if(i==29)
		{
			return "2:30PM";
		}
		else if(i==30)
		{
			return "3:00PM";
		}
		else if(i==31)
		{
			return "3:30PM";
		}
		else if(i==32)
		{
			return "4:00PM";
		}
		else if(i==33)
		{
			return "4:30PM";
		}
		else if(i==34)
		{
			return "5:00PM";
		}
		else if(i==35)
		{
			return "5:30PM";
		}
		else if(i==36)
		{
			return "6:00PM";
		}
		else if(i==37)
		{
			return "6:30PM";
		}
		else if(i==38)
		{
			return "7:00PM";
		}
		else if(i==39)
		{
			return "7:30PM";
		}
		else if(i==40)
		{
			return "8:00PM";
		}
		else if(i==41)
		{
			return "8:30PM";
		}
		else if(i==42)
		{
			return "9:00PM";
		}
		else if(i==43)
		{
			return "9:30PM";
		}
		else if(i==44)
		{
			return "10:00PM";
		}
		else if(i==45)
		{
			return "10:30PM";
		}
		else if(i==46)
		{
			return "11:00PM";
		}
		else
		{
			return "11:30PM";
		}
	}

	/**
	 * This is a method that will take in ints places in the availability vectors
	 * and will convert it into its corresponding time string for 24 hour mode.
	 *
	 * @param i This is the integer value given to the method.
	 * @return A string representing the integers corresponding time string.
	 */
	public String twentyFourHourConversion(int i)
	{
		if(i==0)
		{
			return "0:00";
		}
		else if(i==1)
		{
			return "0:30";
		}
		else if(i==2)
		{
			return "1:00";
		}
		else if(i==3)
		{
			return "1:30";
		}
		else if(i==4)
		{
			return "2:00";
		}
		else if(i==5)
		{
			return "2:30";
		}
		else if(i==6)
		{
			return "3:00";
		}
		else if(i==7)
		{
			return "3:30";
		}
		else if(i==8)
		{
			return "4:00";
		}
		else if(i==9)
		{
			return "4:30";
		}
		else if(i==10)
		{
			return "5:00";
		}
		else if(i==11)
		{
			return "5:30";
		}
		else if(i==12)
		{
			return "6:00";
		}
		else if(i==13)
		{
			return "6:30";
		}
		else if(i==14)
		{
			return "7:00";
		}
		else if(i==15)
		{
			return "7:30";
		}
		else if(i==16)
		{
			return "8:00";
		}
		else if(i==17)
		{
			return "8:30";
		}
		else if(i==18)
		{
			return "9:00";
		}
		else if(i==19)
		{
			return "9:30";
		}
		else if(i==20)
		{
			return "10:00";
		}
		else if(i==21)
		{
			return "10:30";
		}
		else if(i==22)
		{
			return "11:00";
		}
		else if(i==23)
		{
			return "11:30";
		}
		else if(i==24)
		{
			return "12:00";
		}
		else if(i==25)
		{
			return "12:30";
		}
		else if(i==26)
		{
			return "13:00";
		}
		else if(i==27)
		{
			return "13:30";
		}
		else if(i==28)
		{
			return "14:00";
		}
		else if(i==29)
		{
			return "14:30";
		}
		else if(i==30)
		{
			return "15:00";
		}
		else if(i==31)
		{
			return "15:30";
		}
		else if(i==32)
		{
			return "16:00";
		}
		else if(i==33)
		{
			return "16:30";
		}
		else if(i==34)
		{
			return "17:00";
		}
		else if(i==35)
		{
			return "17:30";
		}
		else if(i==36)
		{
			return "18:00";
		}
		else if(i==37)
		{
			return "18:30";
		}
		else if(i==38)
		{
			return "19:00";
		}
		else if(i==39)
		{
			return "19:30";
		}
		else if(i==40)
		{
			return "20:00";
		}
		else if(i==41)
		{
			return "20:30";
		}
		else if(i==42)
		{
			return "21:00";
		}
		else if(i==43)
		{
			return "21:30";
		}
		else if(i==44)
		{
			return "22:00";
		}
		else if(i==45)
		{
			return "22:30";
		}
		else if(i==46)
		{
			return "23:00";
		}
		else
		{
			return "23:30";
		}
	}

	/**
	 * Converts time strings for 12 hour mode as its corresponding integer for the availability vectors.
	 *
	 * @param time The time as a string that the user inputs in 12 hour mode.
	 * @return an integer representing the time string's corresponding integer for the availability vector.
	 */
	public static int twelveHourtoInt(String time)
	{
		if(time.equals("12:00AM"))
		{
			return 0;
		}
		else if(time.equals( "12:30AM"))
		{
			return 1;
		}
		else if(time.equals( "1:00AM"))
		{
			return 2;
		}
		else if(time.equals( "1:30AM"))
		{
			return 3;
		}
		else if(time.equals( "2:00AM"))
		{
			return 4;
		}
		else if(time.equals( "2:30AM"))
		{
			return 5;
		}
		else if(time.equals( "3:00AM"))
		{
			return 6;
		}
		else if(time.equals( "3:30AM"))
		{
			return 7;
		}
		else if(time.equals( "4:00AM"))
		{
			return 8;
		}
		else if(time.equals( "4:30AM"))
		{
			return 9;
		}
		else if(time.equals( "5:00AM"))
		{
			return 10;
		}
		else if(time.equals( "5:30AM"))
		{
			return 11;
		}
		else if(time.equals( "6:00AM"))
		{
			return 12;
		}
		else if(time.equals( "6:30AM"))
		{
			return 13;
		}
		else if(time.equals( "7:00AM"))
		{
			return 14;
		}
		else if(time.equals( "7:30AM"))
		{
			return 15;
		}
		else if(time.equals( "8:00AM"))
		{
			return 16;
		}
		else if(time.equals( "8:30AM"))
		{
			return 17;
		}
		else if(time.equals( "9:00AM"))
		{
			return 18;
		}
		else if(time.equals( "9:30AM"))
		{
			return 19;
		}
		else if(time.equals( "10:00AM"))
		{
			return 20;
		}
		else if(time.equals( "10:30AM"))
		{
			return 21;
		}
		else if(time.equals( "11:00AM"))
		{
			return 22;
		}
		else if(time.equals( "11:30AM"))
		{
			return 23;
		}
		else if(time.equals( "12:00PM"))
		{
			return 24;
		}
		else if(time.equals( "12:30PM"))
		{
			return 25;
		}
		else if(time.equals( "1:00PM"))
		{
			return 26;
		}
		else if(time.equals( "1:30PM"))
		{
			return 27;
		}
		else if(time.equals( "2:00PM"))
		{
			return 28;
		}
		else if(time.equals( "2:30PM"))
		{
			return 29;
		}
		else if(time.equals( "3:00PM"))
		{
			return 30;
		}
		else if(time.equals( "3:30PM"))
		{
			return 31;
		}
		else if(time.equals( "4:00PM"))
		{
			return 32;
		}
		else if(time.equals( "4:30PM"))
		{
			return 33;
		}
		else if(time.equals( "5:00PM"))
		{
			return 34;
		}
		else if(time.equals( "5:30PM"))
		{
			return 35;
		}
		else if(time.equals( "6:00PM"))
		{
			return 36;
		}
		else if(time.equals( "6:30PM"))
		{
			return 37;
		}
		else if(time.equals( "7:00PM"))
		{
			return 38;
		}
		else if(time.equals( "7:30PM"))
		{
			return 39;
		}
		else if(time.equals( "8:00PM"))
		{
			return 40;
		}
		else if(time.equals( "8:30PM"))
		{
			return 41;
		}
		else if(time.equals( "9:00PM"))
		{
			return 42;
		}
		else if(time.equals( "9:30PM"))
		{
			return 43;
		}
		else if(time.equals( "10:00PM"))
		{
			return 44;
		}
		else if(time.equals( "10:30PM"))
		{
			return 45;
		}
		else if(time.equals( "11:00PM"))
		{
			return 46;
		}
		else if(time.equals( "11:30PM"))
		{
			return 47;
		}
		else
		{
			return 50; //random value that for all other cases that will throw an error else if the time isn't one of the above.
		}
	}

	/**
	 * Converts time strings for 24 hour mode as its corresponding integer for the availability vectors.
	 *
	 * @param time The time as a string that the user inputs in 24 hour mode.
	 * @return an integer representing the time string's corresponding integer for the availability vector.
	 */
	public static int twentyFourHourtoInt(String time)
	{
		if(time.equals( "0:00"))
		{
			return 0;
		}
		else if(time.equals( "0:30"))
		{
			return 1;
		}
		else if(time.equals( "1:00"))
		{
			return 2;
		}
		else if(time.equals( "1:30"))
		{
			return 3;
		}
		else if(time.equals( "2:00"))
		{
			return 4;
		}
		else if(time.equals( "2:30"))
		{
			return 5;
		}
		else if(time.equals( "3:00"))
		{
			return 6;
		}
		else if(time.equals( "3:30"))
		{
			return 7;
		}
		else if(time.equals( "4:00"))
		{
			return 8;
		}
		else if(time.equals( "4:30"))
		{
			return 9;
		}
		else if(time.equals( "5:00"))
		{
			return 10;
		}
		else if(time.equals( "5:30"))
		{
			return 11;
		}
		else if(time.equals( "6:00"))
		{
			return 12;
		}
		else if(time.equals( "6:30"))
		{
			return 13;
		}
		else if(time.equals( "7:00"))
		{
			return 14;
		}
		else if(time.equals( "7:30"))
		{
			return 15;
		}
		else if(time.equals( "8:00"))
		{
			return 16;
		}
		else if(time.equals( "8:30"))
		{
			return 17;
		}
		else if(time.equals( "9:00"))
		{
			return 18;
		}
		else if(time.equals( "9:30"))
		{
			return 19;
		}
		else if(time.equals( "10:00"))
		{
			return 20;
		}
		else if(time.equals( "10:30"))
		{
			return 21;
		}
		else if(time.equals( "11:00"))
		{
			return 22;
		}
		else if(time.equals( "11:30"))
		{
			return 23;
		}
		else if(time.equals( "12:00"))
		{
			return 24;
		}
		else if(time.equals( "12:30"))
		{
			return 25;
		}
		else if(time.equals( "13:00"))
		{
			return 26;
		}
		else if(time.equals( "13:30"))
		{
			return 27;
		}
		else if(time.equals( "14:00"))
		{
			return 28;
		}
		else if(time.equals( "14:30"))
		{
			return 29;
		}
		else if(time.equals( "15:00"))
		{
			return 30;
		}
		else if(time.equals( "15:30"))
		{
			return 31;
		}
		else if(time.equals( "16:00"))
		{
			return 32;
		}
		else if(time.equals( "16:30"))
		{
			return 33;
		}
		else if(time.equals( "17:00"))
		{
			return 34;
		}
		else if(time.equals( "17:30"))
		{
			return 35;
		}
		else if(time.equals( "18:00"))
		{
			return 36;
		}
		else if(time.equals( "18:30"))
		{
			return 37;
		}
		else if(time.equals( "19:00"))
		{
			return 38;
		}
		else if(time.equals( "19:30"))
		{
			return 39;
		}
		else if(time.equals( "20:00"))
		{
			return 40;
		}
		else if(time.equals( "20:30"))
		{
			return 41;
		}
		else if(time.equals( "21:00"))
		{
			return 42;
		}
		else if(time.equals( "21:30"))
		{
			return 43;
		}
		else if(time.equals( "22:00"))
		{
			return 44;
		}
		else if(time.equals("22:30"))
		{
			return 45;
		}
		else if(time.equals("23:00"))
		{
			return 46;
		}
		else if(time.equals("23:30"))
		{
			return 47;
		}
		else
		{
			return 50; //random value that for all other cases that will throw an error else if the time isn't one of the above.
		}
	}
}