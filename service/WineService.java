package com.trm.winecellar.service;

import java.util.List;

import com.trm.winecellar.dao.WineDAOImpl;
import com.trm.winecellar.dao.WineDao;
import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.RequestError;
import com.trm.winecellar.model.Wine;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class WineService {
	
	private WineDao wineDao = new WineDAOImpl();
	
	public List<Wine> getWines() {
		return wineDao.getWines();
	}
	
	public List<Wine> getWinesByRegion(Region region){
		return wineDao.getWinesByRegion(region);
	}
	
	public List<Wine> getWinesByVintage(Integer vintage){
		validateVintage(vintage);
		return wineDao.getWinesByVintage(vintage);
	}
		
	public List<Wine> getWinesById(Integer wineId){
		validateWineId(wineId);
		return wineDao.getWinesById(wineId);
	}
	
//	Validation logic
	
	private void validateVintage(Integer vintage) {
		if (vintage < 1950 || vintage > 2030) {
			RequestError error = new RequestError(1, "Invalid year entered.");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
		
	}
	
	private void validateWineId(Integer wineId) {
		if (wineId < 1) {
			RequestError error = new RequestError(2, "wineId must be > 1.");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}
	
	public Wine createWine(Wine newWine) {
//		validateVintage(newWine.getVintage());
		return wineDao.createWine(newWine);
	}

	public Wine deleteWine(Integer id) {
		validateWineId(id);
		return wineDao.deleteWine(id);
		}
	
	public Wine updateWine(Wine updateWine) {
		validateVintage(updateWine.getVintage());
		validateWineId(updateWine.getId());
		return wineDao.updateWine(updateWine);
	}

	public List<Wine> getReport(Integer startVintage, Integer endVintage) {
		validateReportQueryValues(startVintage, endVintage);
		return wineDao.report(startVintage, endVintage);
		
	}

	private void validateReportQueryValues(Integer startVintage, Integer endVintage) {
		if(startVintage < 1950 || startVintage > 2030) {
			makeError(3, "Invalid value for beginning year: " + startVintage);
		}
		if(endVintage < 1950 || endVintage > 2030) {
			makeError(4, "Invalid ending vintage year: " + endVintage);
		}
		if(startVintage > endVintage) {
			makeError(5, "The starting year must be less than the ending year. ");
		}
		
	}
	
	private void makeError(int errorNumber, String errorMessage) {
		RequestError error = new RequestError(errorNumber, errorMessage);
		Response response = Response.status(400)
				.entity(error)
				.build();
		throw new WebApplicationException(response);
	}
	
	public List<Wine> getWinesByQuantity(Integer quantity){
		return wineDao.getWinesByQuantity(quantity);
	}

}
