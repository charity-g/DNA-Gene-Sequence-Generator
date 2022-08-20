import java.util.Scanner; // Import the Scanner class

class InputLogistics {
  Scanner scan = new Scanner(System.in);
  Generator generate = new Generator();
  CheckerStates check = new CheckerStates();

  int codonCount = 0;
  int branchChoice;
  String dnaSeq = "temporary placeholder";

  // intializing question
  public void ask() {
    System.out.println(
        "\n\n\nPlease type the number of the following options:\n🐛 1\tGenerate a DNA CODING STRAND sequence.\n\t\t• \tWhat is a  coding strand? To learn, please enter \"12\"\n🐛 2\tGenerate a mock exam problem.\n\t\t•Has teacher vers and student ver!\n🐛 3\tInput a DNA CODING sequence to check if it is a valid sequence!\n🐛 4\tInput a DNA Seq and recieve it's coding and template strands");
    branchChoice = scan.nextInt();
    scan.nextLine();
  }

  // ask for codonCount to begin generator
  public void startGen() {
    System.out.println(
        "Please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");

    codonCount = scan.nextInt();
    if (codonCount <= 10 && codonCount >= 0) {
      generate.genSeq(codonCount);
      System.out.println("The generated sequence, from start to stop is: " + generate.getSeq());
      generate.clearSeq();
    } else {
      System.out.println("That is not an allowed number of codons, please try again >:(");
    }
  }

  public void startCheck() {
    System.out.println("Please enter your coding strand, from 5' to 3'. No spaces.\nIf you don't understand what 5' and 3' means, please restart the program and choose option 31.");
    dnaSeq = scan.nextLine();

    if (!dnaSeq.equals("temporary placeholder")) {
      check.initialize(dnaSeq);
    } else {
      System.out.println("You have somehow not entered anything.");
    }
    dnaSeq = "temporary placeholder";
  }

}