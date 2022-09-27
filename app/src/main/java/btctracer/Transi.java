package btctracer;

import java.util.ArrayList;

public class Transi {
  private String hash;
  private ArrayList<Bitcoins> stack;
  private Wallet papa;

  public Transi(String hash, Wallet papa) {
    this.hash = hash;
    this.papa = papa;
    stack = new ArrayList<Bitcoins>();
  }

  public void addBitcoins(Bitcoins btc) {
    stack.add(btc);
  }

  public void addToStack(ArrayList<Bitcoins> alb) {
    if (alb != null) {
      for (Bitcoins b : alb) {
        stack.add(b);
      }
    }
  }

  public ArrayList<Bitcoins> takeFromStack(Double amount) {
    ArrayList<Bitcoins> alb = new ArrayList<Bitcoins>();
    if (!stack.isEmpty()) {
      Double num = stack.get(0).getAmount();
      if (amount < num) {
        stack.get(0).minusAmount(amount);
        if (stack.get(0).getFlagged()) {
          alb.add(new Bitcoins(amount, true));
        } else {
          alb.add(new Bitcoins(amount, false));
        }
      } else if (amount == num) {
        if (stack.get(0).getFlagged()) {
          shiftstack();
          alb.add(new Bitcoins(amount, true));
        } else {
          shiftstack();
          alb.add(new Bitcoins(amount, false));
        }
      } else if (amount > num) {
        do {
          alb.add(stack.get(0));
          shiftstack();
          amount -= num;
          if (stack.size() <= 0) {
            break;
          }
          num = stack.get(0).getAmount();
        } while (amount >= num);
      }
    } else {
      return null;
    }
    return alb;
  }

  // private Double calcAmountFromList(ArrayList<Bitcoins> alb) {
  //   Double num = 0.0;
  //   for (Bitcoins b : alb) {
  //     num += b.getAmount();
  //   }
  //   return num;
  // }

  private void shiftstack() {
    for (int i = 1; i < stack.size(); i++) {
      Bitcoins oldValue = stack.get(i);
      stack.set(i - 1, oldValue);
    }
    stack.remove(stack.size() - 1);
  }

  public String getHash() {
    return hash;
  }

  public ArrayList<Bitcoins> getStack() {
    return stack;
  }

  public Double getTotalValue() {
    Double num = 0.0;
    for (Bitcoins b : stack) {
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
    for (Bitcoins b : stack) {
      b.setFlagged();
    }
  }

  public ArrayList<Bitcoins> getFlaggedCoins() {
    ArrayList<Bitcoins> al = new ArrayList<Bitcoins>();
    for (Bitcoins b : stack) {
      if (b.getFlagged()) {
        al.add(b);
      }
    }
    return al;
  }

  public Wallet getPapa() {
    return papa;
  }
}
