package javaLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class JavaLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        addInOrder(list,"India");
        addInOrder(list, "France");
        addInOrder(list, "Turkey");
        addInOrder(list, "Japan");
        addInOrder(list, "China");
        addInOrder(list, "Korea");
        addInOrder(list, "Britain");
        addInOrder(list, "New Zealand");
        addInOrder(list, "Australia");

        printList(list);

        visit(list);
    }

    private static void printList(LinkedList<String> list){
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            System.out.println("Now Visiting.... " + i.next());
        }
        System.out.println("===================================================");
    }

    private static boolean addInOrder(LinkedList<String> list , String newCountry){
        ListIterator<String> stringListIterator = list.listIterator();

        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCountry);
            if(comparison == 0){
                System.out.println("Already in the list!");
                return false;
            }
            else if(comparison > 0){
                // newCountry should appear after this one
                stringListIterator.previous();
                stringListIterator.add(newCountry);
                return true;
            }
            else if(comparison < 0){
                // move on to next city
            }

        }
        stringListIterator.add(newCountry);
        return true;
    }

    public static void visit(LinkedList cities){
        Scanner sc = new Scanner(System.in);
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No Cities in the itenerary");
            return;
        }
        else{
            System.out.println("Now visiting.... " + listIterator.next());
            printMenu();
        }
        boolean quit = false;
        boolean goingForward = false;

        while(!quit){
            System.out.println("Enter action: ");
            int actions = sc.nextInt();
            switch (actions){
                case 0:
                    quit = true;
                    break;

                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Visiting " + listIterator.next() + "!");
                    }
                    else{
                        System.out.println("We reached the end of the journey!");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("We are visiting " + listIterator.previous() + "!");
                    } else {
                        System.out.println("We are at the start of the list!");
                    }

                    break;

                case 3:
                    printMenu();
                    break;
            }
        }

    }

    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0- to quit\n" +
                           "1- go to next country\n"+
                           "2- go to previous country\n" +
                           "3- to print menu actions");
    }
}
