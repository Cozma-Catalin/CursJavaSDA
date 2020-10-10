public class Main {

    public static void main(String[] args) {
      /*  LinkedList linkedList = new LinkedList();
        linkedList.addNode("Capra cu 3 iezi.");
        linkedList.addNode("Luceafarul.");
        linkedList.addNode(9);
        linkedList.display();
        linkedList.deleteNode();
        linkedList.display();

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(10);
        doubleLinkedList.addNode("O fata ");
        doubleLinkedList.display();
        doubleLinkedList.deleteNode();
        doubleLinkedList.display();
*/

        int[][] numbers = new int[3][3];
        numbers[0][0] = 1;
        numbers[0][1] = 2;
        numbers[0][2] = 3;
        numbers[1][0] = 4;
        numbers[1][1] = 5;
        numbers[1][2] = 6;
        numbers[2][0] = 7;
        numbers[2][1] = 8;
        numbers[2][2] = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >=0; j--) {
                System.out.print(numbers[i][j] + "   ");
            }
            System.out.println();
        }

        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        System.out.println(dynamicArray.getSize());
        dynamicArray.add(156);
        System.out.println(dynamicArray.getSize());
        dynamicArray.add(215);
        System.out.println(dynamicArray.getSize());
    }
}
