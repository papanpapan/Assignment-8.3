public class withdrawaccount implements Runnable {
	private bankaccount Acc;
    private int Amount;

    public withdrawaccount(){
        Acc = null;
        Amount = 0;
    }

    public withdrawaccount(bankaccount acc,int amount){
        this.Acc = acc;
        this.Amount = amount;
    }
	public void run() {
		int wd; 

        for(int i =0; i<30; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Balance Before "+Thread.currentThread().getName()+" Withdrawl: "+Acc.getBalance());
            wd = Acc.withdraw(Amount);
            System.out.println("Balance after "+Thread.currentThread().getName()+" withdrawl: "+Acc.getBalance());
            System.out.println("amount with drawn by: "+Thread.currentThread().getName()+" "+wd);

        }

    }

public static void main(String args[]){
	 bankaccount bc = new bankaccount(2000);
     withdrawaccount wd = new withdrawaccount(bc,10);
     Thread wd1 = new Thread(wd);
     wd1.setName("T");

     Thread wd2 = new Thread(wd);
     wd2.setName("T1");

     wd1.start();
     wd2.start();
 
		
	}
}
