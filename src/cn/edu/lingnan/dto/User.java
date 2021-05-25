package cn.edu.lingnan.dto;

public class User {

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public int getSuperuser() {
		return superuser;
	}
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	
	private int ban;
	private String uid;
	private String uname;
	private String upassword;
	private int superuser;
	
	
	
	
	
	
	
}
