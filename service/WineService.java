package com.trm.winecellar.service;

import java.util.List;

import com.trm.winecellar.dao.WineCellarImpl;
import com.trm.winecellar.dao.WineDAO;
import com.trm.winecellar.dao.WineDAOMock;
import com.trm.winecellar.model.RequestError;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class WineService {
	private WineDAO wineDAO = new WineDAOMock();
	
	public List<Wine> getWines(){
		return wineDAO.getWines();
	}
	
	public List<Wine> getWinesByVintage(Integer vintage){
		validateVintageYear(vintage);
		return wineDAO.getWinesByVintage(vintage);
	}
	
	private void validateVintageYear(Integer vintage) {
		if (vintage < 1950 || vintage > 2035) {
			RequestError err = new RequestError(1, "The vintage is outside nnormal range (1950 - 2035). Please check your input.");
			Response response = Response.status(400)
					.entity(err)
					.build();
			throw new WebApplicationException(response);
		}
		
	}

	public List<Wine> getWinesByVarietal(Varietal varietal){
		return wineDAO.getWinesByVarietal(varietal);
	}

}
