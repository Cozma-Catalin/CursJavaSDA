public class BooleanOps {

    public static void main(String[] args) {
    System.out.println(boolToWord(true));
}
    public static String boolToWord(boolean b)
    {
        if(b){
            return "Yes";
        }
        return "No";
    }

}