#!/bin/bash
cd /media/sf_share/software-architecture/java_project
mvn clean package
cd /media/sf_share/software-architecture/java_project/user-parent/user-app/target
nohup java -jar user-app-0.0.1-SNAPSHOT.jar >> /dev/null 2>&1 &
nohup java -jar user-app-0.0.1-SNAPSHOT.jar --server.port=8081 >> /dev/null 2>&1 & 
