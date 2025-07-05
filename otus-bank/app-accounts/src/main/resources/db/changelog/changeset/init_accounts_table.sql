create schema if not exists app_accounts;

create table if not exists app_accounts.accounts (
                                                        id bigserial,
                                                        acc_num varchar(20),
                                                        currency varchar(3),
                                                        open_date date,
                                                        saldo numeric,
                                                        client_inn varchar(12),
                                                        primary key (id),
                                                        constraint ACC_NUM_UN unique (acc_num),
                                                        constraint CUR_CLI_UN unique (currency, client_inn)
                                                        );