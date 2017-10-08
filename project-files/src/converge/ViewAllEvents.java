package converge;

import java.util.Scanner;
import java.util.Vector;

public class ViewAllEvents {
	
	public void viewAllEventNames(Vector<Event> eventsVector) {
		if(eventsVector.size() == 0) {
			clearPrint("Error! There are no events to join\n");
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
			viewEventDetails(eventsVector.get(eventChoice));
		}	
	}
	
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
		for(int i = 0; i < event.getDatesAndTimes().size(); i++) {
			for(int j = 0; j < event.getDatesAndTimes().elementAt(i).size(); j++) {
				if(j == 0) {
					System.out.print(event.getDatesAndTimes().elementAt(i).elementAt(j) + " ");
				} else if(hourMode == 12) {
					System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
				} else {
					System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(event.getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
				}
			}
			System.out.println();
		}
		if (event.getAttendees().size() != 0) {
			System.out.println("Attendees:");
			for (int i = 0; i<event.getAttendees().size(); i++) {
				System.out.println("\t" + event.getAttendeeName(i));
			}
		}
		if (event.getTasks().size() != 0) {
			System.out.print("Tasks:");
			for(int i = 0; i < event.getTasks().size(); i++) {
				System.out.print(event.getTasks().get(i) + " ");
			}
		}
		System.out.println();
	}
	
	public static void clearPrint(String text) {
		clearScreen();
		System.out.println(text);
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n");
		}
	}
}
