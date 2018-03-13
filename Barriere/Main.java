package Barriere;

public class Main {
	private final static int NThreadMax = Runtime.getRuntime().availableProcessors();
	public static void main(String[] args) 
	{

		final long start = System.nanoTime();
		final Main mac = new Main();
		System.out.println("Primi tra 1'000'000 e 10'000'000: " + mac.contaPrimi(1, 1000));
		final long elapsed = System.nanoTime() - start;
		System.out.println("Tempo trascorso: " + (double) elapsed / 1000000000 + " secondi.");
		System.out.println(Main.NThreadMax);
	}
		public int contaPrimi(final int MIN, final int MAX) {
			if (MAX < MIN)
				return 0;

			int threadReali = Main.NThreadMax;

			int fetta = (MAX - MIN + 1) / threadReali;
			while (fetta == 0) {
				threadReali--;
				fetta = (MAX - MIN + 1) / threadReali;
			}
			final Barriera b = new Barriera(threadReali + 1);

			// creazione e invocazione thread.
			final Maker[] c = new Maker[threadReali];
			for (int i = 0; i < threadReali - 1; i++) {
				final int min = MIN + i * fetta;
				final int max = min + fetta - 1;
				c[i] = new Maker(b,min, max);
				c[i].start();
			}
			c[threadReali - 1] = new Maker(b,MIN + (threadReali - 1) * fetta, MAX);
			c[threadReali - 1].start();

			b.await();

			int totale = 0;
			for (int i = 0; i < threadReali; i++)
				totale += c[i].getTotale();
			return totale;
			
		}
	}


