package persistance.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classroomID;
	@Column(length=100)
	private String trainer;
	@OneToMany(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@Column(length=50)
	private List<Trainee> trainees;
	
	public Classroom() {
		
	}
	
	public Classroom(int classroomId, String trainer, List<Trainee> trainees) {
		this.classroomID = classroomId;
		this.trainer = trainer ; 
		this.trainees = trainees;
	}


	public int getClassroomID() {
		return this.classroomID;
	}
	
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}
	

	public String getTrainer() {
		return this.trainer;
	}
	
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	

	public List<Trainee> getTrainees() {
		return this.trainees;
	}
	
	public void setTrainees(List<Trainee>  traineesToAdd) {
		trainees.addAll(traineesToAdd);
	}
	
}
