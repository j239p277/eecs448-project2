package converge;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

/**
 * The main.java file will be used to run the Convergent App.
 * 
 * @author Menita Vedantam
 * @since 2017-09-15
 */
public class Main {
	public static void main(String []args) throws IOException
	{
		Scanner myScan = new Scanner(System.in);
		String choice = "";
		boolean incorrectInput = true;
		boolean cont = true;
		int c = 0;
		AddEvent AdminEvent = new AddEvent();

		while (cont)
		{
			incorrectInput = true;
			while(incorrectInput) {
				clearPrint("What would you like to do?\n 1. Create an Event\n 2. Join an event\n 3. View an existing event\n 0. Quit\nPlease enter number corresponding to the option you choose.");
				try 
				{
					if (!myScan.hasNextInt())
					{
						myScan.next();
						throw new Exception();
					}
					
					c = myScan.nextInt();
					
					if(c == 0 || c == 1 || c == 2 || c == 3) {
						incorrectInput = false;
					}
				}
				catch (Exception e)
				{
					System.out.println("Error\nPlease enter valid option.");
				}
			}
			if (c == 0)
			{
				clearScreen();
				System.exit(0);
			}
			else if(c == 1) 
			{

AdminEvent.start();
			}
			else if (c == 2) {
//				JoinEvent.run();	TODO
			}
			else if (c == 3)
			{
				JoinEvent.view();
			}

			c = 0;
			incorrectInput = true;
			choice = "";
			String exit = "";

			while (incorrectInput)
			{
				try 
				{
					System.out.println("\nType 'return' to return to main menu\nType 'quit' to exit:\n");
					//myScan.next();
					exit = myScan.next();
					if (exit.equals("quit"))
					{
						clearScreen();
						cont = false;
						incorrectInput = false;
						System.exit(0);
					}
					else if (exit.equals("return"))
					{
						cont = true;
						incorrectInput = false;
					}
					else
					{
						throw new Exception();
					}
				}
				catch (Exception e)
				{
					clearPrint("Error\nPlease enter valid option.");
				}
			}
		}
		clearScreen();
		myScan.close();
	}
	
	/**
	 * Checks to see if the given value is an integer.
	 * @param s the string that will be checked to see if it is
	 * an integer.
	 * @return boolean that determines if the string is an integer.
	 */
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException e) { 
	        return false; 
	    } 
	    catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Method that clearly prints whatever string is given to the method.
	 * 
	 * @param text that will be clearly printed.
	 */
	private static void clearPrint(String text)
	{
		clearScreen();
		System.out.println(text);
	}
	
	/**
	 * Method that will clear the screen of all output.
	 */
	private static void clearScreen()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("\n");
		}
	}
}