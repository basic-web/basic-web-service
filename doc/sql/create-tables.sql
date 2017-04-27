CREATE TABLE users (
  id           VARCHAR(36)  NOT NULL,
  phone        VARCHAR(13)  DEFAULT NULL,
  password     VARCHAR(50)  DEFAULT NULL,
  salt         VARCHAR(50)  DEFAULT NULL,
  nickname     VARCHAR(100) NOT NULL,
  head         VARCHAR(100) DEFAULT NULL,
  status       VARCHAR(20)  NOT NULL,
  created_time TIMESTAMP    NOT NULL,
  updated_time TIMESTAMP    DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE messages (
  id           VARCHAR(36)  NOT NULL,
  source       VARCHAR(36) DEFAULT NULL REFERENCES users (id),
  dest         VARCHAR(36)  NOT NULL REFERENCES users (id),
  title        VARCHAR(100) NOT NULL,
  content      TEXT         NOT NULL,
  readed       BOOLEAN      NOT NULL,
  created_time TIMESTAMP    NOT NULL,
  PRIMARY KEY (id)
);