insert into courses (name,description) values ('Machine learning','Machine learning');
insert into courses (name,description) values ('Data Science','Data Science');
insert into courses (name,description) values ('IOT','Internet of things');


insert into countries(code,name,currency) values('IND','India','INR');
insert into countries(code,name,currency) values('US','United States','USD');


insert into payment_strategy(strategy,months) values ('FREE',null);
insert into payment_strategy(strategy,months) values ('One Time',null);
insert into payment_strategy(strategy,months) values ('Subscription Based',6);


insert into course_payment_detail(course_id,country_id,payment_strategy_id) values (1,'IND',2);
insert into course_payment_detail(course_id,country_id,payment_strategy_id) values (2,'IND',3);
insert into course_payment_detail(course_id,country_id,payment_strategy_id) values (1,'US',2);
insert into course_payment_detail(course_id,country_id,payment_strategy_id) values (2,'US',3);
insert into course_payment_detail(course_id,country_id,payment_strategy_id) values (3,'US',1);

insert into price_component(name,description,is_discount,is_required) values('Base price','Basic price of course',false,true);
insert into price_component(name,description,is_discount,is_required) values('Discount','Special discount',true,false);
insert into price_component(name,description,is_discount,is_required) values('TAX','Tax on course',false,true);
insert into price_component(name,description,is_discount,is_required) values('Conversion fees','Conversion fees',false,false);


insert into course_detail_price_component values(1,1,false,1000);
insert into course_detail_price_component values(1,3,true,12);
insert into course_detail_price_component values(2,1,false,2000);
insert into course_detail_price_component values(2,2,false,500);
insert into course_detail_price_component values(2,3,true,12);
insert into course_detail_price_component values(3,1,false,50);
insert into course_detail_price_component values(3,3,true,20);
insert into course_detail_price_component values(4,1,false,100);
insert into course_detail_price_component values(4,3,true,20);
insert into course_detail_price_component values(4,4,false,15);