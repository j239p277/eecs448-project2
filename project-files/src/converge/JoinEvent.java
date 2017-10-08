package converge;

import java.util.Vector;
import java.util.Scanner;

public class JoinEvent {

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
			boolean addATask = true;
			Vector<String> attendee = new Vector();
			boolean addAnotherTime = true;
			boolean addAnotherTask = true;
			boolean firstTask = true;
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
			}

			if(Integer.parseInt(input) == 0) {
				clearScreen();
			} else {
				eventChoice = Integer.parseInt(input) - 1;
				validInput = false;

				clearPrint("Enter your name");
				input = scan.nextLine();

				while(!validInput) {
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

				while(addAnotherDay) {
					addAnotherTime = true;
					clearPrint(eventsVector.elementAt(eventChoice).getEventName() + ", hosted by " + eventsVector.elementAt(eventChoice).getHostName() + "\n"); //print details about the event the attendee chose
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

					while(!validInput) {
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

					validInput = false;

					attendee.addElement(input); //add day to attendee vector

					while(addAnotherTime) {
						clearPrint("Available times:\n");

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

						while(!validInput) {
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
							attendee.addElement(Integer.toString(TimeConverter.twelveHourtoInt(input)));
						} else {
							attendee.addElement(Integer.toString(TimeConverter.twentyFourHourtoInt(input)));
						}

						clearPrint("Would you like to add another time for this day? Enter 'y' or 'n' (Without quotes)");
						input = scan.nextLine();
						validInput = false;

						while(!validInput) {
							if(input.charAt(0) != 'y' && input.charAt(0) != 'n') {
								clearPrint("Error! Invalid input\n\nWould you like to add another time for this day? Enter 'y' or 'n' (Without quotes)");
								input = scan.nextLine();
							} else {
								validInput = true;
							}
						}

						if(input.charAt(0) == 'n') {
							addAnotherTime = false;
						}

					}

					clearPrint("Would you like to add another day? Enter 'y' or 'n' (Without quotes)");
					input = scan.nextLine();
					validInput = false;

					while(!validInput) {
						if(input.charAt(0) != 'y' && input.charAt(0) != 'n') {
							clearPrint("Error! Invalid input\n\nWould you like to add another day? Enter 'y' or 'n' (Without quotes)");
							input = scan.nextLine();
						} else {
							validInput = true;
						}
					}

					clearPrint("Would you like to sign up for a task? Enter 'y' or 'n' (Without quotes)");
					input = scan.nextLine();
					validInput = false;

					while(!validInput) {
						if(input.charAt(0) != 'y' && input.charAt(0) != 'n') {
							clearPrint("Error! Invalid input\n\nWould you like to sign up for a task? Enter 'y' or 'n' (Without quotes)");
							input = scan.nextLine();
						} else {
							validInput = true;
						}
					}

					if(input.charAt(0) == 'n') {
						addATask = false;
					}

					if(addATask) {
							for(int i = 0; i < eventsVector.elementAt(eventChoice).getTasks().size(); i++) {
								System.out.print(eventsVector.elementAt(eventChoice).getTasks().get(i) + " \n");
							}
							System.out.print("Enter the task you can undertake\n");
							input = scan.nextLine();
							validInput = false;

							while(!validInput) {
								boolean notFound = true;
								for(int i = 0; i < eventsVector.elementAt(eventChoice).getTasks().size(); i++) {
									if(eventsVector.elementAt(eventChoice).getTasks().get(i) == input) {
										notFound = false;
									}
								}
								if(notFound) {
									clearPrint("Error! Invalid input\n\nEnter the task you can undertake");
									for(int i = 0; i < eventsVector.elementAt(eventChoice).getTasks().size(); i++) {
										System.out.print(eventsVector.elementAt(eventChoice).getTasks().get(i) + " \n");
									}
									input = scan.nextLine();
								} else {
									validInput = true;
								}
							}
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
							if(input.charAt(0) != 'y' && input.charAt(0) != 'n') {
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