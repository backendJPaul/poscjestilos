insert into user(name)values("pticlavilca");
insert into user(name)values("cleon");
insert into user(name)values("jjafac");
insert into user(name)values("grosberi");

insert into category(name)values("Accesorios");
insert into category(name)values("Básicos");
insert into category(name)values("Blazers");
insert into category(name)values("Blusas y camisas");
insert into category(name)values("Camisas");
insert into category(name)values("Casacas y abrigos");
insert into category(name)values("Chompas y cárdigans");
insert into category(name)values("Correas");
insert into category(name)values("Faldas");
insert into category(name)values("Jeans");
insert into category(name)values("Joggers");
insert into category(name)values("Medias");
insert into category(name)values("Mochilas");
insert into category(name)values("Pantalones");
insert into category(name)values("Pantys");
insert into category(name)values("Pijamas");
insert into category(name)values("Poleras");
insert into category(name)values("Poleras");
insert into category(name)values("Polos");
insert into category(name)values("Polos y tops");
insert into category(name)values("Ropa de Cama");
insert into category(name)values("Ropa de maternidad");
insert into category(name)values("Ropa deportiva");
insert into category(name)values("Ropa formal");
insert into category(name)values("Ropa interior");
insert into category(name)values("Shorts");
insert into category(name)values("Toallas");
insert into category(name)values("Toys");
insert into category(name)values("Vestidos");
insert into category(name)values("Zapatos");
insert into category(name)values("Polo Manga larga");


insert into brand(name)values("Aaron");
insert into brand(name)values("Damaris");
insert into brand(name)values("Disney");
insert into brand(name)values("Guinier");
insert into brand(name)values("KLEY");
insert into brand(name)values("Lee");
insert into brand(name)values("Paw Patrol");
insert into brand(name)values("Pioner");
insert into brand(name)values("Quasila");
insert into brand(name)values("Generico");

insert into color(name)values("acero");
insert into color(name)values("amarillo");
insert into color(name)values("azul");
insert into color(name)values("azul_marino");
insert into color(name)values("azulino");
insert into color(name)values("beige");
insert into color(name)values("blanco");
insert into color(name)values("camello");
insert into color(name)values("celeste");
insert into color(name)values("cristal");
insert into color(name)values("fuccia");
insert into color(name)values("hielo");
insert into color(name)values("intermedio ");
insert into color(name)values("jade");
insert into color(name)values("lila");
insert into color(name)values("marron");
insert into color(name)values("morado");
insert into color(name)values("negro");
insert into color(name)values("palo_rosa");
insert into color(name)values("plomo");
insert into color(name)values("plomo_rata");
insert into color(name)values("rojo");
insert into color(name)values("rosado");
insert into color(name)values("topo");
insert into color(name)values("verde_agua");
insert into color(name)values("verde_botella");
insert into color(name)values("verde_esmeralda");
insert into color(name)values("verde_militar");

insert into product(name, color, size, sale_price, buy_price, genre,brand_id, category_id) values ("trenzas delgado","negro","M",18.00,10.00,"M",10,15);
insert into product(name, color, size, sale_price, buy_price, genre,brand_id, category_id) values ("lino delgado","negro","M",18.00,10.00,"M",10,15);
insert into product(name, color, size, sale_price, buy_price, genre,brand_id, category_id) values ("trenzas delgado","negro","M",18.00,10.00,"M",10,15);

