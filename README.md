#  电商微服务系统骨架 Dubbo版本

```
基于 Spring Boot(2.2.2.RELEASE) Dubbo(2.7.5)搭建的电商微服务系统骨架
可无限扩展，高并发，系统解耦
```

### Requirements
- Java8+
- Mysql5.6+
- Redis
- RocketMq
- Zookeeper

#### Done
- 集成Spring Boot
- 整合Mybatis, Mybatis Generator
- 整合Dubbo
- 整合Redis
- 整合RocketMq
- Maven多模块
- 整合Response统一输出，方便Controller层使用
- 拆分多个系统blog, checkout, item, order, user
- GateWay接口签名

### Todo
- 登录模块/OAuth

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

### Samples
```
GET request: 
http://localhost:8090/order/get/15

POST request: 
http://localhost:8090/order/add

body:
{
    "consignee_id":1,
    "order_item_list":[
        {
            "item_id":1,
            "number":1
        },
        {
            "item_id":2,
            "number":2
        }
    ]
}

```

# License
The project is licensed under the BSD license.

### 微信公众号: 互联网技术的秘密 （intecsec）
![公众号](http://www.intecsec.com/wp-content/uploads/2020/06/intecsec_wechat.jpg)
### [官方网站: www.intecsec.com](http://www.intecsec.com)
### 个人微信号：sindoc
欢迎交流~
