package blockchain.block;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
public class Util {
     /*
    Hash function which uses previous hash, timestamp and nonce
    Used StringBuffer for concurrency, and SHA-256
     */

    public static String calculateHash(String input){
        MessageDigest digest = null;
        byte[] hashedBytes = null;

        try{

            digest = MessageDigest.getInstance("SHA-256");
            hashedBytes = digest.digest(input.getBytes());

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

    public static KeyPair generateKeyPair(){

        try{

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
            return keyPairGenerator.generateKeyPair();

        }catch (Exception e){

            Logger.ERROR.log(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    //Sign using private key
    public static byte[] applyECDSASignature(PrivateKey privateKey, String input){
        try{

            Signature sig = Signature.getInstance("ECDSA");
            sig.initSign(privateKey);
            sig.update(input.getBytes(StandardCharsets.UTF_8));
            return sig.sign();

        }catch(Exception e){

            Logger.ERROR.log(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
    //Verify using public key
    public static boolean verifyECDSASignature(PublicKey publicKey, String input, byte[] signature){
        try{

            Signature verifier = Signature.getInstance("ECDSA");
            verifier.initVerify(publicKey);
            verifier.update(input.getBytes(StandardCharsets.UTF_8));
            return verifier.verify(signature);

        }catch(Exception e){
            Logger.ERROR.log(e.getMessage());
            e.printStackTrace();
            return false;
        }

    }
}
