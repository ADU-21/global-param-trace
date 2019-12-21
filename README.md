# Global param trace demo

This is a demo for enable global param via spring boot and trace via log.

# How to use
* Start server
```bash
mvn clean install    # Install dependencey
mvn spring-boot:run  # Start application 
```

* Test api
```bash
curl localhost:8080/user?id=1   # Should response user info
curl localhost:8080/user?id=4   # Should response error
```

* Check log file 
```bash
tail -f ~/global-param-trace/logs/application.log
```