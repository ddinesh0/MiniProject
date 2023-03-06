package com.hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;






public class Main {
	
	 public static void main(String[] args){
		 

	        try
	        {
	           
	            Scanner sc = new Scanner(System.in);
	            int ch,ch2;
	            char wish;
	            System.out.println("----------WELCOME TO NEW HOTEL----------");
	            Hotel.register();
            	Hotel.login();
	           
	            do{
	            	System.out.println("WELCOME");
	                System.out.println("\nPlease select option:Eg-(1,2..)  \n\t1.Show Display room details\n\t2.Show Display room availability \n\t3.Book My Room\n\t4.Order Food Items\n\t5.If you want Checkout\n\t6.Exit\n");
	                ch = sc.nextInt();
	                switch(ch){
	                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Bed Room \n2.Deluxe Double Bed  Room \n3.Luxury Single Bed  Room \n4.Deluxe Single  Bed Room\n");
	                        ch2 = sc.nextInt();
	                        Hotel.features(ch2);
	                        break;
	                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Bed  Room \n2.Deluxe Double Bed  Room \n3.Luxury Single Bed  Room\n4.Deluxe Single Bed  Room\n");
	                        ch2 = sc.nextInt();
	                        Hotel.availability(ch2);
	                        break;
	                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Bed  Room \n2.Deluxe Double Bed  Room \n3.Luxury Single Bed  Room\n4.Deluxe Single  Bed Room\n");
	                        ch2 = sc.nextInt();
	                        Hotel.bookroom(ch2);
	                    
	                        break;
	                    case 4:
	                        System.out.print("Room Number -");
	                        ch2 = sc.nextInt();
	                        if(ch2>60)
	                            System.out.println("Room doesn't exist");
	                        else if(ch2>40)
	                            Hotel.order(ch2-41,4);
	                        else if(ch2>30)
	                            Hotel.order(ch2-31,3);
	                        else if(ch2>10)
	                            Hotel.order(ch2-11,2);
	                        else if(ch2>0)
	                            Hotel.order(ch2-1,1);
	                        else
	                            System.out.println("Room doesn't exist");
	                        break;
	                    case 5:
	                        System.out.print("Room Number -");
	                        ch2 = sc.nextInt();
	                        if(ch2>60)
	                            System.out.println("Room doesn't exist");
	                        else if(ch2>40)
	                            Hotel.deallocate(ch2-41,4);
	                        else if(ch2>30)
	                            Hotel.deallocate(ch2-31,3);
	                        else if(ch2>10)
	                            Hotel.deallocate(ch2-11,2);
	                        else if(ch2>0)
	                            Hotel.deallocate(ch2-1,1);
	                        else
	                            System.out.println("Room doesn't exist");
	                        break;
	                    case 6:
	                    	System.exit(6);
	                    	break ;

	                }

	                System.out.println("\nBack to MainMenu : (y/n)");
	                wish=sc.next().charAt(0);
	                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
	                {
	                    System.out.println("Invalid Option");
	                    System.out.println("\nContinue : (y/n)");
	                    wish=sc.next().charAt(0);
	                }

	            }while(wish=='y'||wish=='Y');

	          
	        }
	        catch(Exception e)
	        {
	            System.out.println("Not a valid input");
	        }
	    }

}
