/**
 * Reads a chosen CSV file of our preferences and prints each field.
 * 
 * @author Yusuf Çağrı DAL
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
	public void readFood() {
		FileResource fr = new FileResource(); //FilesResource is empty because it allows us to chose the file we want
		CSVParser parser = fr.getCSVParser(); //it gives us CSV Parser
		for (CSVRecord record : parser){
			System.out.print(record.get("Name") + " "); // get us the field "Name"
			System.out.print(record.get("Favorite Color") + " "); 
			System.out.println(record.get("Favorite Food"));
		}
	}
}
