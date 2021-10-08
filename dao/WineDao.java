package com.trm.winecellar.dao;

import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Wine;

public interface WineDao {
	
	public List<Wine> getWines();
	public List<Wine> getWinesByRegion(Region region);
	public List<Wine> getWinesByVintage(Integer vintage);
	public List<Wine> getWinesById(Integer id);
	public List<Wine> report(Integer startVintage, Integer endVintage);
	public Wine createWine(Wine newWine);
	public Wine updateWine(Wine updateWine);
	public Wine deleteWine(Integer id);
	public List<Wine> getWinesByQuantity(Integer quantity);
	
	

}
