package Sedia;

public class Main 
{
	
	public static void main(String[] args) 
	{
		sedia[] s= new sedia[10-1];
		ShareDate d = new ShareDate(s);
		Negozio n = new Negozio(d);
		for(int i=0;i<s.length;i++)
		{
			s[i]= new sedia();
		}
		Partecipante [] p= new Partecipante[10];
		for(int i=0;i<10;i++)
		{
			p[i]= new Partecipante(n);
			p[i].start();
		}
		Barbiere b = new Barbiere(n);
		b.start();
	}
}
