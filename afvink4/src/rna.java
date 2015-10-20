public class rna extends nucleotiet {
    private String seq;
    private static int count = 0;

    private rna(String seq) {
        this.setNtseq(seq, "rna");
    }

    private void setRNA(String seq) {
        this.seq = seq;
    }

    private int getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        //rna rna1 = new rna("augatuggaugau"); //faulty
        rna rna1 = new rna("augauguaguagu"); //correct
        System.out.println(rna1.getNtseq());
    }
}
