package btctracer;

public class Transaction {
  private String senderAddress;
  private String receiverAddress;
  private Double btcAmount;

  public Transaction(String sender, String receiver, Double amount) {
    senderAddress = sender;
    receiverAddress = receiver;
    btcAmount = amount;
  }
  
  public String getSenderAddress() {
    return this.senderAddress;
  }

  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }

  public String getReceiverAddress() {
    return this.receiverAddress;
  }

  public void setReceiverAddress(String receiverAddress) {
    this.receiverAddress = receiverAddress;
  }

  public Double getBtcAmount() {
    return this.btcAmount;
  }

  public void setBtcAmount(Double btcAmount) {
    this.btcAmount = btcAmount;
  }



}
