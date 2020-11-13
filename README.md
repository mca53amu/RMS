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
#Rate Management System
![Alt Text](https://github.com/mca53amu/RMS/blob/main/Rate%20Management%20System.png)


https://dzone.com/articles/all-about-hibernate-manytomany-association

