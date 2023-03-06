package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Hotel {
	 static Holder hotel_ob=new Holder();
	
	
	   static Scanner sc = new Scanner(System.in);
	    static String user,pass, name,contact, gender;
	  static String checkindate=null;
	  
	   public static void register() {
		   System.out.println("******REGISTER******");
			System.out.println("Enter the Name");
			name=sc.next();
			System.out.println("Enter UserName");
			user=sc.next();
			System.out.println("Enter Password");
			pass=sc.next();
		

	}
	   public static void login()  {
		   
			String user1,pass1;
			char ch;
		
		
			System.out.println("*****LOGIN******");
				System.out.println("Enter UserName");
				user1=sc.next();
				System.out.println("Enter Password");
				pass1=sc.next();
		
				if(user1.equals(user)&&pass1.equals(pass)) {
					System.out.println("Log in sucessfully");
				}
				
				else {
					System.out.println("Failed\nPlease enter Valid Username or password");
					Hotel.login();
					
				}
				
				
			
	   }
	   public static void getDate() {
		  // String checkindate;
		   if(checkindate==null) {
			   
		   
		   System.out.println("Enter Checkin date Format:  (dd/mm/yyyy)");
		   checkindate=sc.next();
		   }else {
			   System.out.println("Checkindate--->"+checkindate);
		   }
		
	}
	public static void CustDetails(int i,int rn) throws SQLException
	    {
		 String regex = "^\\d{10}$";
		
	        String name, contact = null, gender;
	        String name2 = null, contact2 = null;
	        String gender2="";
	        Hotel.getDate();
	        System.out.print("\nEnter the name: ");
	        name = sc.next();
	        System.out.print("Enter contact number: ");
	        contact=sc.next();
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(contact);
	        matcher.matches();
	        System.out.print("Enter gender: ");
	        gender = sc.next();
	       
	       
	        if(i<3)
	        {
	            System.out.print("Enter second person name: ");
	            name2 = sc.next();
	            System.out.print("Enter contact number: ");
	            contact2=sc.next();
	            System.out.print("Enter gender: ");
	            gender2 = sc.next();
	         
	            
	        }

	        switch (i) {
	            case 1:hotel_ob.luxury_doublerrom[rn]=new Doubleroom(checkindate,name,contact,gender,name2,contact2,gender2);
	                break;
	            case 2:hotel_ob.deluxe_doublerrom[rn]=new Doubleroom(checkindate,name,contact,gender,name2,contact2,gender2);
	                break;
	            case 3:hotel_ob.luxury_singleerrom[rn]=new Singleroom(checkindate,name,contact,gender);
	                break;
	            case 4:hotel_ob.deluxe_singleerrom[rn]=new Singleroom(checkindate,name,contact,gender);
	                break;
	            default:System.out.println("Wrong option");
	                break;
	        }
	    }

	   public static void bookroom(int i)
	    {
	        int j;
	        int rn = 0;
	        System.out.println("\nChoose room number from : ");
	        switch (i) {
	            case 1:
	                for(j=0;j<hotel_ob.luxury_doublerrom.length;j++)
	                {
	                    if(hotel_ob.luxury_doublerrom[j]==null)
	                    {
	                        System.out.print(j+1+",");
	                    }
	                }
	                System.out.print("\nEnter room number: ");
	                try{
	                    rn=sc.nextInt();
	                    rn--;
	                    if(hotel_ob.luxury_doublerrom[rn]!=null)
	                        throw new NotAvaliable();
	                    CustDetails(i,rn);
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Invalid Option");
	                    return;
	                }
	                break;
	            case 2:
	                for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
	                {
	                    if(hotel_ob.deluxe_doublerrom[j]==null)
	                    {
	                        System.out.print(j+11+",");
	                    }
	                }
	                System.out.print("\nEnter room number: ");
	                try{
	                    rn=sc.nextInt();
	                    rn=rn-11;
	                    if(hotel_ob.deluxe_doublerrom[rn]!=null)
	                        throw new NotAvaliable();
	                    CustDetails(i,rn);
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Invalid Option");
	                    return;
	                }
	                break;
	            case 3:
	                for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
	                {
	                    if(hotel_ob.luxury_singleerrom[j]==null)
	                    {
	                        System.out.print(j+31+",");
	                    }
	                }
	                System.out.print("\nEnter room number: ");
	                try{
	                    rn=sc.nextInt();
	                    rn=rn-31;
	                    if(hotel_ob.luxury_singleerrom[rn]!=null)
	                        throw new NotAvaliable();
	                    CustDetails(i,rn);
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Invalid Option");
	                    return;
	                }
	                break;
	            case 4:
	                for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
	                {
	                    if(hotel_ob.deluxe_singleerrom[j]==null)
	                    {
	                        System.out.print(j+41+",");
	                    }
	                }
	                System.out.print("\nEnter room number: ");
	                try{
	                    rn=sc.nextInt();
	                    rn=rn-41;
	                    if(hotel_ob.deluxe_singleerrom[rn]!=null)
	                        throw new NotAvaliable();
	                    CustDetails(i,rn);
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Invalid Option");
	                    return;
	                }
	                break;
	            default:
	                System.out.println("Enter valid option");
	                break;
	        }
	       
	        System.out.println("Room Booked");
	        System.out.println("Address: 20/9,Teachers colony,Moolaikadai,Chennai");
	    }

	   public static void features(int i)
	    {
	        switch (i) {
	            case 1:System.out.println("Number of double beds : 2\nAC : Yes\nFree breakfast : Yes\n Free wifi\nCharge per day:4000 ");
	                break;
	            case 2:System.out.println("Number of double beds : 2\nAC : No\nFree breakfast : Yes\n Free wifi\nCharge per day:3000  ");
	                break;
	            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\n Free wifi\nCharge per day:2200  ");
	                break;
	            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\n Free wifi\nCharge per day:1200 ");
	                break;
	            default:
	                System.out.println("Enter valid option");
	                break;
	        }
	    }

	   public static void availability(int i)
	    {
	        int j,count=0;
	        switch (i) {
	            case 1:
	                for(j=0;j<10;j++)
	                {
	                    if(hotel_ob.luxury_doublerrom[j]==null)
	                        count++;
	                }
	                break;
	            case 2:
	                for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
	                {
	                    if(hotel_ob.deluxe_doublerrom[j]==null)
	                        count++;
	                }
	                break;
	            case 3:
	                for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
	                {
	                    if(hotel_ob.luxury_singleerrom[j]==null)
	                        count++;
	                }
	                break;
	            case 4:
	                for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
	                {
	                    if(hotel_ob.deluxe_singleerrom[j]==null)
	                        count++;
	                }
	                break;
	            default:
	                System.out.println("Enter valid option");
	                break;
	        }
	        System.out.println("Number of rooms available : "+count);
	    }

	   public static void bill(int rn,int rtype)
	    {
	        double amount=0;
	        
	        String list[]={"Idly","Dosa","Meals","Briyani"};
	        System.out.println("\n*******");
	        System.out.println(" Bill:-");
	        System.out.println("*******");
	        Hotel.getDate();
	      
	        

	        switch(rtype)
	        {
	            case 1:
	                amount+=4000;
	                System.out.println("\nRoom Charge - "+4000);
	                System.out.println("\n===============");
	                System.out.println("Food Charges:- ");
	                System.out.println("===============");
	                System.out.println("Item   Quantity    Price");
	                System.out.println("-------------------------");
	                for(Food obb:hotel_ob.luxury_doublerrom[rn].food)
	                {
	                    amount+=obb.price;
	                    String format = "%-10s%-10s%-10s%n";
	                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
	                }

	                break;
	            case 2:amount+=3000;
	                System.out.println("Room Charge - "+3000);
	                System.out.println("\nFood Charges:- ");
	                System.out.println("===============");
	                System.out.println("Item   Quantity    Price");
	                System.out.println("-------------------------");
	                for(Food obb:hotel_ob.deluxe_doublerrom[rn].food)
	                {
	                    amount+=obb.price;
	                    String format = "%-10s%-10s%-10s%n";
	                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
	                }
	                break;
	            case 3:amount+=2200;
	                System.out.println("Room Charge - "+2200);
	                System.out.println("\nFood Charges:- ");
	                System.out.println("===============");
	                System.out.println("Item   Quantity    Price");
	                System.out.println("-------------------------");
	                for(Food obb:hotel_ob.luxury_singleerrom[rn].food)
	                {
	                    amount+=obb.price;
	                    String format = "%-10s%-10s%-10s%n";
	                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
	                }
	                break;
	            case 4:amount+=1200;
	                System.out.println("Room Charge - "+1200);
	                System.out.println("\nFood Charges:- ");
	                System.out.println("===============");
	                System.out.println("Item   Quantity    Price");
	                System.out.println("-------------------------");
	                for(Food obb: hotel_ob.deluxe_singleerrom[rn].food)
	                {
	                    amount+=obb.price;
	                    String format = "%-10s%-10s%-10s%n";
	                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
	                }
	                break;
	            default:
	                System.out.println("Not valid");
	        }
	        System.out.println("\nTotal Amount- "+amount);
	    }

	    static void deallocate(int rn,int rtype)
	    {
	        int j;
	        char w;
	        switch (rtype) {
	            case 1:
	            
	                if(hotel_ob.luxury_doublerrom[rn]!=null)
	                    System.out.println("Room used by "+hotel_ob.luxury_doublerrom[rn].name);
	               
	            
	                else
	                {
	                    System.out.println("Empty Already");
	                    return;
	                }
	                System.out.println("Do you want to checkout ?(y/n)");
	                w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.luxury_doublerrom[rn]=null;
	                    System.out.println("Deallocated succesfully");
	                }

	                break;
	            case 2:
	                if(hotel_ob.deluxe_doublerrom[rn]!=null)
	                    
	                	System.out.println("Room used by "+hotel_ob.deluxe_doublerrom[rn].name);
	                
	                else
	                	
	                {
	                    System.out.println("Empty Already");
	                    return;
	                }
	                System.out.println(" Do you want to checkout ?(y/n)");
	                w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.deluxe_doublerrom[rn]=null;
	                    System.out.println("Deallocated succesfully");
	                }

	                break;
	            case 3:
	                if(hotel_ob.luxury_singleerrom[rn]!=null)
	                    System.out.println("Room used by "+hotel_ob.luxury_singleerrom[rn].name );
	                else
	                {
	                    System.out.println("Empty Already");
	                    return;
	                }
	                System.out.println(" Do you want to checkout ? (y/n)");
	                w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.luxury_singleerrom[rn]=null;
	                    System.out.println("Deallocated succesfully");
	                }

	                break;
	            case 4:
	                if(hotel_ob.deluxe_singleerrom[rn]!=null)
	                    System.out.println("Room used by "+hotel_ob.deluxe_singleerrom[rn].name);
	                else
	                {
	                    System.out.println("Empty Already");
	                    return;
	                }
	                System.out.println(" Do you want to checkout ? (y/n)");
	                w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.deluxe_singleerrom[rn]=null;
	                    System.out.println("Deallocated succesfully");
	                }
	                break;
	            default:
	                System.out.println("\nEnter valid option : ");
	                break;
	        }
	    }

	    static void order(int rn,int rtype)
	    {
	        int i,q;
	        char wish;
	        try{
	            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Idly----->\tRs.5\n2.Dosa----->\tRs.20\n3.Meals----->\tRs.70\n4.Briyani\tRs.150\n");
	            do
	            {
	                i = sc.nextInt();
	                System.out.print("Quantity- ");
	                q=sc.nextInt();

	                switch(rtype){
	                    case 1: hotel_ob.luxury_doublerrom[rn].food.add(new Food(i,q));
	                        break;
	                    case 2: hotel_ob.deluxe_doublerrom[rn].food.add(new Food(i,q));
	                        break;
	                    case 3: hotel_ob.luxury_singleerrom[rn].food.add(new Food(i,q));
	                        break;
	                    case 4: hotel_ob.deluxe_singleerrom[rn].food.add(new Food(i,q));
	                        break;
	                }
	                System.out.println("Do you want to order anything else ? (y/n)");
	                wish=sc.next().charAt(0);
	            }while(wish=='y'||wish=='Y');
	        }
	        catch(NullPointerException e)
	        {
	            System.out.println("\nRoom not booked");
	        }
	        catch(Exception e)
	        {
	            System.out.println("Cannot be done");
	        }
	    }

}
