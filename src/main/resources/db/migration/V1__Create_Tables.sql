create table member
(
    id bigint not null
        constraint pk_member_id
            primary key,
    nickname varchar(50) not null
);

create table product
(
    id bigint not null
        constraint pk_product
            primary key,
    title varchar(120) not null,
    price numeric(19,2) not null,
    member_id bigint not null
        constraint fk_member_id
            references member
);

create sequence seq_member;

create sequence seq_product;
