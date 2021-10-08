package com.trm.winecellar.model;

public enum Region {
	ca("California"), otherUs("Other US"), or("Oregon"), wa("Washington"), fr("France"), sp("Spain"), it("Italy"), au("Australia"), ROW("Rest of World");
	
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
