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

import soa.dao.MedicinedetailDAO;
import soa.model.Medicinedetail;

import soa.model.Medicine;



	@Path("/services")
	public class MedicinedetailService { 
		
		MedicinedetailDAO MedCDao = new MedicinedetailDAO();  
	   @GET 
	   @Path("/Medicinedetails") 
	   @Produces(MediaType.APPLICATION_JSON) 

	   public List<Medicinedetail> getUsers(){ 
		
	      return MedCDao.getAllMedicinedetail();
	      }  
	   	
	   	@POST
		@Path("/Medicinedetails")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addMedicinedetail(Medicinedetail MedcDao) throws IOException {
	   		
	   		if(MedcDao.getDoctor()==null)
	   		{
	   			return Response.status(401).entity(" please provide Doctor").build();
	   		}
	   		else if(MedcDao.getMedicine()==null)
	   		{
	   			return Response.status(401).entity(" please provide Medicine").build();
	   		}
	   		else if(MedcDao.getMedicineTotalPrice()==null)
	   		{
	   			return Response.status(401).entity(" please provide TotalPrice").build();
	   		}
	   		else if(MedcDao.getMedicineAmount()==0)
	   		{
	   			return Response.status(401).entity(" please provide Amount").build();
	   		}
	   		else {
			boolean i = MedCDao.addMedicinedetail(MedcDao);
			if (i == true)
				return Response.status(201).entity(" create successfully").build();
			else
				return Response.status(201).entity(" create fail").build();
	   		}
			
		}
		@PUT
		@Path("/Medicinedetails")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateMedicinedetail(Medicinedetail MedcDao) throws  JsonGenerationException, 
		JsonMappingException, IOException 
		 {	
		   		
				boolean i = MedCDao.updateMedicinedetail(MedcDao);
				if (i == true)
					return Response.status(201).entity(" update successfully").build();
				else
					return Response.status(201).entity(" update fail").build();
				
			}
		   	
		   
		   	@DELETE
			@Path("/Medicinedetails/{id}")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response deleteMedicinedetail(@PathParam("id") int id) throws  JsonGenerationException, 
			JsonMappingException, IOException 
		   	{	
		   		
				boolean i = MedCDao.DeleteByID(id);
				if (i == true)
					return Response.status(201).entity(" delete successfully").build();
				else
					return Response.status(201).entity(" delete fail").build();
				
			}

}
