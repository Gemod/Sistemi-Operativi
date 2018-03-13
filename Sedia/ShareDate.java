package Sedia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareDate 
{
	private int i;
	private sedia [] s;
	private int index;
	private Lock lock = new ReentrantLock();
	public ShareDate(sedia []s)
	{
		this.s=s;
		i=0;
		index=0;
	}
	public int getI() 
	{
		lock.lock();
		try
		{
			return i;
		}
		finally
		{
			lock.unlock();
		}
	}
	public void setI(int i) 
	{
		lock.lock();
		this.i = i;
		lock.unlock();
	}
	public boolean put()
	{
		lock.lock();
		try
		{
			if(i<s.length)
			{
				for(int ii=0;ii<s.length;ii++)
				{
					if(!s[ii].getOccupata())
					{
						s[ii].setOccupata(true);
						i++;
						return true;
					}
				}
				
				
			}
			else
			{
				return false;
			}
		}
		finally
		{
			lock.unlock();
		}
		return false;
	}
	public sedia getPartecipante()
	{
		lock.lock();
		try
		{
			if(i>0 && i<8+1)
				return s[i--];
		}
		finally
		{
			lock.unlock();
		}
		return null;
	}
	public sedia[] getS() {
		return s;
	}
}
