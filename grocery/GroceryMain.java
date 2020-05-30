package grocery;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryMain {
    private static Scanner sc = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while(!quit){
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 0: printInstructions();
                        break;
                case 1: addItem();
                        break;
                case 2: groceryList.printGroceryList();
                        break;
                case 3: modifyItem();
                        break;
                case 4: searchItem();
                        break;
                case 5: removeItem();
                        break;
                case 6: quit = true;
                        break;
            }
        }
    }

    public  static  void printInstructions(){
        System.out.println("Press");
        System.out.println("\t0: Print Instructions");
        System.out.println("\t1: Add Item");
        System.out.println("\t2: Print List");
        System.out.println("\t3: Modify List");
        System.out.println("\t4: Search Item in a list");
        System.out.println("\t5: Remove Item");
        System.out.println("\t6: Quit");
    }

    public static void addItem(){
        System.out.println("Please Enter the item name: ");
        groceryList.addGroceryItem(sc.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Enter the Item Name to be modified: ");
        String oldItem = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the New Item: ");
        String newItem = sc.nextLine();
        groceryList.modifyGroceryList(oldItem, newItem);
    }

    public static void searchItem(){
        System.out.println("Enter the item name to be searched for: ");
        String searchedItem = sc.nextLine();
        if(groceryList.onFile(searchedItem)){
            System.out.println("Found " + searchedItem + " in our GroceryList");
        }
        else{
            System.out.println("Item not found!");
        }
    }

    public static void removeItem(){
        System.out.println("Enter the Item Name to be deleted: ");
        String itemName = sc.nextLine();
        groceryList.deleteGroceryItem(itemName);
    }

    public static void processArrayList(){
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(groceryList.getGroceryList());

        ArrayList<String> nextList = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
