package concurrency;

public class CountMultiple extends Thread {
	
	CountMultiple(String myThreadName)
   {
     super(myThreadName);
     System.out.println("The thread just created is called " + this.getName());
     start();
   }
   
   public void run()
   {
     try
     {
        for (int i=0 ;i<10;i++)
        {
           System.out.println("This is " + this.getName() + " - Printing the count " + i);
           Thread.sleep(1000);
           long threadID = Thread.currentThread().getId();
           System.out.println("This is the actual thread ID of " + this.getName() + " " + threadID);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("My thread interrupted");
     }
     System.out.println("My thread run is over" );
   }


public static void main(String args[])
   {
      CountMultiple cnt1 = new CountMultiple("Thread1");
      CountMultiple cnt2 = new CountMultiple("Thread2");

      try
      {
         while(cnt1.isAlive() & cnt2.isAlive())
         {
           System.out.println("This is the Main thread - it will be ALIVE until the Child thread is LIVE");
           Thread.sleep(500);
         }
      }
      catch(InterruptedException e)
      {
        System.out.println("Main thread interrupted");
      }
      System.out.println("Main thread's run is over" );
   }
}


