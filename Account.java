import java.util.*;

public class Account{
	private String accName,accId;
	protected double accBalance;
	
	//Transaction stuff
	private List<Transaction> listOfTransaction = new ArrayList<Transaction>();
	int totalNumberOfTransaction;

	Account(){
		accName = accId = "N/A";
		accBalance = 0;
	}
	
	public double getAccBalance(){
		return accBalance;
	}
	
	public String getAccName(){
		return accName;
	}
	
	public String getAccId(){
		return accId;
	}

	Account(String accName,String accId,double accBalance){
		this.accName = accName;
		this.accId = accId;
		this.accBalance = accBalance;
	}

	public boolean deposit(double amount){
		if(amount > 0){
			accBalance = accBalance + amount;
			return true;
		}
		else return false;
	}

	public boolean withdraw(double amount){
		if(amount > 0 && amount <= accBalance){
			accBalance = accBalance - amount;
			return true;
		}
		else return false;
	}
	
	public boolean transfer(Account toAcc, double ammount){
		
		if(this.withdraw(ammount)){
			if(toAcc.deposit(ammount)){
			
				this.display();
				toAcc.display();
				
				System.out.println("Successfully transfered "+ammount+" from "+this.accName+" to "+toAcc.accName);
				
				//add Transaction
				addTransaction(this,toAcc,ammount);
				
				return true;
			}
			else{
			this.deposit(ammount);
			}
		}
		System.out.println("Failed to transfer "+ammount+" from "+this.accName+" to "+toAcc.accName);
		
		return false;
	}
	
	public void display(){
		System.out.println(accName+"'s Balance : "+accBalance);
	}
	
	
	
	public static void main(String args[]){
	
	Account acc1 = new Account("Mr. Habib","111-554",5000);
	Account acc2 = new Account("Mr. Abdul;","111-487",200);
	
	acc1.display();
	acc2.display();
	
	System.out.println();
	
	acc1.transfer(acc2,200);
	System.out.println();	
	acc1.transfer(acc2,300);	
	System.out.println();
	acc2.transfer(acc1,600);
	
	System.out.println();

	acc1.showAllTransaction();
	acc2.showAllTransaction();
		
	}
	
	//Transaction stuff
	
		
	private void addTransaction(Account sender, Account reciever, double ammount){
		
		addTransaction(sender,reciever,ammount,"N/A");
	}

	private void addTransaction(Account sender, Account reciever, double ammount, String additionalInfo){	

		Transaction currentTransaction = new Transaction(sender, reciever, ammount,additionalInfo);

		listOfTransaction.add(currentTransaction);
		
		totalNumberOfTransaction++;
	}		
	
	public void showAllTransaction(){
		
		for(Transaction item : listOfTransaction){
			item.showInfo();
		}
	}
		
	
	
	class Transaction{
		Account sender,reciever;
		double ammount;
		String additionalInfo;
		
		Transaction(Account sender, Account reciever, double ammount){
			this.sender = sender;
			this.reciever = reciever;
			this.ammount = ammount;
			additionalInfo = "N/A";
		}
		
		Transaction(Account sender, Account reciever, double ammount, String additionalInfo){
			
			this(sender,reciever,ammount);
			this.additionalInfo = additionalInfo;
		}
		
		public void showInfo(){
		
			System.out.println(
			"Sender: "+sender.getAccName()+"\n"
			+"Reciever: "+reciever.getAccName()+"\n"
			+"Ammount: "+this.ammount+"\n"
			+"Additional Info: "+this.additionalInfo+"\n"
			
			);
			
		}
		
		
	}

}

