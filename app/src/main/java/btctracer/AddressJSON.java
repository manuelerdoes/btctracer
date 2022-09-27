
package btctracer;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class AddressJSON {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("chain")
    @Expose
    private String chain;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("coinbase")
    @Expose
    private Boolean coinbase;
    @SerializedName("mintIndex")
    @Expose
    private Integer mintIndex;
    @SerializedName("spentTxid")
    @Expose
    private String spentTxid;
    @SerializedName("mintTxid")
    @Expose
    private String mintTxid;
    @SerializedName("mintHeight")
    @Expose
    private Integer mintHeight;
    @SerializedName("spentHeight")
    @Expose
    private Integer spentHeight;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("script")
    @Expose
    private String script;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("confirmations")
    @Expose
    private Integer confirmations;
    @SerializedName("sequenceNumber")
    @Expose
    private Long sequenceNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Boolean getCoinbase() {
        return coinbase;
    }

    public void setCoinbase(Boolean coinbase) {
        this.coinbase = coinbase;
    }

    public Integer getMintIndex() {
        return mintIndex;
    }

    public void setMintIndex(Integer mintIndex) {
        this.mintIndex = mintIndex;
    }

    public String getSpentTxid() {
        return spentTxid;
    }

    public void setSpentTxid(String spentTxid) {
        this.spentTxid = spentTxid;
    }

    public String getMintTxid() {
        return mintTxid;
    }

    public void setMintTxid(String mintTxid) {
        this.mintTxid = mintTxid;
    }

    public Integer getMintHeight() {
        return mintHeight;
    }

    public void setMintHeight(Integer mintHeight) {
        this.mintHeight = mintHeight;
    }

    public Integer getSpentHeight() {
        return spentHeight;
    }

    public void setSpentHeight(Integer spentHeight) {
        this.spentHeight = spentHeight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

}
