package btctracer;

import java.util.ArrayList;

public class Level {
  private int depth;
  private ArrayList<Transi> transactions;
  private ArrayList<Wallet> wallets;

  public Level(int depth) {
    this.depth = depth;
    transactions = new ArrayList<Transi>();
    wallets = new ArrayList<Wallet>();
  }

  public void flagTransactions() {
    for (Transi t : transactions) {
      Wallet parent = t.getPapa();
      for (Bitcoins b : t.getStack()) {
        if (parent.hasValue()) {
          parent.takeFromStore(b.getAmount());
        }
      }
    }
  }

  private boolean transactionExists(Transi t) {
    for (Transi tu : transactions) {
      if (t.getHash().contains(tu.getHash())) {
        return true;
      }
    }
    return false;
  }

  private boolean walletExists(Wallet w) {
    for (Wallet wu : wallets) {
      if (w.getAddress().contains(wu.getAddress())) {
        return true;
      }
    }
    return false;
  }

  public void addTransaction(Transi t) {
    if (!transactionExists(t)) {
      transactions.add(t);
    }
  }

  public void loadTransactionsFromLevel(Level l) {
    for (Transi t : l.getTransactions()) {
      addTransaction(t);
    }
  }

  public void loadWalletsFromLevel(Level l) {
    for (Wallet w : l.getWallets()) {
      addWallet(w);
    }
  }

  public void addWallet(Wallet w) {
    if (!walletExists(w)) {
      wallets.add(w);
      if (w.getTotalValue() > 0) {
        Handler.output += "wallet: " + w.getPapa().getPapa().getAddress() + " -> tx: " + w.getPapa().getHash() + " -> wallet: " + w.getAddress() + " => " + w.getTotalValue()
            + "\n";
      }
    }
  }

  public Transi getTransaction(String hash) {
    for (Transi t : transactions) {
      if (t.getHash().contains(hash)) {
        return t;
      }
    }
    return null;
  }

  public Wallet getWallet(String address) {
    for (Wallet w : wallets) {
      if (w.getAddress().contains(address)) {
        return w;
      }
    }
    return null;
  }

  public boolean isEmpty() {
    boolean b = false;
    if (transactions.isEmpty()) {
      b = true;
    }
    if (wallets.isEmpty()) {
      b = true;
    }
    return b;
  }

  public boolean hasNoTransactions() {
    return transactions.isEmpty();
  }

  public boolean hasNoWallets() {
    return wallets.isEmpty();
  }

  public ArrayList<Transi> getTransactions() {
    return transactions;
  }

  public ArrayList<Wallet> getWallets() {
    return wallets;
  }

  public ArrayList<Wallet> getWallets(Transi papa) {
    ArrayList<Wallet> ws = new ArrayList<Wallet>();
    for (Wallet w : wallets) {
      if (w.getPapa() == papa) {
        ws.add(w);
      }
    }
    return ws;
  }

  public int getDepth() {
    return depth;
  }

  public void flagAllTransCoins() {
    for (Transi t : transactions) {
      t.flagAllCoins();
    }
  }

}
