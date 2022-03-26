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

import soa.dao.MedicinedetailDAO;
import soa.model.Medicinedetail;

@Path("/services")
public class MedicinedetailService {

	MedicinedetailDAO MedCDao = new MedicinedetailDAO();

	@GET
	@Path("/medicinedetails")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Medicinedetail> getUsers() {

		return MedCDao.getAllMedicinedetail();
	}

	@POST
	@Path("/medicinedetails/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMedicinedetail(Medicinedetail MedcDao) throws IOException {

		boolean i = MedCDao.addMedicinedetail(MedcDao);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(201).entity(" create fail").build();

	}

}
