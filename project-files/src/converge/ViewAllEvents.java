package converge;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;
import java.util.Vector;

/**
 * Displays all relevant information about each event.
 * @since 2017-10-8
 */

public class ViewAllEvents {

	/**
	 * Displays all event names and prompts the user to select an event to find out more
	 * @param eventsVector dynamic data structure that stores all event objects
	 */

	public void viewAllEventNames(Vector<Event> eventsVector) {
		if(eventsVector.size() == 0) {
			clearPrint("Error! There are no scheduled events.\n");
		} else {
			Scanner scan = new Scanner(System.in);
			String input = "";
			int eventChoice = -1;
			boolean validInput = false;

			//print a list of all event names
			clearScreen();
			for(int i = 0; i < eventsVector.size(); i++) {
				System.out.println((i + 1) + ". " + eventsVector.elementAt(i).getEventName() + ", hosted by " + eventsVector.elementAt(i).getHostName());
			}
			System.out.println("0. Return to menu\n\nPlease enter the number of the event you would like to join or enter 0 to return to menu");
			input = scan.nextLine();

			while(!validInput) {
				try {
					if(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= eventsVector.size()) {
						validInput = true;
					} else {
						throw new Exception();
					}
				} catch(Exception e) {
					clearPrint("Error! Invalid input\n");
					for(int i = 0; i < eventsVector.size(); i++) {
						System.out.println((i + 1) + ". " + eventsVector.elementAt(i).getEventName() + ", hosted by " + eventsVector.elementAt(i).getHostName());
					}
					System.out.println("0. Return to menu\n\nPlease enter the number of the event you would like to join or enter 0 to return to menu");
					input = scan.nextLine();
				}
				eventChoice = Integer.parseInt(input) - 1;
			}
			
			if(eventChoice == -1) {
				clearScreen();
			} else {
				viewEventDetails(eventsVector.get(eventChoice));
			}
		}
	}
	
	/**
	 * Displays detailed information about a certain event. Includes dates, times, attendee, tasks, etc.
	 * @param event specific event that the user would like to know more about
	 */

	public void viewEventDetails(Event event) {

		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean validInput = false;
		int hourMode;

		clearPrint("Would you like to use 12 hour mode or 24 hour mode? (12/24)"); //ask how they would like times formatted
		input = scan.nextLine();

		while(!validInput) {
			try {
				if(Integer.parseInt(input) == 12 || Integer.parseInt(input) == 24) {
					validInput = true;
				} else {
					throw new Exception();
				}
			} catch(Exception e) {
				clearPrint("Error! Invalid input\n\nWould you like to use 12 hour mode or 24 hour mode? (12/24)");
				input = scan.nextLine();
			}
		}

		if(Integer.parseInt(input) == 12) {
			hourMode = 12;
		} else {
			hourMode = 24;
		}

		//display host, days, times, tasks, attendees names, attendees times, attendees tasks
		clearPrint("Event:\t" + event.getEventName());
		System.out.println("Host:\t" + event.getHostName());
		System.out.println("Times:");
//		for(int i = 0; i < event.getDatesAndTimes().size(); i++) {
//			for(int j = 0; j < event.getDatesAndTimes().elementAt(i).size(); j++) {
//				if(j == 0) {
//					System.out.println(event.getDatesAndTimes().elementAt(i).elementAt(j) + " \n");
//				} else if(hourMode == 12) {
//					if ( j == event.getDatesAndTimes().elementAt(i).size() - 1 ) {
//						System.out.print(twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + "\n");
//					}else {
//						//This Needs Fixed
//						if( Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j + 1)) != Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j)) + 1 ) {
//							System.out.print(twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " - ");
//						}
//					}
//				} else {
//					if ( j == event.getDatesAndTimes().elementAt(i).size() - 1 ) {
//						System.out.print(twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + "\n");
//					}else {
//						//This Needs Fixed
//						if( Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j + 1)) != Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j)) + 1 ) {
//							System.out.print(twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " - ");
//						}
//					}
//				}
//			}
//			System.out.println();
//		}
		for(int i = 0; i < event.getDatesAndTimes().size(); i++) { 
			for(int j = 0; j < event.getDatesAndTimes().elementAt(i).size(); j++) {
				if(j == 0) { // print date
					System.out.print(" " + event.getDatesAndTimes().elementAt(i).elementAt(j) + " ");
				} else if(hourMode == 12) {  // prints times for 12hr format
					System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
				} else {  // prints times for 24hr format
					System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
				}
			}
			System.out.println();
		}
		// display tasks
		if (event.getTasks().size() != 0) { 
			System.out.println("Event tasks:");
			for(int i = 0; i < event.getTasks().size(); i++) {
				System.out.println(" " + event.getTasks().get(i));
			}
		}
		// display attendees names, attendees times, attendees tasks
		if (event.getAttendees().size() != 0) {
			System.out.println("Attendees:");
			for(int attIndex = 0; attIndex < event.getAttendees().size(); attIndex++) { 
				// print attendee name
				System.out.print(event.getAttendeeName(attIndex) + " "); 
				for(int attDateAndTimesIndex = 1; attDateAndTimesIndex < event.getAttendees().elementAt(attIndex).size(); attDateAndTimesIndex++) {
					if (!isTime(event.getAttendees().elementAt(attIndex).elementAt(attDateAndTimesIndex))) {
						// print attendee date
						System.out.print("\n " + event.getAttendees().elementAt(attIndex).elementAt(attDateAndTimesIndex) + " "); 
					} else if(hourMode == 12) {   // prints times for 12hr format
						System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(event.getAttendees().elementAt(attIndex).elementAt(attDateAndTimesIndex))) + " ");
					} else {   // prints times for 24hr format
							System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(event.getAttendees().elementAt(attIndex).elementAt(attDateAndTimesIndex))) + " "); 					
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	/**
	 * Clearly prints a string for better looking output.
	 * @param text The string that will get clearly printed.
	 */
	
	public static void clearPrint(String text) {
		clearScreen();
		System.out.println(text);
	}

	/**
	 * Clears terminal window
	 */
	
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n");
		}
	}
	
	/**
	 * Checks if given is between 0 and 47
	 * @param str string representing a time int
	 * @return true if it is, false if not
	 */
	public Boolean isTime(String str) {
		Boolean time = false;
		if (isNumber(str)  == true) {
			if (Integer.parseInt(str)>=0 || Integer.parseInt(str)<=47) {
				time = true;
			}
		}
		return time;
	}
	
	/**
	 * Checks if string is a valid number
	 * @param str string representing a number
	 * @return true if it is, false if not
	 */
	
	// Checks if string is a valid number
	// @return true if string represents a number
	public static boolean isNumber(String str) {
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
}
