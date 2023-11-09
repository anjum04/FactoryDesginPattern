package LLDATM.ATMState;

import LLDATM.ATM;
import LLDATM.Card;

public class SelectOperation extends ATMState{
	
	 public void selectOperation(ATM atm, Card card, TransactionType txnType){
		 txnType.showAllTransactionTypes();
		 switch(txnType)
		 {
		 case CASH_WITHDRAWAL:
		      atm.setCurrentATMState(new CashWithdrawl());
		      break;
		 case BALANCE_CHECK:
			 atm.setCurrentATMState(new CheckBalance());
			 break;
	     default:
	    	 System.out.println("Invalid Option");
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
