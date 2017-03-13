# --- First database schema

# --- !Ups

create table guest (
 id                         bigint not null,
 firstName                  varchar(255),
 lastName                   varchar(255),
 email                      varchar(255),
 telNum                     varchar(255),
 constraint pk_guest primary key (id)
)

create table restaurant (
 id                         bigint not null,
 name                       varchar(255),
 legalName                  varchar(255),
 inn                        varchar(255),
 adress                     varchar(255),
 constraint pk_restaurant primary key (id)
)

create sequence guest_seq start with 1000;

create sequence restaurant_seq start with 1000;

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;

create sequence company_seq start with 1000;

create sequence computer_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;

