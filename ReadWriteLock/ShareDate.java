package ReadWriteLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareDate 
{
	private int date;
	private int ReaderNum;
	private int WriterNum;
	private boolean thereIsWriter;
	private Lock lock= new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	ShareDate()
	{
		
	}
	public void takeReadLock()
	{
		lock.lock();
		
		while(thereIsWriter || ReaderNum > 5  )
		{
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ReaderNum++;
		lock.unlock();
	}
	public void LeaveReadLock()
	{
		lock.lock();
		ReaderNum--;
		if(ReaderNum==0)
			condition.signalAll();
		
		lock.unlock();
	}
	public int getDate() 
	{
		return date;
	}
	public void setDate(int date) 
	{
		this.date = date;
	}
	public void takeWriteLock()
	{
		lock.lock();
		WriterNum++;
		while(ReaderNum > 0 || thereIsWriter)
		{
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		thereIsWriter=true;
		WriterNum--;
		lock.unlock();
	}
	public void leaveWriteLock()
	{
		lock.lock();
		
		thereIsWriter=false;
		condition.signalAll();
		lock.unlock();
	}
}
