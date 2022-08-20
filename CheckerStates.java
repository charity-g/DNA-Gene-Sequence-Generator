class CheckerStates {
  private boolean runCheck = false;
  public String[] dnaSeqArr;
  public String result;
  public int length;
  private int codonsSeen = 0;
  public int counter;
  public int stateOn;

  public void nextLetter(){
    counter++;
  }
  public void updateRes(String update){
    result = result + update;
  }

  
  // MAIN
  public void initialize(String seq){
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

  public void callStates(int state) {
    switch (state){
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
          updateRes("\n Somehow your sequence is off, leading to it going into a state not found. I don't what you did to get this error.");
        }
  }


  //STATES
  public void s0() {
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

  public void s1() {
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

  public void s2(){
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
  
  public void s3(){
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
  
  public void s4(){
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
  
  public void s5(){
    switch (dnaSeqArr[counter]) {
      case "A":
      case "G":
        updateRes("\nStop codon found after " + (counter-2) + " nucleotides.\nValid DNA coding sequence can be transcribed until this point. The mRNA will not see anything else after this point, and thus the computer also will not have seen anything after this point.");
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
  
  public void s6(){
    switch (dnaSeqArr[counter]) {
      case "A":
        updateRes("\nStop codon found after " + (counter-2) + " nucleotides.\nValid DNA coding sequence can be transcribed until this point. The mRNA will not see anything else after this point, and thus the computer also will not have seen anything after this point.");
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
  
  public void s7(){
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
  
  public void s8(){
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
  
  public void s9(){
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