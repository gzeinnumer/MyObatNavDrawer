package com.gzeinnumer.myobatnavdrawer.model;

import com.google.gson.annotations.SerializedName;

public class ResponseReadObat{

	@SerializedName("Satuan")
	private String satuan;

	@SerializedName("UnitID")
	private String unitID;

	@SerializedName("BrgID")
	private String brgID;

	@SerializedName("BrgName")
	private String brgName;

	@SerializedName("Jam")
	private String jam;

	@SerializedName("LokasiName")
	private String lokasiName;

	@SerializedName("Qty")
	private int qty;

	@SerializedName("Tgl")
	private String tgl;

	@SerializedName("LokasiID")
	private String lokasiID;

	@SerializedName("UnitName")
	private String unitName;

    public ResponseReadObat(String satuan, String unitID, String brgID, String brgName, String jam, String lokasiName, int qty, String tgl, String lokasiID, String unitName) {
        this.satuan = satuan;
        this.unitID = unitID;
        this.brgID = brgID;
        this.brgName = brgName;
        this.jam = jam;
        this.lokasiName = lokasiName;
        this.qty = qty;
        this.tgl = tgl;
        this.lokasiID = lokasiID;
        this.unitName = unitName;
    }

    public void setSatuan(String satuan){
		this.satuan = satuan;
	}

	public String getSatuan(){
		return satuan;
	}

	public void setUnitID(String unitID){
		this.unitID = unitID;
	}

	public String getUnitID(){
		return unitID;
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

	public void setJam(String jam){
		this.jam = jam;
	}

	public String getJam(){
		return jam;
	}

	public void setLokasiName(String lokasiName){
		this.lokasiName = lokasiName;
	}

	public String getLokasiName(){
		return lokasiName;
	}

	public void setQty(int qty){
		this.qty = qty;
	}

	public int getQty(){
		return qty;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setLokasiID(String lokasiID){
		this.lokasiID = lokasiID;
	}

	public String getLokasiID(){
		return lokasiID;
	}

	public void setUnitName(String unitName){
		this.unitName = unitName;
	}

	public String getUnitName(){
		return unitName;
	}
}