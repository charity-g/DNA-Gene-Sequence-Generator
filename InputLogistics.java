import java.util.Scanner; // Import the Scanner class

class InputLogistics {
  Scanner scan = new Scanner(System.in);
  Generator generate = new Generator();
  Checker check = new Checker();

  int codonCount = 0;
  int branchChoice;
  String dnaSeq = "temporary placeholder";

  // intializing question
  public void ask() {
    System.out.println(
        "\n\n\nPlease type the number of the following options:\n🐛 1\tGenerate a DNA CODING STRAND sequence.\n\t\t• \tWhat is a  coding strand? To learn, please enter \"12\"\n🐛 2\tGenerate a mock exam problem.\n\t\t•Has teacher vers and student ver!\n🐛 3\tInput a DNA CODING sequence to check if it is a valid sequence!\n🐛 4\tInput a DNA Seq and recieve it's coding and template strands");
    branchChoice = scan.nextInt();
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

  // ask for DNA coding strand to begin checker for coding strand. If you would
  // like the program to digitally convert a template strand to a coding strand,
  // please restart it and choose option 4.
  public void startCheck() {
    System.out.println("No spaces"); // !!!
    dnaSeq = scan.nextLine();

    if (!dnaSeq.equals("temporary placeholder")) {
      check.Check(dnaSeq);
    } else {
      System.out.println("You have somehow not entered anything.");
    }
    //need to check if dnaSeq is a string or not or something
    //then
    //check. FUNCTION/METHOD here with inserted dnaSeq
  }

}