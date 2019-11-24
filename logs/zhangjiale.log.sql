2019-09-05 16:36:35,798 [http-nio-8888-exec-1] ==>  Preparing: select id, name, account_id, token, gmt_create, gmt_moditify from user WHERE ( token = ? ) 
2019-09-05 16:36:35,831 [http-nio-8888-exec-1] ==> Parameters: a10ee9cc-fdc7-477d-9c12-7b83345332d4(String)
2019-09-05 16:36:35,843 [http-nio-8888-exec-1] <==      Total: 0
2019-09-05 16:36:38,131 [http-nio-8888-exec-3] ==>  Preparing: select id, name, account_id, token, gmt_create, gmt_moditify from user WHERE ( token = ? ) 
2019-09-05 16:36:38,137 [http-nio-8888-exec-3] ==> Parameters: a10ee9cc-fdc7-477d-9c12-7b83345332d4(String)
2019-09-05 16:36:38,142 [http-nio-8888-exec-3] <==      Total: 0
2019-09-05 22:48:59,322 [http-nio-8888-exec-5] ==>  Preparing: insert into user (id, name, account_id, token, gmt_create, gmt_moditify ) values (?, ?, ?, ?, ?, ? ) 
2019-09-05 22:48:59,423 [http-nio-8888-exec-5] ==> Parameters: null, 为了辛多雷的荣耀(String), 48975250(String), ac33bca9-91aa-44f1-bb92-d616d4db5632(String), 1567694938967(Long), 1567694938967(Long)
2019-09-05 22:48:59,458 [http-nio-8888-exec-5] <==    Updates: 1
2019-09-05 22:48:59,592 [http-nio-8888-exec-6] ==>  Preparing: select id, name, account_id, token, gmt_create, gmt_moditify from user WHERE ( token = ? ) 
2019-09-05 22:48:59,593 [http-nio-8888-exec-6] ==> Parameters: ac33bca9-91aa-44f1-bb92-d616d4db5632(String)
2019-09-05 22:48:59,622 [http-nio-8888-exec-6] <==      Total: 1
2019-09-05 22:52:36,563 [http-nio-8888-exec-1] ==>  Preparing: select id, name, account_id, token, gmt_create, gmt_moditify from user WHERE ( token = ? ) 
2019-09-05 22:52:36,627 [http-nio-8888-exec-1] ==> Parameters: ac33bca9-91aa-44f1-bb92-d616d4db5632(String)
2019-09-05 22:52:36,678 [http-nio-8888-exec-1] <==      Total: 1
2019-09-05 22:53:11,498 [http-nio-8888-exec-4] ==>  Preparing: select id, name, account_id, token, gmt_create, gmt_moditify from user WHERE ( token = ? ) 
2019-09-05 22:53:11,504 [http-nio-8888-exec-4] ==> Parameters: ac33bca9-91aa-44f1-bb92-d616d4db5632(String)
2019-09-05 22:53:11,512 [http-nio-8888-exec-4] <==      Total: 1
