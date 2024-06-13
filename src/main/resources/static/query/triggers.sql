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

