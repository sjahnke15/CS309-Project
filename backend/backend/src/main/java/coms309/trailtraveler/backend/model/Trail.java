package coms309.trailtraveler.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "trail_id")
	private int id;
	
	@OneToMany(mappedBy = "trail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Review> reviews  = new HashSet<>();
	
	private String name;
	private int difficulty;
	
	/* Constructor */
	public Trail() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public Set<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review r) {
		reviews.add(r);
	}
}
