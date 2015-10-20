public class dna extends nucleotiet {

    private String seq;
    private static int count = 0;

    private dna(String seq) {
        setDNA(seq);
        count++;
    }

    private void setDNA(String seq) {
        this.seq = seq;
    }

    private int getCount() {
        return this.count;
    }
}
