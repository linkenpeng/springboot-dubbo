```
在这个开源的时代，贡献一点点源代码，也许一名有点点追求的程序员必经的一个阶段，
本项目主要是想帮助那些初创电商项目，做一些基础的架构演示，
只需要设计好数据库，生成mapper层代码后，做少量的修改，就可以在上面进行各种逻辑开发。
```

### 本开源项目的特点
1. 简单
1. 支持高并发
1. 支持低耦合
1. 可无限扩展
1. 开箱即用


### Requirements
- Java8+
- Mysql5.6+
- Redis
- RocketMq
- Zookeeper

#### Done
- 集成Spring Boot(2.2.2.RELEASE)
- 整合Mybatis, Mybatis Generator
- 整合Dubbo(2.7.5)
- 整合Redis
- 整合RocketMq
- Maven多模块
- 整合Response统一输出，方便Controller层使用
- 拆分多个系统blog, checkout, item, order, user
- GateWay接口签名

### Todo
- 登录模块(OAuth2.0, JWT等)
- 配置中心（Diamond/Apollo)

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

# 项目地址
[https://github.com/linkenpeng/springboot-dubbo](https://github.com/linkenpeng/springboot-dubbo)

欢迎star，欢迎fork，欢迎合作

### 官方微信公众号: 互联网技术的秘密 （intecsec）
![公众号](http://www.intecsec.com/wp-content/uploads/2020/06/intecsec_wechat.jpg)
### [官方网站: www.intecsec.com](http://www.intecsec.com)
### 个人微信号：sindoc
欢迎交流~
