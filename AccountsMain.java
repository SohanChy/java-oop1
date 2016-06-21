public class AccountsMain{
	public static void main(String args[]){
		
		Account acc1 = new SavingsAccount("Mr. Habib","111-554",5000);
		
		Account acc2 = new OverdraftAccount("Mr. Abdul","111-487",2200);
		
		Account acc3 = new CurrentAccount("Mr. Salam","155-527",9000);
		
		acc1.display();
		acc2.display();
		acc3.display();
		
		System.out.println();
			
		acc1.withdraw(5000);
		acc1.withdraw(4000);
		
		acc1.display();
		
		acc2.withdraw(3000);
		acc2.withdraw(2400);

		acc2.display();

		acc3.withdraw(10000);
		acc3.withdraw(9000);
		
		acc3.display();
		
		
	}
}


class OverdraftAccount extends Account{
	private int overdraftLimit;
	
	OverdraftAccount(String accName,String accId,double accBalance, int limit){
		super(accName,accId,accBalance);
		this.overdraftLimit = limit;
	}
	
	OverdraftAccount(String accName,String accId,double accBalance){
		this(accName,accId,accBalance,500);
	}
	
	//Override
	public boolean withdraw(double amount)
	{
		if ( (amount > 0.0) && ( getAccBalance()+overdraftLimit > amount ) ){
			accBalance = accBalance - amount;
			
			System.out.println("OverdraftAccount withdraw complete");
			return true;
		}
		System.out.println("Failed: OverdraftAccount limit exceeded");
		return false;
	}

}

class SavingsAccount extends Account{
	
	SavingsAccount(String accName,String accId,double accBalance){
		super(accName,accId,accBalance);
	}
	
	//Override
	public boolean withdraw(double amount)
	{
		if ( (amount > 0.0) && ( amount  <= 0.9 * getAccBalance() ) ){
			accBalance = accBalance - amount;
			
			System.out.println("SavingsAccount withdraw complete");
			return true;
		}
		System.out.println("Failed: SavingsAccount limit exceeded");
		return false;
	}

}


class CurrentAccount extends Account{
	
	CurrentAccount(String accName,String accId,double accBalance){
		super(accName,accId,accBalance);
	}
	
	//No need to Override withdraw

}

