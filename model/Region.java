package com.trm.winecellar.model;

public enum Region {
	Ca("California"), OtherUS("Other US"), Or("Oregon"), Wa("Washington"), Fr("France"), Sp("Spain"), It("Italy"), Au("Australia"), ROW("Rest of World"), OtherEU("Other EU");
	
	public static Region convertStringToRegion(String value) {
		Region myRegion = null;
		for (Region region : Region.values()) {
			if(region.toString().equalsIgnoreCase(value)) {
				myRegion = region;
			}
		}
		return myRegion;
	}
	
	private String displayRegion;
	
	Region(String displayRegion) {
		this.displayRegion = displayRegion;
	}
	
	public String displayRegion() {
		return displayRegion;
	}

}
