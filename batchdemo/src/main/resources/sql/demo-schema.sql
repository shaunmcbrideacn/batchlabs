create table mailing_list_stg (id BIGINT IDENTITY NOT NULL PRIMARY KEY,first_name VARCHAR(100),last_name VARCHAR(100),email VARCHAR(500));

CREATE SEQUENCE mailing_list_stg_seq;


create table orders (id bigint identity not null primary key, sku BIGINT, CUSTOMER_ID BIGINT, QUANTITY BIGINT, PROCESSED VARCHAR(1));
INSERT INTO ORDERS (id,sku,customer_id,quantity,processed) VALUES  (1,10,6,8,'N');
INSERT INTO ORDERS (id,sku,customer_id,quantity,processed) VALUES  (2,10,2,7,'Y');
INSERT INTO ORDERS (id,sku,customer_id,quantity,processed) VALUES  (3,9,1,6,'N');
INSERT INTO ORDERS (id,sku,customer_id,quantity,processed) VALUES  (4,5,3,5,'N');