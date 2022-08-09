import java.lang.*;

class Generator {

  // VARIABLES
  public String seq = "";
  // CONSTUCTORS

  // ACCESSORS

  // METHODS
  // startCodon, purpose: to put DNA coding strand “ATG” in string
  public void startCodon() {
    seq += "ATG";
  }

  // addCodons, purpose: to add as many codons as required by user
  public void addCodons(int counter) {

  }

  // addCodon, purpose: to add ONE codon, ensures a stop codon is not added
  public void addCodon() {
    for (int i = 0; i < 3; i++) {
      // (int)(Math.random() * 3)
    }
  }

  // addStop, purpose: to put DNA coding strand “ATG” in string
  public void addStop() {
    switch ((int)(Math.random() * 3)) {
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
