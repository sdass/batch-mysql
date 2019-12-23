https://spring.io/guides/gs/batch-processing/

mysql> show create table bets_promo\G
CREATE TABLE bets_promo (
  ID double primary key NOT NULL AUTO_INCREMENT,
  EMAIL varchar(70) NOT NULL,
  FIRST_NAME varchar(70) NOT NULL,
  LAST_NAME varchar(70) NOT NULL,
  BETS_ID double DEFAULT NULL,
  STATE varchar(2) DEFAULT NULL,
  PROMO_ID double DEFAULT NULL,
  signup_date datetime DEFAULT NULL
);

insert into bets_promo (email, first_name, last_name, bets_id, state, promo_id) values('mc@yahoo.com', 'Jhon', 'Dolan', 5, 'NY', 44);

 select * from bets_promo;
 -------------------------------------
 Actuator endpoints
 /actuator/health
 /actuator/info
 /actuator

