public class nucleotiet {


    protected String ntseq;


    public String getNtseq() {
        return ntseq;
    }

    public void setNtseq(String ntseq, String type) {
        if (type.toLowerCase() == "rna") {
            for (char ch : ntseq.toLowerCase().toCharArray()) {
                if (ch != 'a' && ch != 'u' && ch != 'c' && ch != 'g') {
                    System.out.println("sequence does not comply to requirements, it might not be RNA");
                } else {
                    this.ntseq = ntseq;
                }
            }
        } else if (type.toLowerCase() == "dna") {
            for (char ch : ntseq.toLowerCase().toCharArray()) {
                if (ch != 'a' && ch != 't' && ch != 'c' && ch != 'g') {
                    System.out.println("sequence does not comply to requirements, it might not be DNA");
                } else {
                    this.ntseq = ntseq;
                }
            }
        } else {
            System.out.println("Cannot determine whether the sequence is DNA or RNA");
        }
    }
}
