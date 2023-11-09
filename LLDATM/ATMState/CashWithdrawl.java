package LLDATM.ATMState;

import LLDATM.ATM;
import LLDATM.Card;
import LLDATM.ATMCashWithdraw.CashWithdrawProcessor;
import LLDATM.ATMCashWithdraw.FiveHundredWithdrawProcessor;
import LLDATM.ATMCashWithdraw.OneHundredWithdrawProcessor;
import LLDATM.ATMCashWithdraw.TwoThousandWithdrawProcessor;

public class CashWithdrawl extends ATMState{
	
	
	public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
       if(card.getBankBalance() < withdrawAmount)
       {
    	   System.out.println("Insuffiecient Balance in user Bank Account");
    	   exit(atm);
       }
       else if(atm.getAtmBalance() < withdrawAmount)
       {
    	   System.out.println("Insufficient fund in the ATM Machine");
           exit(atm);
       }
       else
       {
    	   card.deductBankBalance(withdrawAmount);
           atm.deductATMBalance(withdrawAmount);
           
    	   CashWithdrawProcessor cashWithdrawprocessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
    	   cashWithdrawprocessor.withdraw(atm, withdrawAmount);
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
