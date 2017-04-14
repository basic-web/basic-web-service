CREATE TABLE users (
  id           VARCHAR(36)  NOT NULL,
  phone        VARCHAR(13) DEFAULT NULL,
  password     VARCHAR(50) DEFAULT NULL,
  salt         VARCHAR(50) DEFAULT NULL,
  nickname     VARCHAR(100) NOT NULL,
  status       VARCHAR(20)  NOT NULL,
  created_time TIMESTAMP    NOT NULL,
  updated_time TIMESTAMP   DEFAULT NULL,
  PRIMARY KEY (id)
);