#                               TTMS影院管理系统

## 一 客户端

###A  顾客接口

#### a 顾客注册

##### 请求路径 /CustomersController/registered      注：前缀为 https://39.107.70.44:8080

##### 请求方法 ：post

##### 请求参数 （格式：不写默认为json）

| 参数名       | 含义   | 类型     | 备注              |
| --------- | ---- | ------ | --------------- |
| email     | 邮箱   | String | 与发送验整证码的邮箱为同一邮箱 |
| password  | 密码   | String |                 |
| name      | 用户名  | String |                 |
| checkcode | 验证码  | String | 通过访问邮箱验证接口获得    |

##### 返回参数



#### b顾客注册

#####请求路径 /CustomersController/customer

##### 请求方法 ：post

##### 请求参数 

| 参数名      | 含义    | 类型     | 备注   |
| -------- | ----- | ------ | ---- |
| email    | 邮箱    | String |      |
| password | 密码    | String |      |
| code     | 图片验证码 | String |      |

##### 返回参数

| 参数名   | 含义     | 备注        |
| ----- | ------ | --------- |
| id    | 用户id   |           |
| token | 加密后的密码 |           |
| error | 验证码错误  | 当验正码错误时返回 |



#### c查询个人信息

##### 请求路径 /CustomersController/query/id

##### 请求方法 ：Get

##### 请求示例 ：/CustomersController/query/1 id为用户id

##### 返回参数

~~~json
{
  "id":1,
 "name":"余耿凯",
 "password":"qweqwe",
 "image":"123",
 "email":"123"
}
~~~





### B 验证码

#### a通过邮箱验证

##### 请求路径 /codeController/getCheckCode

##### 请求方法 :Post

##### 请求参数

| 参数名   | 含义   | 类型     | 备注      |
| ----- | ---- | ------ | ------- |
| email | 邮箱   | String | 与登录邮箱一样 |

#### b生成验证码图片

##### 请求路径 /codeController/getCheckphoto

##### 请求方法： GET

### C 影院

#### a 保存影院

##### 请求路径 /cinemasController/cinemas   

##### 请求方法 ：post

##### 请求参数 

| 参数名            | 含义   | 类型      | 备注      |
| -------------- | ---- | ------- | ------- |
| cinemaId       | 影院Id | Integer | 默认为null |
| cinemaName     | 影院名  | String  |         |
| cinemaCity     | 所在城市 |         |         |
| cinemaCommuity | 所在区  |         |         |
| cinemaAddress  | 具体地址 |         |         |

#####返回参数 :无

####b 查询所有影厅

##### 请求路径  /cinemasController/cinemas

##### 请求方法 ：GET

##### 返回参数：(示例)

~~~json
[
  {
    "cinemaId":1,
  "cinemaName":"奥斯卡",
    "cinemaCity":"西安",
    "cinemaCommuity":"长安",
    "cinemaAddress":"邮电"
  },
  {
    "cinemaId":2,
    "cinemaName":"金逸",
    "cinemaCity":"耿耿",
    "cinemaCommuity":"guai",
    "cinemaAddress":"123"}]
~~~

#### c 查询单个影厅（根据影院id）

#####请求路径：/cinemasController/cinemasById/{id}

#####示例：/cinemasController/cinemasById/1

##### 请求方法：GET

##### 返回参数

~~~json
{"cinemaId":1,
 "cinemaName":"奥斯卡",
 "cinemaCity":"西安",
 "cinemaCommuity":"长安",
 "cinemaAddress":"邮电"
}
~~~

### D 影厅

#### a 根据影院Id查询影厅

##### 请求路径：/hallController/hall/{id}

#####示例：/hallController/hall/1

##### 返回参数(JSON集合)

~~~json
[
  {"hallSeats":123,//座位id
  "hallDescription":"1",//影厅描述
  "hallId":1,//影厅ID
  "cid":1 //对应的影院Id
 }]
~~~

### E 剧目演出安排

#### a查询所有的剧目安排

#####请求路径 /scheduleController/schedule

##### 请求方法 GET

##### 返回参数（集合）

```json
[
  {
    "scheduleId":2,//剧目id
  "mId":1, //电影id
  "hId":1, //影院id
  "schedulefee":12.33, //该剧目价格
  "schedulebegintime":"2019-05-15 18:40:52" //剧目开始时间
 }
]
```

