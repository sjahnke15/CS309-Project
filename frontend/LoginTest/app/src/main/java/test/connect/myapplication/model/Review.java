package test.connect.myapplication.model;
/**
 *@author Elijah Hanson
 *
 * Class for creating an object based on JSON object we recieve from the backend
 */
public class Review {

    private int reviewID;
    private String text;
    private float rating;


    /**
     * Default constructor for Review object
     */
    public Review() {
    }

    /**
     * Getter method for ReviewID
     * @return the reviewID of the Review object
     */
    public int getReviewID() {
        return reviewID;
    }

    /**
     * Setter Method for ReviewID
     * @param reviewID
     */
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    /**
     * Getter method for review text
     * @return the text field of the Review object
     */
    public String getText() {
        return text;
    }

    /**
     * Setter Method for ReviewID
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter method for rating
     * @return the rating of the Review object
     */
    public float getRating() {
        return rating;
    }

    /**
     * Setter Method for ReviewID
     * @param rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Method to print out some useful information about a review in string format
     * @return Text and rating of a review concatenated together
     */
    public String printable(){
        return "\nText: " + this.text
                + "\nRating: "+ this.rating + "\n";
    }
}
