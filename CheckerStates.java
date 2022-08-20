class CheckerStates{
  private int codonsSeen = 0;
  private String tempResult;

  //State 0, not seen any indication of a start codon
  public void state0(int counter){
    switch (dnaSeqArr[counter]) {
        case "":
          tempResult = tempResult + "\nNo start codon found.";
          break;
        case "A":
          state1(counter++);
          break;
        case "T":
        case "C":
        case "G":
          state0(counter++);
          break;
      default:
        tempResult = tempResult + "\nError found before start codon.";
    }
  }
  
  public void state1(int counter){
    switch (dnaSeqArr[counter]) {
      case "":
          tempResult = tempResult + "\nNo start codon found.";
          break;
      case "A":
          state1(counter++);
          break;
      case "T":
          state2(counter++);
          break;
      case "G":
      case "C":;
          state0(counter++);
          break;
      default:
        tempResult = tempResult + "\nError found before start codon.";
    }
  }

  public void state2(int counter){
    switch (dnaSeqArr[counter]) {
      case "":
          tempResult = tempResult + "\nNo start codon found.";
          break;
      case "G":
          tempResult = tempResult + "\nStart codon found.";
          state3(counter++);
          break;
      case "A":
          state1(counter++);
          break;
      case "T":
      case "C":
          state0(counter++);
          break;
      default:
        tempResult = tempResult + "\nError found before start codon.";
    }
  }

  //seen start Codon
  public void state3(int counter) {
    switch (dnaSeqArr[counter]) {
      case "":
          tempResult = tempResult + "\nNo stop codon found.";
          break;
      case "T":
          state4(counter++);
          break;
      case "G":
      case "C":
      case "A":
          state8(counter++);
          break;
      default:
        tempResult = tempResult + "\nError found before stop codon.";
    }
  }

  public void state4(int counter) {
    switch (dnaSeqArr[counter]) {
      case "":
          tempResult = tempResult + "\nNo stop codon found.";
          break;
      case "A":
          state5(counter++);
          break;
      case "G":
          state6(counter++);
          break;
      case "T":
      case "C":
          state9(counter++);
          break;
      default:
        tempResult = tempResult + "\nError found before stop codon.";
    }
  }

  public void state5(int counter) {
//place holder to be deleted!!!    
  }

  public void state6(int counter) {
//place holder to be deleted!!!    
  }
  public void state7(int counter) {
//place holder to be deleted!!!    
  }
  public void state8(int counter) {
//place holder to be deleted!!!    
  }
  public void state9(int counter) {
//place holder to be deleted!!!    
  }
  
}