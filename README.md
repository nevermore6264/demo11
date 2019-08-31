# demo11

create database qlsv
go

use qlsv
go

create table course(
	id int identity,
	name nvarchar(50), 
	constraint pk_course primary key (id)
)
go

create table student(
	id int identity,
	code nvarchar(10),
	fullname nvarchar(10),
	gender bit,
	hometown nvarchar(255),
	course_id int,
	constraint pk_student primary key(id),
	constraint fk_student_course foreign key(course_id) references course(id)
)
go

insert into course
values(N'?ng d?ng ph?n m?m')

insert into course
values(N'Thi?t k? ?? h?a')

insert into course
values(N'Thi?t k? website')

select * from course

insert into student
values ('PH04773',N'Tr?n Hi?u', 1, N'Hà Nam', 1)

insert into student
values ('PH04772',N'Trung Hi?u', 1, N'Hà N?i', 1)

insert into student
values ('PH04771',N'Tr?n Trung', 1, N'Hà T?nh', 1)

select * from student
go

-- Create course
create proc sp_createCourse(@name nvarchar(50))
as
	insert into course values(@name)
go

sp_createCourse N'Marketing'

go

-- update
create proc sp_updateCourse(@id int, @name nvarchar(50))
as
	update course set name = @name
	where id = @id
go

sp_updateCourse 2, N'L?p trình mobile'
go

-- delete

create proc sp_deleteCourse(@id int)
as
	delete from course
	where id = @id
go

sp_deleteCourse 4
