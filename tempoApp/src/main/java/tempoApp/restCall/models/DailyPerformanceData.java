package tempoApp.restCall.models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "DailyPerformanceData")
public class DailyPerformanceData {
	
	@Id
	@Column(name = "performanceDate")
	private LocalDate performanceDate;
	
	/*
	 * @ManyToOne
	 * @JoinColumn (name="user_ID")
	 * @JsonBackReference
	 * private User ownedBy;
	*/
	
	@Column(name = "distanceRun")
	private double distanceRun;
	
	
	@Column(name = "averagePace")
	private double averagePace;
	
	@Column(name= "caloriesBurnt")
	private double caloriesBurnt;
	
	@Column(name = "userID")
	private int userID;//one to one later
	
	//end of attributes
	
	///////////////////////////////////////////////
	
	//begin getters and setters//
	
	public LocalDate getPerformanceDate() {
		return performanceDate;
	}
	
	public void setPerformanceDate(LocalDate performanceDate) {
		this.performanceDate= performanceDate;
	}
	
	
	public double getDistanceRun() {
		return distanceRun;
	}
	
	public void setDistanceRun(double distanceRun) {
		this.distanceRun = distanceRun;
	}
	
	
	public double getAveragePace() {
		return averagePace;
	}
	
	public void setAveraPace(double averagePace) {
		this.averagePace= averagePace;
	}
	
	
	public double getCaloriesBurnt() {
		return caloriesBurnt;
	}
	
	public void setCaloriesBurn(double caloriesBurnt) {
		this.caloriesBurnt= caloriesBurnt;
	}
	
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID= userID;
	}
	
	//end of getters and setters
	
	///////////////////////////////////////////////////
	
	//other methods
	
	public LocalDate stringtoLocalDate(String nonDate) {
		//takes a string of YYYY-MM-DD format and return a LocalDate version of it
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		return LocalDate.parse(nonDate, formatter);
	}
	
	@Override
	public String toString() {
		//new toString method for using possible fail checks (validation) later
		return String.format("UserID: "+ userID +"\nperformanceDate: "+ performanceDate+
				"\ndistanceRun: "+distanceRun+"\naveragePace: "+averagePace);
	}
	
	
	
	
	
	
	

}
