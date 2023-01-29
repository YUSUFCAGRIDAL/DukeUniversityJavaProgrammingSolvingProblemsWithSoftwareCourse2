
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneWhile {
    
    public String findGene(String dna) {
        int startIndex =dna.indexOf("ATG"); //find the first occurance of ATG and call it startIndex
        int currIndex =dna.indexOf("TAA", startIndex +3); //look for TAA after ATG call it currIndex
        
        while (currIndex != -1) { //if ATG doeasn't appear in our DNA, doesn't start the program
            if((currIndex - startIndex) % 3 == 0){ //check if the distance between ATG and TAA is multiple of 3
                
                return dna.substring (startIndex, currIndex + 3); // finishes the method and gives the DNA
            
            }
            else {
                currIndex = dna.indexOf("TAA", currIndex + 3); //continue to look for right TAA and update the currIndex
                
            }
        }
        
        return ""; //no gene found. because no TAA found
    }
    
    public void testFindGeneSimple(){
        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is" + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene); 
    
    
    }


}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Part1 {
	public int findStopCodon(String dna, int startIndex, String stopCodon) {
		int currIndex = dna.indexOf(stopCodon, startIndex + 3);
		while(currIndex != -1) {
			int diff = currIndex - startIndex;
			if(diff % 3 == 0) {
				return currIndex;
			} else {
				currIndex = dna.indexOf(stopCodon, currIndex + 1);
			}
		}

		return dna.length();
	}

	public void testFindStopCodon() {
		String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        
        int dex = findStopCodon(dna, 0,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 9,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 1,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 0,"TAG");
        System.out.println(dex);

	}

	public String findGene(String dna) {
		int startIndex = dna.indexOf("ATG");
		if(startIndex == -1) {
			return "";
		}

		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");

		int minIndex = 0;
		if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
			minIndex = tagIndex;
		} else {
			minIndex = taaIndex;
		}

		if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
			minIndex = tgaIndex;
		}

		if(minIndex == -1) {
			return "";
		}

		return dna.substring(startIndex, minIndex + 3);
	}

	public void testFindGene() {
		String one = "ATFxxxyyyzzzTAAxxxTAGxxx";
		String two = "xxxATGxxxyyyxxTAGxTAAxxx";
		String three = "xyyATGxxxyyyuuuTGAxxxTAGxxx";
		String four = "xyyATGxxxyyxxxyuuuTGAxxxTAGxxx";

		System.out.println("Gene is: " + one + " " + findGene(one));
		System.out.println("Gene is: " + two + " " + findGene(two));
		System.out.println("Gene is: " + three + " " + findGene(three));
		System.out.println("Gene is: " + four + " " + findGene(four));
	}

	public void printAllGenes(String dna) {
		while (true) {
			String gene = findGene(dna);
			if (gene.isEmpty()) {
				break;
			} else {
				System.out.println(gene);
			}

		}
	} 

	public static void main() {
        Part1 test = new Part1();
        test.testFindGene();
    }
}
    
    


