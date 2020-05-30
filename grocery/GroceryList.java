package grocery;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public ArrayList<String> getGroceryList(){
        return groceryList;
    }

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        for(int i=0; i<groceryList.size(); i++){
            System.out.println((i+1) + " : " + groceryList.get(i));
        }
    }

    public void modifyGroceryList(String currItem, String itemName){
        int position = findGroceryItem(currItem);
        if(position >= 0)
            modifyGroceryList(position, itemName);
    }

    private void modifyGroceryList(int position, String item){
        groceryList.set(position, item);
        System.out.println("Grocery List Updated!");
    }

    public void deleteGroceryItem(String itemName){
        int position = findGroceryItem(itemName);
        if(position >= 0)
            deleteGroceryItem(position);
    }

    private void deleteGroceryItem(int position){
        groceryList.remove(position);
    }

    private int findGroceryItem(String itemName){
        return groceryList.indexOf(itemName);
    }

    public boolean onFile(String searchItem){
        int position = findGroceryItem(searchItem);
        if(position >= 0)
            return true;
        return false;
    }
}
