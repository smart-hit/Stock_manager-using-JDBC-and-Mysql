package Controller;
import modal.admindetails;
import modal.product;

import java.sql.SQLException;
import java.util.Scanner;
import dao.LoginDAO;
import dao.productDAO;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int i;
		admindetails l=new admindetails();
		LoginDAO ldao=new LoginDAO();
		product p=new product();
		productDAO pdao=new productDAO();
      do {
    	  System.out.println("Enter your choice \n1.Admin \n2.Agent\n3.Exit");
    	  System.out.println("****************************************************");
    	   i=obj.nextInt();
    	   switch(i) {
    	   case 1:{
    		   System.out.println("enter your username");
    		   String username=obj.next();
    		   System.out.println("enter your password");
    		   String password=obj.next();
    		   l.setUsername(username);
    		   l.setPass(password);
    		   if(ldao.loginValidation(l)) {
    		   System.out.println("login successfull");
    		   }
    		   else {
    			   System.out.println(username+" "+password +" are invalid credentials");
    			   break;
    		   }
    		  
    		   int j;
    		   do {
    			   System.out.println("Enter your choice \n1.Add product\n2.display product");
    			 j=obj.nextInt();
    		   switch(j) {
    		   
    		   
    		   case 1:{
    			   System.out.println("Enter the product id to be added");
    			   int productId=obj.nextInt();
    			   p.setProductId(productId);
    			   System.out.println("Enter the product name");
    			   String productname=obj.next();
    			   p.setProductname(productname);
    			   System.out.println("Enter the product Minimum sell quantity");
    			   int minSellQuan=obj.nextInt();
    			   p.setMsq(minSellQuan);
    			   System.out.println("Enter the price");
    			   int price=obj.nextInt();
    			   p.setPrice(price);
    			   System.out.println("Enter the quantity");
    			   int quan=obj.nextInt();
    			   p.setQuantity(quan);
    			   pdao.addproduct(p);
    			   System.out.println(productname+" is added in list");
    			   break;
    		   }
    		   case 2:{
    			   System.out.println("Enter the product name to be display");
    			   
    			   pdao.viewProduct();
    			  
    			   break;
    		   }
    		   case 3:{
    			   System.out.println("logged out successfully");
     			  break;
    		   }
    		   }
    		   }
    		   while(j!=3);
    		   break;
    	   }
    	   case 2:{
    		   System.out.println("enter your username");
    		   String username1=obj.next();
    		   System.out.println("enter your password");
    		   String password1=obj.next();
    		   l.setUsername(username1);
    		   l.setPass(password1);
    		   if(ldao.loginValidation(l)) {
    		   System.out.println("login successfull");
    		   }
    		   else {
    			   System.out.println(username1+" "+password1 +" are invalid credentials");
    			   break;
    		   }
    		   int h;
    		   do {
    		   System.out.println("1.view product");
    		   System.out.println("2.sell product");
    		   System.out.println("3.Delete a product");
    		   System.out.println("4,Log out");
    		   System.out.println("Enter your choice ");
    		    h=obj.nextInt();
    		   switch(h) {
    		   case 1:{
    			   System.out.println("Enter the product name to be display");
    			   pdao.viewProduct();
    			  
    			   break;
    		   }
    		   case 2:{
    			   System.out.println("enter the product id to be selled");
    			   int productid=obj.nextInt();
    			   p.setProductId(productid);
    			   System.out.println("enter the quantity");
    			   int sold=obj.nextInt();
    			   p.setSoldquan(sold);
    			   pdao.update(p);
    			  break;
    			  
    		   }
    		   case 3:{
    			   System.out.println("enter the product id to be deleted");
    			   int id=obj.nextInt();
    			   pdao.delete(id);
    			   break;
    		   }
    		   default:{
    			   break;
    		   }
    		  
    		   }
    		  
    		   }while(h!=4);
    	   }
    	   default:{
    		   System.out.println("Exited");
    		   break;
    	   }
    	   }
      }
      while(i!=3);
	}

}
