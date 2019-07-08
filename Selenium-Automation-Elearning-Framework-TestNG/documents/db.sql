create table login(
userName varchar(50) not null,
password varchar(50));
insert into login values("admin", "admin@123"); 
insert into login values("admin", "admin@123"); 


create table apartments(
Name varchar(50) not null,
Email varchar(50),
Subject varchar(100),
Message varchar(200));

insert into apartments values("Jaya","jaya2007@gmail.com","Apartments","looking for an apartments");
insert into apartments values("Alex hales","alex@gmail.com","Plots","looking for an plots");
insert into apartments values("Mariya","mariya@gmail.com","Vilas","looking for an vila");


create table posts(
UserName varchar(50) not null,
Password varchar(50),
Name varchar(100),
Slug varchar(50) not null,
Description varchar(50),
Title varchar(100),
Body varchar(200),
Phrase varchar(200));

insert into posts values("admin","adminuser@12345","Bangalore","Launch","Launch Vilas","Bangalore Vilas","Vilas in Bangalore","Vilas in Bangalore");



