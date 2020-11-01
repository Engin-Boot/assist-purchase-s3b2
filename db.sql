create database philips_product;
use philips_product;
create table product(id int NOT NULL PRIMARY KEY AUTO_INCREMENT,name varchar(600) NOT NULL,price int NOT NULL,is_wireless varchar(600) NOT NULL,is_touchscreen varchar(600) NOT NULL,is_interoperable varchar(600) NOT NULL);
insert into product(name,price,is_wireless,is_touchscreen,is_interoperable) values("IntelliVue MX500",25000,"true","true","false");
insert into product(name,price,is_wireless,is_touchscreen,is_interoperable) values("IntelliBridge EC10",35000,"false","true","false");
insert into product(name,price,is_wireless,is_touchscreen,is_interoperable) values("IntelliComm",45000,"true","true","true");
insert into product(name,price,is_wireless,is_touchscreen,is_interoperable) values("IntellivUE E1C",25000,"true","false","false");
