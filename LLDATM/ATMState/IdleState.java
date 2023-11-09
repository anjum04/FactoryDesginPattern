package LLDATM.ATMState;

import LLDATM.ATM;
import LLDATM.Card;

public class IdleState extends ATMState{
	  
	  public void insertCard(ATM atm, Card card) {
	        System.out.println("Card is Inserted");
	        atm.setCurrentATMState(new HasCard());
	    }

}
