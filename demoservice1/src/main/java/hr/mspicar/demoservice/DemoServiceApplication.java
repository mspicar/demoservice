/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import java.io.IOException;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Poruka (REST servisa)
 * 
 */
@SpringBootApplication
public class DemoServiceApplication {

    @Autowired
    Configuration customConfiguration;

    @Bean
    public RestTemplate getRestTemplate() {

            RestTemplate restTemplate = new RestTemplate();

            HttpComponentsClientHttpRequestFactory requestFactory = null;

            try {
                    KeyStore trustStore = KeyStore.getInstance(customConfiguration.getClientTrustStoreType());
                    trustStore.load(DemoServiceApplication.class.getClassLoader().getResourceAsStream(customConfiguration.getClientTrustStore()), customConfiguration.getClientTrustStorePwd().toCharArray());

                    KeyStore keyStore = KeyStore.getInstance(customConfiguration.getClientKeyStoreType());
                    keyStore.load(DemoServiceApplication.class.getClassLoader().getResourceAsStream(customConfiguration.getClientKeyStore()), customConfiguration.getClientKeyStorePwd().toCharArray());

                    SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder()
                                    .setProtocol("TLSv1.2")
                                    .loadTrustMaterial(trustStore,null)
                                    .loadKeyMaterial(keyStore, customConfiguration.getClientKeyStorePwd().toCharArray()).build(), NoopHostnameVerifier.INSTANCE);

                    HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory)
                                    .setMaxConnTotal(5)
                                    .setMaxConnPerRoute(5)
                                    .build();

                    requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
                    requestFactory.setReadTimeout(10000);
                    requestFactory.setConnectTimeout(10000);

                    restTemplate.setRequestFactory(requestFactory);

            } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException exception) {
                    System.out.println("Exception Occured while creating restTemplate "+exception);
            }
            return restTemplate;
    }


    public static void main(String[] args) {
            SpringApplication.run(DemoServiceApplication.class, args);
    }
}
