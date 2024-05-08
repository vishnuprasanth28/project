create table donor_list(
id int primary key auto_increment,donor_name varchar(20) not null, age int not null, blood_group varchar(5) not null,location varchar(20),mobile varchar(10)
 );
 select donor_name,location,mobile from donor_list where blood_group ='O+';
 select * from donor_list;
 insert into donor_list values(4,'vikram',27,'A+','dindugal','9764553469');