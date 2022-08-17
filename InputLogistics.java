import java.util.Scanner; // Import the Scanner class

class InputLogistics {
  Scanner scan = new Scanner(System.in);
  Generator generate = new Generator();

  int codonCount = 0;
  int branchChoice;


  //intializing question
  public void ask() {
    System.out.println("\n\n\nPlease choose enter the number of the following options:\n🐛 1\tGenerate an accurate DNA CODING STRAND sequence from the start codon to the stop codon.\n\t\t• \tFor more information about the difference between coding and template strands, please enter the number \"12\"\n🐛 2\tGenerate a problem to test yourself on your understanding of DNA questions. Good for teachers and students!\n🐛 3\tInput a DNA sequence of your own and let the computer check if it is correct!");
    branchChoice = scan.nextInt();
  }

  
  //ask for codonCount to begin generator
  public void startGen() {
    System.out.println(
          "Please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");
  
    codonCount = scan.nextInt();
    if (codonCount <= 10) {
      generate.genSeq(codonCount);
      System.out.println("The generated sequence is: " + generate.getSeq());
      generate.clearSeq();
    }
}
  
}