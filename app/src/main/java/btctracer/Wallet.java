package btctracer;

import java.util.ArrayList;

public class Wallet {
  private String address;
  private ArrayList<Bitcoins> store;
  private Transi papa;

  public Wallet(String address, Transi papa) {
    this.address = address;
    this.papa = papa;
    store = new ArrayList<Bitcoins>();
  }

  public void addToStore(Double amount, Boolean flagged) {
    amount = amount / 100000000;
    Bitcoins btc = new Bitcoins(amount, flagged);
    store.add(btc);
  }

  public void addToStore(ArrayList<Bitcoins> alb) {
    if (alb != null) {
      for (Bitcoins b : alb) {
        store.add(b);
      }
    }
  }

  public ArrayList<Bitcoins> takeFromStore(Double amount) {
    ArrayList<Bitcoins> alb = new ArrayList<Bitcoins>();
    if (!store.isEmpty()) {
      Double num = store.get(0).getAmount();
      if (amount < num) {
        store.get(0).minusAmount(amount);
        if (store.get(0).getFlagged()) {
          alb.add(new Bitcoins(amount, true));
        } else {
          alb.add(new Bitcoins(amount, false));
        }
      } else if (amount == num) {
        if (store.get(0).getFlagged()) {
          shiftStore();
          alb.add(new Bitcoins(amount, true));
        } else {
          shiftStore();
          alb.add(new Bitcoins(amount, false));
        }
      } else if (amount > num) {
        do {
          alb.add(store.get(0));
          shiftStore();
          amount -= num;
          if (store.size() <= 0) {
            break;
          }
          num = store.get(0).getAmount();
        } while (amount >= num);
      }
    } else {
      return null;
    }
    return alb;
  }

  private void shiftStore() {
    for (int i = 1; i < store.size(); i++) {
      Bitcoins oldValue = store.get(i);
      store.set(i - 1, oldValue);
    }
    store.remove(store.size() - 1);
  }

  public String getAddress() {
    return address;
  }

  public Double getTotalValue() {
    Double num = 0.0;
    for (Bitcoins b : store) {
      num += b.getAmount();
    }
    return num;
  }

  public boolean hasValue() {
    if (getTotalValue() <= 0) {
      return false;
    }
    return true;
  }

  public void flagAllCoins() {
    for (Bitcoins b : store) {
      b.setFlagged();
    }
  }

  public Transi getPapa() {
    return papa;
  }
}
