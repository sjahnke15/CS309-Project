package test.connect.myapplication.model;

import java.util.List;

/**
 *@author Elijah Hanson
 *
 * Class for creating an object based on JSON object we recieve from the backend
 */
public class Trail {

    private int trailID;
    private List<Review> reviews;
    private String name;
    private int difficulty;

    /**
     * Default constructor for Trail object
     */
    public Trail() {
    }

    /**
     * Getter method for TrailID
     * @return trailID of object
     */
    public int getTrailID() {
        return trailID;
    }

    /**
     * Setter method for trailID
     * @param trailID
     */
    public void setTrailID(int trailID) {
        this.trailID = trailID;
    }

    /**
     * Getter method for trail reviews
     * @return list of reviews of trail object
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Setter method for trail reviews
     * @param reviews
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Getter method for trail name
     * @return name of object
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for trail name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for trail difficulty
     * @return difficulty of object
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Setter method for trail difficulty
     * @param difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
