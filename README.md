# ngrok-java-client

* For example jitpack can be used to get the dependecy from a github repo:

```
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

* Include the dependency:

```
<dependency>
    <groupId>com.github.dmanchon</groupId>
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
