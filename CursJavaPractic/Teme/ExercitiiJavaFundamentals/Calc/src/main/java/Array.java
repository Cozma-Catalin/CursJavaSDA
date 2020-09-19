public class Array {

    public int lungimeArray(int[] array){
    return array.length;
    }
    public int numereMaiMari(int[] array){
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]>5){
                count++;
            }
        }
        return count;
    }
}
