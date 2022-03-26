package soa.controller;


import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import soa.dao.HospitalDAO;
import soa.dao.MedicineDAO;
import soa.model.Hospital;
import soa.model.Medicine;

@Path("/services")
public class MedicineService { 
	
	MedicineDAO MedDao = new MedicineDAO();  
   @GET 
   @Path("/medicines") 
   @Produces(MediaType.APPLICATION_JSON) 

   public List<Medicine> getUsers(){ 
	
      return MedDao.getAllMedicine();
      }  
   	
   	@POST
	@Path("/medicines/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMedicine(Medicine Med) throws IOException {

		boolean i = MedDao.addMedicine(Med);
		if (i == true)
			return Response.status(201).entity(" create successfully").build();
		else
			return Response.status(201).entity(" create fail").build();
		
	}
}