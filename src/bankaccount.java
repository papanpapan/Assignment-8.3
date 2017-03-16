public class bankaccount {
	private volatile int balnc;

    public bankaccount(int bc){
        balnc = bc;
    }

    public bankaccount(){
        balnc = 0;
    }


    synchronized public int getBalance(){
        return balnc;
    }

    synchronized public int withdraw(int wd)
    {
        int bc = getBalance();
        if(wd <= bc){
            balnc = balnc-wd;
            return wd;
        }
        else
            return 0;
    }
}