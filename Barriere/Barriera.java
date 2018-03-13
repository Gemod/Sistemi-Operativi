package Barriere;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barriera 
{
	private int numeroThread;
	private int ThreadAttivi;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	Barriera(int numeroThread)
	{
		this.numeroThread=numeroThread;
		this.ThreadAttivi=0;
	}
	public void await()
	{
		lock.lock();
		ThreadAttivi++;
		if(ThreadAttivi==numeroThread)
			condition.signalAll();
		
		while(ThreadAttivi<numeroThread)
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		lock.unlock();
	}
	public void fatto()
	{
		lock.lock();
		
		ThreadAttivi++;
		if(ThreadAttivi==numeroThread)
			condition.signalAll();
		
		lock.unlock();
	}
}
