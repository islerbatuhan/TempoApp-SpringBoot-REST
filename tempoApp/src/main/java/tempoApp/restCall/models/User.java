package tempoApp.restCall.models;


import javax.persistence.*;

@Entity
@Table(name= "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "userID")
	private long userID;
	
	
	@Column(name= "Username")
	private String username;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "Weight")
	private double weight;
	
	//playlist one to many
	
	//song one to many
	
	//daily performance data one to one
	
	
	
	//end of attributes
	
	////////////////////////////////////
	
	//getters and setters
	
	public long getUserID() {
		return userID;
	}
	
	public void setUserID(long userID) {
		this.userID= userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username= username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight= weight;
	}
	
	//end of getters and setters
	
	/////////////////////////
	
	//other methods
	
	@Override
	public String toString() {
		//new toString method for using possible fail checks (validation) later
		//it will not print PASSWORD
		return String.format("UserID: "+ userID +"\nUsername: "+ username +"\nWeight: "+ weight);
	}
	
	
	
}
