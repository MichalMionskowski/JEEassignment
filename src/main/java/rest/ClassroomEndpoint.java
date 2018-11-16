package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.service.ClassroomService;
import util.JSONUtil;

@Path("/classroom")
public class ClassroomEndpoint { 	
	
	@Inject
	private  ClassroomService service;
	@Inject
	JSONUtil JSONUtil;
	
	@Path("/operation/{id}")
	@GET
	@Produces({ "application/json" })
	public String findClassroom(@PathParam("id") int id) {
		return JSONUtil.getJSONForObject(service.findClassroom(id));
	}
	
	@Path("/operations")
	@GET
	public String getClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/operation")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/operation/{id}")
	@PUT
	@Produces({ "application/json" })
	public boolean updateClassroom(@PathParam("id") int id,String classroom) {
		return service.updateClassroom(classroom,id);
	}
	
	@Path("/operation/{id}")
	@DELETE
	@Produces({ "application/json" })
	public boolean deleteClassroom(@PathParam("id") int id) {
		return service.deleteClassroom(id);
	}
	
}
