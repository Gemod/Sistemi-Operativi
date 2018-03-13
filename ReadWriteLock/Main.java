package ReadWriteLock;

public class Main {

	public static void main(String[] args) 
	{
		ShareDate d = new ShareDate();
		Reader[] r= new Reader[10];
		for(int i=0;i<10;i++)
		{
			r[i]= new Reader(d);
			r[i].start();
		}
		Writer[] w= new Writer[2];
		for(int i=0;i<2;i++)
		{
			w[i]= new Writer(d);
			w[i].start();
		}

	}

}
