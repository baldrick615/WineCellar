package com.trm.winecellar.dao;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public class WineDAOMock implements WineDAO {
	
	private static List<Wine> wines = new ArrayList<Wine>();
	
	static {
		Wine stags = new Wine();
		stags.setName("Stags Leap");
		stags.setDescription("Artemis. Rated 91 points by Wine Spectator.");
		stags.setId(4);
		stags.setPrice(new BigDecimal(69.99));
		stags.setPurchaseDate(LocalDate.parse("2021-03-19"));
		stags.setQuantity(1);
		stags.setRegion(Region.ca);
		stags.setVarietal(Varietal.rose);
		stags.setVintage(2018);
		
		Wine franciscan = new Wine();
		franciscan.setName("Franciscan");
		franciscan.setDescription("Buttery and deliious");
		franciscan.setId(5);
		franciscan.setPrice(new BigDecimal(22.00));
		franciscan.setPurchaseDate(LocalDate.parse("2021-08-19"));
		franciscan.setQuantity(5);
		franciscan.setRegion(Region.ca);
		franciscan.setVarietal(Varietal.chardonnay);
		franciscan.setVintage(2017);
		
		Wine csMichelle = new Wine();
		csMichelle.setName("Chateau Ste Michelle");
		csMichelle.setDescription("full bodied and dry.");
		csMichelle.setId(4);
		csMichelle.setPrice(new BigDecimal(32.99));
		csMichelle.setPurchaseDate(LocalDate.parse("2020-05-10"));
		csMichelle.setQuantity(1);
		csMichelle.setRegion(Region.usOther);
		csMichelle.setVarietal(Varietal.cabernetSauvignon);
		csMichelle.setVintage(2018);
		
		wines.add(stags);
		wines.add(franciscan);
		wines.add(csMichelle);
		
	}
	
	public List<Wine> getWines(){
		List<Wine> wineCollection = new ArrayList<Wine>();
		wineCollection.addAll(wines);
		return wineCollection;
	}
		
	public List<Wine> getWinesByRegion(Region region){
		List<Wine> bottles = new ArrayList<Wine>();
		for(Wine bottle : WineDAOMock.wines) {
			if(bottle.getRegion().equals(region)) {
				bottles.add(bottle);
			}
		}
		return bottles;
	}

	@Override
	public List<Wine> getWinesByVintage(Integer vintage) {
		List<Wine> bottles = new ArrayList<Wine>();
		for (Wine bottle : WineDAOMock.wines) {
			if (bottle.getVintage() == vintage.intValue()) {
				bottles.add(bottle);
			}
		}
		return bottles;
	}

	@Override
	public List<Wine> getWinesByVarietal(Varietal varietal) {
		List<Wine> bottles = new ArrayList<Wine>();
		for (Wine bottle : WineDAOMock.wines) {
			if(bottle.getVarietal().equals(varietal)) {
				bottles.add(bottle);
			}
		}
		return bottles;
	}

	

}
