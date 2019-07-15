package gres.model;

public class Reimbursement {
	
	int id;
	String email;
	String rStuff;
	double rAmount;
	String adchoice;
	

	
	
	public Reimbursement(int id, String email, String rStuff, double rAmount, String adchoice) {
		super();
		this.id = id;
		this.email = email;
		this.rStuff = rStuff;
		this.rAmount = rAmount;
		this.adchoice = adchoice;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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

	


	public String isAdchoice() {
		return adchoice;
	}




	public void setAdchoice(String adchoice) {
		this.adchoice = adchoice;
	}




	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", email=" + email + ", rStuff=" + rStuff + ", rAmount=" + rAmount
				+ ", adchoice=" + adchoice + "]";
	}
	
	

}
