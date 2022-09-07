package btctracer;

public class Investigation {
  private Search search;
  private int depth;

  public Investigation(Search search, int depth) {
    this.search = search;
    this.depth = depth;
  }

  public void flagTransactions() {
    search.getIncomingTransactions();
  }
}
