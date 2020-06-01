package javaLinkedListChallenge;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public String toString(){
        return "Title: " + this.title + " Duration: " + this.duration;
    }

}
