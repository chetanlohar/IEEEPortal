package com.ieeeportal.entity;

import java.io.Serializable;

public class CityEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cityId;
	private String cityName;
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	
}
