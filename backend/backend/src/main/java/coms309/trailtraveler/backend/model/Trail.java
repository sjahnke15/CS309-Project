package coms309.trailtraveler.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "trail")
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trailID;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "trail_fk", referencedColumnName = "trailID")
	List<Review> reviews  = new ArrayList<>();
	
	private String name;
	private int difficulty;
	
	/* Constructor */
	public Trail() {}
	
	public int getId() {
		return trailID;
	}
	
	public void setId(int id) {
		this.trailID = id;
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

	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review r) {
		reviews.add(r);
	}
}
