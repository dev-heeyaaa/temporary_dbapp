<<<<<<< HEAD
#DBAPP~

###데이터베이스 생성 방법
```sql

CREATE USER 'korea'@'%' IDENTIFIED BY 'korea1234';
GRANT ALL PRIVILEGES ON *.* TO 'korea'@'%';
CREATE DATABASE koreadb;
=======
# DBAPP

### 데이터베이스 생성 방법
```sql
create user 'korea'@'%' identified by 'korea1234';
GRANT ALL PRIVILEGES ON *.* TO 'korea'@'%';
create database koreadb;
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
```

### 추가 의존성
```xml
<dependency>
<<<<<<< HEAD
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>9.0.46</version>
=======
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>9.0.46</version>
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
</dependency>

<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

<<<<<<< HEAD
###JSTL  태그 라이브러리
=======
### JSTL 태그 라이브러리
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

<<<<<<< HEAD
###application.yml
=======
### application.yml
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
```yml
server:
  port: 8000
  servlet:
    encoding:
<<<<<<< HEAD
      charset:  UTF-8
=======
      charset: UTF-8
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
      
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
<<<<<<< HEAD
  
=======
      
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    username: korea
    password: korea1234
    url: jdbc:mysql://localhost:3306/koreadb
    
  jpa:
    hibernate:
<<<<<<< HEAD
      ddl-auto: none #create,update,none(서비스 배포할때 none사용)
    show-sql: true
```

###sql 쿼리문 -더미데이터
```sql
INSERT INTO user(username,PASSWORD) VALUES('ssar','1234');
INSERT INTO user(username,PASSWORD) VALUES('cos','1234');

SELECT *FROM user;

INSERT INTO post(title,content,user_id) VALUES('제목1','내용1',1);
INSERT INTO post(title,content,user_id) VALUES('제목2','내용2',1);
INSERT INTO post(title,content,user_id) VALUES('제목3','내용3',1);
INSERT INTO post(title,content,user_id) VALUES('제목4','내용4',2);
INSERT INTO post(title,content,user_id) VALUES('제목5','내용5',2);

SELECT *FROM post;
```
=======
      ddl-auto: none # create, update, none
    show-sql: true
```
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
