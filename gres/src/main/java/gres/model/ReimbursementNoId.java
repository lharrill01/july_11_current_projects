package gres.model;

public class ReimbursementNoId {

	String email;
	String rStuff;
	double rAmount;
	String adchoice;
	public ReimbursementNoId(String email, String rStuff, double rAmount, String adchoice) {
		super();
		this.email = email;
		this.rStuff = rStuff;
		this.rAmount = rAmount;
		this.adchoice = adchoice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getrStuff() {
		return rStuff;
	}
	public void setrStuff(String rStuff) {
		this.rStuff = rStuff;
	}
	public double getrAmount() {
		return rAmount;
	}
	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}
	public String getAdchoice() {
		return adchoice;
	}
	public void setAdchoice(String adchoice) {
		this.adchoice = adchoice;
	}
	@Override
	public String toString() {
		return "ReimbursementNoId [email=" + email + ", rStuff=" + rStuff + ", rAmount=" + rAmount + ", adchoice="
				+ adchoice + "]";
	}
	
	
	

}
