
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
    
    


