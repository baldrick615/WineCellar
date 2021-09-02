package com.trm.winecellar.service;

import java.util.List;

import com.trm.winecellar.dao.WineDAO;
import com.trm.winecellar.dao.WineDAOMock;
import com.trm.winecellar.model.Wine;

public class WineService {
	private WineDAO wineDAO = new WineDAOMock();
	
	public List<Wine> getWines(){
		return wineDAO.getWines();
	}
	
	public List<Wine> getWinesByVintage(Integer vintage){
		return wineDAO.getWinesByVintage(vintage);
	}

}
