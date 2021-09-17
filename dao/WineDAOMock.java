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
	private static Integer lastWineId = 0;
	
	static {
		Wine stags = new Wine();
		stags.setName("Stags Leap");
		stags.setDescription("Artemis. Rated 91 points by Wine Spectator.");
		stags.setId(1);
		stags.setPrice(new BigDecimal(69.99));
		stags.setPurchaseDate(LocalDate.parse("2021-03-19"));
		stags.setQuantity(1);
		stags.setRegion(Region.ca);
		stags.setVarietal(Varietal.rose);
		stags.setVintage(2018);
		
		Wine franciscan = new Wine();
		franciscan.setName("Franciscan");
		franciscan.setDescription("Buttery and deliious");
		franciscan.setId(2);
		franciscan.setPrice(new BigDecimal(22.00));
		franciscan.setPurchaseDate(LocalDate.parse("2021-08-19"));
		franciscan.setQuantity(5);
		franciscan.setRegion(Region.ca);
		franciscan.setVarietal(Varietal.chardonnay);
		franciscan.setVintage(2017);
		
		Wine csMichelle = new Wine();
		csMichelle.setName("Chateau Ste Michelle");
		csMichelle.setDescription("full bodied and dry.");
		csMichelle.setId(3);
		csMichelle.setPrice(new BigDecimal(32.99));
		csMichelle.setPurchaseDate(LocalDate.parse("2020-05-10"));
		csMichelle.setQuantity(1);
		csMichelle.setRegion(Region.usOther);
		csMichelle.setVarietal(Varietal.cabernetSauvignon);
		csMichelle.setVintage(2018);
		
		Wine antinori = new Wine();
		antinori.setName("Antinori Tignanello");
		antinori.setDescription("Tignanello 2018 is a deeply intense ruby red color. On the nose, it’s remarkably complex with notes of ripe red fruit, black cherries, sour cherries that merge with sweet hints of vanilla, mint anddelicate sensations of white pepper and myrtle. Its palate is rich and well balanced: supple velvety tannins are sustained by exceptional freshness that give the wine length, elegance and persistence of flavors.");
		antinori.setId(4);
		antinori.setPrice(new BigDecimal(130));
		antinori.setPurchaseDate(LocalDate.parse("2021-05-11"));
		antinori.setQuantity(3);
		antinori.setRegion(Region.italy);
		antinori.setVarietal(Varietal.redBlend);
		antinori.setVintage(2018);
		
		wines.add(stags);
		wines.add(franciscan);
		wines.add(csMichelle);
		wines.add(antinori);
		
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
		List<Wine> wines = new ArrayList<Wine>();
		for (Wine wine : WineDAOMock.wines) {
			if (wine.getVintage() == vintage.intValue()) {
				wines.add(wine);
			}
		}
		return wines;
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

	@Override
	public List<Wine> getWinesByPrice(BigDecimal price) {
		List<Wine> bottles = new ArrayList<Wine>();
		for (Wine bottle : WineDAOMock.wines) {
			if(bottle.getPrice().equals(price)) {
				bottles.add(bottle);
			}
		}
		return bottles;
	}

//	Create New Wine Entry
	@Override
	public Wine createWine(Wine newWine) {
		newWine.setId(getNextWineId());
		wines.add(newWine);
		return newWine;
	}

//	Generate new Wine ID number
	private int getNextWineId() {
		return ++lastWineId;
	}

	@Override
	public Wine updateWine(Wine updateWine) {
		for (Wine wine : WineDAOMock.wines) {
			if(wine.getId().intValue() == updateWine.getId().intValue()) {
				wine.setDescription(updateWine.getDescription());
				wine.setName(updateWine.getName());
				wine.setPrice(updateWine.getPrice());
				wine.setPurchaseDate(updateWine.getPurchaseDate());
				wine.setQuantity(updateWine.getQuantity().intValue());
				wine.setVarietal(updateWine.getVarietal());
				wine.setRegion(updateWine.getRegion());
				wine.setVintage(updateWine.getVintage().intValue());
			}
		}
		return updateWine;
	}

	@Override
	public List<Wine> deleteWineById(Integer id) {
		List<Wine> bottles = new ArrayList<Wine>();
		Wine wineToRemove = null;
		for(Wine wine : WineDAOMock.wines) {
			if(wine.getId().intValue() == id.intValue()) {
				wineToRemove = wine;
			}
		}
		if (wineToRemove != null) {
			bottles.add(wineToRemove);
			WineDAOMock.wines.remove(wineToRemove);
		}
		return bottles;
	}
	
	@Override
	public List<Wine> report(Integer startVintage, Integer endVintage){
		List<Wine> wineList = new ArrayList<Wine>();
		for (Wine wine : wines) {
			if(wine.getVintage() >= startVintage) {
				if(wine.getVintage() <= endVintage) {
					wineList.add(wine);
				}
			}
		}
		return wineList;
	}

	@Override
	public List<Wine> getWinesById(Integer id) {
		List<Wine> bottles = new ArrayList<Wine>();
		for (Wine bottle : WineDAOMock.wines) {
			if(bottle.getId().intValue() == id.intValue()) {
				bottles.add(bottle);
			}
		}
		return bottles;
	}
	
	

}
