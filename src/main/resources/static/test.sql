drop database if exists basic;
create database if not exists basic;
use basic;

drop table if exists color;
create table if not exists color(
	id int auto_increment,
	name varchar(35),
	primary key(id)
);

drop table if exists enterprise;
create table if not exists enterprise(
	id int auto_increment,
	name varchar(35),
	primary key(id)
);
drop table if exists material;
create table if not exists material(
	id int  auto_increment,
	name varchar(35),
	primary key(id)
);

drop table if exists category;
create table if not exists category(
 	id int auto_increment,
	name varchar(35),
	primary key(id)
);

drop table if exists product;
create table product(
	id int auto_increment,
	code varchar(35),
	name varchar(35),
	material_id int,	
	category_id int,
	enterprise_id int,
	primary key(id),
	foreign key(material_id) references material(id),
	foreign key(category_id) references category(id),
	foreign key(enterprise_id) references enterprise(id)
);

drop table if exists product_item;
create table if not exists product_item(
	id int auto_increment,
	code varchar(35),	
	size varchar(2),
	price decimal(15,2),	

	color_id int,
	product_id int,

	primary key(id),
	foreign key(color_id) references color(id),
	foreign key(product_id) references product(id)
);

drop table if exists user;
create table user(
	id int auto_increment,
	name varchar(35),
	primary key(id)	
);


drop table if exists cart;
create table cart(
	id int auto_increment,
	user_id int,
	primary key(id),
	foreign key(user_id) references user(id)
);

drop table if exists item_cart;
create table item_cart(
	id int auto_increment,
	quantity int,
	discount decimal(13,2),
	
	primary key(id),	
	cart_id int,
	foreign key(cart_id) references cart(id)
);

drop table if exists inventory;
create table if not exists inventory(
	id int auto_increment,
	quantity int,
	date DATE default(CURRENT_DATE),
	product_item_id int,
	primary key(id),
	
	foreign key(product_item_id) references product_item(id)
); 


