insert into color(name)values("acero");
insert into color(name)values("negro");
insert into color(name)values("beish");
insert into color(name)values("azul_marino");
insert into color(name)values("rojo");
insert into color(name)values("cemento");
insert into color(name)values("melach");
insert into color(name)values("negro");
insert into enterprise(name)values("generico");
insert into enterprise(name)values("adidas");
insert into enterprise(name)values("nike");
insert into material(name)values("algodon");
insert into material(name)values("sintetico");
insert into material(name)values("rip");
insert into material(name)values("franela");

insert into category(name)values("pantalon_joggers");
insert into category(name)values("pantolon_jeans");
insert into category(name)values("pantolon_jeans_baggi");
insert into category(name)values("pantolon_jeans_palazo");
insert into category(name)values("pantolon_jeans_moon");
insert into category(name)values("pantolon_jeans_clasico");
insert into category(name)values("polera_abierta");
insert into category(name)values("polera_cerrada");

insert into product(name,material_id,category_id,enterprise_id)values("BASIC",3,7,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,1,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,2,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,3,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,4,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,5,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,6,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,7,1);
insert into product_item(size,price,color_id,product_id)values("M",36.00,8,1);


insert into user(name)values("jazzmin");
insert into user(name)values("glimer");

insert into cart(user_id)values(1);
