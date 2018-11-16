package persistance.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import persistance.domain.Classroom;
@Default
@Transactional(SUPPORTS)
@RequestScoped
public class ClassroomDBRepository implements ClassroomRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public Classroom findClassroom(int classroomID) {
		// TODO Auto-generated method stub
		return null;
	}

	public String createClassroom(Classroom newClassroom) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateClassroom(Classroom updateClassroom, int classroomIdToChange) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteClassroom(int classroomID) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllTrainees(int classroomID) {
		// TODO Auto-generated method stub
		return null;
	}

}