#### b 根据电影Id查询出剧目安排

##### 请求路径 /scheduleController/schedulemannger/{mId}

##### 请求方法 GET

##### 返回参数  同上

#### c 根据影厅id查询剧目安排

#####请求路径：/scheduleController/schedulehall/{hId}

##### 请求方法 GET

##### 返回参数  同上

### F 查询座位

#### a根据影厅Id查询座位

#####请求路径 /seatController/seat/1

##### 请求方法 GET

##### 返回参数

```json
[{"seatId":1,"seatRow":1,"seatColumn":1,"seatState":2,"hId":1},{"seatId":2,"seatRow":2,"seatColumn":2,"seatState":1,"hId":1},{"seatId":3,"seatRow":4,"seatColumn":1,"seatState":1,"hId":1},{"seatId":4,"seatRow":3,"seatColumn":2,"seatState":1,"hId":1}]
```

#####b 修改座位状态

#####请求路径：/seatController/seat

#####请求方法 PUT 

##### 请求参数

| 参数名   | 含义   | 类型   | 备注              |
| ----- | ---- | ---- | --------------- |
| id    | 座位id | int  |                 |
| state | 座位状态 | int  | 1为代售，2为已预订，3为已卖 |

### G 订单

#### a 提交订单

##### 请求路径 /orderController/order

##### 请求方法 Post

##### 请求参数

| 参数名           | 含义      | 类型     | 备注            |
| ------------- | ------- | ------ | ------------- |
| orderId       | 订单id    | Int    | 默认为null       |
| customerId    | 用户id    | int    |               |
| sId           | 剧目安排的id | int    |               |
| orderFee      | 订单价钱    | double |               |
| orderState    | 订单状态    |        |               |
| buyDate       | 购买时间    | String |               |
| oId           | 订单id    | int    | null(以下是一个集合) |
| seatRow       | 座位行     |        |               |
| seatColumn    | 座位列     |        |               |
| orderDetailId | 订单详情id  |        | null          |

###### 示例

