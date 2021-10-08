package com.trm.winecellar.model;

public enum Varietal {
	champagne, chardonnay, cabernetSauvignon, pinotNoir, otherWhite, merlot, shiraz, otherRed;
	
	public static Varietal convertStringToVarietal(String value) {
		Varietal myVarietal = null;
		for (Varietal v : Varietal.values()) {
			if(v.toString().equalsIgnoreCase(value)) {
				myVarietal = v;
			}
		}
		return myVarietal;
	}

}
