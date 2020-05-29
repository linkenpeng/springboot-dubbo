#!/usr/bin/env bash

mvn clean install

java -jar blog-app/target/blog-app-1.0-SNAPSHOT.jar
java -jar user-app/target/user-app-1.0-SNAPSHOT.jar
java -jar item-app/target/item-app-1.0-SNAPSHOT.jar
java -jar order-app/target/order-app-1.0-SNAPSHOT.jar
java -jar gateway/target/gateway-1.0-SNAPSHOT.jar