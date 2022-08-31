package btctracer;

import java.util.ArrayList;

public class Search {
  private String address;
  private int depth;

  private ArrayList<Transaction> transactions;
  private String[] transactionHashes;

  public Search(String address) {
    this.address = address;
    transactions = new ArrayList<Transaction>();
    AddressJSON[] aj = DataRetriever.getAddressJSONObject(address);
    System.out.println(aj[1].getSpentTxid());
  }

  public void addTransactionToArrayList(Transaction t) {
    transactions.add(t);
  }

  public void ajArrayToTransactionList(AddressJSON[] aj) {
    for (int i = 0; i < aj.length; i++) {
     transactionHashes[i] = aj[i].getSpentTxid();
    }
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
