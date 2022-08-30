package btctracer;

import java.util.ArrayList;

public class Search {
  private String address;
  private int depth;

  private ArrayList<Transaction> transactions;

  public Search(String address) {
    this.address = address;
    transactions = new ArrayList<Transaction>();
  }

  public void addTransactionToArrayList(Transaction t) {
    transactions.add(t);
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getDepth() {
    return this.depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

}
