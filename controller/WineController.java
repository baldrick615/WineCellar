package com.trm.winecellar.controller;

import java.math.BigDecimal;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
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
@Produces(MediaType.APPLICATION_JSON)
public class WineController {
	private WineService service = new WineService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWines() {
		return service.getWines();
	}
	
	@GET
	@Path("/id/{wineId}")
	public List<Wine> getWinesById(@PathParam("wineId") Integer id) {
		return service.getWinesById(id);
	}
	
	@GET
	@Path("/vintage/{vintage}")
	public List<Wine> getWinesByVintage(@PathParam("vintage") Integer vintage){
		return service.getWinesByVintage(vintage);
	}
	
	@GET
	@Path("/varietal/{varietal}")
	public List<Wine> getWinesByVarietal(@PathParam("varietal") Varietal varietal){
		return service.getWinesByVarietal(varietal);
	}
	
	@GET
	@Path("/region/{region}")
	public List<Wine> getWinesByRegion(@PathParam("region") Region region){
		return service.getWinesByRegion(region);
	}
	
	@GET
	@Path("/price/{purchasePrice}")
	public List<Wine> getWinesByPrice(@PathParam("purchasePrice") BigDecimal price){
		return service.getWinesByPrice(price);
	}
	
//	CREATE NEW WINE
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine createWine(Wine newWine) {
		return service.createWine(newWine);
	}
	
//	UPDATE WINE ENTRY
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine updateWine(Wine updateWine) {
		return service.updateWine(updateWine);
	}
	
//	DELETE EXISTING WINE
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public List<Wine> deleteWineById(@PathParam("id") Integer id){
		return service.deleteWineById(id);
	}
	
	@GET
	@Path("/report")
	public List<Wine> getReport(
			@QueryParam("startVintage") Integer startVintage,
			@QueryParam("endVintage") Integer endVintage){
		return service.getReport(startVintage, startVintage);
	}
	

}
