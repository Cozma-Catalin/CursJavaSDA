public class Quick {
    public static void main(String[] args) {

        int arr[] = {20, 4, 15, -22, 50, -5};
        quick(arr, 0, arr.length);
        for (int i : arr) {
            System.out.println(i);
        }

    }


    public static void quick(int[] arr, int start, int end) {
        if (end - start < 2) return;

        int pivot = partition(arr, start, end);

        quick(arr, start, pivot);
        quick(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] >= pivot) ;
            if (i < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] <= pivot) ;
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;

    }
}
