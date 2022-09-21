import java.util.Scanner; // Import the Scanner class

class InputLogistics {
  Scanner scan = new Scanner(System.in);
  Generator generate = new Generator();
  CheckerStates check = new CheckerStates();
  Complement complement;

  int codonCount = 0;
  int branchChoice;
  String dnaSeq = "temporary placeholder";

  // EFFECT: asks question + record's user's choice
  public void ask() {
    System.out.println(
        "\n\n\nPlease type the number of the following options:\n🐛 1\tGenerate a DNA CODING STRAND sequence.\n\t\t• \tWhat is a  coding strand? To learn, please enter \"12\"\n🐛 2\tGenerate a mock exam problem.\n\t\t•Has teacher vers and student ver!\n🐛 3\tInput a DNA CODING sequence to check if it is valid.\n\t\t• \tWhat is do the terms 5' and 3' mean? To learn, please enter \"31\"!\n🐛 4\tInput a DNA Seq and recieve it's complementary strand");
    branchChoice = scan.nextInt();
    scan.nextLine(); // here to reset the line for the next input
  }

  // EFFECT: records codonCount and if codonCount is a valid number, begins the
  // generator
  public void startGen() {
    System.out.println(
        "You will be producing a sequence that goes from 5' to 3'. To learn more, please restart the program and enter \"31\".\n \n To begin the generator, please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");

    codonCount = scan.nextInt();
    if (codonCount <= 10 && codonCount >= 0) {
      generate.genSeq(codonCount);
      System.out.println("The generated sequence, from start to stop is: " + generate.getSeq());
    } else {
      System.out.println("That is not an allowed number of codons, please try again >:(");
    }
  }

  // EFFECT: records the user's dnaSeq from 5' -> 3' and calls the methods to check it
  public void startCheck() {
    System.out.println(
        "Please enter your coding strand, from 5' to 3'. No spaces.\nIf you don't understand what 5' and 3' means, please restart the program and choose option 31.");
    dnaSeq = scan.nextLine();

    if (!dnaSeq.equals("temporary placeholder")) {
      check.initialize(dnaSeq);
    } else {
      System.out.println("You have somehow not entered anything.");
    }
    dnaSeq = "temporary placeholder";
  }

  // EFFECT: takes in a DNA sequence and if the codons are all valid, then it will
  // ask the user to choose it's desired output, and call the necessary methods to
  // perform that
  public void makeComplement() {
    System.out.println("Please input your sequence. It doesn't matter whether it is 5' to 3' or 3' to 5'.");
    String sequenceAns = scan.nextLine();
    ;
    complement = new Complement(sequenceAns);
    if (complement.valid()) {
      System.out.println(
          "You have a valid DNA sequence. \nPlease enter the type of output you would like you sequence to be made in: \n- \"DNA\" for the complementary DNA sequence \n- \"RNA 1\" for the same DNA sequence but in RNA nucleotides\n- \"RNA 2\" for the complementary DNA sequence");
      String desiredOutput = scan.nextLine();
      switch (desiredOutput) {
        case "DNA":
          complement.complementSeqDNA();
          System.out.println("Your sequence is: " + complement.seq + " and the complement DNA sequence is: "
              + complement.complementSeq);
          break;
        case "RNA 1":
          break;
        case "RNA 2":
          break;
        default:
          System.out.println("That is not an option, please try again.");
      }
    } else {
      System.out.println(
          "This is not a possible DNA sequence. Please double check that you have not entered an RNA sequence or made any typos.");
    }
  }

}
