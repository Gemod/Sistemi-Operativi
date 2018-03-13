package BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> 
{
	private T theBuffer[];
	private int in ,out;
	private int slotpieni;
	private Lock lock=new ReentrantLock();
	private Condition full_condition =lock.newCondition();
	private Condition  emptycondition=lock.newCondition();
	
	public BlockingQueue(int dim)
	{
		
		in=0;
		out=0;
		slotpieni=0;
		theBuffer = (T[]) new Object[dim];
		
	}
	public void put(T x)
	{
		lock.lock();
		while(slotpieni==theBuffer.length)
		{	try {
				full_condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		theBuffer[in]=x;
		in=(in+1)%theBuffer.length;
		slotpieni++;
		emptycondition.signalAll();
		lock.unlock();
	}
	public T take()
	{
		lock.lock();
		try
		{
			while(slotpieni==0)
			{	try {
					emptycondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(slotpieni == theBuffer.length-1)
				full_condition.signalAll();
			return theBuffer[out];
		}
		finally
		{
			out=(out+1)%theBuffer.length;
			slotpieni--;
			full_condition.signalAll();
			lock.unlock();   		
		}
		/*
		 * T returnVAlue=theBuffer[out];
		 * out=(out+1)%theBuffer.length;
		 * return returnVAlue;
		 * ianni's code*/
	}
	public int getSlotPieni()
	{
		this.lock.lock();
		try
		{
			return this.slotpieni;
		}
		finally
		{
			this.lock.unlock();
		}
	}
	public int getFullSlot()
	{
		this.lock.lock();
		try
		{
			return this.slotpieni;
		}
		finally
		{
			this.lock.unlock();
		}
	}
	public boolean isEmpty() // verifica se è vuota
	{
		this.lock.lock();
		try
		{
			if (this.slotpieni == 0)
				return true;
			return false;
		}
		finally
		{
			this.lock.unlock();
		}
	}
	public int getSize() // verifica se è piena
	{
		this.lock.lock();
		try
		{
			
				return this.theBuffer.length; 
		}
		finally
		{
			this.lock.unlock();
		}
	}
}
