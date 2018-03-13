package ReadWriteLock;

public class Writer extends Thread
{
	private ShareDate d;
	Writer(ShareDate d)
	{
		this.d=d;
	}
	 @Override
	 public void run()
	 {
		 while(true)
		 {
			 d.takeWriteLock();
			 d.setDate(5);
			 d.leaveWriteLock();
		 }
	 }
}
