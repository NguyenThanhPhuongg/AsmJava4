create database Assignment_Java4
 create table favorite (
       id_favorite bigint identity not null,
        like_date datetime2(6),
        user_id int,
        video_id int,
        primary key (id_favorite)
    )

 create table share (
       id_share bigint identity not null,
        emails varchar(255),
        share_date datetime2(6),
        user_id int,
        video_id int,
        primary key (id_share)
    )

create table users (
       id_user int identity not null,
        admin bit,
        email varchar(255),
        full_name nvarchar(50),
        password varchar(255),
        primary key (id_user)
    )
	insert into users(admin,email,full_name,password)
	values('1','phuongnttph36297@fpt.edu.vn','ThanhPhuong','Phuong306204');

	insert into users(admin,email,full_name,password)
	values(0,'phuong306204@gmail.com','ThanhPhuong','123456');

	DELETE FROM users where id_user = 2
	create table video (
       id_video int identity not null,
        active bit,
        description NVARCHAR(255),
        poster varchar(255),
        title NVARCHAR(255),
        name_video varchar(255),
        primary key (id_video)
    )