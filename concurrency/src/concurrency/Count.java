package concurrency;

public class Count extends Thread
{
   Count()
   {
     super("MY THREAD");
     System.out.println("The thread just created is called " + this.getName());
     start();
   }
   
   public void run()
   {
     try
     {
        for (int i=0 ;i<10;i++)
        {
           System.out.println("This is MY THREAD - Printing the count " + i);
           Thread.sleep(1000);
           long threadID = Thread.currentThread().getId();
           System.out.println("This is the actual thread ID of MY THREAD " + threadID);
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
      Count cnt = new Count();
      try
      {
         while(cnt.isAlive())
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