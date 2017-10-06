package converge;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

/**
 * The JoinEvent.java file will be used to implement the Attendee Mode for the Converge Application
 * 
 * @author Menita Vedantam
 * @since 2017-09-15
 */

public class JoinEvent {
	
	public static void view() throws IOException
	{
		FileRead fr = new FileRead();
		Vector<Event> events = fr.readEvents();
		Vector<Integer> times=new Vector<Integer>();
		String eventChoice = "";
		int eventC = 0;
		Scanner myScan = new Scanner(System.in);
		int timeChoice = 0;
		boolean invalidInput = true;
		clearScreen();
		while(invalidInput) 
		{
			System.out.println("12 Hour / 24 Hour Mode? (12/24):");
				try {
					if (!myScan.hasNextInt())
					{
						myScan.next();
						throw new Exception();
					}
					timeChoice = myScan.nextInt();
					if(timeChoice == 12 || timeChoice == 24) 
					{
						invalidInput = false;
					}
					else 
					{
						throw new Exception();
					}
				}
				catch (Exception e)
				{
					clearPrint("Error\nThe selection is invalid.\n");
					invalidInput = true;
				}
		}
		invalidInput = true;
		clearScreen();
		
		while(invalidInput) 
		{
			System.out.println("Which event would you like to view?");
			System.out.println("Please enter the number cooresponding to your event choice.\n");
			for(int i=0; i<events.size(); i++) 
			{
				System.out.println((i+1)+". "+events.elementAt(i).getEventName());
			}
			
			try {
				if (!myScan.hasNextInt())
				{
					myScan.next();
					throw new Exception();
				}
					eventC = myScan.nextInt();
					if(eventC > events.size() || eventC < 1) 
					{
						throw new Exception();
					}
					else 
					{
						invalidInput = false;
					}
				}
				catch (Exception e)
				{
					clearPrint("Error\nThe selection is invalid.\n");
					invalidInput = true;
				}
		}
		clearScreen();
		
		clearPrint("The following attendees of " + events.get(eventC-1).getEventName() + " have the following availabilities:\n");
		for (int i = 0; i < events.get(eventC-1).a_attendees.size(); i++)
		{
			String timestring = "\t";
			System.out.println(events.get(eventC-1).a_attendees.get(i).getName() + ": ");
			for (int j = 0; j < events.get(eventC-1).a_attendees.get(i).getAvailability().size(); j++)
			{
				if (timeChoice == 12)
				{
					timestring += " ";
//	TODO				+ twelveHourConversion(events.get(eventC-1).a_attendees.get(i).getAvailability().get(j));
				}
				else if (timeChoice == 24)
				{
					timestring += " " ;
//	TODO			+ twentyFourHourConversion(events.get(eventC-1).a_attendees.get(i).getAvailability().get(j));
				}
			}
			System.out.print(timestring + "\n");
		}
		
	}
	/**
	 * This method will be called when the user selects join event in main.
	 */
	static void run()throws IOException {
		FileRead fr = new FileRead();
		/** 
		 * vector used to access already created events
		 */
		Vector<Event> events = fr.readEvents();
		/** 
		 * vector used to hold the user's available times.
		 */
		Vector<DateAndTimes> times=new Vector<DateAndTimes>();		/** 
		 * vector used to hold the user's tasks.
		 */
		Vector<String> tasks=new Vector<String>();
		Scanner myScan = new Scanner(System.in);
		/** 
		 * string that takes the user's name.
		 */
		String userName = "";
		/** 
		 * int that stores the user's choice in which event to join.
		 */
		String eventChoice = "";
		/** 
		 * int that stores the user's choice in 12/24 hour mode for time representation.
		 */
		int timeChoice = 0;
		int eventC = 0;
		clearPrint("Please enter your name.");
		userName = myScan.nextLine();
		/** 
		 * boolean value that verifies proper input.
		 */
		boolean invalidInput = true;
		clearScreen();
		while(invalidInput) 
		{
			System.out.println("Which event would you like to join?");
			System.out.println("Please enter the number cooresponding to your event choice.\n");
			for(int i=0; i<events.size(); i++) 
			{
				System.out.println((i+1)+". "+events.elementAt(i).getEventName());
			}
			try {
				if (!myScan.hasNextInt())
				{
					myScan.next();
					throw new Exception();
				}
				eventC = myScan.nextInt();
				if(eventC > events.size() || eventC < 1) 
				{
					throw new Exception();
				}
				else 
				{
					invalidInput = false;
				}
			}
			catch (Exception e)
			{
				clearPrint("Error\nThe selection is invalid.\n");
				invalidInput = true;
			}
		}
				clearScreen();
				boolean wrongFormat = true;
				while (wrongFormat) {
					System.out.println("12 Hour / 24 Hour Mode? (12/24):");
					
					try {
						if (!myScan.hasNextInt())
						{
							myScan.next();
							throw new Exception();
						}
						timeChoice = myScan.nextInt();
						if(timeChoice == 12 || timeChoice == 24) 
						{
							invalidInput = false;
						}
						else 
						{
							throw new Exception();
						}
					}
					catch (Exception e)
					{
						clearPrint("Error\nThe selection is invalid.\n");
						invalidInput = true;
					}
					if(timeChoice == 12) 
					{
						clearPrint("The available times:");
						for(int i=0; i<events.size(); i++) 
						{
							if(i+1 == eventC) 
							{
								events.elementAt(i).get12HourAvailability();
							}
						}
						wrongFormat = false;
					}
					else if(timeChoice == 24) 
					{
						clearPrint("The available times:");
						for(int i=0; i<events.size(); i++) 
						{
							if(i+1 == eventC) 
							{
								events.elementAt(i).get24HourAvailability(); 
							}
						}
						wrongFormat = false;
					}
					else
					{
						clearPrint("Error\nThe selection is invalid.\n");
					}
				}
				boolean correctTime = false;
				while(!correctTime) {
					System.out.println("Please enter all the times you are available within the given time options(seperate with spaces).");
					String s = "";
					myScan.nextLine();
					s = myScan.nextLine();
					String[] temp = s.split(" ");
					for(int i = 0; i<temp.length; i++) 
					{
						boolean correctValueFound = false;
						Integer num = 0;
						if (timeChoice == 12)
						{
							num =twelveHourtoInt(temp[i]);
						}
						else
						{
							num = twentyFourHourtoInt(temp[i]);
						}
						for(int j=0; j<events.elementAt(eventC-1).getAvailability().size(); j++) 
						{
							if(num == events.elementAt(eventC-1).getAvailability().elementAt(j).getAvailability().elementAt(j)) 
							{
								j=events.elementAt(eventC-1).getAvailability().size();
								correctValueFound = true;
								
//		TODO						times.add(num[i]);
//								times.add(String.valueOf(num).indexOf(1));
								}
						}
						if(!correctValueFound) 
						{
							i = temp.length;
							correctTime = false;
							clearPrint("Error\nThe values inputted are invalid.");
							if(timeChoice == 12) 
							{
								System.out.println("The available times:");
								for(int j=0; j<events.size(); j++) 
								{
									if(j+1 == eventC) 
									{
										events.elementAt(j).get12HourAvailability();
									}
								}
							}
							else if(timeChoice == 24) 
							{
								System.out.println("The available times:");
								for(int j=0; j<events.size(); j++) 
								{
									if(j+1 == eventC) 
									{
//			TODO							events.elementAt(j).get24HourAvailability();
									}
								}
							}
						}
						else
						{
							correctTime = true;
						}
					}
				}
				System.out.println(times);
				
				Attendee a = new Attendee(userName, times, tasks);
//				Attendee a = new Attendee(userName, times); //REMOVED AVAILABILITY PARAMETER BETWEEN USERNAME AND TIMES FOR COMPILE CHECK, MUST ADD LATER

				events.elementAt(eventC-1).a_attendees.add(a);
				events.elementAt(eventC-1).writeEventToFile();
				clearPrint("You have successfully been added to the event " + events.elementAt(eventC-1).getEventName() + "!");

	}
		/**
		 * Converts time strings for 12 hour mode as its corresponding integer for the availability vectors.
		 * 
		 * @param time The time as a string that the user inputs in 12 hour mode.
		 * @return an integer representing the time string's corresponding integer for the availability vector.
		 */
	static int twelveHourtoInt(String time)
	{
		int timeAsInt; //variable that will convert string into the corresponding number
		
		if(time.equals("12:00AM"))
		{
			timeAsInt = 0;
		}
		else if(time.equals( "12:30AM"))
		{
			timeAsInt = 1;
		}
		else if(time.equals( "1:00AM"))
		{
			timeAsInt = 2;
		}
		else if(time.equals( "1:30AM"))
		{
			timeAsInt = 3;
		}
		else if(time.equals( "2:00AM"))
		{
			timeAsInt = 4;
		}
		else if(time.equals( "2:30AM"))
		{
			timeAsInt = 5;
		}
		else if(time.equals( "3:00AM"))
		{
			timeAsInt = 6;
		}
		else if(time.equals( "3:30AM"))
		{
			timeAsInt = 7;
		}
		else if(time.equals( "4:00AM"))
		{
			timeAsInt = 8;
		}
		else if(time.equals( "4:30AM"))
		{
			timeAsInt = 9;
		}
		else if(time.equals( "5:00AM"))
		{
			timeAsInt = 10;
		}
		else if(time.equals( "5:30AM"))
		{
			timeAsInt = 11;
		}
		else if(time.equals( "6:00AM"))
		{
			timeAsInt = 12;
		}
		else if(time.equals( "6:30AM"))
		{
			timeAsInt = 13;
		}
		else if(time.equals( "7:00AM"))
		{
			timeAsInt = 14;
		}
		else if(time.equals( "7:30AM"))
		{
			timeAsInt = 15;
		}
		else if(time.equals( "8:00AM"))
		{
			timeAsInt = 16;
		}
		else if(time.equals( "8:30AM"))
		{
			timeAsInt = 17;
		}
		else if(time.equals( "9:00AM"))
		{
			timeAsInt = 18;
		}
		else if(time.equals( "9:30AM"))
		{
			timeAsInt = 19;
		}
		else if(time.equals( "10:00AM"))
		{
			timeAsInt = 20;
		}
		else if(time.equals( "10:30AM"))
		{
			timeAsInt = 21;
		}
		else if(time.equals( "11:00AM"))
		{
			timeAsInt = 22;
		}
		else if(time.equals( "11:30AM"))
		{
			timeAsInt = 23;
		}
		else if(time.equals( "12:00PM"))
		{
			timeAsInt = 24;
		}
		else if(time.equals( "12:30PM"))
		{
			timeAsInt = 25;
		}
		else if(time.equals( "1:00PM"))
		{
			timeAsInt = 26;
		}
		else if(time.equals( "1:30PM"))
		{
			timeAsInt = 27;
		}
		else if(time.equals( "2:00PM"))
		{
			timeAsInt = 28;
		}
		else if(time.equals( "2:30PM"))
		{
			timeAsInt = 29;
		}
		else if(time.equals( "3:00PM"))
		{
			timeAsInt = 30;
		}
		else if(time.equals( "3:30PM"))
		{
			timeAsInt = 31;
		}
		else if(time.equals( "4:00PM"))
		{
			timeAsInt = 32;
		}
		else if(time.equals( "4:30PM"))
		{
			timeAsInt = 33;
		}
		else if(time.equals( "5:00PM"))
		{
			timeAsInt = 34;
		}
		else if(time.equals( "5:30PM"))
		{
			timeAsInt = 35;
		}
		else if(time.equals( "6:00PM"))
		{
			timeAsInt = 36;
		}
		else if(time.equals( "6:30PM"))
		{
			timeAsInt = 37;
		}
		else if(time.equals( "7:00PM"))
		{
			timeAsInt = 38;
		}
		else if(time.equals( "7:30PM"))
		{
			timeAsInt = 39;
		}
		else if(time.equals( "8:00PM"))
		{
			timeAsInt = 40;
		}
		else if(time.equals( "8:30PM"))
		{
			timeAsInt = 41;
		}
		else if(time.equals( "9:00PM"))
		{
			timeAsInt = 42;
		}
		else if(time.equals( "9:30PM"))
		{
			timeAsInt = 43;
		}
		else if(time.equals( "10:00PM"))
		{
			timeAsInt = 44;
		}
		else if(time.equals( "10:30PM"))
		{
			timeAsInt = 45;
		}
		else if(time.equals( "11:00PM"))
		{
			timeAsInt = 46;
		}
		else if(time.equals( "11:30PM"))
		{
			timeAsInt = 47;
		}
		else
		{
			timeAsInt = 50; //random value that for all other cases that will throw an error if the time isn't one of the above.
		}
		return timeAsInt;
	} 
		/**
		 * Converts time strings for 24 hour mode as its corresponding integer for the availability vectors.
		 * 
		 * @param time The time as a string that the user inputs in 24 hour mode.
		 * @return an integer representing the time string's corresponding integer for the availability vector.
		 */
	static int twentyFourHourtoInt(String time)
	{
		int timeAsInt; //variable that will convert string into the corresponding number
		
		if(time.equals( "0:00"))
		{
			timeAsInt = 0;
		}
		else if(time.equals( "0:30"))
		{
			timeAsInt = 1;
		}
		else if(time.equals( "1:00"))
		{
			timeAsInt = 2;
		}
		else if(time.equals( "1:30"))
		{
			timeAsInt = 3;
		}
		else if(time.equals( "2:00"))
		{
			timeAsInt = 4;
		}
		else if(time.equals( "2:30"))
		{
			timeAsInt = 5;
		}
		else if(time.equals( "3:00"))
		{
			timeAsInt = 6;
		}
		else if(time.equals( "3:30"))
		{
			timeAsInt = 7;
		}
		else if(time.equals( "4:00"))
		{
			timeAsInt = 8;
		}
		else if(time.equals( "4:30"))
		{
			timeAsInt = 9;
		}
		else if(time.equals( "5:00"))
		{
			timeAsInt = 10;
		}
		else if(time.equals( "5:30"))
		{
			timeAsInt = 11;
		}
		else if(time.equals( "6:00"))
		{
			timeAsInt = 12;
		}
		else if(time.equals( "6:30"))
		{
			timeAsInt = 13;
		}
		else if(time.equals( "7:00"))
		{
			timeAsInt = 14;
		}
		else if(time.equals( "7:30"))
		{
			timeAsInt = 15;
		}
		else if(time.equals( "8:00"))
		{
			timeAsInt = 16;
		}
		else if(time.equals( "8:30"))
		{
			timeAsInt = 17;
		}
		else if(time.equals( "9:00"))
		{
			timeAsInt = 18;
		}
		else if(time.equals( "9:30"))
		{
			timeAsInt = 19;
		}
		else if(time.equals( "10:00"))
		{
			timeAsInt = 20;
		}
		else if(time.equals( "10:30"))
		{
			timeAsInt = 21;
		}
		else if(time.equals( "11:00"))
		{
			timeAsInt = 22;
		}
		else if(time.equals( "11:30"))
		{
			timeAsInt = 23;
		}
		else if(time.equals( "12:00"))
		{
			timeAsInt = 24;
		}
		else if(time.equals( "12:30"))
		{
			timeAsInt = 25;
		}
		else if(time.equals( "13:00"))
		{
			timeAsInt = 26;
		}
		else if(time.equals( "13:30"))
		{
			timeAsInt = 27;
		}
		else if(time.equals( "14:00"))
		{
			timeAsInt = 28;
		}
		else if(time.equals( "14:30"))
		{
			timeAsInt = 29;
		}
		else if(time.equals( "15:00"))
		{
			timeAsInt = 30;
		}
		else if(time.equals( "15:30"))
		{
			timeAsInt = 31;
		}
		else if(time.equals( "16:00"))
		{
			timeAsInt = 32;
		}
		else if(time.equals( "16:30"))
		{
			timeAsInt = 33;
		}
		else if(time.equals( "17:00"))
		{
			timeAsInt = 34;
		}
		else if(time.equals( "17:30"))
		{
			timeAsInt = 35;
		}
		else if(time.equals( "18:00"))
		{
			timeAsInt = 36;
		}
		else if(time.equals( "18:30"))
		{
			timeAsInt = 37;
		}
		else if(time.equals( "19:00"))
		{
			timeAsInt = 38;
		}
		else if(time.equals( "19:30"))
		{
			timeAsInt = 39;
		}
		else if(time.equals( "20:00"))
		{
			timeAsInt = 40;
		}
		else if(time.equals( "20:30"))
		{
			timeAsInt = 41;
		}
		else if(time.equals( "21:00"))
		{
			timeAsInt = 42;
		}
		else if(time.equals( "21:30"))
		{
			timeAsInt = 43;
		}
		else if(time.equals( "22:00"))
		{
			timeAsInt = 44;
		}
		else if(time.equals("22:30"))
		{
			timeAsInt = 45;
		}
		else if(time.equals("23:00"))
		{
			timeAsInt = 46;
		}
		else if(time.equals("23:30"))
		{
			timeAsInt = 47;
		}
		else
		{
			timeAsInt = 50; //random value that for all other cases that will throw an error if the time isn't one of the above.
		}
		return timeAsInt;
	}

