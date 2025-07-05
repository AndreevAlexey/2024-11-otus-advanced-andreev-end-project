create schema if not exists app_clients;

create table if not exists app_clients.clients (
                                            id bigserial,
                                            full_name varchar(255),
                                            birth_date date,
                                            mail varchar(50),
                                            inn varchar(12),
                                            primary key (id),
                                            constraint INN_UN unique (inn)
                                            );