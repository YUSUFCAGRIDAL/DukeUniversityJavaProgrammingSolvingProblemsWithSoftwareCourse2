/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author YUSUF ÇAĞRI DAL 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
	public void printNames () {
		FileResource fr = new FileResource(); // we created a FileResource and leave it empty to chose from files from UI
		for (CSVRecord rec : fr.getCSVParser(false)) {//CSV file does not have header row. false means that
			int numBorn = Integer.parseInt(rec.get(2)); //only print out the names, we change string value to integer
			if (numBorn <= 100) { //we want only names under 100
				System.out.println("Name " + rec.get(0) + //because we don't have header, we use numbers. 0 means first row
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) { //how many girls and boys born in a given year
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
	}
}
