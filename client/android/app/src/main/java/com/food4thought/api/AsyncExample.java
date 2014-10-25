package com.food4thought.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class AsyncExample extends AsyncTask<Void, Void, String> {
  
  private AsyncRequestDelegate delegate;
  private String params;
  
  public AsyncExample(String params, AsyncRequestDelegate delegate) {
    this.params = params;
    this.delegate = delegate;
  }
  
  private String request() throws IOException {
        String url = "http://162.13.46.62/db_recipe_request.php";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("POST");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes("state=" + params);
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //return result
        return response.toString();
    }
  
  @Override
  protected String doInBackground(Void... params) {
    String result;
    try {
      result = request();
    } catch (IOException e) {
      result = null;
    }
    return result;
  }
  
  @Override
  protected void onPostExecute(String result) {
    if (result == null) {
      delegate.failure();
    } else {
      delegate.success(result);
    }
  }

}