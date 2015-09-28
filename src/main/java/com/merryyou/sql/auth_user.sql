DROP TABLE auth_user;
CREATE TABLE auth_user( -- 账户信息表
  id                 VARCHAR (128)            NOT NULL, -- 账户编号
  username           CHARACTER VARYING(30)    NOT NULL, -- 账户登录名
  passwd             CHARACTER VARYING(150)   NOT NULL, -- 账户登录密码 经过md5加密
  role               INTEGER                  DEFAULT 2,  -- 账户角色 1表示管理员 2表示普通用户
  status             INTEGER                  DEFAULT 1,  -- 账户状态；0：无效；1：有效
  created_time       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP , -- 创建时间
  last_modified_time TIMESTAMP, -- 记录最后修改时间
  CONSTRAINT auth_user_pkey PRIMARY KEY (id),
  CONSTRAINT auth_user_ukey_username UNIQUE (username)
);

