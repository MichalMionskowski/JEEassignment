package persistance.repository;

import persistance.domain.Classroom;

public interface ClassroomRepository {
	public Classroom findClassroom(int classroomID);
	
	public String createClassroom(Classroom newClassroom);
	
	public boolean updateClassroom(Classroom updateClassroom, int classroomIdToChange);
	
	public boolean deleteClassroom(int classroomID);

	public String getAllClassrooms();

	public String getAllTrainees(int classroomID);
}