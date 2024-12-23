alter table patient add active tinyint not null default 1;
update patient set active = 1;
