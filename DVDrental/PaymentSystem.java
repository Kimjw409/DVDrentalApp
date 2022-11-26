package eecs3311proj;

import javax.swing.JOptionPane;

public class PaymentSystem {
	
	public PaymentSystem() {
		
	}
	
	public Boolean validate() {
		JOptionPane.showMessageDialog(
                null,
                "Payment Successful !",
                "MovieCo",
                JOptionPane.PLAIN_MESSAGE
        );
		
		return true;
	}

}
