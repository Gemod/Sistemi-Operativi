package ReadWriteLock;

public class Reader extends Thread
{
	private ShareDate d;
	Reader(ShareDate d)
	{
		this.d=d;
	}
	@Override
	public void run()
	{
		while(true)
		{
			d.takeReadLock();
			int x=d.getDate();
			//do something
			System.out.println(x);
			d.LeaveReadLock();
		}
	}
}
