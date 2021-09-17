package com.trm.winecellar.service;

import java.math.BigDecimal;
import java.util.List;

import com.trm.winecellar.dao.WineCellarImpl;
import com.trm.winecellar.dao.WineDAO;
import com.trm.winecellar.dao.WineDAOMock;
import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.RequestError;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class WineService {
	private WineDAO wineDAO = new WineCellarImpl();
	
	public List<Wine> getWines(){
		return wineDAO.getWines();
	}
	
	public List<Wine> getWinesByVintage(Integer vintage){
		validateVintageYear(vintage);
		return wineDAO.getWinesByVintage(vintage);
	}
	
	private void validateVintageYear(Integer vintage) {
		if (vintage < 1950 || vintage > 2035) {
			RequestError err = new RequestError(1, "The vintage is outside normal range (1950 - 2035). Please check your input.");
			Response response = Response.status(400)
					.entity(err)
					.build();
			throw new WebApplicationException(response);
		}
		
	}
	
	private void priceCheck(BigDecimal price) {
		BigDecimal low = new BigDecimal("2");
		BigDecimal high = new BigDecimal("500");
		
		if (price.compareTo(low) < 1 || price.compareTo(high) > -1) {
			RequestError priceCheck = new RequestError(2, "The value entered is too high or too low.");
			Response response = Response.status(400)
				.entity(priceCheck)
				.build();
			throw new WebApplicationException(response);
		}
	}

	public List<Wine> getWinesByVarietal(Varietal varietal){
		return wineDAO.getWinesByVarietal(varietal);
	}

	public List<Wine> getWinesByRegion(Region region) {
		return wineDAO.getWinesByRegion(region);
	}

	public List<Wine> getWinesByPrice(BigDecimal price) {
		priceCheck(price);
		return wineDAO.getWinesByPrice(price);
	}

//	CREATE new bottle
	public Wine createWine(Wine newWine) {
		priceCheck(newWine.getPrice());
		validateVintageYear(newWine.getVintage());
		return wineDAO.createWine(newWine);
	}

//	Update wine entry
	public Wine updateWine(Wine updateWine) {
		validateVintageYear(updateWine.getVintage());
		priceCheck(updateWine.getPrice());
		return wineDAO.updateWine(updateWine);
	}
	
//	DELETE wine from collection
	public List<Wine> deleteWineById(Integer id) {
		return wineDAO.deleteWineById(id);
	}
	
	public List<Wine> getReport(Integer startVintage, Integer endVintage){
		return wineDAO.report(startVintage, endVintage);
	}

	public List<Wine> getWinesById(Integer id) {
		return wineDAO.getWinesById(id);
	}

}
