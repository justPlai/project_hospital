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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import soa.dao.DoctorDAO;
import soa.dao.MedicineDAO;
import soa.dao.MedicinedetailDAO;
import soa.model.Medicinedetail;
import soa.response.MedicinedetailResponse;
import soa.responsebyid.HospitalIdResponse;
import soa.responsebyid.MedicinedetailIdResponse;
import soa.model.Doctor;
import soa.model.Hospital;
import soa.model.Medicine;

@Path("/services")
public class MedicinedetailService {

	MedicinedetailDAO MedCDao = new MedicinedetailDAO();
	DoctorDAO DoctorDao = new DoctorDAO();
	MedicineDAO MedDao = new MedicineDAO();

	@GET
	@Path("/medicinedetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws JsonGenerationException, JsonMappingException, IOException {

		MedicinedetailResponse responsePojo = new MedicinedetailResponse();
		responsePojo.setStatus("200");
		responsePojo.setMsg("ok");

		responsePojo.setResult(MedCDao.getAllMedicinedetail());
		return Response.status(200).entity(responsePojo).build();
		// return MedCDao.getAllMedicinedetail();
	}

	@GET
	@Path("/medicinedetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicinedetailById(@PathParam("id") int id) {
		Medicinedetail M = MedCDao.findById(id);
		if (M == null) {
			return Response.status(401).entity(" Invalid Medicinedetail id").build();
		} else {
			MedicinedetailIdResponse responsePojo = new MedicinedetailIdResponse();
			responsePojo.setStatus("200");
			responsePojo.setMsg("ok");
			responsePojo.setResult(MedCDao.findById(id));
			return Response.status(200).entity(responsePojo).build();
		}
	}

	@POST
	@Path("/medicinedetails")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMedicinedetail(Medicinedetail MedcDao) throws IOException {
		Doctor d = DoctorDao.findById(MedcDao.getDoctor().getDoctorId());
		Medicine Med = MedDao.findById(MedcDao.getMedicine().getMedicineId());

		if (MedcDao.getDoctor() == null) {
			return Response.status(400).entity(" please provide Doctor").build();
		} else if (MedcDao.getMedicine() == null) {
			return Response.status(400).entity(" please provide Medicine").build();
		} else if (MedcDao.getMedicineTotalPrice() == null) {
			return Response.status(400).entity(" please provide TotalPrice").build();
		} else if (MedcDao.getMedicineAmount() == 0) {
			return Response.status(400).entity(" please provide Amount").build();
		} else if (d == null) {
			return Response.status(401).entity(" Invalid doctor id").build();
		} else if (Med == null) {
			return Response.status(401).entity(" Invalid Medicine id").build();
		} else {
			boolean i = MedCDao.addMedicinedetail(MedcDao);
			if (i == true)
				return Response.status(201).entity(" create successfully").build();
			else
				return Response.status(201).entity(" create fail").build();
		}

	}

	@PUT
	@Path("/medicinedetails")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMedicinedetail(Medicinedetail medicineDetail)
			throws JsonGenerationException, JsonMappingException, IOException {
		Medicinedetail medc = MedCDao.findById(medicineDetail.getMedicineDetailId());
		if (medc == null) {
			return Response.status(401).entity("Invalid Medicinedetails id").build();
		}
		Doctor d = DoctorDao.findById(medicineDetail.getDoctor().getDoctorId());
		if (d == null) {
			return Response.status(401).entity("Invalid doctor id").build();
		}
		Medicine Med = MedDao.findById(medicineDetail.getMedicine().getMedicineId());
		if (Med == null) {
			return Response.status(401).entity("Invalid Medicine id").build();
		}
		if (medicineDetail.getMedicineAmount() == 0) {
			medicineDetail.setMedicineAmount(medc.getMedicineAmount());
		}
		if (medicineDetail.getMedicineTotalPrice() == null) {
			medicineDetail.setMedicineTotalPrice(medc.getMedicineTotalPrice());
		}
		boolean i = MedCDao.updateMedicinedetail(medicineDetail);
		if (i == true)
			return Response.status(200).entity(" update successfully").build();
		else
			return Response.status(201).entity(" update fail").build();

	}

	@DELETE
	@Path("/medicinedetails/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMedicinedetail(@PathParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		Medicinedetail Med = MedCDao.findById(id);
		if (Med == null) {
			return Response.status(401).entity(" Invalid Medicinedetails id").build();
		}
		boolean i = MedCDao.deleteById(id);
		if (i == true)
			return Response.status(200).entity(" delete successfully").build();
		else
			return Response.status(201).entity(" delete fail").build();

	}

}
