package btctracer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class DataRetriever {
  private InputStreamReader addressData;
  private InputStreamReader transactionData;

  public InputStreamReader getAddressData(String address) {
    String API_URL2 = "https://api.bitcore.io/api/BTC/mainnet/address/" + address;
    try {
      URL url = new URL(API_URL2);
      HttpURLConnection request;
      do {
      request = (HttpURLConnection)url.openConnection();
      request.connect();
      } while (request.getResponseCode() == 429);
      return new InputStreamReader((InputStream) request.getContent());
    } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public InputStreamReader getTransactionData(String hash) {
    String API_URL2 = "https://api.bitcore.io/api/BTC/mainnet/tx/" + hash + "/coins";
    try {
      URL url = new URL(API_URL2);
      HttpURLConnection request;
      do {
      request = (HttpURLConnection)url.openConnection();
      request.connect();
      } while (request.getResponseCode() ==429);
      return new InputStreamReader((InputStream) request.getContent());
    } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void storeAddressData(String address) {
    addressData = getAddressData(address);
  }

  public void storeTransactionData(String hash) {
    transactionData = getTransactionData(hash);
  }

/*   public void printStoredData() {
    if (addressData != null) {
      try {
        BufferedReader bf = new BufferedReader(addressData);
        String line;
        while (true) {
          line = bf.readLine();
          if (line == null) {
            break;
          }
          System.out.println(line);
        }
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
  */

  public String storedAddressDataToString() {
    if (addressData != null) {
      String output = new String();
      try {
        BufferedReader bf = new BufferedReader(addressData);
        String line;
        while (true) {
          line = bf.readLine();
          if (line == null) {
            break;
          }
          output = output + line;
        }
        return output;

      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
    return null;
  } 

  public String storedTransactionDataToString() {
    if (transactionData != null) {
      String output = new String();
      try {
        BufferedReader bf = new BufferedReader(transactionData);
        String line;
        while (true) {
          line = bf.readLine();
          if (line == null) {
            break;
          }
          output = output + line;
        }
        return output;

      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
    return null;
  } 

  public static AddressJSON[] getAddressJSONObject(String address) {
    DataRetriever dr = new DataRetriever();
    dr.storeAddressData(address);
    String json = dr.storedAddressDataToString();
    Gson gson = new Gson();
    return gson.fromJson(json, AddressJSON[].class);
  }

  public static TransactionJSON getTransactionJSONObject(String hash) {
    DataRetriever dr = new DataRetriever();
    dr.storeTransactionData(hash);
    String json = dr.storedTransactionDataToString();
    Gson gson = new Gson();
    return gson.fromJson(json, TransactionJSON.class);
  }
}
