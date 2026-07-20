package blockchain.block;

public class Transactions {

    private String sender;
    private String receiver;
    private String amount;
    private String timestamp;

    public Transactions(String sender, String receiver, String amount, String timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = timestamp;
    }

}
