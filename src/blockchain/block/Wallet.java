package blockchain.block;

public class Wallet{
    private long balance;
    private final String address;
    private final String data;

    public Wallet(long balance, String address, String data){
        this.balance = balance;
        this.address = address;
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    private long getBalance() {
        return balance;
    }


}
