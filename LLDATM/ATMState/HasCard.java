package LLDATM.ATMState;


import LLDATM.ATM;
import LLDATM.Card;

public class HasCard extends ATMState {
	
	 public void authenticatePin(ATM atm, Card card, int pin){
		 boolean isPINCorrect = card.isCorrectPINEntered(atm, pin);
		 if(isPINCorrect)
		 {
			 atm.setCurrentATMState(new SelectOperation());
		 }
		 else {
			 System.out.println("PIN is Invalid!");
			 exit(atm);
		 }

	    }
	 @Override
	    public void exit(ATM atm){
	        returnCard();
	        atm.setCurrentATMState(new IdleState());
	        System.out.println("Exit happens");
	    }

	    @Override
	    public void returnCard(){
	        System.out.println("Please collect your card");
	    }

}
