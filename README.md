#  Spring Boot Dubbo Demo

```
基于 Spring Boot 最新版的演示项目
```

#### Done
- 集成Spring Boot
- 整合Mybatis, Mybatis Generator
- 整合Dubbo
- 整合Redis
- 整合RocketMq
- Maven多模块
- 整合Reponse统一输出，方便Controller层使用
- 拆分多个系统blog, checkout, item, order, user
- gateway接口签名

### Todo
- 整合Shiro/Spring Security

### Require Components
- Zookeeper
- Mysql
- Redis
- RocketMq

### Application Port

App | web |  dubbo  
-:|-:|-:
blog-app | 8083 | 20803 |
checkout-app | 8084 | 20804 |
item-app | 8085 | 20805 |
order-app | 8086 | 20806 |
user-app | 8087 | 20807 |
gateway | 8090 | - |

### Run Application
``` shell
mvn clean install

java -jar blog-app/target/blog-app-1.0-SNAPSHOT.jar
java -jar user-app/target/user-app-1.0-SNAPSHOT.jar
java -jar item-app/target/item-app-1.0-SNAPSHOT.jar
java -jar order-app/target/order-app-1.0-SNAPSHOT.jar
java -jar gateway/target/gateway-1.0-SNAPSHOT.jar

```



[微信公众号: intecsec](http://www.intecsec.com)
