package converge;

import java.io.*;
import java.util.Vector;

public class FileIO {
	
	public void loadEventsVector(Vector<Event> eventsVector) {
		File eventsFile = new File("events.txt");
		
		if(eventsFile.exists()) { //check if "events.txt" even exists
			
			String eventName, hostName, numberOfDays, numberOfTasks, numberOfAttendees;
			String[] tempTimes, tempAttendeeAndTasks;
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader("events.txt")); //open file reader
				
				while((eventName = reader.readLine()) != null) { //read the whole file (also get event name)
					
					hostName = reader.readLine();  //get host name
					numberOfDays = reader.readLine(); //get number of days to control following for loop
					
					Vector<Vector<String>> datesAndTimes = new Vector(); //create a new datesAndTimes vector to hold info from file
					for(int i = 0; i < Integer.parseInt(numberOfDays); i++) { //get all datesAndTimes
						Vector<String> tempDay = new Vector();
						
						tempTimes = reader.readLine().split(" ");
						
						for(int j = 0; j < tempTimes.length; j++) {
							tempDay.addElement(tempTimes[j]);
						}
						
						datesAndTimes.addElement(tempDay);
					}
					
					numberOfTasks = reader.readLine(); //get number of tasks to control following for loop
					Vector<String> tasks = new Vector(); //create a new tasks vector to hold information from file
					for(int i = 0; i < Integer.parseInt(numberOfTasks); i++) { //get all tasks
						tasks.addElement(reader.readLine());
					}
					
					numberOfAttendees = reader.readLine(); //get number of attendees to control following for loop
					Vector<Vector<String>> attendees = new Vector(); //create a new attendees vector to hold information from file
					for(int i = 0; i < Integer.parseInt(numberOfAttendees); i++) { //get all attendees
						Vector<String> tempAttendee = new Vector();
						
						tempAttendeeAndTasks = reader.readLine().split("~");
						
						for(int j = 0; j < tempAttendeeAndTasks.length; j++) {
							tempAttendee.addElement(tempAttendeeAndTasks[j]);
						}
						
						attendees.addElement(tempAttendee);
					}
					eventsVector.addElement(new Event(eventName, hostName, datesAndTimes, tasks, attendees)); //add event to events vector that will be returned
					reader.readLine(); //read in blank line that separates events
				}	
				
				reader.close();
				
			} catch(Exception e) { //if anything goes wrong during this process, return an empty vector
				System.out.println("error");
				eventsVector = new Vector();
			}
			
		} else { //if "events.txt" does not exists simply return an empty vector
			eventsVector = new Vector();
		}
	}
	
	public void saveEventsVector(Vector<Event> eventsVector) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("events.txt", false)); //create file writer, output will be stored in "events.txt"
			
			for(int i = 0; i < eventsVector.size(); i++) { //for each event in the events vector
				writer.write(eventsVector.elementAt(i).getEventName()); //write the event name
				writer.newLine();
				writer.write(eventsVector.elementAt(i).getHostName()); //write the host name
				writer.newLine();
				
				writer.write(Integer.toString(eventsVector.elementAt(i).getDatesAndTimes().size())); //write the number of days the event takes place over
				writer.newLine();
				
				for(int j = 0; j < eventsVector.elementAt(i).getDatesAndTimes().size(); j++) { //for each day the event takes place over
					
					for(int k = 0; k < eventsVector.elementAt(i).getDatesAndTimes().elementAt(j).size(); k++) { //loop through all the times
						
						if(k < eventsVector.elementAt(i).getDatesAndTimes().elementAt(j).size() - 1) { //if its not the last time in the vector, put a space after it, separating individual times
							writer.write(eventsVector.elementAt(i).getDatesAndTimes().elementAt(j).elementAt(k) + " ");
						} else { //but if its the last element in the vector, do not put a space after
							writer.write(eventsVector.elementAt(i).getDatesAndTimes().elementAt(j).elementAt(k));
						}
					}
					
					writer.newLine(); //print each day on a separate line
				}
				
				writer.write(Integer.toString(eventsVector.elementAt(i).getTasks().size())); //write the number of tasks for the event
				writer.newLine();
				
				for(int j = 0; j < eventsVector.elementAt(i).getTasks().size(); j++) {
					writer.write(eventsVector.elementAt(i).getTasks().elementAt(j));
					writer.newLine(); //print each task on its own line
				}
				
				writer.write(Integer.toString(eventsVector.elementAt(i).getAttendees().size())); //write the number of people attending the event
				writer.newLine();
				
				for(int j = 0; j < eventsVector.elementAt(i).getAttendees().size(); j++) { //for each attendee for the event
					
					for(int k = 0; k < eventsVector.elementAt(i).getAttendees().elementAt(j).size(); k++) { //print their name and the tasks they signed up for
						
						if(k < eventsVector.elementAt(i).getAttendees().elementAt(j).size() - 1) {
							writer.write(eventsVector.elementAt(i).getAttendees().elementAt(j).elementAt(k) + "~"); //separate attendee name and each event with a ~
						} else {
							writer.write(eventsVector.elementAt(i).getAttendees().elementAt(j).elementAt(k));
						}
					}
					
					writer.newLine(); //print the name (and tasks) of each attendee on its own line
				}
				
				writer.newLine(); //have a blank line between each event (for clarity)
			}
			writer.close();
		} catch(Exception e) {
			System.out.println("error");
		}
	}
	
}