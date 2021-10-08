package com.trm.winecellar.dao;

import java.util.ArrayList;
import java.util.List;

import com.trm.winecellar.model.Region;
import com.trm.winecellar.model.Varietal;
import com.trm.winecellar.model.Wine;

public class WineDaoMock implements WineDao {
	
	private static Integer lastWineId = 5;
	
	private static List<Wine> wines = new ArrayList<Wine>();
	
	static {
		Wine lafite = new Wine();
		lafite.setId(1);
		lafite.setName("Chateau Lafite");
		lafite.setQuantity(6);
		lafite.setRegion(Region.fr);
		lafite.setVarietal(Varietal.cabernetSauvignon);
		lafite.setVintage(1999);
		
		Wine eagle = new Wine();
		eagle.setId(2);
		eagle.setName("Screaming Eagle");
		eagle.setQuantity(3);
		eagle.setRegion(Region.ca);
		eagle.setVarietal(Varietal.cabernetSauvignon);
		eagle.setVintage(2016);
		
		Wine franciscan = new Wine();
		franciscan.setId(3);
		franciscan.setName("Franciscan");
		franciscan.setQuantity(12);
		franciscan.setRegion(Region.ca);
		franciscan.setVarietal(Varietal.cabernetSauvignon);
		franciscan.setVintage(1999);
		
		Wine michelle = new Wine();
		michelle.setId(4);
		michelle.setName("Chateau Ste Michelle");
		michelle.setQuantity(1);
		michelle.setRegion(Region.wa);
		michelle.setVarietal(Varietal.chardonnay);
		michelle.setVintage(2016);
		
		wines.add(eagle);
		wines.add(lafite);
		wines.add(franciscan);
		wines.add(michelle);
	}

	@Override
	public List<Wine> getWines() {
		List<Wine> myWines = new ArrayList<Wine>();
		myWines.addAll(wines);
		return myWines;
	}

	@Override
	public List<Wine> getWinesByRegion(Region region) {
		List<Wine> myWines = new ArrayList<Wine>();
		for (Wine wine : WineDaoMock.wines) {
			if(wine.getRegion().equals(region)) {
				myWines.add(wine);
			}
		}
		
		return myWines;
	}

	@Override
	public List<Wine> getWinesByVintage(Integer vintage) {
		List<Wine> myWines = new ArrayList<Wine>();
		for (Wine wine : WineDaoMock.wines) {
			if (wine.getVintage().intValue() == vintage.intValue()) {
				myWines.add(wine);
			}
		}
		return myWines;
	}

	@Override
	public List<Wine> getWinesById(Integer wineId) {
		List<Wine> myWines = new ArrayList<Wine>();
		for (Wine wine : WineDaoMock.wines) {
			if(wine.getId().intValue() == wineId.intValue()) {
				myWines.add(wine);
			}
		}
		return myWines;
	}

	@Override
	public Wine createWine(Wine newWine) {
		newWine.setId(getNextWineNumber());
		wines.add(newWine);
		return newWine;
	}

	private Integer getNextWineNumber() {
		return ++lastWineId;
	}
	
	@Override
	public Wine deleteWine(Integer wineId) {
		List<Wine> myWines = getWinesById(wineId);
		Wine wineToDelete = null;
		for(Wine wine : WineDaoMock.wines) {
			if(wine.getId().intValue() == wineId.intValue()) {
				wineToDelete = wine;
			}
		}
		if (wineToDelete != null) {
			myWines.add(wineToDelete);
			WineDaoMock.wines.remove(wineToDelete);
		}
		return wineToDelete;
	}

	@Override
	public Wine updateWine(Wine updateWine) {
		for (Wine wine : WineDaoMock.wines) {
			if(wine.getId().intValue() == updateWine.getId().intValue()) {
				wine.setName(updateWine.getName());
				wine.setQuantity(updateWine.getQuantity());
				wine.setRegion(updateWine.getRegion());
				wine.setVarietal(updateWine.getVarietal());
				wine.setVintage(updateWine.getVintage());
			}
		}
		return updateWine;
	}

	@Override
	public List<Wine> report(Integer startVintage, Integer endVintage) {
		List<Wine> myWines = new ArrayList<Wine>();
		for (Wine wine : wines) {
			if(wine.getVintage() >= startVintage) {
				if(wine.getVintage() <= endVintage) {
					myWines.add(wine);
				}
			}
		}
		return myWines;
	}

	@Override
	public List<Wine> getWinesByQuantity(Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
