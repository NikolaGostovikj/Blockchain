package blockchain.block;

import java.security.MessageDigest;

public class Util {

    //Put all necessary work in a separate class

    public static String calculateHash(String previousHash, long timeStamp, long nonce){
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
