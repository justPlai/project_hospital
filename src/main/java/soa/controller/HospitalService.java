package soa.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import soa.dao.HospitalDAO;
import soa.model.Doctor;
import soa.model.Hospital;

@Path("/services")
public class HospitalService {

	HospitalDAO hospitalDAO = new HospitalDAO();

	@GET
	@Path("/hospitals")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Hospital> getUsers() {

		return hospitalDAO.getAllHospital();
	}
	
	@GET
	@Path("/hospitals/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getDoctorById(@PathParam("param") int id) {
		return hospitalDAO.findByID(id);
	}

	@POST
	@Path("/hospitals/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createHospital(Hospital Hos) throws IOException {

		boolean i = hospitalDAO.addHospital(Hos);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(201).entity(" create fail").build();

	}
	
	@PUT
	@Path("/doctors")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateHospital(Hospital Hos) throws IOException {
		boolean i = hospitalDAO.update(Hos);
		if (i == true)
			return Response.status(201).entity(" edit successfully").build();
		else
			return Response.status(201).entity(" edit fail").build();
		
	}

}
