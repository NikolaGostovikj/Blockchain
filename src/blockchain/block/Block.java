package blockchain.block;
import java.util.Date;
import java.util.List;

import static blockchain.block.Util.calculateHash;

public class Block {
    private String hash;
    private final String previousHash;
    private long timeStamp;
    private long nonce;
    private List<Transactions> transactions;

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(previousHash, timeStamp, nonce);
    }


    /*
    Hash function which uses previous hash, timestamp and nonce
    Used StringBuffer for concurrency, and SHA-256
     */

    public void mineBlock(int difficulty) {
        String target = "0".repeat(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash(previousHash, timeStamp, nonce);
        }
    }


}
