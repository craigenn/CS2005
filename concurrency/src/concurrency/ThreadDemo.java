package concurrency;

public class ThreadDemo extends Thread{  
	//A simple program to show how you define and start a thread running  
	  public void run(){  
	    System.out.println("My thread is in running state.");  
	  } 
	  
	  public static void main(String args[]){  
	     //create the new thread
	     ThreadDemo thisIsTheThread = new ThreadDemo();   
	    //start it
	     thisIsTheThread.start();  
	  }  
	}