package Buffer;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pizzeria 
{
	private Lock lock =new ReentrantLock();
	private boolean chiusura;
	private Condition conditionPizzaiolo=lock.newCondition();
	private Condition conditionCliente=lock.newCondition();
	BlockingQueue<Ordine> ordini =new BlockingQueue<>(10);
	BlockingQueue<Ordine> ritiro =new BlockingQueue<>(10); 
	
	public Pizzeria()
	{
		this.chiusura=false;
	}
	
	public Boolean getChiusura()
	{
		return this.chiusura;
	}
	public void setChiusura(Boolean chiusura)
	{
		this.chiusura=chiusura;
	}
	public void putOrdine(Ordine r)
	{
		lock.lock();
	
	
		ordini.put(r);
		conditionPizzaioloS();
		
		lock.unlock();
	}
	public Ordine getOrdine()
	{
		
		lock.lock();
		try
		{	
			while(this.ordini.getSlotPieni()==0)
			{
				conditionPizzaioloA();
			}
			
			return	ordini.take();
		}
		finally
		{
			this.lock.unlock();
		}
	}
	public void putPizza(Ordine r)
	{
	
		lock.lock();

		while(this.ritiro.getSlotPieni()==this.ritiro.getSize())
		{
			conditionPizzaioloA();
		}
	
		ritiro.put(r);
		conditionPizzaioloS();
		
		lock.unlock();
	}
	public Ordine getPizza()
	{
		lock.lock();
		try
		{
			while(this.ritiro.getSlotPieni()==0)
			{
				try {
					conditionCliente.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ritiro.take();
		}
		finally
		{
			lock.unlock();
		}
	}
	public void conditionPizzaioloA()
	{
		try 
		{
			conditionPizzaiolo.await();
		}
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}
	public void conditionPizzaioloS()
	{
		conditionPizzaiolo.signalAll();
	}
}
