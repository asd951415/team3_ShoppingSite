package kr.or.bit.model.dto;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOSalePost {
	private int saleNum;
	private int selNum;
	private int categoryNum;
	private String saleTitle;
	private String saleContent;
	private Date saleCreatedAt;
	private List<String> imageAddrs;
	private List<Integer> pNums;
	private int salPrice;
	
	public DTOSalePost() {}
	
	public DTOSalePost(int selNum, int categoryNum, String saleTitle, String saleContent, List<Integer> pNums, List<String> imageAddrs) {
		this.selNum = selNum;
		this.categoryNum = categoryNum;
		this.saleTitle = saleTitle;
		this.saleContent = saleContent;
		this.pNums = pNums;
		this.imageAddrs = imageAddrs;
	}
	
	public DTOSalePost(int saleNum, int selNum, int categoryNum, String saleTitle, String saleContent, Date saleCreatedAt) {
		this.saleNum = saleNum;
		this.selNum = selNum;
		this.categoryNum = categoryNum;
		this.saleTitle = saleTitle;
		this.saleContent = saleContent;
		this.saleCreatedAt = saleCreatedAt;
	}
	
	public DTOSalePost(int saleNum, int selNum, int categoryNum, String saleTitle, String saleContent, Date saleCreatedAt, List<String> imageAddrs, int salPrice) {
		this.saleNum = saleNum;
		this.selNum = selNum;
		this.categoryNum = categoryNum;
		this.saleTitle = saleTitle;
		this.saleContent = saleContent;
		this.saleCreatedAt = saleCreatedAt;
		this.imageAddrs = imageAddrs;
		this.salPrice = salPrice;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public int getSelNum() {
		return selNum;
	}

	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getSaleTitle() {
		return saleTitle;
	}

	public void setSaleTitle(String saleTitle) {
		this.saleTitle = saleTitle;
	}

	public String getSaleContent() {
		return saleContent;
	}

	public void setSaleContent(String saleContent) {
		this.saleContent = saleContent;
	}

	public Date getSaleCreatedAt() {
		return saleCreatedAt;
	}

	public void setSaleCreatedAt(Date saleCreatedAt) {
		this.saleCreatedAt = saleCreatedAt;
	}

	public List<String> getImageAddrs() {
		return imageAddrs;
	}

	public void setImageAddrs(List<String> imageAddrs) {
		this.imageAddrs = imageAddrs;
	}

	public List<Integer> getpNums() {
		return pNums;
	}

	public void setpNums(List<Integer> pNums) {
		this.pNums = pNums;
	}

	public int getSalPrice() {
		return salPrice;
	}

	public void setSalPrice(int salPrice) {
		this.salPrice = salPrice;
	}
	
}
