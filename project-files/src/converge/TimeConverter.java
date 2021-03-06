package converge;

/**
 * Contains methods that allow switching between 12 and 24 hour mode.
 * @since 2017-10-8
 */

public class TimeConverter {
	/**
	 * Converts arbitrary fileIO ints to their corresponding strings in the 12 hour format
	 *
	 * @param i integer value representing an abstract time
	 * @return a string representing a time in the 12 hour format
	 */
	public static String twelveHourConversion(int i)
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
	 * Converts arbitrary fileIO ints to their corresponding strings in the 24 hour format
	 *
	 * @param i integer value representing an abstract time
	 * @return a string representing a time in the 24 hour format
	 */
	public static String twentyFourHourConversion(int i)
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
	 * Converts 12 hour time strings to abstract ints for fileIO
	 *
	 * @param time string representing the time in 12 hour format
	 * @return arbitrary integer representing time
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
	 * Converts 24 hour time strings to abstract ints for fileIO
	 *
	 * @param time string representing the time in 24 hour format
	 * @return arbitrary integer representing time
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