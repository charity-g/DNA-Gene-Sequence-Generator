class Checker {
  //VAR
  String dnaSeq;
  String[] dnaSeqArr;

  // Main METHOD
  public void checkCodSeq(String in) {
    dnaSeq = in;

    dnaSeqArr = dnaSeq.split("");
    
  }

  for (int i=0; i<dnaSeqArr.length; i++) {
        System.out.println(dnaSeqArr[i]);
            
    }
    System.out.println("Done");
}