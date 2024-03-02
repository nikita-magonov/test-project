--liquibase formatted sql
--changeset nikita.magonov:1
create table book_author (
    book_id uuid not null constraint fk_book_author_book references book (id),
    author_id uuid not null constraint fk_book_author_author references author (id),
    constraint uq_book_author_book_id_author_id unique (book_id, author_id)
);

--changeset nikita.magonov:2
insert into book_author(book_id, author_id) values
('3b470977-36f7-4a8b-ad37-c5cdcc2bbcf6', '97e5b4b6-bab7-4b64-b142-29b1566b26ce'),
('114257eb-f216-4812-9025-cfae5df84add', '082a880d-34aa-4eb2-902b-92a2fe947ed3'),
('114257eb-f216-4812-9025-cfae5df84add', 'c20cc81d-c556-4475-a72a-ee595addf7cf');
