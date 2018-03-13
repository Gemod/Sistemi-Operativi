package Buffer;

public class Main 
{
	
		public static void main(String[] args)
		{
			String nomi[] = { "Mario", "Luigi", "Beppe" };
			Pizzeria Da_Toto = new Pizzeria();
			for (int i = 0; i < 4; i++)
				new Cliente(Da_Toto).start();
			for (int i = 0; i < 2; i++)
				new Pizzaiolo(Da_Toto, nomi[i]).start();

	}
}
