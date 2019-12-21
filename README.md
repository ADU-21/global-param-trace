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
curl -H 'User-Id:1' -H 'Trace-Id:123' localhost:8080/user   # Should response user info
curl -H 'User-Id:4' -H 'Trace-Id:123' localhost:8080/user   # Should response error
```

* Check log file 
```bash
tail -f ~/global-param-trace/logs/application.log
```