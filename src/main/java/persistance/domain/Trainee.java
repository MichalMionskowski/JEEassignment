package persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	public Trainee() {
		
	}
	
	public Trainee(int traineeID, String traineeName) {
		this.traineeID = traineeID;
		this.traineeName = traineeName;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeID;
	public int getTraineeId() {
		return this.traineeID;
	}
	public void setTraineeId(int traineeID) {
		this.traineeID = traineeID;
	}
	
	@Column(length=100)
	private String traineeName;
	public String getTraineeName() {
		return this.traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
}
