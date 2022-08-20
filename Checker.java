class Checker {
  //CONSTANTS
  String passCheck = "\nCongrats! Your input DNA coding strand was correct!";
  String failcheck = "\nThat was not an input DNA coding strand.";
  
  //VAR
  private String dnaSeq;
  public String[] dnaSeqArr;
  public String result; // holds the current result

 
  //OBJ
  CheckerStates callStates = new CheckerStates();

  // Main METHOD
  public void Check(String in) {
    result = "";
    dnaSeq = in;
    dnaSeqArr = dnaSeq.split("");
    String result = callStates.state0(0);
    System.out.println(result);
  }

}

/*
  for (int i=0; i<dnaSeqArr.length; i++) {
        System.out.println(dnaSeqArr[i]);
            
    }
    System.out.println("Done");
*/