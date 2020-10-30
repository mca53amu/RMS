# RMS
Rate Management system(RMS) in Logisc domain
to authenticate
{
    "username":"javainuse",
    "password":"password"
}


docker run -d -p 6033:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=book_manager" mysql
docker build -f Dockerfile -t retail-management-system .
1
docker run -t --link docker-mysql:mysql -p 8080:8080 retail-management-system

#https://dzone.com/articles/all-about-hibernate-manytomany-association


web sequence diagram

title Retail Management System

User->Logging Fileter: Authentication \n Request
note right of Logging Fileter:Generate Log Id
Logging Fileter ->Auth:
Auth->Validator: Validate\nInput
Validator->controller:Authenticate\nUser
controller->Service:
Service->repo:
note right of repo:H2 Database
repo->Service:
Service->controller:
controller->User: JWT Token
User->Validator: Requet with valid token
note right of Validator:validate \n Input fields
Validator->controller:Invoke method
controller->Service:Request Object
Service->repo:
note right of repo: H2 Database
repo->Service:Entity Object
Service->controller:Reponse Object
controller ->Validator: Response
Validator->User:Response
