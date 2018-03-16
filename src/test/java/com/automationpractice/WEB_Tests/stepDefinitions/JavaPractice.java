package com.automationpractice.WEB_Tests.stepDefinitions;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.htmlunit.cyberneko.HTMLEventInfo.SynthesizedItem;
import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


//Reference https://www.w3schools.in/java-tutorial/

public class JavaPractice {

	
	@Given ("^I know some Java$")
	public void IKnowJava() {
		int a =1;
		
		
//		*********************** IF ELSE  ***********************
		if(a==a) {
			System.out.println("IF ELSE a = "+a);
			} else {	
				System.out.println("IF ELSE  - Else statement for if else says = "+a);	
			}
	
		
//		*********************** ELSE IF ***********************
		if (a==2) { 
			System.out.println("a = "+a);
		}		
		else if(a==14) {
			System.out.println("ELSE IF - Else if says a = "+a);
		}
		else {
			System.out.println("ELSE IF - Else statement says a = "+a);
		}
		
	
		
//		*********************** WHILE LOOPS ***********************
		int x =1;
		while(x<10){
		    System.out.println("While Loops Number is "+x);
		    x++;
		}
		
		
//		*********************** DO WHILE LOOPS ***********************
		// using a do loop the loop is always executed at least once.
		int y = 5;
		
		do{
		  System.out.println("Do while loop:  y = " + y);
		  ++y;
		}
		while( y<10 );
	
		
	
//		*********************** FOOR LOOPS ***********************
		
//		init; condition; increment
		
		int n = 1, times = 5;
		for (n=1; n<=10; n++) {
		System.out.println("For Loop - incrementer = "+ n);
	}
	
		
//		*********************** NESTED FOR LOOPS ***********************
		
		
		for(int i=0;i<=10;i++) {
			System.out.println("NESTED LOOP - the value of i = "+i);
			
			for(int j=0;j<=10;j++) {
				System.out.println("NESTED LOOP -  the value of j = "+j);
			}
		}
	
		// decrement loop so it runs down from 10 to 1
	for(int d=10; d>=0;d--) {
		System.out.println("decrementing nested for loop d=    "+d);
		for(int e=5;e>=0;e--) {
			System.out.println("decrementing nested the value of e = "+e);
		}
	}
		
	
	// for loop iterating through an array
	
	
		
	
//	We have BREAKS & CONTINUE in for loops
	
	for(int i=0;i<=10;i++) {
		
		if (i==5) break;
		System.out.println("The value of i = "+i);
	}
	
	for(int b=1;b<=10;b++) {
		if(b==5) continue;    // continue starts the loop again if true and does not continue past this value. So it gets to 5 and restarts. So doens't print 5 and starts the loop again.
		System.out.println("The value of b = "+b);
	}
	
	
//	*********************** ARRAYS ***********************
//	https://www.w3schools.in/java-tutorial/arrays/
		
//	can be declared 2 ways
	
	int woof[] = new int[5];
	int[] age = new int[5];  //preferred way

	int arr[] = {1,6,9,4,6};
	
	//initialise an array in a for loop
	int[] forArray = new int[5];
	for (int f=0; f<=forArray.length-1;f++) {
		try {
			forArray[f] = f;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("The ARRAY element "+f+" = "+f);
	}
	
	
	int[] anArray = {56,43,7,32,8};	
	int ss = anArray.length;
	System.out.println("********** Array length is   "+ss);
	for (int g = 0; g<= anArray.length-1; g++) {
		System.out.println("Array value at index of: "+g+" = "+ anArray[g]);
	}
	
	
	
//	*********************** ARRAY LISTS ***********************
//	https://beginnersbook.com/2013/12/java-arraylist/
//	Most of the developers choose Arraylist over Array
//	ArrayList can dynamically grow and shrink after addition and removal of elements	
	
	
	ArrayList<String> arList = new ArrayList<String>();
	arList.add("Steven Willson");
	arList.add("Joe Satriani");
	arList.add("Steve Vai");
	arList.add("John Bonaboo");
	
	System.out.println("the Array list has these element " + arList);
	
	/*Add element at the given index*/
	arList.add(0, "woofty");
	System.out.println("the Array list has these element " + arList);
	
	/*Remove elements from array list like this*/
	arList.remove(0);
	System.out.println("REMOVE INDEX 0 - the Array list has these element " + arList);
	
	
	arList.add(0, "woofty");
	System.out.println("the Array list has these element " + arList);
	arList.remove("woofty");
	System.out.println("REMOVE BY STRING WOOFTY - the Array list has these element " + arList);
	
	
	
}
	
	
	
	
	
	
	
	@When ("^I practice$") 
	public void practice() {
		
//		*********************** PRINTING A TRIANGLE *********************** 
//		https://learn-java-by-example.com/java/printing-triangles-java/
		
		 // Our triangle will have 10 lines
	      // One loop iteration each line
	 
	      for (int i=1; i<=10; i++) {
	 
	         // For each loop iteration 
	         // we want to print a number of stars
	         // 1st line -> 1 star   2nd line -> 2 star
	 
	         for (int j=0;j<i; j++) {
	            System.out.print("*");  // print NOT println
	         }
	         System.out.println();
	      }
	   
	      // upside Left bounded triangle
	      for (int p=10;p>=0;p--) {
	    	  for (int q=p;q>=0;q--) {
	    		  System.out.print("*");   // print NOT println
	    	  }
	    	  System.out.println("*");
	      }
	      
	      // triangle
	      for(int i=0;i<5;i++) {
	          for(int j=0;j<5-i;j++) {
	              System.out.print(" ");
	          }
	         for(int k=0;k<=i;k++) {
	             System.out.print("* ");
	         }
	         System.out.println();  
	     }
	      
//	      TRIANGLE WITH MEANINGFUL VARIABLE NAMES
	      for (int mainCounter=0;mainCounter<5;mainCounter++) {
	    	  for(int spaceCounter=0; spaceCounter<= 5-mainCounter;spaceCounter++) {    // 1 less space each time main counter increments
	    		  System.out.print(" ");
	    	  }
	    	  for (int starCounter=0;starCounter<=mainCounter;starCounter++) {   // 1 more star each time main counter increments
	    		  System.out.print("* ");
	    	  }
	    	  System.out.println();  // move to next line
	      }
	      
		
	      
	      
	      System.out.println("MY GO AT THE STAR TRIANGLE");
	      
	      // triangle on my own
	      for (int l=0;l<5;l++) {
	    	  for(int m=0; m<= 5-l; m++ ) {  //spaces
	    		  System.out.print(" ");
	    	  }
	    	  for(int n=0;n<= l; n++) {
	    		  System.out.print("* ");
	    	  }
	    	  System.out.println();
	      }
	      
	      
//	      *********************** Getting user input ***********************
//	      using scanner
	      
	      Scanner scan = new Scanner(System.in);
	      System.out.println(scan.nextLine());
	      int myInt = scan.nextInt();
	      System.out.println(myInt);
	      
//	      *********************** Testing for odd and even *********************** 
//	      if(n%2==1)    if its 0 n is even else its odd.   % is modulus which is the remainder value, so 4 in 1.4
	      
		
	      System.out.println("");
	      System.out.println("enter integer for weird ------");
	      Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();            
          String ans="";
          if(n%2==1){
            ans = "Weird";
          }else{
          
             if(n>=2 && n<=5) {
            	 ans = "Not Weird" ; 
             }else if (n >=6 && n<=20) {
            	 ans = "Weird" ;
             }else {
            	 ans = "Not Weird"; 
             }
          System.out.println(ans); 
      }
	      
	     

	      
	      
		
	}

	@Then  ("^I get better$") 
	public void GotTheJob() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
