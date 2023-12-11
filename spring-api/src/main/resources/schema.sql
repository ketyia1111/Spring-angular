create table if not exists teacher(
	id bigint not null auto_increment primary key,
	user_name varchar(60) not null,
	email varchar(255) not null
);