insert into product(name, size, sale_price, buy_price, genre, category_id) values ("colchas color entero","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values ("colchas con diseño","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values ("edredon con carnero con diseño","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values("top tira rayas","S",10,5.00,"M",21);

select *
from product inner join brand on product.brand_id = brand.id  inner join category on product.category_id = category.id;

/*inventory*/

drop table if exists inventory;
create table if not exists inventory(
                                        id int auto_increment primary key,
                                        beginning_available_quantity int,
                                        date_updated timestamp default current_timestamp,

                                        product_id int,
                                        foreign key(product_id) references product(id)
    );

describe inventory;

insert into inventory(beginning_available_quantity, product_id) values (1,1);
insert into inventory(beginning_available_quantity, product_id) values (1,2);
insert into inventory(beginning_available_quantity, product_id) values (1,3);
insert into inventory(beginning_available_quantity, product_id) values (1,4);
insert into inventory(beginning_available_quantity, product_id) values (1,5);
insert into inventory(beginning_available_quantity, product_id) values (22,8);
insert into inventory(beginning_available_quantity, product_id) values (37,9);
insert into inventory(beginning_available_quantity, product_id) values (37,9);
insert into inventory(beginning_available_quantity, product_id) values (6,10);
insert into inventory(beginning_available_quantity, product_id) values (2,11);

select inventory.id, product.id, product.name, product.color, product.genre, brand.name, category.name, product.size, inventory.beginning_available_quantity, inventory.date_updated
from inventory inner join product on inventory.product_id = product.id  inner join brand on brand.id = product.brand_id inner join category on category.id = product.category_id;

/*sale*/

drop table if exists sale;
create table if not exists sale(
                                   id int auto_increment primary key,
                                   date_updated timestamp default current_timestamp,
                                   quantity_sold int,
                                   discount decimal(7, 2),

    user_id int,
    foreign key (user_id) references user(id),

    inventory_id int,
    foreign key (inventory_id) references inventory (id)
    );

select *
from sale inner join inventory on sale.inventory_id = inventory.id inner join product on inventory.product_id = product.id;

/*triggers*/

delimiter //
create trigger refresh_stock
    after insert on sale
    for each row
begin
    update inventory
    set beginning_available_quantity = beginning_available_quantity - NEW.quantity
    where product_id = NEW.product_id;
end //

describe inventory;

describe inventory;
drop trigger add_inventory;
delimiter //
create trigger add_inventory
    after insert on product
    for each row
begin
    insert into inventory(date_update,beginning_available_quantity, product_id) values (CURRENT_TIMESTAMP,NEW.id);
end //

insert into sale(quantity_sold, discount, user_id, inventory_id) values(1,0.50,1,3);
insert into sale(inventory_id, quantity_sold, discount,date_updated) values (1,1,0.50,now());


select * from inventory;

create view  view_sale as
select sale.id, inventory.name, inventory.brand, inventory.beginning_available_quantity, inventory.size, inventory.sale_price, inventory.buy_price, sale.discount , inventory.sale_price - sale.discount as total, (inventory.sale_price - sale.discount) - inventory.buy_price as ganacnia   from sale inner join inventory on sale.inventory_id = inventory.id where sale.date_updated between '2024-05-08 00:00:00' and '2024-05-08 22:00:00';

select  sum(ganacnia) as total  from view_sale;

/*TODO
  store procedure add field in inventory after new field in the product table


 */

drop database if exists toys;
create database if not exists toys;
use toys;

/*user*/
drop table if exists user;
create table if not exists user(
                                   id int auto_increment primary key,
                                   username varchar(35),
    password varchar(35) default "12345678"
    );

insert into user(username)values("pticlavilca");
insert into user(username)values("cleon");
insert into user(username)values("jjafac");
insert into user(username)values("grosberi");

/*category*/

drop table if exists category;
create table if not exists category(
                                       id int auto_increment primary key,
                                       name varchar(35)
    );

insert into category(name)values("Accesorios");
insert into category(name)values("Basicos");
insert into category(name)values("Básicos");
insert into category(name)values("Blazers");
insert into category(name)values("Blusas y camisas");
insert into category(name)values("Camisas");
insert into category(name)values("Casacas y abrigos");
insert into category(name)values("Chompas y cárdigans");
insert into category(name)values("Correas");
insert into category(name)values("Faldas");
insert into category(name)values("Jeans");
insert into category(name)values("Joggers");
insert into category(name)values("Medias");
insert into category(name)values("Mochilas");
insert into category(name)values("Pantalones");
insert into category(name)values("Pantys");
insert into category(name)values("Pijamas");
insert into category(name)values("Poleras");
insert into category(name)values("Poleras");
insert into category(name)values("Polos");
insert into category(name)values("Polos y tops");
insert into category(name)values("Ropa de Cama");
insert into category(name)values("Ropa de maternidad");
insert into category(name)values("Ropa deportiva");
insert into category(name)values("Ropa formal");
insert into category(name)values("Ropa interior");
insert into category(name)values("Shorts");
insert into category(name)values("Toallas");
insert into category(name)values("Toys");
insert into category(name)values("Vestidos");
insert into category(name)values("Zapatos");
insert into category(name)values("Polo Manga larga");


/*brand*/

drop table if exists brand;
create table if not exists brand(
                                    id int auto_increment primary key,
                                    name varchar(35)
    );

insert into brand(name)values("Aaron");
insert into brand(name)values("Damaris");
insert into brand(name)values("Disney");
insert into brand(name)values("Guinier");
insert into brand(name)values("KLEY");
insert into brand(name)values("Lee");
insert into brand(name)values("Paw Patrol");
insert into brand(name)values("Pioner");
insert into brand(name)values("Quasila");
insert into brand(name)values("Generico");


/*product*/

drop table if exists product;
create table if not exists product(
                                      id int auto_increment primary key,
                                      name varchar(35),
    color varchar(35) default "ninguno",
    size varchar(10) default "standart",
    sale_price decimal(7,2),
    buy_price decimal(7,2),
    genre varchar(2),

    brand_id int default 10,
    foreign key(brand_id) references brand(id),

    category_id int default 32,
    foreign key(category_id) references category(id)
    );

/*
genre
H, M, MK, HK, MB, HB
NG no genre
*/

insert into product(name, color, size, sale_price, buy_price, genre, category_id) values ("trenzas delgado","negro","M",18.00,10.00,"M",15);
insert into product(name, color, size, sale_price, buy_price, genre, category_id) values ("trenzas delgado","melanch","M",18.00,10.00,"M",15);
insert into product(name, color, size, sale_price, buy_price, genre, category_id) values ("trenzas delgado","acero","M",18.00,10.00,"M",15);
insert into product(name, color, size, sale_price, buy_price, genre, category_id) values ("trenzas delgado","marron","M",18.00,10.00,"M",15);
insert into product(name, color, size, sale_price, buy_price, genre, category_id) values ("trenzas delgado","rosado","M",18.00,10.00,"M",15);
insert into product(name, size, sale_price, buy_price, genre, category_id) values ("colchas color entero","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values ("colchas con diseño","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values ("edredon con carnero con diseño","M",20.00,14.50,"NG",22);
insert into product(name, size, sale_price, buy_price, genre, category_id) values("top tira rayas","S",10,5.00,"M",21);

select *
from product inner join brand on product.brand_id = brand.id  inner join category on product.category_id = category.id;

/*inventory*/

drop table if exists inventory;
create table if not exists inventory(
                                        id int auto_increment primary key,
                                        beginning_available_quantity int,
                                        date_updated timestamp default current_timestamp,

                                        product_id int,
                                        foreign key(product_id) references product(id)
    );

insert into inventory(beginning_available_quantity, product_id) values (1,1);
insert into inventory(beginning_available_quantity, product_id) values (1,2);
insert into inventory(beginning_available_quantity, product_id) values (1,3);
insert into inventory(beginning_available_quantity, product_id) values (1,4);
insert into inventory(beginning_available_quantity, product_id) values (1,5);
insert into inventory(beginning_available_quantity, product_id) values (22,8);
insert into inventory(beginning_available_quantity, product_id) values (37,9);
insert into inventory(beginning_available_quantity, product_id) values (37,9);
insert into inventory(beginning_available_quantity, product_id) values (6,10);
insert into inventory(beginning_available_quantity, product_id) values (2,11);

select inventory.id, product.id, product.name, product.color, product.genre, brand.name, category.name, product.size, inventory.beginning_available_quantity, inventory.date_updated
from inventory inner join product on inventory.product_id = product.id  inner join brand on brand.id = product.brand_id inner join category on category.id = product.category_id;

/*sale*/

drop table if exists sale;
create table if not exists sale(
                                   id int auto_increment primary key,
                                   date_updated timestamp default current_timestamp,
                                   quantity_sold int,
                                   discount decimal(7, 2),

    user_id int,
    foreign key (user_id) references user(id),

    inventory_id int,
    foreign key (inventory_id) references inventory (id)
    );

select *
from sale inner join inventory on sale.inventory_id = inventory.id inner join product on inventory.product_id = product.id;

/*triggers*/
use poscjestilos;
delimiter //
create trigger refresh_stock
    after insert on sale
    for each row
begin
    update inventory
    set beginning_available_quantity = beginning_available_quantity - NEW.quantity
    where inventory.id = NEW.inventory_id;
end //

delimiter //
create trigger add_inventory
    after insert on product
    for each row
begin
    insert into inventory(beginning_available_quantity, product_id) values (0,LAST_INSERT_ID());
end //

insert into sale(quantity_sold, discount, user_id, inventory_id) values(1,0.50,1,3);
insert into sale(inventory_id, quantity_sold, discount,date_updated) values (1,1,0.50,now());


select * from inventory;

create view  view_sale as
select sale.id, inventory.name, inventory.brand, inventory.beginning_available_quantity, inventory.size, inventory.sale_price, inventory.buy_price, sale.discount , inventory.sale_price - sale.discount as total, (inventory.sale_price - sale.discount) - inventory.buy_price as ganacnia   from sale inner join inventory on sale.inventory_id = inventory.id where sale.date_updated between '2024-05-08 00:00:00' and '2024-05-08 22:00:00';

select  sum(ganacnia) as total  from view_sale;

/*TODO
  store procedure add field in inventory after new field in the product table


 */

