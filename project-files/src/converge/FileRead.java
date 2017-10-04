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
	public Vector<Event> readEvents() throws IOException {
		//Declare List of events
		Vector<Event> events = new Vector<Event>();
		//Declare input stream
		FileReader in = null;
		BufferedReader bufferedReader = null;
		String line = null;
		List<String> records = new ArrayList<String>();
		Vector<Integer> adminAvailability = new Vector<Integer>();
		Vector<Attendee> attendees = new Vector<Attendee>();
		Vector<String> task = new Vector<String>();
		
		//Navigate to event log directory where events are stored as .txt files
		File folder = new File("bin/");
		
		//Create a list of all the files in the directory
		File[] listOfFiles = folder.listFiles();

		//Iterate through files
		for (int i = 0; i < listOfFiles.length; i++) 
		{
		  File file = listOfFiles[i];
//		  System.out.println(file.getName());
		  if (file.isFile() && file.getName().endsWith(".txt")) // TODO CHANGED FROM ".event" ??? YES/NO
		  {
				try {
					System.out.println(file.getName());
					in = new FileReader(file);
					bufferedReader = new BufferedReader(in);
				}
		        catch (FileNotFoundException e) {
		        		System.err.println("Error reading events. Stack trace: ");
					e.printStackTrace();
				}
//						finally {
//							try {
//								if (bufferedReader != null) {
//									bufferedReader.close();
//								}
//								if (in != null) {
//									in.close();
//								}
//							} catch (IOException ex) {
//								ex.printStackTrace();
//							}
//						}
				  
		//Iterate through files
		//Adds every line to 'record' list
		while ((line = bufferedReader.readLine()) != null)
		{
			System.out.println(line);
			records.add(line);
		}
		        
		//Assign first value as event name
		String name = records.get(0);
		        
		//Assign second value as date
		String dateAndTimesLine = records.get(1);
		String[] splitDateAndTimes = dateAndTimesLine.split("\\s+");
//		int month = 	Integer.parseInt(splitLine[0]);
//		int day =	Integer.parseInt(splitLine[1]);
//		int year = 	Integer.parseInt(splitLine[2]);
		
		// TODO GET DATES AND TIMES
		// TODO GET TASKS
		String tasksLine = records.get(2);
		String[] splitTasks = tasksLine.split("\\s+");
		
		//Iterate through admin availability and each attendee in file
		int attendeeIndex = 3; // Which line attendees start in each file
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
		Event e = new Event(name, dateAndTimesLine, attendees, adminAvailability, task);
//		Event e = new Event(name, date, attendees, adminAvailability, task);	// TODO USE WHEN DATE FINISHED
		events.add(e);
			}
		}
		//Et voila!
		return events;
	}
}
