### add mongo connection to intellij VM options before running the app
-Dspring.data.mongodb.username=fake user name 
-Dspring.data.mongodb.password=fake password
-Dspring.data.mongodb.host=fake host 
-Dspring.data.mongodb.port=xxxxx 
-Dspring.data.mongodb.database=fake database 
-Dspring.data.mongodb.retryWrites=false

### add JWT secret to intellij VM options before running the app
-Dsecurity.jwt.token.secret-key=secret