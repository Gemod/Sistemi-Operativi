package Barriere;

public class Maker extends Thread
{
	private Barriera b;
	private int min;
	private int max;
	private int totale;
	Maker(Barriera b, int min, int max)
	{
		this.b=b;
		this.min=min;
		this.max=max;
		totale=0;
	}
	private void contaPrimiSeq() {

		for (int i = min; i <= max; i++)
			if (eprimo(i))
				totale++;

	}

	private boolean eprimo(final int n) {
		if (n <= 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0)
				return false;

		return true;
	}

	public int getTotale() {
		return totale;
	}

	@Override
	public void run()
	{
		contaPrimiSeq();
		b.fatto();
		
	}
}
