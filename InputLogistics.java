import java.util.Scanner; // Import the Scanner class

class InputLogistics {
  Scanner scan = new Scanner(System.in);
  Generator generate = new Generator();

  int codonCount = 0;
  int branchChoice;

  // intializing question
  public void ask() {
    System.out.println(
        "\n\n\nPlease type the number of the following options:\n🐛 1\tGenerate a DNA CODING STRAND sequence.\n\t\t• \tWhat is a  coding strands? To learn, please enter \"12\"\n🐛 2\tGenerate a mock exam problem.\n\t\t•Has teacher vers and student ver!\n🐛 3\tInput a DNA CODING sequence to check if it is a valid sequence!");
    branchChoice = scan.nextInt();
  }

  // ask for codonCount to begin generator
  public void startGen() {
    System.out.println(
        "Please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");

    codonCount = scan.nextInt();
    if (codonCount <= 10) {
      generate.genSeq(codonCount);
      System.out.println("The generated sequence, from start to stop is: " + generate.getSeq());
      generate.clearSeq();
    }
  }

}