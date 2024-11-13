CREATE TABLE answer
(
    uuid        BINARY(16)   NOT NULL,
    question_id BINARY(16)   NULL,
    text        VARCHAR(255) NULL,
    created_at  datetime NULL,
    user_id     BINARY(16)   NULL,
    CONSTRAINT pk_answer PRIMARY KEY (uuid)
);

CREATE TABLE answer_comments
(
    answer_uuid BINARY(16) NOT NULL,
    comments_id BINARY(16) NOT NULL
);

CREATE TABLE comments
(
    id          BINARY(16)   NOT NULL,
    parent_id   BIGINT NULL,
    text        VARCHAR(255) NULL,
    created_at  datetime NULL,
    user_id     BINARY(16)   NULL,
    answer_uuid BINARY(16)   NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);

CREATE TABLE question
(
    id         BINARY(16)   NOT NULL,
    title      VARCHAR(255) NULL,
    body       VARCHAR(255) NULL,
    created_at datetime NOT NULL,
    user_id    BINARY(16)   NULL,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE question_answers
(
    question_id  BINARY(16) NOT NULL,
    answers_uuid BINARY(16) NOT NULL
);

CREATE TABLE user
(
    id        BINARY(16)   NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE answer_comments
    ADD CONSTRAINT uc_answer_comments_comments UNIQUE (comments_id);

ALTER TABLE question_answers
    ADD CONSTRAINT uc_question_answers_answers_uuid UNIQUE (answers_uuid);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_ANSWER_UUID FOREIGN KEY (answer_uuid) REFERENCES answer (uuid);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE answer_comments
    ADD CONSTRAINT fk_anscom_on_answer FOREIGN KEY (answer_uuid) REFERENCES answer (uuid);

ALTER TABLE answer_comments
    ADD CONSTRAINT fk_anscom_on_comments FOREIGN KEY (comments_id) REFERENCES comments (id);

ALTER TABLE question_answers
    ADD CONSTRAINT fk_queans_on_answer FOREIGN KEY (answers_uuid) REFERENCES answer (uuid);

ALTER TABLE question_answers
    ADD CONSTRAINT fk_queans_on_question FOREIGN KEY (question_id) REFERENCES question (id);