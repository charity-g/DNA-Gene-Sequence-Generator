import java.lang.*;

class Generator {

  // VARIABLES
  public String seq = "";
  private String firstC;
  private String seconC;
  private String thirdC;
  // CONSTUCTORS

  // ACCESSORS
  public String getSeq() { // seq getter
    return seq;
  }

  public void clearSeq() { // seq setter
    this.seq = "";
  }

  // MAIN METHOD, purpose: to generate a coding strand sequence DNA
  public void genSeq(int codonCount) {
    startCodon();
    addCodons(codonCount);
    addStop();

  }

  // SUBMETHODS
  // startCodon, purpose: to put DNA coding strand “ATG” in string
  private void startCodon() {
    seq += "ATG";
  }

  // addCodons, purpose: to add as many codons as required by user
  private void addCodons(int counter) {
    for (int i = 0; i < counter; i++) {
      addCodon();
    }
  }

  // addCodon, purpose: to add ONE codon, ensures a stop codon is not added
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

  // overloading ChooseOutOf
  static String outOf2(String a, String b) {
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

  static String chooseOutOf3(String a, String b, String c) {
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

  // addStop, purpose: to put DNA coding strand “ATG” in string
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
