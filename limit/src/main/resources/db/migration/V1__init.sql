create table limits(
id bigint not null auto_increment,
account varchar(100) not null,
code varchar(100) not null,
daily_operations int not null,
daily_withdrawal_amount int not null,
unique(code),
constraint pk_limit primary key (id)
);