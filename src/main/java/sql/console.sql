create table category(
    id          int primary key auto_increment NOT NULL,
    name        varchar(255)                   not null,
    description text                           not null
);

create table product(
    id          int primary key auto_increment NOT NULL,
    name        varchar(255)                   not null,
    category_id int                            not null,
    foreign key (category_id) references category(id),
    price       double                         not null,
    description text                           not null,
    quantity    int                            not null
);

DELIMITER //
create procedure SHOW_PRODUCT()
BEGIN
    SELECT * FROM product;
end; //

DELIMITER //
create procedure ADD_PRODUCT(
IN p_name varchar(255),
p_category_id int,
p_price double,
p_description text,
p_quantity int
)
BEGIN
    INSERT INTO product (name,category_id, price, description, quantity)
    values (p_name,p_category_id,p_price,p_description,p_quantity);
end; //

DELIMITER //
create procedure UPDATE_PRODUCT(
    IN p_id int,
    p_name varchar(255),
    p_category_id int,
    p_price double,
    p_description text,
    p_quantity int
)
BEGIN
    UPDATE product
    SET name = p_name,
        category_id = p_category_id,
        price = p_price,
        description = p_description,
        quantity = p_quantity
    WHERE id = p_id;
end; //

DELIMITER //
create procedure DELETE_PRODUCT(IN p_id int)
BEGIN
    DELETE FROM product where id = p_id;
end; //

DELIMITER //
create procedure SHOW_CATEGORY()
BEGIN
    SELECT * FROM category;
end; //