create schema if not exists app_manuals;

create table if not exists app_manuals.ft_money (
                                                   id bigserial,
                                                   code varchar(3),
                                                   name varchar(50),
                                                   curs numeric,
                                                   primary key (id)
);