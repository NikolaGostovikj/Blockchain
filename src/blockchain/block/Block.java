package blockchain.block;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static blockchain.block.Util.calculateHash;

public class Block {
    private String hash;
    private final String previousHash;
    private final long timeStamp;
    private long nonce;
    private final List<Transactions> transactions = new ArrayList<>();
    private String merkleRoot;


    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateBlockHash();
    }

    public boolean addTransaction(Transactions transaction) {
        if(transaction == null) {
            return false;
        }
        transactions.add(transaction);
        this.hash = calculateBlockHash();
        return true;
    }


    private String calculateBlockHash(){
        return Util.calculateHash(hash + timeStamp + nonce + merkleRoot);
    }



    public void mineBlock(int difficulty) {
        String target = "0".repeat(difficulty);
        hash = calculateBlockHash();
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateBlockHash();
        }
    }


    private String getMerkleRoot() {
        return merkleRoot;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public long getNonce() {
        return nonce;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

}
