package Sedia;

public class Partecipante extends Thread
{
	private String nome;
	private Negozio dt;
	public Partecipante(Negozio n)
	{
		this.dt=n;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			if(dt.put())
				System.out.println("mi sono seduto zio"+this.getId());
			else
				System.out.println("Non mi sono seduto zio"+this.getId()+"ho perso");
		}
	}	
	
}
