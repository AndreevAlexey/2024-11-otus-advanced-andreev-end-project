create schema if not exists app_moves;

create table if not exists app_moves.moves (
                                                         id bigserial,
                                                         acc_dt varchar(20),
                                                         acc_kt varchar(20),
                                                         doc_date date,
                                                         sum_dt numeric,
                                                         sum_kt numeric,
                                                         description varchar(250),
                                                         primary key (id)
                                           );