package business.service;

import persistance.domain.Classroom;

public interface ClassroomService {
	
	public Classroom findClassroom(int classroomID);
	
	public String createClassroom(String newClassroom);
	
	public boolean updateClassroom(String updateClassroom, int classroomIdToChange);
	
	public boolean deleteClassroom(int classroomID);

	public String getAllClassrooms();

	public String getAllTrainees(int classroomID);
	
}
