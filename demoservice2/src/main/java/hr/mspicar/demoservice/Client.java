/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * HTTP Client (POST Method)
 * 
 */

@Service

public class Client {

    @Autowired
    Configuration customConfiguration;

    public Message Posalji(Message localMessage) {
	  
        try {
		URL url = new URL(customConfiguration.getUrlServicePath());
                
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = localMessage.toString();

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output = br.toString();
                
                localMessage.setMessageID(102);
                localMessage.setMessageDescription(output);
                        
		conn.disconnect();

	  } catch (MalformedURLException e) {

                localMessage.setMessageID(301);
                localMessage.setMessageDescription(e.getLocalizedMessage());

	  } catch (IOException e) {

                localMessage.setMessageID(302);
                localMessage.setMessageDescription(e.getLocalizedMessage());
	 }
      return localMessage;  
    } 
}
