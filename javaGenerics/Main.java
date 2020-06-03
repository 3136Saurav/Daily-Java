package javaGenerics;

public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        HockeyPlayer mahesh = new HockeyPlayer("Mahesh");
        BaseballPlayer michael = new BaseballPlayer("Michael");

        Team<FootballPlayer> footballTeam = new Team("Adelaide Crows");
        footballTeam.addPlayer(joe);
//      adelaideCrows.addPlayer(mahesh);
//      adelaideCrows.addPlayer(michael);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        System.out.println(footballTeam.numPlayers());

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(melbourne, 5, 5);

        System.out.println("\nRankings");
        System.out.println(footballTeam.getName() + ": " + footballTeam.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());
    }
}
