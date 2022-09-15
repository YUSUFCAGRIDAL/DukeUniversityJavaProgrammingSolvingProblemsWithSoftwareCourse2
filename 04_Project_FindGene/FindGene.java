
/**
 * Write a description of FindGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGene {
    public String findGene (String dna) {
        String result ="";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) //no ATG, we write this code, if there is no ATG we want empty string
        {
          return "";   
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if(stopIndex == -1) //no TAA, we write this code, if there is no TAA we want empty string
        {
          return "";   
        }
        
        
        result = dna.substring(startIndex, stopIndex+3); //starting from ATG until TAA, returns the DNA
                
        return result;

    }
    
    public void testGene (){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        String gene =findGene(dna);
        System.out.println("Gene "+gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene =findGene(dna);
        System.out.println("Gene "+gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene =findGene(dna);
        System.out.println("Gene "+gene);
        
        dna = "ATGTAA";
        System.out.println("DNA strand is "+dna);
        gene =findGene(dna);
        System.out.println("Gene "+gene);
        }
     
}
