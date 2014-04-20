package com.mss.livesmart.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;

import com.mss.livesmart.sampledata.CurStatus;

import android.content.Intent;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class Communicator extends AsyncTask<String, Integer, String> {

    // Log tag
    private static final String TAG = "Communicator";

    private AndroidHttpClient hc; 
    private int reqType;
    private String message;
    private String url;
    private Object extra;

    public Communicator(AndroidHttpClient hc,   
            int reqType, String message, String url, Object extra){
        super();

        this.hc = hc; 
        this.reqType = reqType;
        this.message = message;
        this.url = url;
        this.extra = extra;
    }

    public AndroidHttpClient getHc() {
        return hc;
    }

    public void setHc(AndroidHttpClient hc) {
        this.hc = hc;
    }
 

    public void start(){
        this.execute(message);
    }

    protected void onPreExecute() {
        //Don't do anything here
    }

    protected String doInBackground(String... req) {

        Log.d(TAG, "Message to send: "+req[0]);
        HttpPost p = new HttpPost(url);

        try{
            p.setEntity(new StringEntity(req[0], "UTF8"));
        }catch(Exception e){
            e.printStackTrace();
        }
        p.setHeader("Content-type", "application/json");

        String response = "";
        try{
            HttpResponse resp = hc.execute(p);
            InputStream is = resp.getEntity().getContent();
            response = convertStreamToString(is);
            Log.d("Response", "Response is " + response);

            Log.d("Status line", ""+resp.getStatusLine().getStatusCode());
        } catch (Exception e){
            e.printStackTrace();
        }

        if(reqType==0){
        	CurStatus.setRecomMutex(1);
        	CurStatus.setRecom(response);
        }
        
        return response;
     }

     protected void onProgressUpdate(Integer... progress) {
         // dont handle this yet
     }

     @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    protected void onPostExecute(String result) {
         Log.d("task", "task finished"); 
     }
 

     private String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {        
            return "";
        }
     }
}
