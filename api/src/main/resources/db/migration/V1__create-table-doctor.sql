create table doctor (

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    crm varchar(20) not null unique,
    speciality varchar(100) not null,
    phone varchar(20) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zipcode varchar(20) not null,
    address_additions varchar(100),
    number varchar(20),
    state varchar(100) not null,
    city varchar(100) not null,

    primary key(id)

);