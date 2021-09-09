package com.trm.winecellar.model;

public enum Varietal {
	cabernetSauvignon, redBlend, pinotNoir, sangiovese, shiraz, zinfandel, rhoneBlends, chardonnay, sauvignonBlanc, otherWhite, rose, port, dessert, sparklingWine;

	public static Varietal convertStringtoVarietal(String value) {
		Varietal myVarietal = null;
		for (Varietal type : Varietal.values()) {
			if (type.toString().equalsIgnoreCase(value)) {
				myVarietal = type;
			}
		}
		return myVarietal;
	}

}
