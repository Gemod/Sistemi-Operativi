package Sedia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Negozio 
{
	private ShareDate d;
	private Lock lock= new ReentrantLock();
	private Condition barbiereCondition= lock.newCondition();
	private Condition partecipanteCondition =lock.newCondition();
	public Negozio(ShareDate d)
	{
		this.d=d;
	}
	
	public boolean put()
	{
		while(d.getI()==d.getS().length)
		{
			try 
			{
				partecipanteCondition.await();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		return  d.put();
	}
	public void getPartecipante()
	{
		lock.lock();
		barbiere();
		d.getPartecipante();
		barbiereCondition.signalAll();
		partecipanteCondition.signalAll();
		lock.unlock();
	}
	public void barbiere()
	{
		while(d.getI()==0)
		{
			try {
				barbiereCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
