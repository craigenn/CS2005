package concurrency;


public class SharingExample {
  public static void main(String[] args) {

	// You want to create a shared data object that allows controlled reading
	// and writing by concurrent threads

	SharedData mySharedData = new SharedData();

    // Create three threads - you could create many more - this is just to show them sharing
    // You share mySharedData by having it in the scope of the thread (i.e. you are passing it 
    // to the thread
    
    SharedDataThread myThread1 = new SharedDataThread("myThread1", mySharedData);
    SharedDataThread myThread2 = new SharedDataThread("myThread2", mySharedData);
    SharedDataThread myThread3 = new SharedDataThread("myThread3", mySharedData);
    
    // Now start the threads executing
    
    myThread1.start();
    myThread2.start();
    myThread3.start();
    
  }
}
