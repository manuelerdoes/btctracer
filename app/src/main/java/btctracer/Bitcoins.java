package btctracer;

public class Bitcoins {
  private Double amount;
  private Boolean flagged;

  public Bitcoins(Double amount, Boolean flagged) {
    this.amount = amount;
    this.flagged = flagged;
  }

  public Double getAmount() {
    return amount;
  }

  public Boolean getFlagged() {
    return flagged;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public void minusAmount(Double amount) {
    this.amount -= amount;
  }

  public void setFlagged() {
    flagged = true;
  }
}
