package converge;
import java.io.*;
import java.util.*;

/**
 * FileRead.java will be strictly accessed by the JoinEvents class to process
 * existing events.
 * 
 * @author Pumposh Bhat
 * @since 2017-09-15
 */
public class FileRead
{
	/**
	 * default constructor for the FileRead class.
	 */
	public FileRead() {}
	//Declare input stream
	FileReader in = null;
	BufferedReader bufferedReader = null;
	String line = null;
	List<String> records = new ArrayList<String>();
	/**
	 * Method reads and processes the event files stored in local "event_log" directory
	 * to output a vector of event objects representing the existing events.
	 * 
	 * @return vector of event type objects representing the existing events.
	 * @throws IOException On input error
	 */
	public Vector<Event> readEvents() throws IOException
	{
		//Declare List of events
		Vector<Event> events = new Vector<Event>();
		

		try {
			in = new FileReader("events.txt");
			bufferedReader = new BufferedReader(in);
		}
        catch (FileNotFoundException e) 
        {
        		System.err.println("Error reading events. Stack trace: ");
			e.printStackTrace();
		}
//		finally {
//			try {
//				if (bufferedReader != null) {
//					bufferedReader.close();
//				}
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}

		//Iterate through files
		//Adds every line to 'record' list
		while ((line = bufferedReader.readLine()) != null)
		{
			records.add(line);
		}
		        
		//Assign first value as event name
		String name = records.get(0);
		        
		//Assign second value as date
		String date = records.get(1);
		String[] splitDate = date.split("\\s+");
		int month = 	Integer.parseInt(splitDate[0]);
		int day =	Integer.parseInt(splitDate[1]);
		int year = 	Integer.parseInt(splitDate[2]);
		        
		Vector<Integer> adminAvailability = new Vector<Integer>();
		Vector<Attendee> attendees = new Vector<Attendee>();
		Vector<String> task = new Vector<String>();
		
		//Iterate through admin availability and each attendee in file
		int attendeeIndex = 2;
		do
		{
			//Index records to find
			String temp = records.get(attendeeIndex);
			int tempInt = 0;
			String[] splitAtt = temp.split("\\s+");
			String attendeeName = null;
			Vector<Integer> availability = new Vector<Integer>();
		        		
			//Within the line, consider the int values as the user availability
			int availabilityIndex = 0;
			do
			{
				try 
				{
					//If the value can be parsed, add to availability
					tempInt = Integer.parseInt(splitAtt[availabilityIndex]);
					availability.add(tempInt);
				} 
				catch (NumberFormatException e) 
				{
					//Otherwise set that value as the name of the user
					if (attendeeName == null)
			   		{
						attendeeName = splitAtt[availabilityIndex];
					}
					else
					{
						attendeeName = attendeeName + " " + splitAtt[availabilityIndex];
					}
				}
				availabilityIndex++;
			} while (availabilityIndex < splitAtt.length);
		        		
			//Consider the nameless line as the admin availability
			if (attendeeName == null)
			{
				adminAvailability = availability;
			}
			else
			{
				//Otherwise add the attendee to the vector of attendees
				Attendee a = new Attendee(attendeeName, availability); //REMOVED TASK PORTION TO TEST COMPILE, MUST REMEMBER TO ADD TASK PORTION
//				Attendee a = new Attendee(attendeeName, availability, task);
				attendees.add(a);
			}
		        		
			attendeeIndex++;
		} while(attendeeIndex < records.size());
		        
		//Create event with values from file
		Event e = new Event(name, month, day, year, attendees, adminAvailability, task);
		events.add(e);
		//Et voila!
		return events;
	}
}
