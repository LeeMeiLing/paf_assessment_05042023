DROP SCHEMA IF EXISTS paf ;
CREATE SCHEMA IF NOT EXISTS paf;

use paf;

create table if not exists user(
	user_id varchar(8) not null,
    username varchar(100) not null,
    name varchar(100),
    constraint  user_pk primary key(user_id)
);

create table if not exists task(
	task_id int not null auto_increment,
    description varchar(255) not null,
    priority int not null,check(priority>=1 and priority<=3),
    due_date date not null,
    user_id varchar(8) not null,
    constraint task_pk primary key(task_id),
    constraint task_user_fk foreign key(user_id) references user(user_id)
);


