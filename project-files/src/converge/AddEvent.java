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
				//checks to see else if the time the user input is valid
				while(twelveHourtoInt(startAvailability) == 50) 
				{
					clearPrint("Error\nThe time inputted is invalid.\nInput your starting availability. Format: 1:00PM");
					startAvailability = userInput.next();
				}
				
				clearPrint("Input your ending availability. Format: 1:00PM");
				endAvailability = userInput.next();
				
				//checks to see else if the time the user input was valid
				while((twelveHourtoInt(endAvailability) == 50) || (twelveHourtoInt(endAvailability) < twelveHourtoInt(startAvailability))) 
				{
					//checks else if the String the user input isn't valid
					clearPrint("Error\nThe time inputted is invalid.\nInput your ending availability. Format: 1:00PM");
					endAvailability = userInput.next();
				}
				
				//adds the availability times of the admin
				for( int i = twelveHourtoInt(startAvailability); i<twelveHourtoInt(endAvailability); i++)
				{
					adminEvent.a_adminAvailability.addElement(i);
					admin.availability.addElement(i);
				}
				
				clearPrint("Would you like to add another slot of availability? (type 'yes'/'no')");
				cont = userInput.next();
				
			} while (cont.charAt(0) == 'y' || cont.charAt(0) == 'Y');
		}
		if (choice == 24)
		{
			String cont;
			do
			{
				clearPrint("Input your starting availability. Format: 13:00");
				startAvailability = userInput.next();
				//checks to see else if the time the user input is valid
				while(twentyFourHourtoInt(startAvailability) == 50) 
				{
					clearPrint("Error\nThe time inputted is invalid.\nInput your starting availability. Format: 13:00");
					startAvailability = userInput.next();
				}
				
				clearPrint("Input your ending availability. Format: 13:00");
				endAvailability = userInput.next();
				
				//checks to see else if the time the user input was valid
				while((twentyFourHourtoInt(endAvailability) == 50) || (twentyFourHourtoInt(endAvailability) < twentyFourHourtoInt(startAvailability))) 
				{
					//checks else if the String the user input isn't valid
					clearPrint("Error\nThe time inputted is invalid.\nInput your ending availability. Format: 13:00");
					endAvailability = userInput.next();
				}
				
				//adds the availability times of the admin
				for( int i = twentyFourHourtoInt(startAvailability); i<twentyFourHourtoInt(endAvailability); i++)
				{
					adminEvent.a_adminAvailability.addElement(i);
					admin.availability.addElement(i);
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