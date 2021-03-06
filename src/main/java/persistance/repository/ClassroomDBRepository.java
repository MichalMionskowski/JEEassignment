package persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import persistance.domain.Classroom;
import util.JSONUtil;
@Default
@Transactional(SUPPORTS)
@RequestScoped
public class ClassroomDBRepository implements ClassroomRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil JSONUtil;
	
	public Classroom findClassroom(int classroomID) {
		TypedQuery<Classroom> query = em.createQuery("SELECT c FROM Classroom c WHERE c.classroomID='" + classroomID + "'", Classroom.class);
		return query.getSingleResult();
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(Classroom newClassroom) {
		em.persist(newClassroom);
		return JSONUtil.getJSONForObject(em.find(Classroom.class,newClassroom.getClassroomID()));
	
	}
	@Transactional(REQUIRED)
	public boolean updateClassroom(Classroom updateClassroom, int classroomIdToChange) {
		Classroom oldClassroom = em.find(Classroom.class, classroomIdToChange);
		oldClassroom.setTrainer((updateClassroom.getTrainer()));
		oldClassroom.setTrainees(updateClassroom.getTrainees());
		em.merge(oldClassroom);
		return em.find(Classroom.class,oldClassroom.getClassroomID())!= null ? true : false;
	
	}
	@Transactional(REQUIRED)
	public boolean deleteClassroom(int classroomID) {
		Classroom toDelete = em.find(Classroom.class, classroomID);
		em.remove(toDelete);
		return true;
	}
	
	public String getAllClassrooms() {
		TypedQuery<Classroom> query = em.createQuery("SELECT c FROM Classroom c", Classroom.class);
		return JSONUtil.getJSONForObject(query.getResultList());
	
	}

	public String getAllTrainees(int classroomID) {
		TypedQuery<Classroom> query = em.createQuery("SELECT c.trainees FROM Classroom c WHERE c.classroomID='" + classroomID + "'", Classroom.class);
		return JSONUtil.getJSONForObject(query.getResultList());
	}

}
