package com.trm.winecellar.model;

public enum Region {
	au, ca, wa, usOther, chile, argentina, france, italy, spain, nz, euOther, ROW;

	public static Region convertStringToRegion(String value) {
		Region convertedRegion = null;
		for (Region region : Region.values()) {
			if (region.toString().equalsIgnoreCase(value)) {
				convertedRegion = region;
			}
		}
		return convertedRegion;
	}

}
