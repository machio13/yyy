create table if not exists published_title (
    id                 serial primary key,
    isbn               varchar(17) not null unique,
    title              varchar(255) not null,
    author             varchar(255) not null,
    created_datetime   timestamp default current_timestamp
);

create table if not exists collection (
    id                   serial primary key,
    status               varchar(20) not null,
    serial_number        integer not null,
    published_title_id   integer not null references published_title(id),
    created_datetime     timestamp default current_timestamp
);

create table if not exists member (
    id                 serial primary key,
    name               varchar(255) not null,
    email              varchar(255) not null,
    created_datetime   timestamp default current_timestamp
);

create table if not exists circulation_record (
    id                   serial primary key,
    member_id            integer not null references member(id),
    collection_id        integer not null references collection(id),
    since_date           date not null,
    due_date             date not null,
    actual_return_date   date,
    status               varchar(20) not null,
    created_datetime     timestamp default current_timestamp
);

select setval('public.circulation_record_id_seq', 1000);
select setval('public.collection_id_seq', 1000);
select setval('public.member_id_seq', 1000);
select setval('public.published_title_id_seq', 1000);
