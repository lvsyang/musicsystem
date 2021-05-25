package cn.edu.lingnan.dto;

public class Music {
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname= kname;
	}
	
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}


	public int getPastm() {
		return pastm;
	}
	public void setPastm(int pastm) {
		this.pastm = pastm;
	}
	
    String mid;
	String mname;
	String kid;
	String kname;
	int pastm;
}
