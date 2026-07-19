package blockchain.block;
import java.util.Date;

public class Block {
    private String hash;
    private final String previousHash;
    private long timeStamp;


    public Block(String previousHash, String hash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = getHash();
    }


    public String getHash(){
        String hash = new String();


        return hash;
    }




}