{

```json
    "orderId": null,
    "customerId": 1,
    "sId": 1,
    "orderFee": 11,
    "orderState": 1,
    "list": [
        {
            "oId": null,
            "seatRow": 12,
            "seatColumn": 12,
            "orderDetailId": null
        },
        {
            "oId": null,
            "seatRow": 1,
            "seatColumn": 11,
            "orderDetailId": null
        }
    ],
    "buyDate": null
}
```
#### b 根据顾客id查询

##### 请求路径： /orderController/order/{customerId}

##### 请求方法 GET

#####返回参数  同上请求参数

#### c根据剧目安排Id获取所有订单

##### 请求路径： /orderController/schedule/{sId}

##### 请求方法 GET

##### 返回参数  同上请求参数

#### d修改订单

##### 请求路径： /orderController/update

##### 请求方法 put

##### 请求参数  同上请求参数 

#### e更改订单状态

#####请求路径 /orderController/updateState 

##### 请求方法：PUT

##### 请求参数：form表单提交

| 参数    | 含义   | 类型   | 备注          |
| ----- | ---- | ---- | ----------- |
| id    | 订单id | int  |             |
| state | 状态   | int  | 1为未支付，2为已支付 |

#### f 删除订单

##### 请求路径 /orderController/order

##### 请求方法 ：delete

##### 请求参数：form表单提交 

| 参数   | 含义   | 类型   | 备注   |
| ---- | ---- | ---- | ---- |
| id   | 订单id | int  |      |

###H 电影

#### a 查找根据状态查找电影的电影

##### 请求路径： /movieController/movie/{state}

#####请求方法 GET

##### 请求参数

| 参数    | 含义   | 类型   | 备注              |
| ----- | ---- | ---- | --------------- |
| state | 状态   | int  | 1为未上映，2热播中，3以下架 |

### I 评论

#### a 提交评论

##### 请求路径 /evaluateController/evaluate

##### 请求方法 ：Post

##### 请求参数

| 参数              | 含义   | 类型     | 备注    |
| --------------- | ---- | ------ | ----- |
| evaluateId      | 评论id | int    | 为null |
| cId;            | 顾客id |        |       |
| mId             | 电影id |        |       |
| evaluateContext | 评论内容 | String |       |
| evaluateRole    | 评论登记 | int    |       |

#### b 删除评论

##### 请求路径 /evaluateController/evaluate

##### 请求方法 ：delete

##### 请求参数 （form表单提交）

| 参数   | 含义   | 类型   | 备注   |
| ---- | ---- | ---- | ---- |
| id   | 评论id | int  |      |

#### c 根据顾客Id获取评论

#####请求路径 /evaluateController/evaluatec/{cId} 

##### 返回参数

~~~json
[
  {
    "evaluateId":2,
    "cId":1,
    "mId":null,
    "evaluateContext":null,
    "evaluateRole":null
  }
]
~~~

#### d 根据电影Id获取评论

##### 请求路径 /evaluateController/evaluatem/{mId}

##### 返回参数  同上



## 二 服务端

### A 影院

#### a 保存影院

##### 请求路径 /cinemasController/cinemas

##### 请求方法 ：post

##### 请求参数

| 参数名            | 含义   | 类型      | 备注      |
| -------------- | ---- | ------- | ------- |
| cinemaId       | 影院Id | Integer | 默认为null |
| cinemaName     | 影院名  | String  |         |
| cinemaCity     | 所在城市 |         |         |
| cinemaCommuity | 所在区  |         |         |
| cinemaAddress  | 具体地址 |         |         |

##### 返回参数 :无

### B 影厅

#### a 保存影厅

##### 请求路径  /hallController/hall

##### 请求方法 ：Post

##### 请求参数

```json
{"hallSeats":123,//座位id

  "hallDescription":"1",//影厅描述

  "hallId":1,//影厅ID 为null

  "cid":1 //对应的影院Id

 }


```

#### b 修改影厅

##### 请求路径  /hallController/hall

##### 请求方法 ：Put

##### 请求参数

```json
{"hallSeats":123,//座位id

  "hallDescription":"1",//影厅描述

  "hallId":1,//影厅ID 为null

  "cid":1 //对应的影院Id

 }


```

### C 电影

#### a 保存电影

##### 请求路径 :/movieController/movie

##### 请求方法：Post

##### 请求参数

| 参数               | 含义   | 类型     | 备注              |
| ---------------- | ---- | ------ | --------------- |
| movieId          | 电影id | int    | null            |
| movieName        | 电影名  | string |                 |
| movieType        | 电影类型 |        |                 |
| movieDirect      | 导演   |        |                 |
| movieActor       | 演员   |        |                 |
| movieDescription | 介绍   |        |                 |
| movieAlltime     | 总时长  |        |                 |
| movieState       | 状态   | int    | 1为未上映，2为上映，3为下架 |

#### b 修改电影或状态

##### 请求路径 :/movieController/movie

##### 请求方法：Put

##### 请求参数

| 参数               | 含义   | 类型     | 备注              |
| ---------------- | ---- | ------ | --------------- |
| movieId          | 电影id | int    |                 |
| movieName        | 电影名  | string |                 |
| movieType        | 电影类型 |        |                 |
| movieDirect      | 导演   |        |                 |
| movieActor       | 演员   |        |                 |
| movieDescription | 介绍   |        |                 |
| movieAlltime     | 总时长  |        |                 |
| movieState       | 状态   | int    | 1为未上映，2为上映，3为下架 |

#### b 删除电影

##### 请求路径 :/movieController/movie

##### 请求方法：delete

##### 请求参数(表单提交)

| 参数   | 含义   | 类型   | 备注   |
| ---- | ---- | ---- | ---- |
| id   | 电影id | int  |      |

### D 演出

#### a 提交演出

##### 请求路径 /scheduleController/schedule

##### 请求方法 post

##### 请求参数

| 参数                | 含义   | 类型     | 备注   |
| ----------------- | ---- | ------ | ---- |
| scheduleId        | id   | int    | null |
| mId               | 电影id |        |      |
| hId               | 影厅id |        |      |
| schedulefee       | 票价   | double |      |
| schedulebegintime | 开始时间 | string |      |



#### b 修改演出

##### 请求路径 /scheduleController/schedule

##### 请求方法 put

##### 请求参数

| 参数                | 含义   | 类型     | 备注   |
| ----------------- | ---- | ------ | ---- |
| scheduleId        | id   | int    |      |
| mId               | 电影id |        |      |
| hId               | 影厅id |        |      |
| schedulefee       | 票价   | double |      |
| schedulebegintime | 开始时间 | string |      |

#### c 删除该影院的演出

##### 请求路径 /scheduleController/schedule

##### 请求方法 delete

##### 请求参数(form表单提交)

| 参数   | 含义   | 类型   | 备注   |
| ---- | ---- | ---- | ---- |
| id   | 影院id | int  |      |

### E 座位

####a 保存座位

##### 请求路径 /seatController/seat

##### 请求方法 post

##### 请求参数（json集合

| 参数         | 含义   | 类型   | 备注   |
| ---------- | ---- | ---- | ---- |
| seatId     | 座位id | int  | null |
| seatRow    | 座位行  |      |      |
| seatColumn | 座位列  |      |      |
| seatState  | 座位列  |      |      |
| hId        | 影厅id |      |      |

### 

#### b 修改座位状态

##### 请求路径 /seatController/seat

##### 请求方法 put

##### 请求参数

| 参数     | 含义   | 类型   | 备注   |
| ------ | ---- | ---- | ---- |
| seatId | 座位id | int  |      |
| state  | 状态   | int  |      |

#### c 删除座位

##### 请求路径 /seatController/seat

##### 请求方法delete

##### 请求参数

| 参数     | 含义   | 类型   | 备注   |
| ------ | ---- | ---- | ---- |
| seatId | 座位id | int  |      |









 数据库建表语句

```sql
顾客表
create table customers(
  id int(11) primary key auto_increment,
  name varchar(255) not null,
  password varchar(255) not null,
  image varchar(255) not null,
  email varchar(255) not null
);
订单表
create table ttms_order(
 order_id int(11) primary key auto_increment,
  customer_id int(11),
  s_id int(11),
  order_fee int(11),
  order_buydate datetime,
  order_state int(1),
  foreign key(s_Id) references ttms_schedule(schedule_id),
  foreign key(customer_Id) references customers(id)
);
订单详情表
create table ttme_orderdetal(
  o_id int(11),
  seat_row int(11),
  seat_column int(11),
  foreign key(o_id) references ttms_order(order_id)
);

管理员表
create table managers(
  id int(11)  primary key auto_increment,
  name varchar(255) not null,
  password varchar(255) not null,
  email varchar(255) not null,
  image varchar(255) not null,
  role int not null,
  class_id int(11),
  foreign key(class_id) references cinemas(cinema_id));
 
影院表
create table cinemas(
  cinema_id int(11) primary key auto_increment,
  cinema_name varchar(255) not null,
  cinema_city varchar(255),
  cinema_commuity varchar(255),
  cinema_address varchar(255)
);
影厅表
create table ttms_hall(
 hall_Id int(11) primary key auto_increment,
  c_Id int (11),
  hall_Seats int(11) unique,
  hall_Description varchar(255),
  foreign key(c_Id) references cinemas(cinema_id)
);
座位表
create table ttms_seat(
seat_Id int(11),
  seat_row int(11),
  seat_column int(11),
  seat_state int(11),
  foreign key(seat_Id) references ttms_hall(hall_id)
);
影厅日程表
create table ttms_schedule(
schedule_id int(11) primary key auto_increment,
  m_id int(11),
  h_id int(11),
  schedule_fee int(11),
  schedule_begintime datetime,
  foreign key(h_id) references ttms_hall(hall_id),
  foreign key(m_id) references ttms_movie(movie_id)
);
电影表
create table ttms_movie(
  movie_id int (11) primary key auto_increment,
  movie_name varchar(255),
  movie_type varchar(255),
  movie_direct varchar(255),
  movie_actor varchar(255),
  movie_description varchar(255),
  movie_alltime varchar(255)
);
评论表
create table ttms_evaluate(
  evaluate_id int(11) primary key auto_increment,
  c_id int(11),
  m_id int(11),
  evaluate_context varchar(255),
  evaluate_role int(1),
  foreign key(c_id) references customers(id),
  foreign key(m_id) references ttms_movie(movie_id)
);

```

