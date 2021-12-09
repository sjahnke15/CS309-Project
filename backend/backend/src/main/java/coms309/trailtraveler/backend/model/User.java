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

/**  **/
@Entity
@Table(name = "user")
public class User {

	/**  **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	/**  **/
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk", referencedColumnName = "userID")
	List<Review> reviews = new ArrayList<>();
	
	/**  **/
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk1", referencedColumnName = "userID")
	List<Trail> completedTrails = new ArrayList<>();

	/**  **/
	private String email;
	
	/**  **/
	private String username;
	
	/**  **/
	private String password;
	
	/**  **/
	public User() {}
	
	/**  **/
	public int getId() {
		return userID;
	}
	
	/**  **/
	public void setId(int id) {
		this.userID = id;
	}
	
	/**  **/
	public String getEmail() {
		return email;
	}
	
	/**  **/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**  **/
	public String getUsername() {
		return username;
	}
	
	/**  **/
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**  **/
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**  **/
	public List<Review> getReviews() {
		return reviews;
	}
	
	/**  **/
	public void addReview(Review r) {
		reviews.add(r);
	}
	
	public void addCompletedTrail(Trail t) {
		completedTrails.add(t);
	}
}
