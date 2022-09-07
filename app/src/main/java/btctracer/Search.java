package btctracer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Search {
  private String address;
  private int depth;

  private ArrayList<Transaction> transactions;
  private HashMap<Transaction, Boolean> transactionMap; // true -> incoming
  private String[] OGTransactionHashes; // outgoing
  private String[] ICTransactionHashes; // incoming

  public Search(String address) {
    this.address = address;
    transactions = new ArrayList<Transaction>();
    transactionMap = new HashMap<Transaction, Boolean>();
    AddressJSON[] aj = DataRetriever.getAddressJSONObject(address);
    for (int i = 0; i < aj.length; i++) {
      getTransactionObject(aj[i].getMintTxid(), true);
      getTransactionObject(aj[i].getSpentTxid(), false);
    }
    ajArrayToTransactionList(aj);
  }

  public void addTransactionToArrayList(Transaction t) {
    transactions.add(t);
  }

  public void ajArrayToTransactionList(AddressJSON[] aj) {
    for (int i = 0; i < aj.length; i++) {
      if (aj[i].getSpentTxid() != null) {
        OGTransactionHashes[i] = aj[i].getSpentTxid();
      }
      if (aj[i].getMintTxid() != null) {
        ICTransactionHashes[i] = aj[i].getMintTxid();
      }
    }
  }

  public void getTransactionObject(String hash, Boolean incoming) { // true -> incoming
    Transaction t = new Transaction(hash);
    TransactionJSON tj = DataRetriever.getTransactionJSONObject(hash);

    if (tj.getInputs() != null) { // avoid null pointer exception if for some reason no data was received
      for (int u = 0; u < tj.getInputs().size(); u++) {
        t.addSender(tj.getInputs().get(u).getMintTxid(), tj.getInputs().get(u).getValue());
      }
    }

    if (tj.getOutputs() != null) { // same as above
      for (int p = 0; p < tj.getOutputs().size(); p++) {
        t.addReceiver(tj.getOutputs().get(p).getAddress(), tj.getOutputs().get(p).getValue());
      }
    }

    transactions.add(t);
    transactionMap.put(t, incoming);
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

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public ArrayList<Transaction> getIncomingTransactions() {
    ArrayList<Transaction> t = new ArrayList<Transaction>();
    for (Map.Entry<Transaction, Boolean> entry : transactionMap.entrySet()) {
      if (entry.getValue()) {
        t.add(entry.getKey());
      }
    } 
    return t;
  }

  public ArrayList<Transaction> getOutgoingTransactions() {
    ArrayList<Transaction> t = new ArrayList<Transaction>();
    for (Map.Entry<Transaction, Boolean> entry : transactionMap.entrySet()) {
      if (!entry.getValue()) {
        t.add(entry.getKey());
      }
    } 
    return t;
  }

}
