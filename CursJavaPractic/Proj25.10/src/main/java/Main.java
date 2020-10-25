public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

       try {
           menu.display();
       }catch (NoSuchInputException e){
           System.out.println(e.getMessage());
       }
    }
}
