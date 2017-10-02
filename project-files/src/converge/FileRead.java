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
		
		//Declare input stream
		FileReader in = null;
		
		//Navigate to event log directory where events are stored as .txt files
		File folder = new File("event_log/");
		
		//Create a list of all the files in the directory
		File[] listOfFiles = folder.listFiles();

		//Iterate through files
		for (int i = 0; i < listOfFiles.length; i++) 
		{
		  File file = listOfFiles[i];
		  System.out.println(file.getName());
		  if (file.isFile() && file.getName().endsWith(".event")) 
		  {
				//in file object within try catch block
		        try 
		        {
					in = new FileReader(file);
				}
		        catch (FileNotFoundException e) 
		        {
					e.printStackTrace();
				}
		        
		        //Take file input as multiple lines in 'record' list
	            BufferedReader bufferedReader = new BufferedReader(in);
		        String line = null;
		        int month, day, year, avail = 0;
		        String name, attendeeName, date = "";
		        Vector<TimeSlot> adminAvailability = new Vector<TimeSlot>();
		        Vector<Attendee> attendees = new Vector<Attendee>();
			  	ArrayList<String> records = new ArrayList<String>();

		        //Adds every line to 'record' list
		        while ((line = bufferedReader.readLine()) != null)
		        {
		          records.add(line);
		        }
		        
		        //Assign first value as event name
		        name = records.get(0);
		        
		        //Assign second value as attendee name
//		        attendeeName = records.get(1);
		        
		        //Iterate through admin availability and each attendee in file
		        int attendeeIndex = 1;
		        do
		        {
		        	//Index records to find
			        line = records.get(attendeeIndex);
			        String[] splitLine = line.split("\\s+");
			        attendeeName = splitLine[0];
			        month = 	Integer.parseInt(splitLine[1]);
			        day =	Integer.parseInt(splitLine[2]);
			        year = 	Integer.parseInt(splitLine[3]);
			        avail = 	Integer.parseInt(splitLine[4]);

		        		
//		        		String temp = records.get(attendeeIndex);
//		        		int tempInt = 0;
//		        		String[] splitAtt = temp.split("\\s+");
//		        		String attendeeName = null;
		        		Vector<TimeSlot> availability = new Vector<TimeSlot>();
		        		
//		        		//Within the line, consider the int values as the user availability
//		        		int availabilityIndex = 0;
//		        		do
//		        		{
//			        		try 
//			        		{
//			        			//If the value can be parsed, add to availability
//			        		    tempInt = Integer.parseInt(splitAtt[availabilityIndex]);
//			        		    TimeSlot tempTimeSlot = new TimeSlot(month, day, year, tempInt);
//			        		    availability.add(availabilityIndex, tempTimeSlot);	
//			        		} 
//			        		catch (NumberFormatException e) 
//			        		{
//			        			//Otherwise set that value as the name of the user
//			        			if (attendeeName == null)
//			        			{
//			        				attendeeName = splitAtt[availabilityIndex];
//			        			}
//			        			else
//			        			{
//				        		    attendeeName = attendeeName + " " + splitAtt[availabilityIndex];
//			        			}
//			        		}
//			        		availabilityIndex++;
//		        		} while (availabilityIndex < splitAtt.length);
		        		
		        		//Consider the nameless line as the admin availability
		        		if (attendeeName == null)
		        		{
		        			adminAvailability = availability;
		        		}
		        		else
		        		{
		        			//Otherwise add the attendee to the vector of attendees
			        		Attendee a = new Attendee(attendeeName, availability);
			        		attendees.add(a);
		        		}
		        		
		        		attendeeIndex++;
		        } while(attendeeIndex < records.size());
		        
		        //Create event with values from file
		        Event e = new Event(name, attendees, adminAvailability);
		        events.add(e);
		  } 
		}
		//Et voila!
		return events;
	}
}
