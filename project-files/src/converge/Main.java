package converge;

import java.util.Vector;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Vector<Event> eventsVector = new Vector();
		FileIO fileIO = new FileIO();
		Event event = new Event();
		AddEvent addEvent = new AddEvent();
		JoinEvent joinEvent = new JoinEvent();
		ViewAllEvents eventViewer = new ViewAllEvents();
		
		Scanner scan = new Scanner(System.in);
		fileIO.loadEventsVector(eventsVector);
		boolean quit = false;
		boolean validInput;
		String input = "";
		int choice;
		
		clearScreen();
		
		while(!quit) {	
			validInput = false;
			
			while(!validInput) {
				System.out.println("What would you like to do?\n 1. Create an event\n 2. Join an event\n 3. View all existing events\n 0. Quit\n\nPlease enter number corresponding to the option you choose.");
				input = scan.nextLine();
				
				try {
					if(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 3) {
						validInput = true;
					} else {
						throw new Exception();
					}
				} catch(Exception e) {
					clearPrint("Error! Please enter a valid option\n");
				}
			}
			
			choice = Integer.parseInt(input);
			
			if(choice == 1) {
				addEvent.start(eventsVector);
				fileIO.saveEventsVector(eventsVector);
				clearPrint("Event successfully created!\n");
			} else if(choice == 2) {
				joinEvent.start(eventsVector);
				fileIO.saveEventsVector(eventsVector);
				clearPrint("Availability successfully added!\n");
			} else if(choice == 3) {
				eventViewer.viewAllEventNames(eventsVector);
				clearScreen();
			} else {
				quit = true;
			}
		}
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