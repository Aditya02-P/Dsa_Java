import java.util.ArrayList;
import java.util.Comparator;

public class Subset {
    static void subSeq(int[] arr, int index, ArrayList<Integer> list, ArrayList<Integer> temp) {

        if (index == arr.length) {
            int sum =0;
            for(int e: temp) {
                sum+=e;
            }
            list.add(sum); // copy
            return;
        }

        // don't select
        subSeq(arr, index + 1, list, temp);

        // select
        temp.add(arr[index]);
        subSeq(arr, index + 1, list, temp);

        // backtrack
        temp.removeLast();
    }

    static void subSeq2(int[] arr, int index, ArrayList<Integer> list, int temp) {
        if (index == arr.length) {
            list.add(temp);
            return;
        }
        subSeq2(arr, index + 1, list, temp);

        subSeq2(arr, index + 1, list,temp+arr[index]);
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        subSeq(arr, 0, list, new ArrayList<>());
        subSeq2(arr,0,list2,0);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        System.out.println(list2);
    }
}
