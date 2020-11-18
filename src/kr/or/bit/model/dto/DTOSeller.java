package kr.or.bit.model.dto;

public class DTOSeller {
	private int selNum;
	private String id;
	private String selEmail;
	private int selRegistNum;
	private String selAccount;
	
	public DTOSeller() {}
	
	public DTOSeller(int selNum, String id, String selEmail, int selRegistNum, String selAccount) {
		this.selNum = selNum;
		this.id = id;
		this.selEmail = selEmail;
		this.selRegistNum = selRegistNum;
		this.selAccount = selAccount;
	}
	
	public DTOSeller(String id, String selEmail, int selRegistNum, String selAccount) {
		this.id = id;
		this.selEmail = selEmail;
		this.selRegistNum = selRegistNum;
		this.selAccount = selAccount;
	}

	public int getSelNum() {
		return selNum;
	}

	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelEmail() {
		return selEmail;
	}

	public void setSelEmail(String selEmail) {
		this.selEmail = selEmail;
	}

	public int getSelRegistNum() {
		return selRegistNum;
	}

	public void setSelRegistNum(int selRegistNum) {
		this.selRegistNum = selRegistNum;
	}

	public String getSelAccount() {
		return selAccount;
	}

	public void setSelAccount(String selAccount) {
		this.selAccount = selAccount;
	}
	
}
