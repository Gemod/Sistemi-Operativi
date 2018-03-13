package Buffer;

import java.util.Random;

public class Cliente extends Thread
{
	Pizzeria p;
	public Cliente(Pizzeria p)
	{
		this.p=p;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
		try {
			int pizza=new Random().nextInt(5)+1;
			int quantita= new Random().nextInt(10)+1;
			switch(pizza)
			{
				case 1:
				{
						p.putOrdine(new Ordine("margherita",quantita));
						System.out.println("margherita");
					break;
				}
				case 2:
				{
					System.out.println("wurstel patatine");
					p.putOrdine(new Ordine("wurstel patatine",quantita));
					break;
				}
				case 3:
				{	
					System.out.println("4Stagioni");
					p.putOrdine(new Ordine("4Stagioni",quantita));
				
					break;
				}
				case 4:
				{
					System.out.println("primavera");
					p.putOrdine(new Ordine("primavera",quantita));
					break;
				}
				case 5:
				{
					System.out.println("funghi");
					p.putOrdine(new Ordine("funghi",quantita));
					break;
				}
					
					
					
			} 
			sleep(new Random().nextInt(1200)*quantita);
			Ordine o =this.p.getPizza();
			System.out.println(o.toString());
		
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}
		

}
