package com.trm.winecellar.controller;

import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;
import com.trm.winecellar.service.WineService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/wines")
@Produces(MediaType.APPLICATION_JSON)
public class WineController {
	private WineService service = new WineService();
	
	@GET
	public List<Wine> getWines() {
		
		return service.getWines();
	}
	
	@GET
	@Path("/vintage/{vintageValue}")
	public List<Wine> getWinesByVintage(@PathParam("vintageValue") Integer vintage){
		return service.getWines();
	}
	
	@GET
	@Path("/varietal/{varietalValue}")
	public List<Wine> getWinesByVarietal(@PathParam("varietalValue") Varietal varietal){
		return service.getWinesByVarietal(varietal);
	}
	

}
