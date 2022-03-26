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

import org.hibernate.Session;

import soa.dao.DoctorDAO;
import soa.dao.HospitalDAO;
import soa.dao.SessionUtil;
import soa.model.Doctor;
import soa.model.Hospital;

@Path("/services")
public class DoctorService {

	DoctorDAO doctorDAO = new DoctorDAO();
	HospitalDAO hospitalDAO = new HospitalDAO();

	@GET
	@Path("/doctors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getUsers() {

		return doctorDAO.getAllDoctor();
	}

	@POST
	@Path("/doctors")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDoctor(Doctor doc) throws IOException {

		
//		 System.out.println(doc.getDoctorFirstname());
//		 System.out.println(doc.getHospital().getHospitalId());
//		doc.setHospital(hospitalDAO.findByID(doc.getHospital().getHospitalId()));
//		 
//		 Hospital h = hospitalDAO.findByID(doc.getHospital().getHospitalId()) ;
//		 Doctor d = new Doctor();
//		 d.setDoctorFirstname(doc.getDoctorFirstname()) ;
//		 d.setDoctorLastname(doc.getDoctorLastname()) ;
//		 d.setDoctorPhonenumber(doc.getDoctorPhonenumber());
//		 d.setMedicinedetails(doc.getMedicinedetails());
//		 
//		 h.getDoctors().add(doc);
//		 
//		 
//		 Session ss = SessionUtil.getSession() ; ss.saveOrUpdate(h); ss.close();
		

		boolean i = doctorDAO.addDoctor(doc);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(201).entity(" create fail").build();

	}

	@PUT
	@Path("/doctors")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDoctor(Doctor doc) throws IOException {
		boolean i = doctorDAO.update(doc);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(201).entity(" create fail").build();
		
	}

}
