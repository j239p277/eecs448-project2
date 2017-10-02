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
	 * This is a method that will take in ints placed in the availability vectors
	 * and will convert it into its corresponding time string for 12 hour mode.
	 * 
	 * @param i This is the integer value given to the method.
	 * @return A string representing the integers corresponding time string.
	 */
	public String twelveHourConversion(int i) 
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
	
	/**
	 * This is a method that will take in ints places in the availability vectors
	 * and will convert it into its corresponding time string for 24 hour mode.
	 * 
	 * @param i This is the integer value given to the method.
	 * @return A string representing the integers corresponding time string.
	 */
	public String twentyFourHourConversion(int i) 
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
	
	/**
	 * Converts time strings for 12 hour mode as its corresponding integer for the availability vectors.
	 * 
	 * @param time The time as a string that the user inputs in 12 hour mode.
	 * @return an integer representing the time string's corresponding integer for the availability vector.
	 */
	public static int twelveHourtoInt(String time)
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
	public static int twentyFourHourtoInt(String time)
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
	 * vector that holds integers 0-47 that each represent time availability in 30
	 * minute periods throughout the day.
	 */
	Vector<Integer> timeVec = new Vector<Integer>() ;
	{ 
	for (int i = 0; i < 48; i++)
		{
//			TimeSlot temp = null;
//			temp.setDay(currentDay);
//			temp.setMonth(currentMonth);
//			temp.setYear(currentYear);
//			temp.setAvailability(i);
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
	
	/**
	 * Method runs the user interaction allowing the admin to create an event.
	 * @throws IOException On invalid user input
	 */
	public void start() throws IOException 
	{
		//prompt for name
		clearPrint("Enter the name of the event:");
		//sets Name of the event to the string the user inputs
		adminEvent.setEventName(userInput.nextLine());
		
		clearPrint("Enter your name:");
		admin.setName(userInput.nextLine());
		
		int[] date = requestDate();
		
		adminEvent.setMonth(date[0]);
		adminEvent.setDay(date[1]);
		adminEvent.setYear(date[2]);
		
		boolean invalidInput = true;
		clearScreen();
		while(invalidInput) 
		{
			System.out.println("12 Hour / 24 Hour Mode? (12/24):");
			userInput.nextLine();
				try {
					choice = userInput.nextInt();
					if(choice == 12 || choice == 24) 
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
		
		if (choice == 12)
		{
			String cont;
			do
			{
				clearPrint("Input your starting availability. Format: 1:00PM");
				startAvailability = userInput.next();
				//checks to see if the time the user input is valid
				while(twelveHourtoInt(startAvailability) == 50) 
				{
					clearPrint("Error\nThe time inputted is invalid.\nInput your starting availability. Format: 1:00PM");
					startAvailability = userInput.next();
				}
				
				clearPrint("Input your ending availability. Format: 1:00PM");
				endAvailability = userInput.next();
				
				//checks to see if the time the user input was valid
				while((twelveHourtoInt(endAvailability) == 50) || (twelveHourtoInt(endAvailability) < twelveHourtoInt(startAvailability))) 
				{
					//checks if the String the user input isn't valid
					clearPrint("Error\nThe time inputted is invalid.\nInput your ending availability. Format: 1:00PM");
					endAvailability = userInput.next();
				}
				
				//adds the availability times of the admin
				for( int i = twelveHourtoInt(startAvailability); i<twelveHourtoInt(endAvailability); i++)
				{
					TimeSlot temp = null;
					temp.setDay(currentDay);
					temp.setMonth(currentMonth);
					temp.setYear(currentYear);
					temp.setAvailability(i);
					timeVec.addElement(i);
					adminEvent.a_adminAvailability.addElement(temp);
					admin.availability.addElement(temp);
				}
				
				clearPrint("Would you like to add another slot of availability? (type 'yes'/'no')");
				cont = userInput.next();
				
			} while (cont.charAt(0) == 'y' || cont.charAt(0) == 'Y');
		}
		else if (choice == 24)
		{
			String cont;
			do
			{
				clearPrint("Input your starting availability. Format: 13:00");
				startAvailability = userInput.next();
				//checks to see if the time the user input is valid
				while(twentyFourHourtoInt(startAvailability) == 50) 
				{
					clearPrint("Error\nThe time inputted is invalid.\nInput your starting availability. Format: 13:00");
					startAvailability = userInput.next();
				}
				
				clearPrint("Input your ending availability. Format: 13:00");
				endAvailability = userInput.next();
				
				//checks to see if the time the user input was valid
				while((twentyFourHourtoInt(endAvailability) == 50) || (twentyFourHourtoInt(endAvailability) < twentyFourHourtoInt(startAvailability))) 
				{
					//checks if the String the user input isn't valid
					clearPrint("Error\nThe time inputted is invalid.\nInput your ending availability. Format: 13:00");
					endAvailability = userInput.next();
				}
				
				//adds the availability times of the admin
				for( int i = twentyFourHourtoInt(startAvailability); i<twentyFourHourtoInt(endAvailability); i++)
				{
					TimeSlot temp = new TimeSlot(0,0,0,0);
					temp.setDay(currentDay);
					temp.setMonth(currentMonth);
					temp.setYear(currentYear);
					temp.setAvailability(i);
					timeVec.addElement(i);
					adminEvent.a_adminAvailability.addElement(temp);
					admin.availability.addElement(temp);
				}
				
				clearPrint("Would you like to add another slot of availability? (type 'yes'/'no')");
				cont = userInput.next();
				
			} while (cont.charAt(0) == 'y' || cont.charAt(0) == 'Y');
		}
		
		adminEvent.addAttendee(admin);
		adminEvent.exportEvent();
		
		clearPrint("The event " + adminEvent.getEventName() + " has been successfully created!");
	} //ends start method
	
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
	
	/**
	 * This method requests the Admin's event date and stores it in an integer array.
	 * 
	 * @return an integer array that stores the date in the format mm/dd/yyyy.
	 */
	private int[] requestDate()
	{
		int year = 0;
		int month = 0;
		int day = 0;
		boolean cont = false;
		clearScreen();
		while (!cont)
		{
			System.out.println("Enter date of event (mm/dd/yyyy): ");
			String date = userInput.next();
			
			//Check year input with current year and integer status
			try
			{
				if (date.length() < 10)
				{
					throw new NumberFormatException();
				}
				
				String monthString = new StringBuilder().append(date.charAt(0)).append(date.charAt(1)).toString();
				String dayString = new StringBuilder().append(date.charAt(3)).append(date.charAt(4)).toString();
				String yearString = new StringBuilder().append(date.charAt(6)).append(date.charAt(7)).append(date.charAt(8)).append(date.charAt(9)).toString();

				year = Integer.parseInt(yearString);
				month = Integer.parseInt(monthString);
				day = Integer.parseInt(dayString);
				cont = true;
				if (year < currentYear)
				{
					throw new NumberFormatException();
				}
				else if (month < currentMonth && year == currentYear && day < currentDay)
				{
					throw new NumberFormatException();
				}
				else if (day > 31 || day < 1)
				{
					throw new NumberFormatException();
				}
				else if((day > 30 && ((month == 4) || (month == 6) || (month == 9) || (month == 11))) || (day > 29 && month == 2 && year%4 == 0) || (day > 28 && month == 2 && year%4 != 0))
				{
					throw new NumberFormatException();
				}
			}
			catch (NumberFormatException e)
			{
				clearPrint("Error\nThe date inputted is invalid\n"); //Re-prompt
				cont = false;
			}
		}
		
		int[] returnDate = new int[3];
		returnDate[0] = month;
		returnDate[1] = day;
		returnDate[2] = year;
		
		return returnDate;
	}
} //ends AddEvent class
