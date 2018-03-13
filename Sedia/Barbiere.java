package Sedia;

public class Barbiere extends Thread
{
	private Negozio n;
	public Barbiere(Negozio n)
	{
		this.n=n;
	}
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("avanti il prossimo");
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n.getPartecipante();
		}
	}
	
}
