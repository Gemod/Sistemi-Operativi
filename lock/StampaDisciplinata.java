package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StampaDisciplinata 
{

	Lock ilLock = new ReentrantLock();

	
	void stampaStriscia(char c)
	{
		ilLock.lock();
		for(int i = 0; i <= 50; i++)
			System.out.print(c);
		System.out.println("");
		ilLock.unlock();
	}
	void stampaStriscia25(char c)
	{
		ilLock.lock();
		
		try
		{
			for(int i = 0; i <= 25; i++)
			System.out.print(c);
		System.out.println("");
	
			System.exit(0);

		}
		finally
		{
			ilLock.unlock();
	}
	}
	
}
class StampaDisciplinataSync
/*
 *  Esempio di classe StampaDisciplinata equivalente alla precedente ma ottenuta
 *  usando il costrutto synchronized
 */
{
	
	void stampaStriscia(char c)
	{
		synchronized(this) 
		{ // this.lockNascosto.lock();
			for(int i = 0; i <= 50; i++)
				System.out.print(c);
			System.out.println("");
	     //} // this.lockNascosto.unlock();
		}
	}
	 synchronized void stampaStriscia25(char c)
	{ // this.lockNascosto.lock();
		
			for(int i = 0; i <= 25; i++)
				System.out.print(c);
			System.out.println("");

	} // this.lockNascosto.unlock();
	
}



class StampaAsterischi2016 extends Thread
{
//	StampaDisciplinata st;
//	StampaAsterischi2016(StampaDisciplinata s)
//	{
//		st = s;
//	}
	StampaDisciplinataSync st;
	public StampaAsterischi2016(StampaDisciplinataSync st) 
	{
		this.st=st;
	}
	public void run()
	{
		while(true)
		{
			st.stampaStriscia25('*');
        }
	}
}

class StampaTrattini2016 extends Thread
{
	StampaDisciplinataSync st;
	StampaTrattini2016(StampaDisciplinataSync s)
	{
		st = s;
	}
	
	public void run()
	{
		while(true)
		{
			st.stampaStriscia25('-');
		}
	}
}
class StampaEntrambi2016 extends Thread
{
	StampaDisciplinata st;
	public StampaEntrambi2016(StampaDisciplinata st)
	{
		this.st=st;
		
	}
	
	public void run()
	{
		while(true)
		{
			st.stampaStriscia('-');
		}
	}
}




