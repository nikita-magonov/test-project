--liquibase formatted sql
--changeset nikita.magonov:1
create table author (
    id uuid not null constraint pk_author primary key,
    first_name varchar(1024) not null,
    last_name varchar(1024) not null
);

--changeset nikita.magonov:2
insert into author (id, first_name, last_name)
values ('97e5b4b6-bab7-4b64-b142-29b1566b26ce', 'Николай', 'Носов');
insert into author (id, first_name, last_name)
values ('082a880d-34aa-4eb2-902b-92a2fe947ed3', 'Илья', 'Ильф');
insert into author (id, first_name, last_name)
values ('c20cc81d-c556-4475-a72a-ee595addf7cf', 'Евгений', 'Петров');
