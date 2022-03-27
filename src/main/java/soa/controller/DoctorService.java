package soa.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import soa.dao.DoctorDAO;
import soa.dao.HospitalDAO;
import soa.dao.MedicineDAO;
import soa.dao.SessionUtil;
import soa.model.Doctor;
import soa.model.Hospital;
import soa.model.Medicine;
import soa.response.DoctorResponse;
import soa.response.HospitalResponse;
import soa.responsebyid.DoctorIdResponse;
import soa.responsebyid.HospitalIdResponse;

@Path("/services")
public class DoctorService {

	DoctorDAO DoctorDao = new DoctorDAO();
	HospitalDAO hospitalDAO = new HospitalDAO();
	MedicineDAO MedDao = new MedicineDAO();
	
	@GET
	@Path("/doctors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws JsonGenerationException, JsonMappingException, IOException {

		// return DoctorDao.getAllDoctor();
		DoctorResponse responsePojo = new DoctorResponse();
		responsePojo.setMsg("ok");
		responsePojo.setStatus("200");
		// ObjectMapper a = new ObjectMapper();

		// String s = a.writeValueAsString(HosDao.getAllHospital());
		responsePojo.setResult(DoctorDao.getAllDoctor());

		return Response.status(200).entity(responsePojo).build();
	}
	
	@GET
	@Path("/doctors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorById(@PathParam("id") int id) {
		Doctor d = DoctorDao.findById(id);
		if(d==null)
		{
			return Response.status(401).entity(" Invalid Doctor id").build();
		}
		else
		{
			DoctorIdResponse responsePojo = new DoctorIdResponse();
			responsePojo.setStatus("200");
			responsePojo.setMsg("ok");
			responsePojo.setResult(DoctorDao.findById(id));
			return Response.status(200).entity(responsePojo).build();
		}
	}

	@POST
	@Path("/doctors")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDoctor(Doctor doc) throws IOException {
		Hospital h = hospitalDAO.findByID(doc.getHospital().getHospitalId());
		/*
		 * System.out.println(doc.getDoctorFirstname());
		 * System.out.println(doc.getHospital().getHospitalId()); HospitalDAO hostDAO =
		 * new HospitalDAO(); Hospital h =
		 * hostDAO.findByID(doc.getHospital().getHospitalId()) ;
		 * 
		 * Doctor d = new Doctor() ;
		 * 
		 * d.setDoctorFirstname(doc.getDoctorFirstname()) ;
		 * d.setDoctorLastname(doc.getDoctorLastname()) ;
		 * d.setDoctorPhonenumber(doc.getDoctorPhonenumber());
		 * //d.setMedecinedetails(doc.getMedecinedetails())
		 * 
		 * h.getDoctors().add(d);
		 * 
		 * Session ss = SessionUtil.getSession() ; ss.saveOrUpdate(h); ss.close();
		 */
		if (doc.getDoctorFirstname() == null) {
			return Response.status(400).entity(" please provide Firstname").build();
		} else if (doc.getDoctorLastname() == null) {
			return Response.status(400).entity(" please provide Lastname").build();
		} else if (doc.getDoctorPhonenumber() == null) {
			return Response.status(400).entity(" please provide Phonenumber").build();
		} else if (doc.getHospital() == null) {
			return Response.status(400).entity(" please provide Hospital").build();
		}else if(h==null) {
			return Response.status(401).entity(" Invalid Hospital id").build();
		}
		else {
			boolean i = DoctorDao.addDoctor(doc);
			if (i == true)
				return Response.status(201).entity(" create successfully").build();
			else
				return Response.status(201).entity(" create fail").build();
		}
	}

	@PUT
	@Path("/doctors")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDoctor(Doctor Doctor) throws JsonGenerationException, JsonMappingException, IOException {
		Doctor D = DoctorDao.findById(Doctor.getDoctorId());
		if(D==null)
		{
			return Response.status(401).entity(" Invalid Doctor id").build();
		}
		Hospital h = hospitalDAO.findByID(Doctor.getHospital().getHospitalId());
		if(h==null)
		{
			return Response.status(401).entity(" Invalid Hospital id").build();
		}
		boolean i = DoctorDao.updateDoctor(Doctor);
		if (i == true)
			return Response.status(200).entity(" update successfully").build();
		else
			return Response.status(201).entity(" update fail").build();

	}

	@DELETE
	@Path("/doctors/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDoctor(@PathParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		Doctor D = DoctorDao.findById(id);
		if(D==null)
		{
			return Response.status(401).entity(" Invalid Doctor id").build();
		}
		boolean i = DoctorDao.deleteById(id);
		if (i == true)
			return Response.status(200).entity(" delete successfully").build();
		else
			return Response.status(201).entity(" delete fail").build();

	}

}
