create table account(
id bigint not null auto_increment,
code varchar(100) not null,
customer varchar(100) not null,
unique(code),
constraint pk_account primary key (id)
);

create table extracts(
id bigint not null auto_increment,
date_extract datetime not null,
credit decimal(15, 4) not null,
debit decimal(15, 4) not null,
balance decimal(15, 4) not null,
description varchar(255) not null,
account_id bigint not null,
constraint pk_extract primary key (id),
constraint fk_account foreign key (account_id) references account(id)
);