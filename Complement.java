class Complement {
  final String[] DNA_NUCLEOTIDES = { "A", "T", "C", "G" };

  public String seq;
  public String complementSeq;
  public String[] seqArr;
  public String[] complementSeqArr;
  public int length;

  Complement(String sequence) {
    this.seq = sequence;
    this.seqArr = sequence.split("");
    this.length = seqArr.length;
    this.complementSeqArr = new String[length];
  }

  // produces true if whole arr only has strings A, T, G or C, else false
  public boolean valid() {
    boolean valid = true;
    for (String s : this.seqArr) {
      if (!equals(s)) {
        valid = false;
      }
    }
    return valid;
  }

  // REQUIRES: seqArr to be a valid strand
  public void complementSeqDNA() {
    for (int i = 0; i < length; i++) {
      switch (seqArr[i]) {
        case "A":
          complementSeqArr[i] = "T";
          break;
        case "T":
          complementSeqArr[i] = "A";
          break;
        case "C":
          complementSeqArr[i] = "G";
          break;
        case "G":
          complementSeqArr[i] = "C";
          break;
        default:
          System.out.println(
              "You should not be seeing this right now. Please leave a comment and let me know how you got here. ERROR 1.");
      }
    }
    // temporary !!!
    for (String s : complementSeqArr) {
      System.out.println(s);
    }
  }

  /*
   * private void addToCompArr(String change) {
   * int compLength = complementSeq.length;
   * String[] temp = new String[complength];
   * for (int i = 0; i < compLength; i++) {
   * temp[i] = compLength[i];
   * }
   * temp[compLength - 1] = change;
   * complementSeq = temp;
   * }
   */

  // produces true if input matches A, T, G or C, else f
  private boolean equals(String base) {
    boolean equal = false;
    for (String s : DNA_NUCLEOTIDES) {
      if (s.equals(base)) {
        equal = true;
      }
    }
    return equal;
  }

}