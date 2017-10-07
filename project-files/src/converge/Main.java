package converge;

import java.util.Vector;
import java.util.Scanner;

public class Main {
	
	static Vector<Event> eventsVector = new Vector<Event>();
	static FileIO fileIO = new FileIO();
	
	public static void main(String[] args) {
		Vector<Event> eventsVector = new Vector<Event>();
		FileIO fileIO = new FileIO();
		Event event = new Event();
		AddEvent addEvent = new AddEvent();
		JoinEvent joinEvent = new JoinEvent();
		
		Scanner scan = new Scanner(System.in);
		eventsVector = fileIO.loadEventsVector();
		boolean quit = false;
		boolean validInput;
		String input = "";
		int choice;
		
		clearScreen();
		
		while(!quit) {	
			validInput = false;
			
			while(!validInput) {
				System.out.println("What would you like to do?\n 1. Create an Event\n 2. Join an event\n 3. View an existing event\n 0. Quit\n\nPlease enter number corresponding to the option you choose.");
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
				eventsVector = addEvent.start(eventsVector);
				fileIO.saveEventsVector(eventsVector);
				clearPrint("Event successfully created!\n");
			} else if(choice == 2) {
				joinEvent.start();
				fileIO.saveEventsVector(eventsVector);
			} else if(choice == 3) {
				clearScreen();
				if (eventsVector.size() == 0) {
					clearPrint("No event has been created, yet!\n");
				} else {
					for (int i = 0; i<eventsVector.size(); i++) {
						eventsVector.get(i).viewEvent();
					}
				}
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
