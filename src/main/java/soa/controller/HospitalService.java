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
import soa.model.Hospital;



	@Path("/services")
	public class HospitalService { 
		
	   HospitalDAO HosDao = new HospitalDAO();  
	   @GET 
	   @Path("/hospitals") 
	   @Produces(MediaType.APPLICATION_JSON) 

	   public List<Hospital> getUsers(){ 
		
	      return HosDao.getAllHospital();
	      }  
	   	
	   	@POST
		@Path("/hospitals/create")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createHospital(Hospital Hos) throws IOException {

			boolean i = HosDao.addHospital(Hos);
			if (i == true)
				return Response.status(201).entity(" create successfully").build();
			else
				return Response.status(201).entity(" create fail").build();
			
		}
	   	
}
