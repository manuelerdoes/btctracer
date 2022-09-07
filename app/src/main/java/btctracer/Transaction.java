package btctracer;

import java.util.HashMap;

public class Transaction {
  private String txHash;
  private HashMap<String, Double> sender;
  private HashMap<String, Double> receiver;
  private Double totalBTCAmount;


  public Transaction(String txHash) {
    this.txHash = txHash;
    sender = new HashMap<String, Double>();
    receiver = new HashMap<String, Double>();
  }

  public void addSender(String address, Double amount) {
    sender.put(address, amount);
  }

  public void addReceiver(String address, Double amount) {
    receiver.put(address, amount);
    calcTotalAmount();
  }

  public String getHash() {
    return txHash;
  }

  public void calcTotalAmount() {
    Double total = 0.0;
    for (Double i : receiver.values()) {
      total += i;
    }
    totalBTCAmount = total;
  }

  public Double getTotalBTCAmount() {
    return totalBTCAmount;
  }
  

}
