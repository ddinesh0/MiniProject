package com.hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Singleroom {
	String checkindate;
    String name;
    String contact;
    String gender;
    ArrayList<Food> food =new ArrayList<>();


  public  Singleroom()
    {
       
    }
   public Singleroom(String checkindate,String name,String contact,String gender)
    {
    	this.checkindate=checkindate;
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }

   

}
