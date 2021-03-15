public class QuickSort {

    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        quickSort(array,0,array.length);
        for (int value:array){
            System.out.println(value);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];

        while (start < end) {
            while (start < end && array[--end] >= pivot) ;
            if (array[end] <= pivot) {
                array[start] = array[end];
            }
            while ((start < end) && array[++start] <= pivot) ;
            if (array[start] >= pivot) {
                array[end] = array[start];
            }
        }
        array[end] = pivot;
        return end;
    }
}
