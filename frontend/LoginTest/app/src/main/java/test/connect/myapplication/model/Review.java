package test.connect.myapplication.model;

public class Review {

    private int reviewID;
    private String text;
    private int rating;

    public Review() {
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String printable(){
        return "\nReviewID: " + this.reviewID
                + "\nText: " + this.text
                + "\nRating: "+ this.rating;
    }
}
