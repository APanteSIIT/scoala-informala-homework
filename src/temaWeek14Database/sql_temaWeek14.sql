drop database if exists school;
create database school;
use school;

drop tables if exists courses;
 create table courses (
id int not null auto_increment,
 area varchar(20) not null,
 title varchar(30) not null,
 descrip varchar(100),
 prereqs varchar(20),
 primary key(id)
 );

drop table if exists classes;
create table classes (
class_id int not null auto_increment,
course_id int not null ,
days int ,
startTime date,
endTime date,
bldg varchar(10),
room_no varchar(10),
primary key(class_id),
foreign key(course_id) references courses (id)
);

drop table if exists crosslistings;
create table crosslistings(
course_id int,
dept varchar(40),
course_no varchar(10),
foreign key (course_id) references courses (id)
);

drop table if exists courses_profs;
create table courses_profs(
course_id int,
prof_id int not null auto_increment,
primary key(prof_id),
foreign key(course_id) references courses (id)
);

drop table if exists profs;
create table profs(
prof_id int,
prof_name varchar(30) not null,
foreign key (prof_id) references courses_profs (prof_id)
);

 insert into school.courses (id,area,title,descrip,prereqs)
 values (1,'sience','Data sience','fundamental R programming skills','High school');
 insert into school.courses (id,area,title,descrip,prereqs)
 values (2,'language','Intro to english bussines','english at work','High school');
 insert into school.courses (id,area,title,descrip,prereqs)
 values (3,'engineering','Drinking water tratament','learn about urban water services','High school');



insert into school.classes (class_id,course_id,days,startTime,endtime,bldg,room_no)
 values (1,1,5,'2019-10-15','2019-10-30','15C','205');
 
insert into school.classes (class_id,course_id,days,startTime,endTime,bldg,room_no)
 values (2,2,10,'2019-11-00','2019-11-10','10D','101');
 
insert into school.classes(class_id,course_id,days,startTime,endTime,bldg,room_no)
 values (3,3,5,'2019-11-15','2019-11-16','40A','308');
 
 
insert into school.crosslistings(course_id,dept,course_no)
values (1,'IT','501');
insert into school.crosslistings(course_id,dept,course_no)
values (2,'Linguistics','408');
insert into school.crosslistings(course_id,dept,course_no)
values (3,'Cos','315');

insert into school.courses_profs(course_id,prof_id)
values  (1,1234);
insert into school.courses_profs(course_id,prof_id)
values  (2,5678);
insert into school.courses_profs(course_id,prof_id)
values  (3,3875);

insert into profs (prof_id,prof_name)
values (1234,'Cosmas Marcus');
insert into profs (prof_id,prof_name)
values (5678,'Strat Oliver');
insert into profs (prof_id,prof_name)
values (3875,'Tomas Alexandra');
