package test;

import java.util.ArrayList;

/**
 * Created by jacob on 14-9-8.
 */
public class AllOrder {


    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> source = new ArrayList<String>();
        String p = "生命诚可贵";
        for (int i = 0; i < 5; i++) {
            source.add(p.charAt(i) + "");
        }
        allRange(result, source, 0);
        System.out.println(result);

    }

    private static <T> void allRange(ArrayList<String> result, ArrayList<T> source, int start) {

        if (start == source.size() - 1) {
            result.add(source.toString());
        }

        for (int i = start; i < source.size(); i++) {
            swap(source, start, i);
            allRange(result, source, start + 1);
            swap(source, start, i);

        }

    }


    private static void allOrder(ArrayList<Integer> A, int start, int size, ArrayList<String> result, ArrayList<Integer> now) {
        if (now.size() == size) {
            result.add(now.toString());
            return;
        }

        for (int i = start; i < A.size(); i++) {
            now.add(A.get(i));
            allOrder(A, start + 1, size, result, now);
            now.remove(now.size() - 1);
        }


    }

    private static <T> void swap(ArrayList<T> A, int i, int j) {
        if (i == j) {
            return;
        }
        T temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

}
