import java.util.Arrays;

public class Quicksort {
    //average time complexity nlogn
    //worst time complexity n^2 if the array is sorted in a dir and we are using it to sort in the opposite dir


    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;


        return i + 1;
    }

    static int partition2(int[] arr, int l, int r) {
        int pivot = arr[r];
        int pos = l;

        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                if (i != pos) {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                }
                pos++;
            }
        }

        // final pivot placement
        int temp = arr[pos];
        arr[pos] = arr[r];
        arr[r] = temp;

        return pos;
    }


    static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition2(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    public static void main(String[] args) {
//        int[] arr ={6,2,5,1,4,2,3};
//        int[] arr={3, 1, 2, 8, 9, 10, 2, 6};
        int[] arr = {1,2,3,4,6,7,8,9,10};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
