/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * Konfiguracija aplikacije 
 * 
 * Atributi spremljeni u application.properties datoteci
 * 
 */

@org.springframework.context.annotation.Configuration

@PropertySource("classpath:application.properties")

@ConfigurationProperties(prefix = "custom")

public class Configuration {

    private String urlServicePath;
    private String serviceVersion;
    private String clientKeyStoreType;
    private String clientKeyStore;
    private String clientKeyStorePwd;
    private String clientTrustStoreType;
    private String clientTrustStore;
    private String clientTrustStorePwd;

    public Configuration() {
    }

    public String getUrlServicePath() {
        return urlServicePath;
    }

    public void setUrlServicePath(String urlServicePath) {
        this.urlServicePath = urlServicePath;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getClientKeyStoreType() {
        return clientKeyStoreType;
    }

    public void setClientKeyStoreType(String clientKeyStoreType) {
        this.clientKeyStoreType = clientKeyStoreType;
    }

    public String getClientKeyStore() {
        return clientKeyStore;
    }

    public void setClientKeyStore(String clientKeyStore) {
        this.clientKeyStore = clientKeyStore;
    }

    public String getClientKeyStorePwd() {
        return clientKeyStorePwd;
    }

    public void setClientKeyStorePwd(String clientKeyStorePwd) {
        this.clientKeyStorePwd = clientKeyStorePwd;
    }

    public String getClientTrustStoreType() {
        return clientTrustStoreType;
    }

    public void setClientTrustStoreType(String clientTrustStoreType) {
        this.clientTrustStoreType = clientTrustStoreType;
    }

    public String getClientTrustStore() {
        return clientTrustStore;
    }

    public void setClientTrustStore(String clientTrustStore) {
        this.clientTrustStore = clientTrustStore;
    }

    public String getClientTrustStorePwd() {
        return clientTrustStorePwd;
    }

    public void setClientTrustStorePwd(String clientTrustStorePwd) {
        this.clientTrustStorePwd = clientTrustStorePwd;
    }
}