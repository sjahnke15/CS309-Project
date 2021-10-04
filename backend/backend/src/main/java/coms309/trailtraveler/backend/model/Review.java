package coms309.trailtraveler.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import coms309.trailtraveler.backend.model.Trail;

@Entity
@Table(name = "review")
public class Review {

	//Generate an ID for each review
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewID;
	
	@ManyToOne
	@JoinColumn(name = "trail_id")
	private Trail trail;
	
	private String text;
	private int rating;
	
	//Need a user foreign key.
	
	public Review() {
		
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
}
