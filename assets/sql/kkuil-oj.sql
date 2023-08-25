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
	difficulty TINYINT NOT NULL DEFAULT 0 COMMENT "难度等级 0-入门 1-简单 2-中等 3-偏难 4-困难 5-地狱",
	required JSON NOT NULL COMMENT "{}",
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
	exec_code TINYTEXT NOT NULL COMMENT "提交的代码",
	exec_status TINYINT NOT NULL COMMENT "代码执行状态",
	exec_result TINYINT NOT NULL DEFAULT 0 COMMENT "代码执行结果(1-失败 0-成功)",
	exec_message VARCHAR(170) NOT NULL DEFAULT "答案正确" COMMENT "代码执行反馈消息",
	exec_time DATETIME NOT NULL COMMENT "代码执行时间单位ms",
	exec_memory INT(10) NOT NULL DEFAULT 0 COMMENT "代码执行所消耗的内存单位KB",
	is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT "是否逻辑删除(0：未删除 1：已删除)",
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	modified_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "最后一次修改时间",
	KEY (question_id, user_id)
);

# 3. 插入查数据
## 提目表
INSERT INTO tb_question (id, title, description, difficulty, required) VALUES 
(0, "题目标题1", "题目描述1", 0, "{}"),
(2, "题目标题2", "题目描述2", 1, "{}"),
(3, "题目标题3", "题目描述3", 2, "{}"),
(4, "题目标题4", "题目描述4", 3, "{}"),
(5, "题目标题5", "题目描述5", 4, "{}"),
(6, "题目标题6", "题目描述6", 0, "{}"),
(7, "题目标题7", "题目描述7", 1, "{}"),
(8, "题目标题8", "题目描述8", 2, "{}"),
(9, "题目标题9", "题目描述9", 3, "{}"),
(10, "题目标题10", "题目描述10", 4, "{}"),
(11, "题目标题11", "题目描述11", 0, "{}"),
(12, "题目标题12", "题目描述12", 1, "{}"),
(13, "题目标题13", "题目描述13", 2, "{}"),
(14, "题目标题14", "题目描述14", 3, "{}"),
(15, "题目标题15", "题目描述15", 4, "{}"),
(16, "题目标题16", "题目描述16", 0, "{}"),
(17, "题目标题17", "题目描述17", 1, "{}"),
(18, "题目标题18", "题目描述18", 2, "{}"),
(19, "题目标题19", "题目描述19", 3, "{}"),
(20, "题目标题20", "题目描述20", 4, "{}");











