package LLDATM;

import LLDATM.ATMState.ATMState;
import LLDATM.ATMState.IdleState;

public class ATM {
	
	private static ATM atmObject = new ATM(); //Singleton: eager initialization

    ATMState currentATMState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;
	
	

	public ATMState getCurrentATMState() {
		return currentATMState;
	}
     
	public void setAtmBalance(int ATMBalance,int noOfTwoThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes )
	{
		this.atmBalance = ATMBalance;
		this.noOfTwoThousandNotes=noOfTwoThousandNotes;
		this.noOfFiveHundredNotes=noOfFiveHundredNotes;
		this.noOfOneHundredNotes=noOfOneHundredNotes;
		
	}
	public void setCurrentATMState(ATMState currentATMState) {
		this.currentATMState = currentATMState;
	}
	public static ATM getATMObject()
	{
		atmObject.setCurrentATMState(new IdleState());
		return atmObject;
	}

	public int getAtmBalance() {
		return atmBalance;
	}
	 public void deductATMBalance(int amount) {
	        atmBalance = atmBalance - amount;
	    }


	public int getNoOfTwoThousandNotes() {
		return noOfTwoThousandNotes;
	}

	public int getNoOfFiveHundredNotes() {
		return noOfFiveHundredNotes;
	}

	public int getNoOfOneHundredNotes() {
		return noOfOneHundredNotes;
	}
	public void printCurrentATMStatus()
	{
		System.out.println("ATM Balance:"+ atmBalance );
		System.out.println("2K notes: "+noOfTwoThousandNotes);
		System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
	}
	public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

	

}
