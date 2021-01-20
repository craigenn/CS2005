package concurrency;


public class SharedData {

	  private boolean accessing=false; // true a thread has a lock, false otherwise
	 
	  // attempt to acquire a lock
	  public synchronized void acquireLock() throws InterruptedException{
        Thread me = Thread.currentThread(); // get a ref to the current thread
        System.out.println(me.getName()+" is attempting to acquire a lock!");
		
	    while (accessing) {  // while someone else is accessing
	      System.out.println(me.getName()+" waiting to get a lock as someone else is accessing...");
	      //wait for the lock to be released - see releaseLock() below
	      wait();
	    }
	    // nobody has got a lock so get one
	    accessing = true;
	    System.out.println(me.getName()+" got a lock!"); 
	    
	  }

	  // Releases a lock to when a thread is finished
	  
	  public synchronized void releaseLock() {
		  //release the lock and tell everyone
	      accessing = false;
	      notifyAll();
	      Thread me = Thread.currentThread(); // get a ref to the current thread
	      System.out.println(me.getName()+" released a lock!");
	  }

	
	}