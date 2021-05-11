--liquibase formatted sql
--changeset sovietspy2:create-tables
CREATE TABLE fun_user
(
    id       serial,
    name     text,
    email    text,
    language text,
    password text,
    score    integer,
    CONSTRAINT fun_user_pk PRIMARY KEY (id)
);
-- rollback DROP TABLE fun_user;


CREATE TABLE fun_tag
(
    id          serial,
    description text,
    name        text,
    CONSTRAINT fun_tag_id_pk PRIMARY KEY (id)
);

-- rollback DROP TABLE fun_tag;

CREATE TABLE fun_post
(

    id           serial,
    fun_user_id  integer,
    content_url  text,
    content_text text,
    title        text,
    CONSTRAINT fun_user_id_fk FOREIGN KEY (fun_user_id) REFERENCES fun_user (id),
    CONSTRAINT fun_post_id PRIMARY KEY (id)
);
-- rollback DROP TABLE fun_post;


CREATE TABLE fun_post_fun_tag
(
    fun_tag_id  integer,
    fun_post_id integer,
    CONSTRAINT fun_post_fun_tag_tag_id_fk FOREIGN KEY (fun_tag_id) REFERENCES fun_tag (id),
    CONSTRAINT fun_post_fun_tag_fun_post_id_fk FOREIGN KEY (fun_post_id) REFERENCES fun_post (id),
    CONSTRAINT fun_post_fun_tag_pk PRIMARY KEY (fun_tag_id, fun_post_id)
);

-- rollback DROP TABLE fun_post_fun_tag;


CREATE TABLE fun_like
(
    fun_user_id integer,
    fun_post_id integer,
    CONSTRAINT fun_user_id_fk_fn_like FOREIGN KEY (fun_user_id) REFERENCES fun_user (id),
    CONSTRAINT fun_post_id_fk_fn_like FOREIGN KEY (fun_post_id) REFERENCES fun_post (id),
    CONSTRAINT fun_like_pk PRIMARY KEY (fun_user_id, fun_post_id)
);
-- rollback DROP TABLE fun_like;


CREATE TABLE fun_comment
(
    entry bigint,
    id serial PRIMARY KEY,
    fun_post_id integer,
    fun_user_id integer,
    content text,
    CONSTRAINT fun_comment_fun_user_id_fk FOREIGN KEY (fun_user_id) REFERENCES fun_user (id),
    CONSTRAINT fun_comment_fun_post_id_fk FOREIGN KEY (fun_post_id) REFERENCES fun_post (id)
);
-- rollback DROP TABLE fun_comment;


