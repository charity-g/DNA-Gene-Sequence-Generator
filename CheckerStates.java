class CheckerStates {
  private boolean runCheck = false;
  private String[] dnaSeqArr;
  private String result;
  private int length;
  private int codonsSeen = 0;
  private int counter;
  private int stateOn;

  // REQUIRES: counter to be <= length
  // MODIFIES: this
  // EFFECTS: adds one to counter, meaning that the program moves onto the next
  // nucleotide in array
  public void nextLetter() {
    counter++;
  }

  // MODIFIES: this
  // EFFECTS: adds a new line update to the result
  public void updateRes(String update) {
    result = result + update;
  }

  // MAIN
  // EFFECTS: resets all the fields back to beginning state and calls the method to check the nucleotides starting with the first nucleotide in the first state
  // FYI: If you are reading this and are confused on the states, know that because the sequence and order of DNA nucleotides is a state sensitive language, I used a sequential circuit to map out what nucleotides were valid given the history of nucleotides the seq had encountered.
  public void initialize(String seq) {
    result = "";
    dnaSeqArr = seq.split("");
    length = dnaSeqArr.length;
    codonsSeen = 0;
    counter = 0;
    stateOn = 0;
    runCheck = true;

    while (runCheck) {
      if (counter >= length) {
        runCheck = false;
      } else {
        callStates(stateOn);
      }
    }

    System.out.println(result);
  }

  // REQUIRE: state to begin at state 0
  // MODIFIES: this
  // EFFECTS: parses the states and calls the correct method to deal with the state
  public void callStates(int state) {
    switch (state) {
      case 0:
        s0();
        break;
      case 1:
        s1();
        break;
      case 2:
        s2();
        break;
      case 3:
        s3();
        break;
      case 4:
        s4();
        break;
      case 5:
        s5();
        break;
      case 6:
        s6();
        break;
      case 7:
        s7();
        break;
      case 8:
        s8();
        break;
      case 9:
        s9();
        break;
      default:
        runCheck = false;
        updateRes(
            "\n Somehow your sequence is off, leading to it going into a state not found. I don't what you did to get this error.");
    }
  }

  // STATES
  // REQUIRES: ALL state functions assume a specific given history, for more information about the sequential circuit the state function was based on, please see the CheckerStates.jpg file
  // MODIFIES: this
  // EFFECTS: changes the next state to an appropriate state
  private void s0() {
    switch (dnaSeqArr[counter]) {
      case "A":
        stateOn = 1;
        nextLetter();
        break;
      case "T":
      case "C":
      case "G":
        stateOn = 0;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base was found.");
        runCheck = false;
    }
  }

  private void s1() {
    switch (dnaSeqArr[counter]) {
      case "A":
        stateOn = 1;
        nextLetter();
        break;
      case "T":
        stateOn = 2;
        nextLetter();
        break;
      case "C":
      case "G":
        stateOn = 0;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base was found.");
        runCheck = false;
    }
  }

  private void s2() {
    switch (dnaSeqArr[counter]) {
      case "A":
        stateOn = 1;
        nextLetter();
        break;
      case "T":
      case "C":
        stateOn = 0;
        nextLetter();
        break;
      case "G":
        stateOn = 3;
        updateRes("\nStart codon found after " + (counter - 2) + " nucleotides.");
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s3() {
    switch (dnaSeqArr[counter]) {
      case "T":
        stateOn = 4;
        nextLetter();
        break;
      case "A":
      case "C":
      case "G":
        stateOn = 8;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s4() {
    switch (dnaSeqArr[counter]) {
      case "A":
        stateOn = 5;
        nextLetter();
        break;
      case "G":
        stateOn = 6;
        nextLetter();
        break;
      case "T":
      case "C":
        stateOn = 9;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s5() {
    switch (dnaSeqArr[counter]) {
      case "A":
      case "G":
        updateRes("\nStop codon found after " + (counter - 2)
            + " nucleotides.\nValid DNA coding sequence can be transcribed until this point. The mRNA will not see anything else after this point, and thus the computer also will not have seen anything after this point.");
        updateRes("\nThe given dna gene has " + codonsSeen + " codons in between the first start and stop codon.");
        stateOn = 7;
        nextLetter();
        break;
      case "T":
      case "C":
        stateOn = 3;
        codonsSeen++;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s6() {
    switch (dnaSeqArr[counter]) {
      case "A":
        updateRes("\nStop codon found after " + (counter - 2)
            + " nucleotides.\nValid DNA coding sequence can be transcribed until this point. The mRNA will not see anything else after this point, and thus the computer also will not have seen anything after this point.");
        updateRes("\nThe given dna gene has " + codonsSeen + " codons in between the first start and stop codon.");
        stateOn = 7;
        nextLetter();
        break;
      case "T":
      case "C":
      case "G":
        stateOn = 3;
        codonsSeen++;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s7() {
    switch (dnaSeqArr[counter]) {
      case "A":
      case "G":
      case "T":
      case "C":
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found after the stop codon.");
        runCheck = false;
    }
  }

  private void s8() {
    switch (dnaSeqArr[counter]) {
      case "A":
      case "G":
      case "T":
      case "C":
        stateOn = 9;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

  private void s9() {
    switch (dnaSeqArr[counter]) {
      case "A":
      case "G":
      case "T":
      case "C":
        stateOn = 3;
        codonsSeen++;
        nextLetter();
        break;
      default:
        updateRes("\nA letter that is not a valid base found.");
        runCheck = false;
    }
  }

}