package com.hotel;


public class Doubleroom extends Singleroom {
	String checkindate;
    String name2;
    String contact2;
    String gender2;

   public Doubleroom()
    {
       
    }
  public  Doubleroom(String checkindate,String name,String contact,String gender,String name2,String contact2,String gender2)
    {
    	this.checkindate=checkindate;
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
  
}

