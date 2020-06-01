package javaLinkedListChallenge;

import java.util.*;

public class Main {
    private static ArrayList<Albums> albums = new ArrayList<>();

    public static void main(String[] args) {

        Albums album = new Albums("My World", "Justin Bieber");
        album.addSong("Baby", 3.36);
        album.addSong("One time", 3.26);
        album.addSong("Come around me", 2.56);
        album.addSong("Sorry", 3.46);
        album.addSong("Love Yourself", 2.99);
        album.addSong("One less lonely girl", 3.21);
        album.addSong("Under the mistletoe", 3.05);
        albums.add(album);

        Albums album1 = new Albums("Recovery", "Eminem");
        album1.addSong("SpaceBound", 3.60);
        album1.addSong("Call me a doctor", 3.16);
        album1.addSong("Superman", 3.56);
        album1.addSong("Legacy", 3.96);
        album1.addSong("Not Afraid", 2.47);
        album1.addSong("Best Friend", 3.51);
        album1.addSong("Rap God", 2.65);
        albums.add(album1);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(1).addToPlaylist("Not Afraid", playList);
        albums.get(0).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist("All I want for Christmas", playList);
        albums.get(0).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist("Rap God", playList);
        albums.get(0).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist("Legacy", playList);
        albums.get(0).addToPlaylist(82, playList);

        play(playList);

    }

    public static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean forward = true;
        boolean quit = false;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in playlist!");
            return;
        }
        else{
            System.out.println("Now playing: " + listIterator.next().toString());
        }

        while (!quit){
            System.out.println("Enter Action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Okk lets quit!");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext())
                            listIterator.next();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing: " + listIterator.next().toString());
                    }
                    else{
                        System.out.println("We have reached end of the playlist!");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing: " + listIterator.previous().toString());
                    } else{
                        System.out.println("We are at the starting of the playlist!");
                        forward = true;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else{
                            System.out.println("We are at the starting of the list!");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            forward = true;
                        } else{
                            System.out.println("We are the end of the list!");
                        }
                    }

                    break;

                case 4:
                    printListSongs(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing: " + listIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Actions\nPress:");
        System.out.println("0- quit\n" +
                           "1- play next song\n" +
                           "2- play previous song\n" +
                           "3- replay the current song\n" +
                           "4- print list of songs in the playlist\n" +
                           "5- print available actions\n" +
                           "6- delete current song");

    }

    private static void printListSongs(LinkedList<Song> playLList) {
        Iterator<Song> iterator = playLList.iterator();
        System.out.println("==========================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==========================================");
    }
}
