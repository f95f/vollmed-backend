alter table doctor add active tinyint not null default 1;
update doctor set active = 1;
