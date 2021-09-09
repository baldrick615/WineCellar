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
}
