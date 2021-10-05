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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trail")
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "trail_id")
	private int id;
	
	private String name;
	private int difficulty;
	
//	//Creates a hashset that will hold all of the reviews for the given Trail
//	@OneToMany(mappedBy = "trail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<Review> reviews = new HashSet<>(); 
	
	/* Constructor */
	public Trail() {
		
	}
	
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
}
