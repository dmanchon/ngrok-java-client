/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.dmanchon.ngrok.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author dmanchon
 */
public class NgrokTunnel {
    public static String url;
    private String name;
    private final String ngrokAddr;
    
    public NgrokTunnel(String url, int port) throws UnirestException {
        this.name = UUID.randomUUID().toString();
        this.ngrokAddr = url;
        String payload = String.format(
                "{"
                    + "\"addr\":\"%d\", "
                    + "\"name\":\"%s\", "
                    + "\"proto\":\"http\", "
                    + "\"bind_tls\":\"false\"" +
                "}"
                , port, name);
                
        HttpResponse<JsonNode> jsonResponse = Unirest.post(ngrokAddr.concat("/api/tunnels"))
            .header("accept", "application/json")
            .header("Content-Type", "application/json; charset=utf8")
            .body(payload)
            .asJson();
        
        this.url = jsonResponse.getBody().getObject().getString("public_url");
    }
    
    public  NgrokTunnel(int port) throws UnirestException {        
        this("http://127.0.0.1:4040", port);        
    }
        
    public void close() throws IOException, UnirestException {
        HttpResponse<String> resp = Unirest.delete(ngrokAddr.concat("/api/tunnels/test")).asString();
    }    
}
