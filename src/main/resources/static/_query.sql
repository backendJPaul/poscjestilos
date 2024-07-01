
insert into user(name)values("pticlavilca");
insert into user(name)values("cleon");
insert into user(name)values("jjafac");
insert into user(name)values("grosberi");

insert into category(name)values("Accesorios");
insert into category(name)values("Básicos");
insert into category(name)values("Blazers");
insert into category(name)values("Blusas_y_camisas");
insert into category(name)values("Camisas");
insert into category(name)values("Casacas_y_abrigos");
insert into category(name)values("Chompas_y_cárdigans");
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
insert into category(name)values("Polos_y_tops");
insert into category(name)values("Ropa_de_Cama");
insert into category(name)values("Ropa_de_maternidad");
insert into category(name)values("Ropa_deportiva");
insert into category(name)values("Ropaformal");
insert into category(name)values("Ropa_interior");
insert into category(name)values("Shorts");
insert into category(name)values("Toallas");
insert into category(name)values("Toys");
insert into category(name)values("Vestidos");
insert into category(name)values("Zapatos");
insert into category(name)values("Polo_Manga_larga");


insert into brand(name)values("Aaron");
insert into brand(name)values("Damaris");
insert into brand(name)values("Disney");
insert into brand(name)values("Guinier");
insert into brand(name)values("KLEY");
insert into brand(name)values("Lee");
insert into brand(name)values("Paw_Patrol");
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
insert into color(name)values("intermedio");
insert into color(name)values("jade");
insert into color(name)values("lila");
insert into color(name)values("marron");
insert into color(name)values("melanch");
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

/*triggers*/

delimiter //
create trigger refresh_stock
    after insert on cart_item
    for each row
begin
    update inventory
    set beginning_available_quantity = beginning_available_quantity - NEW.quantity
    where item_product_id = NEW.item_product_id;
end //
