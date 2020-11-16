package kr.or.bit.model.dto;

import java.util.Date;

public class DTOPdInqPost {
	private int inqNum;
	private int saleNum;
	private String id;
	private String inqTitle;
	private String inqContent;
	private Date inqCreatedAt;
	private char inqPrivate;
	
	public DTOPdInqPost() {}
	
	public DTOPdInqPost(int saleNum, String id) {	
		this.saleNum = saleNum;
		this.id = id;
	}
	
	
	
	public DTOPdInqPost(int saleNum, String id, String inqTitle, String inqContent,char inqPrivate) {	
		this.saleNum = saleNum;
		this.id = id;
		this.inqTitle = inqTitle;
		this.inqContent = inqContent;	
		this.inqPrivate = inqPrivate;
	}
	
	public DTOPdInqPost(int inqNum, int saleNum, String id, String inqTitle, String inqContent, char inqPrivate) {
		this.inqNum = inqNum;
		this.saleNum = saleNum;
		this.id = id;
		this.inqTitle = inqTitle;
		this.inqContent = inqContent;
		this.inqPrivate = inqPrivate;
		
	}
	
	public DTOPdInqPost(int inqNum, int saleNum, String id, String inqTitle, String inqContent, char inqPrivate, Date inqCreatedAt) {
		this.inqNum = inqNum;
		this.saleNum = saleNum;
		this.id = id;
		this.inqTitle = inqTitle;
		this.inqContent = inqContent;
		this.inqPrivate = inqPrivate;
		this.inqCreatedAt = inqCreatedAt;
		
	}

	public int getInqNum() {
		return inqNum;
	}

	public void setInqNum(int inqNum) {
		this.inqNum = inqNum;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInqTitle() {
		return inqTitle;
	}

	public void setInqTitle(String inqTitle) {
		this.inqTitle = inqTitle;
	}

	public String getInqContent() {
		return inqContent;
	}

	public void setInqContent(String inqContent) {
		this.inqContent = inqContent;
	}

	public Date getInqCreatedAt() {
		return inqCreatedAt;
	}

	public void setInqCreatedAt(Date inqCreatedAt) {
		this.inqCreatedAt = inqCreatedAt;
	}

	public char getInqPrivate() {
		return inqPrivate;
	}

	public void setInqPrivate(char inqPrivate) {
		this.inqPrivate = inqPrivate;
	}

	@Override
	public String toString() {
		return "DTOPdInqPost [inqNum=" + inqNum + ", saleNum=" + saleNum + ", id=" + id + ", inqTitle=" + inqTitle
				+ ", inqContent=" + inqContent + ", inqCreatedAt=" + inqCreatedAt + ", inqPrivate=" + inqPrivate + "]";
	}

		
}
