drop database if exists basic;
create database if not exists basic;
use basic;

drop table if exists color;
create table if not exists color(
	id int auto_increment,
	name varchar(35),
	primary key(id)
);

insert into color(name)values("acero");
insert into color(name)values("negro");
insert into color(name)values("beish");
insert into color(name)values("azul_marino");
insert into color(name)values("rojo");
insert into color(name)values("cemento");
insert into color(name)values("melach");
insert into color(name)values("negro");

drop table if exists enterprise;
create table if not exists enterprise(
	id int auto_increment,
	name varchar(35),
	primary key(id)
);
insert into enterprise(name)values("generico");
insert into enterprise(name)values("adidas");
insert into enterprise(name)values("nike");

drop table if exists material;
create table if not exists material(
	id int  auto_increment,
	name varchar(35),
	primary key(id)
);
insert into material(name)values("algodon");
insert into material(name)values("sintetico");
insert into material(name)values("rip");
insert into material(name)values("franela");


drop table if exists category;
create table if not exists category(
 	id int auto_increment,
	name varchar(35),
	primary key(id)
);

insert into category(name)values("pantalon_joggers");
insert into category(name)values("pantolon_jeans");
insert into category(name)values("pantolon_jeans_baggi");
insert into category(name)values("pantolon_jeans_palazo");
insert into category(name)values("pantolon_jeans_moon");
insert into category(name)values("pantolon_jeans_clasico");
insert into category(name)values("polera_abierta");
insert into category(name)values("polera_cerrada");

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

insert into product(name,material_id,category_id,enterprise_id)values("BASIC",3,7,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,1,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,2,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,3,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,4,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,5,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,6,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,7,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,8,1);

select product.name, material.name, category.name, enterprise.name, size, price, color.name  from product_item
    inner join product on product.id = product_item.product_id
    inner join material on material.id = product.material_id
    inner join category on category.id = product.category_id
    inner join enterprise on enterprise.id = product.enterprise_id
    inner join color on color.id = product_item.color_id;

select * from inventory;

drop table if exists user;
create table user(
	id int auto_increment,
	name varchar(35),
	primary key(id)	
);

insert into user(name)values("jazzmin");
insert into user(name)values("glimer");

drop table if exists cart;
create table cart(
	id int auto_increment,
	user_id int,
	primary key(id),
	foreign key(user_id) references user(id)
);

insert into cart(user_id)values(1);

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

delimiter //
create trigger set_random_number_product before insert on product
	for each row
	begin
		set NEW.code = floor(RAND() * 10000000000);
	end //


delimiter //
create trigger set_random_number_product_item before insert on product_item
	for each row
	begin
		set NEW.code = floor(RAND() * 10000000000);
	end //

delimiter //
create trigger add_inventory before insert on product_item
    for each row
    begin
        insert into inventory(quantity,product_item_id)values(0,LAST_INSERT_ID());
    end //


