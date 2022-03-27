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

import soa.dao.HospitalDAO;
import soa.dao.MedicineDAO;
import soa.model.Doctor;
import soa.model.Hospital;
import soa.model.Medicine;
import soa.model.Medicinedetail;
import soa.response.MedicineResponse;
import soa.responsebyid.MedicineIdResponse;
import soa.responsebyid.MedicinedetailIdResponse;

@Path("/services")

public class MedicineService {

	MedicineDAO MedDao = new MedicineDAO();

	@GET
	@Path("/medicines")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws JsonGenerationException, JsonMappingException, IOException {
		MedicineResponse responsePojo = new MedicineResponse();
		responsePojo.setStatus("200");
		responsePojo.setMsg("ok");

		responsePojo.setResult(MedDao.getAllMedicine());
		return Response.status(200).entity(responsePojo).build();
	}

	@GET
	@Path("/medicines/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineById(@PathParam("id") int id) {
		Medicine M = MedDao.findById(id);
		if (M == null) {
			return Response.status(401).entity(" Invalid Medicine id").build();
		} else {
			MedicineIdResponse responsePojo = new MedicineIdResponse();
			responsePojo.setStatus("200");
			responsePojo.setMsg("ok");
			responsePojo.setResult(MedDao.findById(id));
			return Response.status(200).entity(responsePojo).build();
		}
	}

	@POST
	@Path("/medicines")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMedicine(Medicine Med) throws IOException {

		if (Med.getMedicineDescription() == null) {
			return Response.status(400).entity(" please provide Description").build();
		} else if (Med.getMedicineEnglish() == null) {
			return Response.status(400).entity(" please provide medicine name in English").build();
		} else if (Med.getMedicineThai() == null) {
			return Response.status(400).entity(" please provide medicine name in Thai").build();
		} else if (Med.getMedicinePrice() == null) {
			return Response.status(400).entity(" please provide Price").build();
		}
		boolean i = MedDao.addMedicine(Med);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(400).entity(" create fail").build();

	}

	@PUT
	@Path("/medicines")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMedicine(Medicine medicine)
			throws JsonGenerationException, JsonMappingException, IOException {
		Medicine M = MedDao.findById(medicine.getMedicineId());
		if (M == null) {
			return Response.status(401).entity(" Invalid Medicine id").build();
		} else {
			if(medicine.getMedicinePrice() == null) {
				medicine.setMedicinePrice(M.getMedicinePrice());
			}
			if(medicine.getMedicineDescription() == null) {
				medicine.setMedicineDescription(M.getMedicineDescription());
			}
			boolean i = MedDao.updateMedicine(medicine);
			if (i == true)
				return Response.status(200).entity(" update successfully").build();
			else
				return Response.status(400).entity(" update fail").build();
		}

	}

	@DELETE
	@Path("/medicines/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMedicine(@PathParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		Medicine M = MedDao.findById(id);
		if (M == null) {
			return Response.status(401).entity(" Invalid Medicine id").build();
		} else {
			boolean i = MedDao.deleteById(id);
			if (i == true)
				return Response.status(200).entity(" delete successfully").build();
			else
				return Response.status(400).entity(" delete fail").build();
		}

	}
}