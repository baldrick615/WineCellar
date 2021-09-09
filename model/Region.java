package com.trm.winecellar.model;

public enum Region {
	au, ca, wa, usOther, chile, argentina, france, italy, spain, euOther, ROW;

	public static Region convertStringToVarietal(String value) {
		Region convertedRegion = null;
		for (Region region : Region.values()) {
			if (convertedRegion.toString().equalsIgnoreCase(value)) {
				convertedRegion = region;
			}
		}
		return convertedRegion;
	}
}
