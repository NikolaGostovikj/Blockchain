package blockchain.block;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Blockchain {

    private List<Block> blockchain = new CopyOnWriteArrayList<>();

    public Blockchain() {

    }

    public void createGenesisBlock() {

    }

    public synchronized boolean addBlock(Block block) {
            if(blockchain.contains(block)) {
                return false;
            }
            //if (block is not valid)


        blockchain.add(block);
        return true;
    }

    public void removeBlock(Block block) {

    }

    public synchronized List<Block> getChain() {

        if(blockchain.isEmpty()) {
            Logger.INFO.log("Blockchain is empty and nothing to do");
            return null;
        }
        return blockchain;

    }

    public Block getLastBlock() {

        if(blockchain.isEmpty()) {
            Logger.INFO.log("Blockchain is empty");
            return null;
        }

        return blockchain.get(blockchain.size() - 1);
    }



}
