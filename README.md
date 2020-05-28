#  Spring Boot Dubbo Demo

```
基于 Spring Boot 最新版的演示项目
```

#### Done
- 集成Spring Boot
- 整合Mybatis, Mybatis Generator
- 整合Dubbo
- 整合Redis
- 整合RocketMQ
- 整合Sentinel
- Maven多模块
- 整合Reponse统一输出，方便Controller层使用
- 拆分多个系统blog, checkout, item, order, user
- gateway接口签名

### Todo
- 整合Shiro/Spring Security

### 各应用对应的web端口

```
blog-app 
web: 8083
dubbo: 20803

checkout-app
web: 8084
dubbo: 20804

item-app
web: 8085
dubbo: 20805

order-app
web: 8086
dubbo: 20806

user-app
web: 8087
dubbo: 20807

gateway
web: 8090
dubbo:
```

应用 | web端口 |  dubbo端口  
-|-|-
blog-app | 8083 | 20803 |
checkout-app | 8084 | 20804 |
item-app | 8085 | 20805 |
order-app | 8086 | 20806 |
user-app | 8087 | 20807 |
gateway | 8090 | - |


[微信公众号: intecsec](http://www.intecsec.com)
