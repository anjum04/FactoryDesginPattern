package LLDATM;

import LLDATM.ATMState.TransactionType;

public class ATMRoom {
	ATM atm;
	User user;
	
	public static void main(String[] args)
	{
		ATMRoom atmRoom = new ATMRoom();
		
		atmRoom.initialize();
		atmRoom.atm.printCurrentATMStatus();
		atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm,atmRoom.user.card);
		atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
		atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card,TransactionType.CASH_WITHDRAWAL);
		atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card,2500);
		atmRoom.atm.printCurrentATMStatus();
	}
	
	void initialize()
	{
		 atm = atm.getATMObject();
		 atm.setAtmBalance(3500,1,2,5);
		 
		 this.user=createUser();
	}
	User createUser()
	{
		User user= new User();
		user.setCard(createCard());
		return user;
	}
	Card createCard()
	{
		Card card = new Card();
		card.setBankAccount(createBankAccount());
		return card;
	}
	UserBankAccount createBankAccount()
	{
		UserBankAccount bankAccount = new UserBankAccount();
		bankAccount.balance=3000;
		return bankAccount;
	}

}
