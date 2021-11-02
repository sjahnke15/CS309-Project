package test.connect.myapplication.model;

import java.util.List;

public class Trail {

    private int trailID;
    private List<Review> reviews;
    private String name;
    private int difficulty;

    public Trail() {
    }

    public int getTrailID() {
        return trailID;
    }

    public void setTrailID(int trailID) {
        this.trailID = trailID;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
