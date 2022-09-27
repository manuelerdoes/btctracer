package btctracer;

import java.util.ArrayList;

public class Handler {
  private String rootAddress;
  private Wallet root;
  private Level l_0;
  private ArrayList<Level> levels;
  public static String output;

  public Handler(String rootAddress, int depth) {
    this.rootAddress = rootAddress;
    root = new Wallet(rootAddress, null);
    levels = new ArrayList<Level>();
    output += "\nLevel 0\n";
    output += "----------\n";
    l_0 = loadOutgoingTx(root, 0);
    l_0.flagAllTransCoins();
    levels.add(l_0);

    for (Transi t : l_0.getTransactions()) {
      l_0.loadWalletsFromLevel(loadWallets(t, 0));
    }

    for (int i = 1; i <= depth; i++) {
      output += "\nLevel " + i + "\n";
      output += "----------\n";
      Level l = new Level(i);
      for (Wallet w : levels.get(i - 1).getWallets()) {
        l.loadTransactionsFromLevel(loadOutgoingTx(w, i));
      }
      for (Transi t : l.getTransactions()) {
        l.loadWalletsFromLevel(loadWallets(t, i));
      }
      levels.add(l);
    }

  }

  private Level loadOutgoingTx(Wallet w, int depth) {
    Level l = new Level(depth);
    String walletAddress = w.getAddress();
    try {
      AddressJSON[] aj = DataRetriever.getAddressJSONObject(walletAddress);

      for (int i = 0; i < aj.length; i++) {
        if (aj[i].getSpentTxid().matches("[a-zA-Z0-9]+")) { // check if there really is a tx hash
          l.addTransaction((new Transi(aj[i].getSpentTxid(), w)));
          if (w == root) {
            l.getTransaction(aj[i].getSpentTxid()).addBitcoins(new Bitcoins(aj[i].getValue() / 100000000, false));
          } else {
            l.getTransaction(aj[i].getSpentTxid()).addToStack(w.takeFromStore(aj[i].getValue() / 100000000));
          }
        }
      }

      if (l.hasNoTransactions()) {
        //System.out.println("nothing to follow.");
        //output += "nothing to follow. exiting..\n";
        //System.exit(0);
      }
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
    return l;
  }

  private Level loadWallets(Transi t, int depth) {
    Level l = new Level(depth);
    String txHash = t.getHash();
    try {
      TransactionJSON tj = DataRetriever.getTransactionJSONObject(txHash);

      for (Output o : tj.getOutputs()) {
        if (o.getAddress().matches("[a-zA-Z0-9]+") && !o.getAddress().contains("false")) { // check if there really is
                                                                                           // an address
          l.addWallet((new Wallet(o.getAddress(), t)));
          l.getWallet(o.getAddress()).addToStore(t.takeFromStack(o.getValue() / 100000000));
        }
      }
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
    return l;
  }

  public String getRootAddress() {
    return rootAddress;
  }

  public Wallet getRoot() {
    return root;
  }
}
