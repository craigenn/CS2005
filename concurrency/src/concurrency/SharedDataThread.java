package concurrency;

public class SharedDataThread extends Thread {

	private SharedData mySharedData;
	private String myThreadName;

	//Setup the thread
	
	SharedDataThread(String name, SharedData sharedstuff) {
		super(name);
		mySharedData=sharedstuff;
		myThreadName=name;
	}

	//This is called when "start" is used in the calling method
	
	public void run() {

		int num = 10; // number of read and write attempts in this thread for demonstration
		int numreads = 0, numwrites = 0;  // counters for the number of read and write operations

        System.out.println(myThreadName+" is running");

        //Have a go at randomly reading or writing num times to represent a real set of operations
		
		for(int i=0;i<num;i++) {
			// Randomly choose to read or write - this is just for demonstration!
		     if(Math.random()<0.5) {
		        //50% chance of read
		        try {
		          // Acquire the lock using the acquireLock() method
		          // The thread will pause here on wait() until it gets a lock
		          mySharedData.acquireLock();
		          // Now simulate a read action
		          System.out.println(myThreadName+" is reading");
		          sleep(1000); // Put the thread to sleep to simulate how long a read might take
		          numreads++; // Increment the number of reads
		          // Release the lock using the releaseLock() method
		          // notifyall() will wake up all the waiting threads but only one will get the lock
		          mySharedData.releaseLock(); 
		        }
		        catch(InterruptedException e) {
		          System.err.println("Failed to get lock when reading:"+e);
		        }
		      }
		      else {
		        //50% chance of write
		    	// Acquire the lock using the acquireWrite() method
		        try {
		        	// Acquire the lock using the acquireLock() method
   		            // The thread will pause here on wait() until it gets a lock
		        	mySharedData.acquireLock();
		        	// Now simulate a write action
		        	System.out.println(myThreadName+" is writing");
		        	sleep(1000); // Put the thread to sleep to simulate how long a write might take
		        	numwrites++; // Increment the number of writes
		        	// Release the lock using the releaseLock() method
		            // notifyall() will wake up all the waiting threads but only one will get the lock
		        	mySharedData.releaseLock(); // releases the lock
			    }
		        catch(InterruptedException e) {
		          System.err.println("Failed to get lock when writing:"+e);
		        }
		     }
		
		  System.out.println(myThreadName+" has made "+numreads+" reads and "+numwrites+" writes");
		 }
		}
}
	
	