	/**
	 * This method is used to clearly print a string for better looking output.
	 * 
	 * @param text The string that will get clearly printed.
	 * @throws IOException On input error.
	 */
	private static void clearPrint(String text)
	{
		clearScreen();
		System.out.println(text);
	}
	
	/**
	 * This method clears the output of whatever has been previously displayed.
	 */
	private static void clearScreen()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("\n");
		}
	}
	//method will convert the ints placed in the vectors to the needed strings for 12 hour mode
	public static String twelveHourConversion(int i) 
	{
		String conversion = "\0";
		
		if(i==0)
		{
			conversion = "12:00AM";
		}
		if(i==1)
		{
			conversion = "12:30AM";
		}
		if(i==2)
		{
			conversion = "1:00AM";
		}
		if(i==3)
		{
			conversion = "1:30AM";
		}
		if(i==4)
		{
			conversion = "2:00AM";
		}
		if(i==5)
		{
			conversion = "2:30AM";
		}
		if(i==6)
		{
			conversion = "3:00AM";
		}
		if(i==7)
		{
			conversion = "3:30AM";
		}
		if(i==8)
		{
			conversion = "4:00AM";
		}
		if(i==9)
		{
			conversion = "4:30AM";
		}
		if(i==10)
		{
			conversion = "5:00AM";
		}
		if(i==11)
		{
			conversion = "5:30AM";
		}
		if(i==12)
		{
			conversion = "6:00AM";
		}
		if(i==13)
		{
			conversion = "6:30AM";
		}
		if(i==14)
		{
			conversion = "7:00AM";
		}
		if(i==15)
		{
			conversion = "7:30AM";
		}
		if(i==16)
		{
			conversion = "8:00AM";
		}
		if(i==17)
		{
			conversion = "8:30AM";
		}
		if(i==18)
		{
			conversion = "9:00AM";
		}
		if(i==19)
		{
			conversion = "9:30AM";
		}
		if(i==20)
		{
			conversion = "10:00AM";
		}
		if(i==21)
		{
			conversion = "10:30AM";
		}
		if(i==22)
		{
			conversion = "11:00AM";
		}
		if(i==23)
		{
			conversion = "11:30AM";
		}
		if(i==24)
		{
			conversion = "12:00PM";
		}
		if(i==25)
		{
			conversion = "12:30PM";
		}
		if(i==26)
		{
			conversion = "1:00PM";
		}
		if(i==27)
		{
			conversion = "1:30PM";
		}
		if(i==28)
		{
			conversion = "2:00PM";
		}
		if(i==29)
		{
			conversion = "2:30PM";
		}
		if(i==30)
		{
			conversion = "3:00PM";
		}
		if(i==31)
		{
			conversion = "3:30PM";
		}
		if(i==32)
		{
			conversion = "4:00PM";
		}
		if(i==33)
		{
			conversion = "4:30PM";
		}
		if(i==34)
		{
			conversion = "5:00PM";
		}
		if(i==35)
		{
			conversion = "5:30PM";
		}
		if(i==36)
		{
			conversion = "6:00PM";
		}
		if(i==37)
		{
			conversion = "6:30PM";
		}
		if(i==38)
		{
			conversion = "7:00PM";
		}
		if(i==39)
		{
			conversion = "7:30PM";
		}
		if(i==40)
		{
			conversion = "8:00PM";
		}
		if(i==41)
		{
			conversion = "8:30PM";
		}
		if(i==42)
		{
			conversion = "9:00PM";
		}
		if(i==43)
		{
			conversion = "9:30PM";
		}
		if(i==44)
		{
			conversion = "10:00PM";
		}
		if(i==45)
		{
			conversion = "10:30PM";
		}
		if(i==46)
		{
			conversion = "11:00PM";
		}
		if(i==47)
		{
			conversion = "11:30PM";
		}
		return conversion;
	}
	
	//method converts ints in vectors into corresponding strings for 24:00 hour mode
	public static String twentyFourHourConversion(int i) 
	
	{
		String conversion = "\0";
		
		if(i==0)
		{
			conversion = "0:00";
		}
		if(i==1)
		{
			conversion = "0:30";
		}
		if(i==2)
		{
			conversion = "1:00";
		}
		if(i==3)
		{
			conversion = "1:30";
		}
		if(i==4)
		{
			conversion = "2:00";
		}
		if(i==5)
		{
			conversion = "2:30";
		}
		if(i==6)
		{
			conversion = "3:00";
		}
		if(i==7)
		{
			conversion = "3:30";
		}
		if(i==8)
		{
			conversion = "4:00";
		}
		if(i==9)
		{
			conversion = "4:30";
		}
		if(i==10)
		{
			conversion = "5:00";
		}
		if(i==11)
		{
			conversion = "5:30";
		}
		if(i==12)
		{
			conversion = "6:00";
		}
		if(i==13)
		{
			conversion = "6:30";
		}
		if(i==14)
		{
			conversion = "7:00";
		}
		if(i==15)
		{
			conversion = "7:30";
		}
		if(i==16)
		{
			conversion = "8:00";
		}
		if(i==17)
		{
			conversion = "8:30";
		}
		if(i==18)
		{
			conversion = "9:00";
		}
		if(i==19)
		{
			conversion = "9:30";
		}
		if(i==20)
		{
			conversion = "10:00";
		}
		if(i==21)
		{
			conversion = "10:30";
		}
		if(i==22)
		{
			conversion = "11:00";
		}
		if(i==23)
		{
			conversion = "11:30";
		}
		if(i==24)
		{
			conversion = "12:00";
		}
		if(i==25)
		{
			conversion = "12:30";
		}
		if(i==26)
		{
			conversion = "13:00";
		}
		if(i==27)
		{
			conversion = "13:30";
		}
		if(i==28)
		{
			conversion = "14:00";
		}
		if(i==29)
		{
			conversion = "14:30";
		}
		if(i==30)
		{
			conversion = "15:00";
		}
		if(i==31)
		{
			conversion = "15:30";
		}
		if(i==32)
		{
			conversion = "16:00";
		}
		if(i==33)
		{
			conversion = "16:30";
		}
		if(i==34)
		{
			conversion = "17:00";
		}
		if(i==35)
		{
			conversion = "17:30";
		}
		if(i==36)
		{
			conversion = "18:00";
		}
		if(i==37)
		{
			conversion = "18:30";
		}
		if(i==38)
		{
			conversion = "19:00";
		}
		if(i==39)
		{
			conversion = "19:30";
		}
		if(i==40)
		{
			conversion = "20:00";
		}
		if(i==41)
		{
			conversion = "20:30";
		}
		if(i==42)
		{
			conversion = "21:00";
		}
		if(i==43)
		{
			conversion = "21:30";
		}
		if(i==44)
		{
			conversion = "22:00";
		}
		if(i==45)
		{
			conversion = "22:30";
		}
		if(i==46)
		{
			conversion = "23:00";
		}
		if(i==47)
		{
			conversion = "23:30";
		}
		return conversion;
	}
}