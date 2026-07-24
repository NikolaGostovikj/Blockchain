package blockchain.block;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private String id;
    private String sender;
    private String receiver;
    private long amount;
    private String timestamp;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] signature;
    private final List<TransactionInput> inputs;
    private final List<TransactionOutput> outputs = new ArrayList<>();

    public Transactions(String sender, String receiver, long amount, String timestamp, List<TransactionInput> inputs) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = timestamp;
        //this.id = Util.calculateHash();

        this.inputs = inputs;
    }

}
