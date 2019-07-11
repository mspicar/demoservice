/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * HTTP Client (POST Method)
 * 
 */

@Service

public class RESTClient {

    @Autowired
    Configuration customConfiguration;
    
    @Autowired
    RestTemplate restTemplate;

    public Message sendMessage(Message localMessage)
    {
        final String uri = customConfiguration.getUrlServicePath();

        Message result = restTemplate.postForObject( uri, localMessage, Message.class);

        return result;
    }   
    
}
