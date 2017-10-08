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
								System.out.print(twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
							} else {
								System.out.print(twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
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
										System.out.print(twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
									} else {
										System.out.print(twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(i).elementAt(j))) + " ");
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
								System.out.print(twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + ", ");
							} else {
								System.out.print(twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + ", ");
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
										if(twelveHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
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
											System.out.print(twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										} else {
											System.out.print(twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										}
									}

									System.out.println("\n\nEnter the time you can attend. Format: 3:00AM or 3:00PM");
									input = scan.nextLine();
								}
							} else {
								try {
									for(int i = 1; i < eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).size(); i++) {
										if(twentyFourHourtoInt(input) == Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) {
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
											System.out.print(twelveHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										} else {
											System.out.print(twentyFourHourConversion(Integer.parseInt(eventsVector.elementAt(eventChoice).getDatesAndTimes().elementAt(day).elementAt(i))) + " ");
										}
									}

									System.out.println("\n\nEnter the time you can attend. Format: 3:00 or 15:00");
									input = scan.nextLine();
								}
							}
						}

						if(hourMode == 12) {
							attendee.addElement(Integer.toString(twelveHourtoInt(input)));
						} else {
							attendee.addElement(Integer.toString(twentyFourHourtoInt(input)));
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
				eventsVector.elementAt(eventChoice).addAttendee(attendee);
				clearPrint("Availablility successfully added!\n");
			}
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
