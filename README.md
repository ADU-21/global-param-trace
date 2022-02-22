# Global param trace demo

This is a demo for enable global param via spring boot and trace via log.

Blog: https://www.duyidong.com/2019/12/21/spring-boot-log-trace/

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
curl -X POST -H 'User-Id:1' -H 'Trace-Id:123' -H 'Content-Type: application/json' -d '{"name":"John"}' localhost:8080/user # add new user, should response 4
curl -X POST -H 'User-Id:1' -H 'Trace-Id:123' -H 'Content-Type: application/json' -d '{"name":"John"}' localhost:8080/user # add new user, should response permission deney
curl -H 'User-Id:4' -H 'Trace-Id:123' localhost:8080/user   # Should response user with name John after add user success
```

* Check log file 
```bash
tail -f ~/global-param-trace/logs/application.log
```
