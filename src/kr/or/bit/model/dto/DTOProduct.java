package kr.or.bit.model.dto;

public class DTOProduct {
	private int pNum;
	private int selNum;
	private String pName;
	private int pPrice;
	private String pSize;
	private int pAmount;
	private String pDescription;
	
	public DTOProduct() {}
	
	public DTOProduct(int selNum, String pName, int pPrice, String pSize, int pAmount, String pDescription) {
		this.selNum = selNum;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pAmount = pAmount;
		this.pDescription = pDescription;
	}
	
	public DTOProduct(int pNum, int selNum, String pName, int pPrice, String pSize, int pAmount, String pDescription) {
		this.pNum = pNum;
		this.selNum = selNum;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pAmount = pAmount;
		this.pDescription = pDescription;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getSelNum() {
		return selNum;
	}

	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public int getpAmount() {
		return pAmount;
	}

	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
}
