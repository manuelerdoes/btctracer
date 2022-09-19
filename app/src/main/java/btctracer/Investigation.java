package btctracer;

import java.util.ArrayList;

public class Investigation {
  private Search search;
  private int depth;
  private double flaggedAmount;

  public Investigation(Search search, int depth) {
    this.search = search;
    this.depth = depth;
    flaggedAmount = 0;
  }

  public void flagTransactions() {
    ArrayList<Transaction> l = search.getIncomingTransactions();
    double sum = 0;
    for (Transaction t : l) {
      sum += t.getTotalBTCAmount();
    }
    flaggedAmount = sum;
  }
}
