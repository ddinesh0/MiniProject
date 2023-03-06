package com.hotel;

import java.io.Serializable;

public class Food implements Serializable{
	 int itemno;
	    int quantity;
	    float price;

	    Food(int itemno,int quantity)
	    {
	        this.itemno=itemno;
	        this.quantity=quantity;
	        switch(itemno)
	        {
	            case 1:price=quantity*5;
	                break;
	            case 2:price=quantity*20;
	                break;
	            case 3:price=quantity*70;
	                break;
	            case 4:price=quantity*150;
	                break;
	        }
	    }

}
