import java.util.Scanner;
package com.service;
import com.bean.Account;
abstract class AccountInitialization
{
	public static int accountcount=0,accountcount1=0,i=0,j=0;
	public static int accno=100; 
	public static int accno1=100;
	public String name;
	public int amount;
	public Account accounts[]=new Account[10];
	void accountcreate()
	{
		if(accountcount<10)
		{
			name="Unknown";
			amount=500;
			accounts[i]=new Account(accno,name,amount);
			accno++;
			i++;
			accountcount++;
		}
		else
		{
			accountcount1=1;
			System.out.println("Account Limit exceed.");
		}
	}
	
	void accountcreate(String name,int amount)
	{
		if(accountcount1<10)
		{
			if(amount>500)
			{
				this.name=name;
				this.amount=amount;
				accounts[j].setaccno(this.accno1);
				accounts[j].setname(this.name);
				accounts[j].setamount(this.amount);
				System.out.println("Name="+accounts[j].getname());
				System.out.println("Account Number="+accounts[j].getaccno());
				System.out.println("Amount="+accounts[j].getamount());
				accountcount1++;
				accno1++;
				j++;
			}
			else
			{
				System.out.println("Amount should be greater than 500.");
			}
		}
		else
		{
			System.out.println("Account Limit exceed.");
		}
	}
	abstract void transfer(int fromaccno,int toaccno,int amount);
}


package com.service;
interface Bank
{
	void withdraw(int accno,int amount);
	void deposit(int accno,int amount);
	void checkbalance(int accno);
}

package com.bean;
class Account
{
	private int accno;
	private String name;
	private int amount;
	public Account(int accno, String name, int amount)
	{
		this.accno=accno;
		this.name=name;
		this.amount=amount;
	}
	
	public void setname(String name)
	{
		this.name=name;
	}
	public void setaccno(int accno)
	{
		this.accno=accno;
	}
	public void setamount(int amount)
	{
		this.amount=amount;
	}
	public String getname()
	{
		return name;
	}
	public int getaccno()
	{
		return accno;
	}
	public int getamount()
	{
		return amount;
	}
	
}

class MyException extends Exception
{
	MyException()
	{
		super();
	}
	MyException(String msg)
	{
		super(msg);
	}
}

package com.service;
class MyBank extends AccountInitialization implements Bank
{	
	public void transfer(int fromaccno, int toaccno,int amount)
	{
		if(accountcount!=0)
		{
			for(i=0;i<10;i++)
			{
				try
				{
				if(accounts[i].getaccno()==fromaccno)
				{
					for(int j=0;j<10;j++)
					{
						try
						{
						if(accounts[j].getaccno()==toaccno)
						{
							if(accounts[i].getamount()-amount>500)
							{
								accounts[i].setamount(accounts[i].getamount()-amount);
								accounts[j].setamount(accounts[j].getamount()+amount);
								break;
							}
							else
							{
								System.out.println("Minimum balance 500 should be maintained.");
							}
						}
						throw new MyException("to account number not matched");
						}
						catch(MyException e)
						{
							System.out.println(e.toString());
							break;
						}
					}
					break;
				}
				throw new MyException("from account number not matched");
				}
				catch(MyException e){
					System.out.println(e.toString());
					break;
				}
			}
		}
		else
		{
			System.out.println("Account is not created. Create Your account first");
		}
	}
	
	public void withdraw(int accno1,int amount1)
	{
		if(accountcount!=0)
		{
			for(int i=0;i<10;i++)
			{
				try
				{
				if(accounts[i].getaccno()==accno1)
				{
					if((accounts[i].getamount()-amount1)>500)
					{
						accounts[i].setamount(accounts[i].getamount()-amount1);
						System.out.println("Amount withdrawn successfully");
						break;
					}
					else
					{
						System.out.println("Minimum balance 500 should be maintained.");
					}
				}
				throw new MyException("Account mismatch");
				}
				catch(MyException e){
					System.out.println(e.toString());
					break;
				}
			}
		}
		else
		{
			System.out.println("Account is not Created. Create your account first.");
		}
	}
	public void deposit(int accno1, int amount1)
	{
		if(accountcount!=0)
		{
			for(int i=0;i<10;i++)
			{
				try
				{
				if(accounts[i].getaccno()==accno1)
				{
					if(amount1<50000)
					{
						accounts[i].setamount(accounts[1].getamount()+amount1);
						System.out.println("Amount Deposited successfully.");
					}
					else
					{
						System.out.println("Amount is more than 50000. Pancard is compulsary.");
						break;
					}
				}
				throw new MyException("Account mismatch");
				}
				catch(MyException e){
					System.out.println(e.toString());
					break;
				}
			}
		}
		else
		{
			System.out.println("Account is not created. create your account first.");
		}
	}
	public void checkbalance(int accno1)
	{
		if(accountcount!=0)
		{
			for(int i=0;i<10;i++)
			{
				try
				{
				if(accounts[i].getaccno()==accno1)
				{
					System.out.println("Available Balance:"+accounts[i].getamount());
					break;
				}
				throw new MyException("Account mismatch");
				}
				catch(MyException e){
					System.out.println(e.toString());
					break;
				}
			}
		}
		else
		{
			System.out.println("Account is not Created. Create your account first.");
		}
	}	
}


import com.service.MyBank;
class BankTestApp
{
public static void main(String args[])
{
	System.out.println("Welcome to Bank Application");
	Scanner sc=new Scanner(System.in);
	String name;
	boolean value=true;
	int accno, toaccno,amount;
	MyBank mybank=new MyBank();
	do
	{
		System.out.println("Press 1 for Create Account\nPress 2 for check Account Balance\nPress 3 for withdraw the amount\nPress 4 for Deposit\nPress 5 for Transfer\nPress 6 for exit the Application: ");
		int choose= sc.nextInt();
		
		switch(choose)
		{
			case 1:
					System.out.println("Press 1 for Default details\nPress 2 for name and Amount pass:");
					int ch=sc.nextInt();
					switch(ch)
					{
						case 1:	mybank.accountcreate();
								break;
						case 2:	System.out.println("Enter Name:");
								name=sc.next();
								System.out.println("Enter amount:");
								amount=sc.nextInt();
								mybank.accountcreate(name,amount);
								break;
						default:
								System.out.println("Invalied choice.");
					}
			case 2: System.out.println("For Check Balance");
					System.out.println("Enter Account Number:");
					accno=sc.nextInt();
					mybank.checkbalance(accno);
					break;
			case 3: System.out.println("Withdraw Money");
					System.out.println("Enter Account Number:");
					accno=sc.nextInt();
					System.out.println("Enter Amount:");
					amount=sc.nextInt();
					mybank.withdraw(accno,amount);
					break;
			case 4: System.out.println("Deposit Money");
					System.out.println("Enter Account Number:");
					accno=sc.nextInt();
					System.out.println("Enter Amount:");
					amount=sc.nextInt();
					mybank.deposit(accno,amount);
					break;
			case 5:	System.out.println("Transfer Money");
					System.out.println("Enter Your Account Number:");
					accno=sc.nextInt();
					System.out.println("Enter Account Number to be transfered:");
					toaccno=sc.nextInt();
					System.out.println("Enter Amount to be transfered:");
					amount=sc.nextInt();
					mybank.transfer(accno,toaccno,amount);
					break;
			case 6:	System.out.println("Thank you for using this bank");
					value=false;
					break;
			default:
					System.out.println("invalied choice.");
		}
	}while(value);
}
}