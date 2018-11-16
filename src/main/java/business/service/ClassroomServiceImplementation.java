package business.service;

import javax.inject.Inject;

import persistance.domain.Classroom;
import persistance.repository.ClassroomRepository;
import util.JSONUtil;

public class ClassroomServiceImplementation implements ClassroomService{

	
	@Inject
	private ClassroomRepository repo;
	@Inject
	JSONUtil JSONUtil;
	
	public Classroom findClassroom(int classroomID) {
		return repo.findClassroom(classroomID);
	}

	public String createClassroom(String jsonString) {
		Classroom newClassroom = JSONUtil.getObjectForJSON(jsonString, Classroom.class);
		if(repo.findClassroom(newClassroom.getClassroomID())!=null) {
			return  repo.createClassroom(newClassroom)  ;	
		}else {
			return "{\"message\":\"This classroom already exists\"}" ;
		}
	}

	public boolean updateClassroom(String updateClassroom, int classroomIdToChange) {
		return repo.updateClassroom(JSONUtil.getObjectForJSON(updateClassroom, Classroom.class), classroomIdToChange);
	}

	public boolean deleteClassroom(int classroomID) {
		return repo.deleteClassroom(classroomID);
	}

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String getAllTrainees(int classroomID) {
		return repo.getAllTrainees(classroomID);
	}

}
