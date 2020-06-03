package javaGenerics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            System.out.println(player.getName() + " already in the team!");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " added to the team!");
            return true;
        }
    }

    public int numPlayers(){
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message = "";
        if(ourScore > theirScore){
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, ourScore, theirScore);
        }
    }

    public int ranking(){
        return 2 * won + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking())
            return -1;
        else if(this.ranking() < this.ranking())
            return 1;
        else
            return 0;
    }
}
