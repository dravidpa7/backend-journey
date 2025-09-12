import java.util.*;

class DynamicArrayExample{
    private int arr[];
    private int size;
    private int capacity;
    private static final int initialCapacity = 16; // constant need to be final

    DynamicArrayExample(){
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(int val){
        if(size==capacity){
            // System.out.println("Array is Full"); but now we are implementing dynamic so we need 
            expandArray();
        }
        
        arr[size++] = val;
        // size++;
    }
    private void expandArray(){
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr,capacity);

    }
    
    public void display(){
        System.out.println("Elements in the print statement");
        for(int i:arr){
            System.out.print(i + " ");
            System.out.println();
        }
    }

}


public class DynamicArray{
    public static void main(String[] args){
        int val,pos;
        DynamicArrayExample list= new DynamicArrayExample();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1.Insert at End");
            System.out.println("2.Display");
            System.out.println("3.Insert specific position");
            System.out.println("4.Delete Specific postion");
            System.out.println("5.Exit");
            System.out.println("Enter Your choice :");

            int choice = scanner.nextInt(); 

            switch(choice){
                case 1: System.out.println("Enter the data");
                        val = scanner.nextInt();
                        list.add(val);
                        break;

                case 2: list.display();
                        break;
                case 3: System.out.println("Enter the pos(Start at 0)");
                        pos = scanner.nextInt();
                        if(pos<0){
                            System.out.println("Invalid Postion");
                            break;
                        }
                        System.out.println("Enter the data");
                        val = scanner.nextInt();
                        // list.insertAtPos(pos,val);
                        break;
                case 4: System.out.println("Enter the pos(Start at 0)");
                        pos = scanner.nextInt();
                        if(pos<0){
                            System.out.println("Invalid Postion");
                            break;
                        }
                        // list.deleteAtPos(pos);
                        break;
                case 5: System.exit(0);

                default: System.out.println("Invalid position");




            }
        }
    }
}