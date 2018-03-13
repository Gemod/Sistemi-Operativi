package Buffer;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pizzaiolo extends Thread
{

	private Lock lock=new ReentrantLock();
	private Condition condition =lock.newCondition();
	private Pizzeria p;
	private String name; 
	public Pizzaiolo(Pizzeria p,String name)
	{
		this.p=p;
		this.name=name;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try 
			{
				
				Ordine o =this.p.getOrdine();
				System.out.println("il pizzaiolo ha preso l'ordine in consegna ,sta lavorando...");
				sleep(new Random().nextInt(780)*o.getQuantità());
				this.p.ritiro.put(o);
				System.out.println("il pizzaiolo ha finito di fare la pizza");
				
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
