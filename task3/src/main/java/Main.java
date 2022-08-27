import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer[]> sequences = new ArrayList<>();
        Integer[] seq1 = new Integer[2];
        Integer[] seq2 = new Integer[2];
        Integer[] seq3 = new Integer[2];
        seq1[0] = 0;
        seq1[1] = 5;
        seq2[0] = 0;
        seq2[1] = 1;
        seq3[0] = 1;
        seq3[1] = 4;
        sequences.add(seq1);
        sequences.add(seq2);
        sequences.add(seq3);
        Shelf shelves = new Shelf("cttatc");

        System.out.println(shelves.getCountOperations(sequences.get(0)));
        System.out.println(shelves.getCountOperations(sequences.get(1)));
        System.out.println(shelves.getCountOperations(sequences.get(2)));


    }
}
