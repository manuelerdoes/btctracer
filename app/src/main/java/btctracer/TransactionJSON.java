package btctracer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionJSON {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("txid")
@Expose
private String txid;
@SerializedName("network")
@Expose
private String network;
@SerializedName("chain")
@Expose
private String chain;
@SerializedName("blockHeight")
@Expose
private Integer blockHeight;
@SerializedName("blockHash")
@Expose
private String blockHash;
@SerializedName("blockTime")
@Expose
private String blockTime;
@SerializedName("blockTimeNormalized")
@Expose
private String blockTimeNormalized;
@SerializedName("coinbase")
@Expose
private Boolean coinbase;
@SerializedName("locktime")
@Expose
private Integer locktime;
@SerializedName("inputCount")
@Expose
private Integer inputCount;
@SerializedName("outputCount")
@Expose
private Integer outputCount;
@SerializedName("size")
@Expose
private Integer size;
@SerializedName("fee")
@Expose
private Integer fee;
@SerializedName("value")
@Expose
private Integer value;
@SerializedName("confirmations")
@Expose
private Integer confirmations;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTxid() {
return txid;
}

public void setTxid(String txid) {
this.txid = txid;
}

public String getNetwork() {
return network;
}

public void setNetwork(String network) {
this.network = network;
}

public String getChain() {
return chain;
}

public void setChain(String chain) {
this.chain = chain;
}

public Integer getBlockHeight() {
return blockHeight;
}

public void setBlockHeight(Integer blockHeight) {
this.blockHeight = blockHeight;
}

public String getBlockHash() {
return blockHash;
}

public void setBlockHash(String blockHash) {
this.blockHash = blockHash;
}

public String getBlockTime() {
return blockTime;
}

public void setBlockTime(String blockTime) {
this.blockTime = blockTime;
}

public String getBlockTimeNormalized() {
return blockTimeNormalized;
}

public void setBlockTimeNormalized(String blockTimeNormalized) {
this.blockTimeNormalized = blockTimeNormalized;
}

public Boolean getCoinbase() {
return coinbase;
}

public void setCoinbase(Boolean coinbase) {
this.coinbase = coinbase;
}

public Integer getLocktime() {
return locktime;
}

public void setLocktime(Integer locktime) {
this.locktime = locktime;
}

public Integer getInputCount() {
return inputCount;
}

public void setInputCount(Integer inputCount) {
this.inputCount = inputCount;
}

public Integer getOutputCount() {
return outputCount;
}

public void setOutputCount(Integer outputCount) {
this.outputCount = outputCount;
}

public Integer getSize() {
return size;
}

public void setSize(Integer size) {
this.size = size;
}

public Integer getFee() {
return fee;
}

public void setFee(Integer fee) {
this.fee = fee;
}

public Integer getValue() {
return value;
}

public void setValue(Integer value) {
this.value = value;
}

public Integer getConfirmations() {
return confirmations;
}

public void setConfirmations(Integer confirmations) {
this.confirmations = confirmations;
}

}
