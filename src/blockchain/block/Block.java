package blockchain.block;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    private String hash;
    private final String previousHash;
    private long timeStamp;
    private long nonce;

    public Block(String previousHash, String hash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }


    /*
    Hash function which uses previous hash, timestamp and nonce
    Used StringBuffer for concurrency, and SHA-256
     */
    public String calculateHash() {
        String hash = previousHash + Long.toString(timeStamp) + Long.toString(nonce);
        MessageDigest digest = null;
        byte[] hashedBytes = null;

        try{

            digest = MessageDigest.getInstance("SHA-256");
            hashedBytes = digest.digest(hash.getBytes());

        }catch(Exception e){

            Logger.ERROR.log(e.getMessage());
            e.printStackTrace();

        }

        StringBuffer buffer = new StringBuffer();
        for ( byte b : hashedBytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();

    }




}
