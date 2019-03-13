package com.gzeinnumer.myobatnavdrawer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseInsertData{

	@SerializedName("LokasiStokID")
	private String lokasiStokID;

	@SerializedName("BrgID")
	private String brgID;

	@SerializedName("Qty")
	private String qty;

	public void setLokasiStokID(String lokasiStokID){
		this.lokasiStokID = lokasiStokID;
	}

	public String getLokasiStokID(){
		return lokasiStokID;
	}

	public void setBrgID(String brgID){
		this.brgID = brgID;
	}

	public String getBrgID(){
		return brgID;
	}

	public void setQty(String qty){
		this.qty = qty;
	}

	public String getQty(){
		return qty;
	}
}