package com.corejava.miniproject;
import java.io.*;
import java.util.*;
class AdminLogin implements Serializable
{
	String name, password;
	AdminLogin(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	public String toString()
	{
		return name+" "+password;
	}
}
class AccountantLogin implements Serializable
{
	String nm, pass;
	AccountantLogin(String nm, String pass)
	{
		this.nm = nm;
		this.pass = pass;
	}
	public String toString()
	{
		return nm+" "+pass;
	}
}
public class FeeReport
{
	public static void main(String[] args)throws IOException, ClassNotFoundException
	{
		int choice = -1;
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		File file = new File("AdminLogin.txt");
		File file1 = new File("AccountantLogin.txt");
		ArrayList<AdminLogin> al = new ArrayList<AdminLogin>();
		ArrayList<AccountantLogin> al1 = new ArrayList<AccountantLogin>();
		ObjectOutputStream oos = null;
		ObjectOutputStream oos1 = null;
		ObjectInputStream ois = null;
		ObjectInputStream ois1 = null;
		ListIterator li = null;
		ListIterator li1 = null;
		
		if(file.isFile())
		{
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<AdminLogin>)ois.readObject();
			ois.close();
		}	
		if(file1.isFile())
		{
			ois1 = new ObjectInputStream(new FileInputStream(file1));
			al1 = (ArrayList<AccountantLogin>)ois1.readObject();
			ois1.close();
		}
		
		do{
			System.out.println("*************** Fee Report ***************");
			System.out.println("1.Admin Login ");
			System.out.println("2.View Admin Login Details ");
			System.out.println("3.Accountant Login ");
			System.out.println("4.View Accountant Login Details ");
			System.out.println("0.Logout ");
			System.out.println("\n Enter your choice: ");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("************* Admin Login *************");
					System.out.print("Name : ");
					String name = s1.nextLine();
					System.out.print("Password : ");
					String password = s1.nextLine();
					System.out.println("Admin Login Successfull");
					
					al.add(new AdminLogin(name,password));
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					
					break;
					
				case 2:
					if(file.isFile())
					{
						ois = new ObjectInputStream(new FileInputStream(file));
						al = (ArrayList<AdminLogin>)ois.readObject();
						ois.close();
						
						System.out.println("************* View Admin Login Details *************");
						li = al.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("--------------------------------------------");
					}
					else
					{
						System.out.println("File not Exist.....!");
					}
					break;
					
				case 3:
					System.out.println("************* Accountant Login *************");
					System.out.print("Name : ");
					String nm = s1.nextLine();
					System.out.print("Password : ");
					String pass = s1.nextLine();
					System.out.println("Accountant Login Successfull");
					
					al1.add(new AccountantLogin(nm,pass));
					oos1 = new ObjectOutputStream(new FileOutputStream(file1));
					oos1.writeObject(al1);
					oos1.close();
					
					break;
					
				case 4:
					if(file1.isFile())
					{
						ois1 = new ObjectInputStream(new FileInputStream(file1));
						al1 = (ArrayList<AccountantLogin>)ois1.readObject();
						ois1.close();
						
						System.out.println("************* View Accountant Login Details *************");
						li1 = al1.listIterator();
						while(li1.hasNext())
							System.out.println(li1.next());
						System.out.println("--------------------------------------------");
					}
					else
					{
						System.out.println("File not Exist.....!");
					}
					break; 
			}
		}while(choice!=0);
	}

}