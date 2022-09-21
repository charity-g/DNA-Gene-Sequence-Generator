import java.lang.*;

class Generator {

  // VARIABLES
  private String seq;
  private String firstC;
  private String seconC;
  private String thirdC;

  // CONSTRUCTOR
  // EFFECTS: Initializes seq to be empty
  Generator() {
    seq = "";
  }

  // ACCESSOR
  public String getSeq() {
    return seq;
  }

  // MAIN METHOD
  // MODIFIES: this
  // EFFECTS: adds the appropriate number of codons to the variable seq
  public void genSeq(int codonCount) {
    startCodon();
    addCodons(codonCount);
    addStop();

  }

  // SUBMETHODS
  // REQUIRES: seq to be empty
  // MODIFIES: this
  // EFFECTS: to initialize the start codon
  private void startCodon() {
    seq += "ATG";
  }

  // REQUIRES: start codon to have been added in seq
  // MODIFIES: this
  // EFFECTS: to add as many codons as counter
  private void addCodons(int counter) {
    for (int i = 0; i < counter; i++) {
      addCodon();
    }
  }

  // REQUIRES: start codon to have been added in seq
  // MODIFIES: this
  // EFFECTS: to add ONE codon, and ensures a stop codon is not added
  private void addCodon() {
    firstC = chooseCodon();
    seconC = chooseCodon();
    thirdC = chooseCodon();

    // preventing stop codons from being prematurely generated
    if (firstC == "T") {
      switch (seconC) {
        case "A":
          if (thirdC == "A" || thirdC == "G") {
            thirdC = outOf2("C", "T");
          }
          break;
        case "G":
          if (thirdC == "A") {
            thirdC = chooseOutOf3("C", "T", "G");
          }
          break;
      }
    }
    seq = seq + firstC + seconC + thirdC;
  }

  // EFFECTS: returns randomly one of the following: "A", "T", "C", "G"
  private String chooseCodon() {
    String choice = "";
    switch ((int) (Math.random() * 4)) {
      case 0:
        choice = "A";
        break;
      case 1:
        choice = "T";
        break;
      case 2:
        choice = "G";
        break;
      case 3:
        choice = "C";
        break;
    }
    return choice;
  }


  // EFFECTS: choose randomly a or b
  private String outOf2(String a, String b) {
    String choice = "";
    switch ((int) (Math.random() * 2)) {
      case 0:
        choice = a;
        break;
      case 1:
        choice = b;
        break;
    }
    return choice;
  }

  // EFFECTS: choose randomly out of the 3 options, a, b, or c
  private String chooseOutOf3(String a, String b, String c) {
    String choice = "";
    switch ((int) (Math.random() * 3)) {
      case 0:
        choice = a;
        break;
      case 1:
        choice = b;
        break;
      case 2:
        choice = c;
        break;
    }
    return choice;
  }

  // REQUIRES: a start codon to be added to seq prior to this
  // MODIEFIES: this
  // EFFECTS: to put any one of the DNA stop codons in seq
  private void addStop() {
    switch ((int) (Math.random() * 3)) {
      case 0:
        seq += "TAG";
        break;
      case 1:
        seq += "TAA";
        break;
      case 2:
        seq += "TGA";
        break;
      default:
        seq += "TAA";
    }
  }

}
