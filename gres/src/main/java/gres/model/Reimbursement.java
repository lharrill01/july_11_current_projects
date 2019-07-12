package gres.model;

public class Reimbursement {
	
	int id;
	String email;
	String selection;
	double rAmount;
	String adchoice;
	

	
	
	public Reimbursement(int id, String email, String selection, double rAmount, String adchoice) {
		super();
		this.id = id;
		this.email = email;
		this.selection = selection;
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




	public String getSelection() {
		return selection;
	}




	public void setSelection(String selection) {
		this.selection = selection;
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
		return "Reimbursement [id=" + id + ", email=" + email + ", selection=" + selection + ", rAmount=" + rAmount
				+ ", adchoice=" + adchoice + "]";
	}
	
	

}
