package lock;

public class IlMioPrimoThread2016 {
	public static void main(String[] args) {

		StampaDisciplinataSync st = new StampaDisciplinataSync();
		StampaDisciplinata sts =new StampaDisciplinata();
		
		StampaAsterischi2016 john = new StampaAsterischi2016(st);
		StampaTrattini2016 al = new StampaTrattini2016(st);
		StampaEntrambi2016 jack =new StampaEntrambi2016(sts);
		
		john.start();
		al.start();
		jack.start();
		
		System.out.println("Main Terminato");
	}

}
