package com.trm.winecellar.dao;

import java.awt.Color;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trm.winecellar.model.Colors;
import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public class WineDAOMock implements WineDAO {
	
	private static List<Wine> wines = new ArrayList<Wine>();
	
	static {
		Wine stags = new Wine();
		stags.setName("Stags Leap");
		stags.setColor(Colors.red);
		stags.setDescription("Artemis. Rated 91 points by Wine Spectator.");
		stags.setId(4);
		stags.setPrice(new BigDecimal(69.99));
		stags.setPurchaseDate(LocalDate.parse("2021-03-19"));
		stags.setQuantity(1);
		stags.setRegion(Region.ca);
		stags.setVarietal(Varietal.cabernetSauvignon);
		stags.setVintage(2018);
		
		wines.add(stags);
	}
	
	public List<Wine> getWines(){
		List<Wine> wineCollection = new ArrayList<Wine>();
		wineCollection.addAll(wines);
		return wineCollection;
	}
	
	public List<Wine> getAllRedWines(){
		List<Wine> redWines = new ArrayList<Wine>();
		for(Wine red : WineDAOMock.wines) {
			if(red.getColor().equals(red)) {
				redWines.add(red);
			}
		}
		return redWines;
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
	public List<Wine> getWinesByColor(Color color) {
		List<Wine> bottles = new ArrayList<Wine>();
		for (Wine bottle : WineDAOMock.wines) {
			if (bottle.getColor().equals(color)) {
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
