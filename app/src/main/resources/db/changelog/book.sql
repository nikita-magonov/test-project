--liquibase formatted sql
--changeset nikita.magonov:1
create table book (
    id uuid not null constraint pk_book primary key,
    title varchar(2048) not null,
    summary text null
);

--changeset nikita.magonov:2
insert into book (id, title) values
('3b470977-36f7-4a8b-ad37-c5cdcc2bbcf6', 'Незнайка на Луне'),
('114257eb-f216-4812-9025-cfae5df84add', 'Двенадцать стульев');

--changeset nikita.magonov:3
alter table book alter column id set default gen_random_uuid();
