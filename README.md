# ngrok-java-client

* Add the github repo to maven:

```
    <repositories>
        <repository>
             <id>git-dmanchon</id>
             <name>dmanchon's Git based repo</name>
             <url>https://github.com/dmanchon/ngrok-java-client/raw/master/</url>
         </repository>
    </repositories>
```

* Include the dependency:

```
    <dependency>
       <groupId>xyz.dmanchon</groupId>
        <artifactId>ngrok-java-client</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>
```

* Start ngrok:

```
$ ngrok start --none
```

* Usage:

```
    ...
    import xyz.dmanchon.ngrok.client.NgrokTunnel;
    ...

    //Start tunnel, ngrok address is default
    NgrokTunnel tunnel = new NgrokTunnel(8080);

    //Start tunnel, explicit ngrok address
    NgrokTunnel tunnel = new NgrokTunnel("http://127.0.0.1:4040", 8080);

    ...
    
    //Get the public url:
    String url = tunnel.url();

    //Close the tunnel:
    tunnel.close();



```