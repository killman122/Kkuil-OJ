# 创建数据库
CREATE DATABASE IF NOT db_kkuiloj;

# 使用数据库
USE db_kkuiloj;

# 创建表

## 用户表
CREATE TABLE IF NOT EXISTS tb_user(
	id BIGINT PRIMARY KEY COMMENT "用户id",
	username VARCHAR(17) UNIQUE KEY NOT NULL DEFAULT "-" COMMENT "用户名",
	password VARCHAR(100) NOT NULL COMMENT "用户密码",
	role ENUM("user", "admin") NOT NULL DEFAULT "user" COMMENT "用户权限",
	is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT "是否逻辑删除(0：未删除 1：已删除)",
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	modified_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "最后一次修改时间"
);

## 题目表
CREATE TABLE IF NOT EXISTS tb_question(
	id BIGINT PRIMARY KEY COMMENT "题目编号",
	title VARCHAR(100) NOT NULL COMMENT "题目标题",
	description TEXT NOT NULL COMMENT "题目描述",
	`rank` TINYINT NOT NULL DEFAULT 0 COMMENT "难度等级 0-入门 1-简单 2-中等 3-偏难 4-困难 5-地狱",
	`condition` JSON NOT NULL COMMENT "题目要求",
	is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT "是否逻辑删除(0：未删除 1：已删除)",
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	modified_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "最后一次修改时间"
);

## 代码提交记录表
CREATE TABLE IF NOT EXISTS tb_commit_record(
	id BIGINT PRIMARY KEY COMMENT "提交记录编号",
	question_id BIGINT COMMENT "题目编号",
	user_id BIGINT NOT NULL COMMENT "提交代码的用户id",
	lang VARCHAR(100) NOT NULL COMMENT "所用的编程语言",
	`code` TEXT NOT NULL COMMENT "提交的代码",
	exec_result TINYINT NOT NULL DEFAULT 0 COMMENT "代码执行结果(1-失败 0-成功)",
	exec_message VARCHAR(170) NOT NULL DEFAULT "答案正确" COMMENT "代码执行反馈消息",
	exec_time DATETIME NOT NULL COMMENT "代码执行时间单位ms",
	exec_memory INT(10) NOT NULL DEFAULT 0 COMMENT "代码执行所消耗的内存单位KB",
	is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT "是否逻辑删除(0：未删除 1：已删除)",
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	modified_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "最后一次修改时间",
	KEY (question_id, user_id)
);











