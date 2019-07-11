/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * REST CONTROLLER (ENDPOINTS)
 * 
 */

@RestController
@RequestMapping("/Demo")

public class RESTServer {

    @Autowired 
    Client customClient;

    @Autowired 
    Configuration customConfiguration;
    
    @Autowired
    RESTClient restClient;

    public RESTServer() {
    }

    @RequestMapping("/Verzija")
    public Message Verzija ()
    {
        Message localMessage = new Message();
        
        localMessage.setMessageID(100);
        localMessage.setMessageDescription(customConfiguration.getServiceVersion());

        return localMessage;
    }    

    @RequestMapping(value="/Salji", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public Message Salji(@RequestBody Message localRequest)
    {
        
        Message localMessage = new Message();
        
        localMessage = restClient.sendMessage(localRequest);

// *****************************************************************************
//      Ovo je druga implementacija klijenta (HttpClient)
//
//      localMessage = customClient.Posalji(localRequest);
        
        return localMessage;
    }    
    
    @RequestMapping(value="/Primaj", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public Message Posalji(@RequestBody Message localRequest)
    {
        // Ispišem na konzolu što sam primio !
        
        System.out.println("Primio sam : " + localRequest.toString());

        // Vratim što sam primio !
        
        Message localMessage = new Message();
        
        localMessage.setMessageID(500);
        localMessage.setMessageDescription("Servis 1 - primio : " + localRequest.toString());
        
        return localMessage;
    }    
    
}
