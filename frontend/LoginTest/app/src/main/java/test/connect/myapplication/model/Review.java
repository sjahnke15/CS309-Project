package test.connect.myapplication.model;

public class Review {

    private int reviewID;
    private String text;
    private float rating;

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


    public String printable(){
        return "\nText: " + this.text
                + "\nRating: "+ this.rating + "\n";
    }
}
