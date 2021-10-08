package com.trm.winecellar.controller;

import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Wine;
import com.trm.winecellar.service.WineService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/wines")
public class WineController {
	
	private WineService service = new WineService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWines() {
		return service.getWines();		
	}
	
	@GET
	@Path("/region/{regionValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWinesByRegion(@PathParam("regionValue") Region region){
		return service.getWinesByRegion(region);
	}
	
	@GET
	@Path("/vintage/{vintageValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWinesByVintage(@PathParam("vintageValue") Integer vintage){
		return service.getWinesByVintage(vintage);
	}
	
	
	@GET
	@Path("/{wineId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWineById(@PathParam("wineId") Integer wineId) {
		return service.getWinesById(wineId);		
	}
	
	@GET
	@Path("/archive/{quantity}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWinesByQuantity(@PathParam("quantity") Integer quantity) {
		return service.getWinesByQuantity(0);		
	}
	
		
//	Create new Wine
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine createWine(Wine newWine) {
		return service.createWine(newWine);
	}
	
//	Delete existing wine
	@DELETE
	@Path("/{wineId}")
	public Wine deleteWine(@PathParam("wineId") Integer wineId){
		return service.deleteWine(wineId);
	}
	
//	Update existing wine entry
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine updateWine(Wine updateWine) {
		return service.updateWine(updateWine);
	}
	
	@GET
	@Path("/report")
	public List<Wine> getReport(
			@QueryParam("startVintage") Integer startVintage,
			@QueryParam("endVintage") Integer endVintage){
		return service.getReport(startVintage, endVintage);
	}
	
		

}
