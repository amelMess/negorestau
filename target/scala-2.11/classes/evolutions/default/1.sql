# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "CAT" ("name" VARCHAR(254) NOT NULL PRIMARY KEY,"color" VARCHAR(254) NOT NULL);
create table "USER_PROB" ("ID_USER_PROB" INTEGER NOT NULL PRIMARY KEY,"last_name" VARCHAR(254) NOT NULL,"first_name" VARCHAR(254) NOT NULL,"email" VARCHAR(254) NOT NULL,"password" VARCHAR(254) NOT NULL,"adress" VARCHAR(254) NOT NULL);

# --- !Downs

drop table "USER_PROB";
drop table "CAT";

