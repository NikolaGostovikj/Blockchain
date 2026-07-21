package blockchain.block;

public class Node {

    private final String id;
    private final int port;
    private final Wallet wallet;
    private final Blockchain blockchain;

    public Node(String id, int port, Wallet wallet, Blockchain blockchain) {
        this.id = id;
        this.port = port;
        this.wallet = wallet;
        this.blockchain = blockchain;
    }


    public int getPort() {
        return port;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getId() {
        return id;
    }
}
