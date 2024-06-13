select product.name, material.name, category.name, enterprise.name, size, price, color.name  from product_item
    inner join product on product.id = product_item.product_id
    inner join material on material.id = product.material_id
    inner join category on category.id = product.category_id
    inner join enterprise on enterprise.id = product.enterprise_id
    inner join color on color.id = product_item.color_id;
