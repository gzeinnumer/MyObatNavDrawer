package com.gzeinnumer.myobatnavdrawer.model;

import com.google.gson.annotations.SerializedName;

public class ResponseGetData{

	@SerializedName("Satuan")
	private String satuan;

	@SerializedName("BrgID")
	private String brgID;

	@SerializedName("BrgName")
	private String brgName;

	public void setSatuan(String satuan){
		this.satuan = satuan;
	}

	public String getSatuan(){
		return satuan;
	}

	public void setBrgID(String brgID){
		this.brgID = brgID;
	}

	public String getBrgID(){
		return brgID;
	}

	public void setBrgName(String brgName){
		this.brgName = brgName;
	}

	public String getBrgName(){
		return brgName;
	}
}