package converge;

import java.util.Vector;
import java.util.Scanner;

/**
 * Facilitates the process of users signing up to attend an event.
 * @since 2017-10-8
 */

public class JoinEvent {

	/**
	 * Prompts user to input information about themselves and the event they want to join
	 * @param eventsVector dynamic data structure that stores all event objects
	 */

	public void start(Vector<Event> eventsVector) {
		if(eventsVector.size() == 0) {
			clearPrint("Error! There are no events to join\n");
		} else {
			Scanner scan = new Scanner(System.in);
			String input = "";
			int eventChoice;
			boolean validInput = false;
			int hourMode;
			int day = 0;
			String attendeeName = "";
			boolean addAnotherDay = true;
			Vector<String> attendee = new Vector();
			boolean addAnotherTime = true;
			boolean addAnotherTask = true;
			boolean firstTask = true;
			int daysAttending = 0;
			int timesAttending = 0;
			int timeInt = 50;
			clearScreen();
			
			for(int i = 0; i < eventsVector.size(); i++) { //begin by listing all events
				System.out.println((i + 1) + ". " + eventsVector.elementAt(i).getEventName() + ", hosted by " + eventsVector.elementAt(i).getHostName());
			}
			System.out.println("0. Return to menu\n\nPlease enter the number of the event you would like to join or enter 0 to return to menu");
			input = scan.nextLine();

			while(!validInput) { //verify input
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
			}

			if(Integer.parseInt(input) == 0) { //if user selects 0, return to menu
				clearScreen();
			} else { //otherwise, 
				eventChoice = Integer.parseInt(input) - 1;
				validInput = false;

				clearPrint("Enter your name"); //enter attendee name
				input = scan.nextLine();

				while(!validInput) { //verify input
					if(input.length() == 0) {
						clearPrint("Error! Your name cannot be blank\n\nEnter your name");
						input = scan.nextLine();
					} else {
						validInput = true;
					}
				}

				attendeeName = input;

				attendee.addElement(attendeeName); //add attendee name

				clearPrint("Would you like to use 12 hour mode or 24 hour mode? (12/24)"); //ask how they would like times formatted
				input = scan.nextLine();
				validInput = false;

				while(!validInput) { //verify input
					try {
						
						if(input.length() == 0) {
							throw new Exception();
						}
						
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

				while(addAnotherDay) { //prompt user to join on a specific day
					addAnotherTime = true;
					clearPrint(eventsVector.elementAt(eventChoice).getEventName() + ", hosted by " + eventsVector.elementAt(eventChoice).getHostName() + "\n"); //print details about the event the attendee chose
					System.out.println("Event dates and times:\n");

					for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) { //print all dates and times
						for(int j = 0; j < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).size(); j++) {
							if(j == 0) {
								System.out.print(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j) + " ");
							} else if(hourMode == 12) {
								System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
							} else {
								System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
							}
						}
						System.out.println();
					}

					System.out.println("\nWhat day would you like to attend? (mm/dd/yyyy)"); //have attendee select the day they want to attend
					input = scan.nextLine();
					validInput = false;
				
					while(!validInput) { //verify input
						for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) {
							if(input.equals(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(0))) {
								validInput = true;
								day = i;
							}
						}

						if(!validInput) {
							clearPrint("Error! Invalid date! Please select a date from the list below\n");
							System.out.println("Event dates and times:\n");

							for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) {
								for(int j = 0; j < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).size(); j++) {
									if(j == 0) {
										System.out.print(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j) + " ");
									} else if(hourMode == 12) {
										System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
									} else {
										System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
									}
								}
								System.out.println();
							}

							System.out.println("\nWhat day would you like to attend? (mm/dd/yyyy)");
							input = scan.nextLine();
						}
					}
					
					while(alreadyContainsDay(attendee, input)) { //if they enter a time they have already entered, stop them
						clearPrint("Error! You have already entered your availability for that day\n\n" + eventsVector.elementAt(eventChoice).getEventName() + ", hosted by " + eventsVector.elementAt(eventChoice).getHostName() + "\n"); //print details about the event the attendee chose
						System.out.println("Event dates and times:\n");

						for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) {
							for(int j = 0; j < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).size(); j++) {
								if(j == 0) {
									System.out.print(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j) + " ");
								} else if(hourMode == 12) {
									System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
								} else {
									System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
								}
							}
							System.out.println();
						}

						System.out.println("\nWhat day would you like to attend? (mm/dd/yyyy)"); //have attendee select the day they want to attend
						input = scan.nextLine();
						validInput = false;
					
						while(!validInput) { //verify input
							for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) {
								if(input.equals(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(0))) {
									validInput = true;
									day = i;
								}
							}

							if(!validInput) {
								clearPrint("Error! Invalid date! Please select a date from the list below\n");
								System.out.println("Event dates and times:\n");

								for(int i = 0; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().size(); i++) {
									for(int j = 0; j < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).size(); j++) {
										if(j == 0) {
											System.out.print(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j) + " ");
										} else if(hourMode == 12) {
											System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
										} else {
											System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
										}
									}
									System.out.println();
								}

								System.out.println("\nWhat day would you like to attend? (mm/dd/yyyy)");
								input = scan.nextLine();
							}
						}
					}
					
					
					attendee.addElement(input); //add day to attendee vector
					daysAttending++;
					timesAttending = 0;

					while(addAnotherTime) { //get times the attendee wants to attend on a given day
						clearPrint("Available times:\n"); 
						for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) { //print all available times for a certain day
							if(hourMode == 12) {
								System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
							} else {
								System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
							}
						}

						if(hourMode == 12) {
							System.out.println("\n\nEnter the time you can attend. Format: 3:00AM or 3:00PM");
						} else {
							System.out.println("\n\nEnter the time you can attend. Format: 3:00 or 15:00");
						}

						input = scan.nextLine();
						validInput = false;
						while(!validInput) { //verify input
							if(hourMode == 12) {
								try {
									for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
										if(TimeConverter.twelveHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
											validInput = true;
										}
									}

									if(!validInput) {
										throw new Exception();
									}

								} catch(Exception e) {
									clearPrint("Error! Invalid time! Please enter a time from the list below\n");

									for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
										if(hourMode == 12) {
											System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										} else {
											System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										}
									}

									System.out.println("\n\nEnter the time you can attend. Format: 3:00AM or 3:00PM");
									input = scan.nextLine();
								}
							} else {
								try {
									for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
										if(TimeConverter.twentyFourHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
											validInput = true;
										}
									}

									if(!validInput) {
										throw new Exception();
									}

								} catch(Exception e) {
									clearPrint("Error! Invalid time! Please enter a time from the list below\n");

									for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
										if(hourMode == 12) {
											System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										} else {
											System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										}
									}

									System.out.println("\n\nEnter the time you can attend. Format: 3:00 or 15:00");
									input = scan.nextLine();
								}
							}
						}
						
						if(hourMode == 12) {
							timeInt = TimeConverter.twelveHourtoInt(input);
						} else {
							timeInt = TimeConverter.twentyFourHourtoInt(input);
						}
						
						while(alreadyContainsTime(attendee, eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(0), timeInt)) { //if the user tries to enter a time they have already entered, stop them
							clearPrint("\nError! You are already available at that time\n\nAvailable times:\n"); 
							for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
								if(hourMode == 12) {
									System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
								} else {
									System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
								}
							}

							if(hourMode == 12) {
								System.out.println("\n\nEnter the time you can attend. Format: 3:00AM or 3:00PM");
							} else {
								System.out.println("\n\nEnter the time you can attend. Format: 3:00 or 15:00");
							}

							input = scan.nextLine();
							validInput = false;
							while(!validInput) { //verify input
								if(hourMode == 12) {
									try {
										for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
											if(TimeConverter.twelveHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
												validInput = true;
											}
										}

										if(!validInput) {
											throw new Exception();
										}

									} catch(Exception e) {
										clearPrint("Error! Invalid time! Please enter a time from the list below\n");

										for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
											if(hourMode == 12) {
												System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
											} else {
												System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
											}
										}

										System.out.println("\n\nEnter the time you can attend. Format: 3:00AM or 3:00PM");
										input = scan.nextLine();
									}
								} else {
									try {
										for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
											if(TimeConverter.twentyFourHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
												validInput = true;
											}
										}

										if(!validInput) {
											throw new Exception();
										}

									} catch(Exception e) {
										clearPrint("Error! Invalid time! Please enter a time from the list below\n");

										for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
											if(hourMode == 12) {
												System.out.print(TimeConverter.twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
											} else {
												System.out.print(TimeConverter.twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
											}
										}

										System.out.println("\n\nEnter the time you can attend. Format: 3:00 or 15:00");
										input = scan.nextLine();
									}
								}
							}
							
							if(hourMode == 12) {
								timeInt = TimeConverter.twelveHourtoInt(input);
							} else {
								timeInt = TimeConverter.twentyFourHourtoInt(input);
							}
						}

						if(hourMode == 12) {
							attendee.addElement(Integer.toString(TimeConverter.twelveHourtoInt(input)));
						} else {
							attendee.addElement(Integer.toString(TimeConverter.twentyFourHourtoInt(input)));
						}
						timesAttending++;
						
						if(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size() != 2 && timesAttending != eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size() - 1) {
							clearPrint("Would you like to add another time for this day? Enter 'y' or 'n' (Without quotes)");
							input = scan.nextLine();
							validInput = false;

							while(!validInput) {
								if(input.length() == 0 || input.charAt(0) != 'y' && input.charAt(0) != 'n') {
									clearPrint("Error! Invalid input\n\nWould you like to add another time for this day? Enter 'y' or 'n' (Without quotes)");
									input = scan.nextLine();
								} else {
									validInput = true;
								}
							}

							if(input.charAt(0) == 'n') {
								addAnotherTime = false;
							}
						} else {
							addAnotherTime = false;
						}
					}
					
					if(eventsVector.elementAt(eventChoice).getDatesAndTimes().size() != 1 && daysAttending != eventsVector.elementAt(eventChoice).getDatesAndTimes().size()) {
						clearPrint("Would you like to add another day? Enter 'y' or 'n' (Without quotes)");
						input = scan.nextLine();
						validInput = false;

						while(!validInput) {
							if(input.length() == 0 || input.charAt(0) != 'y' && input.charAt(0) != 'n') {
								clearPrint("Error! Invalid input\n\nWould you like to add another day? Enter 'y' or 'n' (Without quotes)");
								input = scan.nextLine();
							} else {
								validInput = true;
							}
						}
						
						if(input.charAt(0) == 'n') {
							addAnotherDay = false;
						}
					} else {
						addAnotherDay = false;
					}
				}
				
				while(addAnotherTask) { 
					if(eventsVector.elementAt(eventChoice).getTasks().size() != 0) { //if there are tasks to be done, ask if attendee would like to sign up for a task
						validInput = false;
						
						System.out.println(addAnotherTask);
						
						if(firstTask) {
							clearPrint("There are tasks for this event. Would you like to sign up for a task? Enter 'y' or 'n' (Without quotes)");
							firstTask = false;
						} else {
							clearPrint("There are still tasks for this event. Would you like to sign up for another task? Enter 'y' or 'n' (Without quotes)");
						}
						input = scan.nextLine();
					
						while(!validInput) {
							if(input.length() == 0 || input.charAt(0) != 'y' && input.charAt(0) != 'n') {
								clearPrint("Error! Invalid input\n\nWould you like to sign up for a task? Enter 'y' or 'n' (Without quotes)");
								input = scan.nextLine();
							} else {
								validInput = true;
							}
						}
					
						if(input.charAt(0) == 'y') {
							clearPrint("The following tasks are still required for this event:\n");
							
							for(int i = 0; i < eventsVector.elementAt(eventChoice).getTasks().size(); i++) {
								System.out.println((i + 1) + ". " + eventsVector.elementAt(eventChoice).getTasks().elementAt(i));
							}
							
							validInput = false;
							System.out.println("\nEnter the number of the task you would like to sign up for");
							input = scan.nextLine();
							
							while(!validInput) {
								try {
									if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= eventsVector.elementAt(eventChoice).getTasks().size()) {
										validInput = true;
									} else {
										throw new Exception();
									}
								} catch(Exception e) {
									clearPrint("Error! Invalid input\n\nThe following tasks are still required for this event:\n");
									
									for(int i = 0; i < eventsVector.elementAt(eventChoice).getTasks().size(); i++) {
										System.out.println((i + 1) + ". " + eventsVector.elementAt(eventChoice).getTasks().elementAt(i));
									}
									
									System.out.println("\nEnter the number of the task you would like to sign up for");
									
									input = scan.nextLine();
								}
							}
							
							attendee.addElement(eventsVector.elementAt(eventChoice).getTasks().elementAt(Integer.parseInt(input) - 1));
							eventsVector.elementAt(eventChoice).getTasks().removeElementAt(Integer.parseInt(input) - 1);
							
						} else {
							addAnotherTask = false;
						}
					} else {
						addAnotherTask = false;
					}
				}
				
				eventsVector.elementAt(eventChoice).addAttendee(attendee);
				clearPrint("Availablility successfully added!\n");
			}
		}
	}
	
	
	/**
	 * Checks if attendee object contains an instance of the given date
	 * @param attendee vector of strings representing the attendee's availability
	 * @param day string representing a date
	 * @return true if the string vector contains the given string, false if not
	 */

	 private boolean alreadyContainsDay(Vector<String> attendee, String day) {
		for(int i = 1; i < attendee.size(); i++) {
			if(day.equals(attendee.elementAt(i))) {
				return true;
			}
		}
		return false;
	 }
	 
	 /**
	  * Checks if attendee contains a given time on a given date
	  * @param attendee vector of strings representing the attendee's availability
	  * @param day string representing a date
	  * @param time int representing a time
	  * @return true if the string vector contains the given time on the given date, false if not
	  */
	 
	 private boolean alreadyContainsTime(Vector<String> attendee, String day, int time) {
		try {
			for(int i = 1; i < attendee.size(); i++) {
				if(day.equals(attendee.elementAt(i))) {
					for(int j = 1; j < attendee.size() - i; j++) {
						if(attendee.elementAt(i + j).length() > 2) {
							return false;
						}
						
						if(Integer.parseInt(attendee.elementAt(i + j)) == time) {
							return true;
						}
					}
				}
			}
			
			return false;
		} catch(Exception e) {
			return false;
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
}