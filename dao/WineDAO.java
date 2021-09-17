package com.trm.winecellar.dao;


import java.math.BigDecimal;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public interface WineDAO {
	public List<Wine> getWines();
	public List<Wine> getWinesByVintage(Integer vintage);
	public List<Wine> getWinesByRegion(Region region);
	public List<Wine> getWinesByVarietal(Varietal varietal);
	public List<Wine> getWinesByPrice(BigDecimal price);
	public Wine createWine(Wine newWine);
	public Wine updateWine(Wine updateWine);
	public List<Wine> deleteWineById(Integer id);
	List<Wine> report(Integer startVintage, Integer endVintage);
	public List<Wine> getWinesById(Integer id);
}
