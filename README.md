# Kkuil-OJ 判题全栈项目 🚀

该项目是一个判题全栈项目，前后端使用了以下技术和工具进行开发和构建。

## 前端技术栈

- 💚 Vue 3.0：使用最新版本的Vue进行开发。
- 📝 Typescript：使用Typescript进行类型检查。
- 📦 Vite：使用Vite作为打包构建工具。
- 🧰 Vue-router：使用Vue-router进行路由管理。
- 🔒 Pinia：使用Pinia进行状态管理。
- 🎨 Scss：使用Scss作为CSS预处理器。
- 📦 Arco Design UI库：使用Arco Design提供UI组件。
- 📦 Axios：使用Axios进行请求。
- 📦 Lodash：使用Lodash提供更多实用的JS工具类。
- 🎨 Tailwindcss：使用Tailwindcss作为CSS框架。
- 📝 Eslint：使用Eslint进行代码检查。
- 📝 Prettier：使用Prettier进行代码美化。

![vue](https://img.shields.io/badge/vue-3.0-brightgreen)
![typescript](https://img.shields.io/badge/typescript-4.3.5-blue)
![vite](https://img.shields.io/badge/vite-2.4.4-yellow)
![vue-router](https://img.shields.io/badge/vue--router-4.0.11-green)
![pinia](https://img.shields.io/badge/pinia-2.0.0-orange)
![scss](https://img.shields.io/badge/scss-1.37.5-pink)
![arco design](https://img.shields.io/badge/arco%20design-1.6.1-lightgrey)
![axios](https://img.shields.io/badge/axios-0.21.4-red)
![lodash](https://img.shields.io/badge/lodash-4.17.21-blueviolet)
![tailwindcss](https://img.shields.io/badge/tailwindcss-2.2.7-purple)
![eslint](https://img.shields.io/badge/eslint-7.32.0-lightblue)
![prettier](https://img.shields.io/badge/prettier-2.3.2-yellowgreen)

## 后端技术栈

- 💚 Spring Boot 3.x：使用最新版本的Spring Boot进行开发。
- 📝 MyBatis`：使用MyBatis进行数据库操作。
- 📦 MyBatis Plus：使用MyBatis Plus提供更多便捷的数据库操作功能。
- 🔒 Jasypt：使用Jasypt进行加密和解密操作。
- 📝 Slf4j：使用Slf4j进行日志记录。
- 🎯 AOP：使用AOP实现面向切面编程。
- 📚 Jackson：使用Jackson进行JSON数据的序列化和反序列化。
- 📚 Hutool：使用Hutool提供更多实用的Java工具类。

![spring-boot](https://img.shields.io/badge/spring--boot-3.x-brightgreen)
![mybatis](https://img.shields.io/badge/mybatis-3.5.6-lightblue)
![mybatis-plus](https://img.shields.io/badge/mybatis--plus-3.4.5-green)
![jasypt](https://img.shields.io/badge/jasypt-3.0.4-orange)
![slf4j](https://img.shields.io/badge/slf4j-1.7.32-red)
![aop](https://img.shields.io/badge/aop-5.3.9-purple)
![jackson](https://img.shields.io/badge/jackson-2.13.0-lightgrey)
![hutool](https://img.shields.io/badge/hutool--all-5.7.9-blueviolet)

## 开发环境要求

### 前端

- 📌 Node.js：请确保你的Node.js版本在14以上。

### 后端

- 📌 JDK：请确保你的JDK版本在11以上。

## 初始化项目

克隆或下载该项目后，进入项目根目录，分别进入frontend和backend目录，执行以下命令来安装依赖：

```shell
npm install
```

```shell
mvn clean install
```

## 目录树形结构

```
│   ├── sql/                      # 项目启动所需sql文件目录
│   ├── src/                      # 主目录
│   │   ├── main/                 # Java主目录
│   │   │   ├── java/             # Java代码目录
│   │   │   │   ├── config/       # 配置类
│   │   │   │   ├── aspect/       # aop类
│   │   │   │   ├── filters/      # 过滤器类
│   │   │   │   ├── controller/   # 控制器类
│   │   │   │   ├── interceptors/ # 控制器类
│   │   │   │   ├── model/        # 数据库实体类
│   │   │   │   ├── mapper/       # MyBatis映射接口
│   │   │   │   ├── service/      # 服务类
│   │   │   │   ├── util/         # 工具类
│   │   │   ├── resources/        # 资源文件目录
│   │   │   │   ├── application.yml       # 应用配置文件
│   │   │   │   ├── application-dev.yml   # 开发环境配置文件
│   │   │   │   ├── application-prod.yml  # 生产环境配置文件
│   │   │   │   ├── application-test.yml  # 测试环境配置文件
│   ├── test/                     # 测试目录
│   ├── target/                   # 后端构建目录
├── kkuiloj-vue/                  # 前端源代码目录
│   ├── public/                   # 静态文件目录
│   ├── src/                      # 源代码目录
│   │   ├── api/                  # API请求目录
│   │   ├── assets/               # 静态资源目录
│   │   ├── components/           # 组件目录
│   │   ├── router/               # 路由目录
│   │   ├── store/                # 状态管理目录
│   │   ├── utils/                # 工具目录
│   │   ├── views/                # 视图目录
│   ├── tests/                    # 测试目录
├── .gitignore                    # Git忽略文件配置
├── pom.xml                       # Maven配置文件
├── package.json                  # 前端依赖配置文件
├── .editorconfig                 # 编辑器配置
├── .gitignore                    # Git忽略文件配置
└── README.md                     # 项目说明文件

## 使用流程
1. 初始化项目（参考上述步骤）。
2. 开发你的应用，根据需要修改或添加控制器、服务类、数据库实体类等（后端），或者修改或添加组件、视图、状态管理等（前端）。
3. 在 `backend/src/main/resources` 目录中配置你的应用配置文件，例如数据库连接信息、日志配置等（后端）。
4. 在 `backend/src/main/java/config` 目录中配置你的配置类，例如数据库连接池配置、AOP切面配置等（后端）。
5. 在 `backend/src/main/java/mapper` 目录中使用 MyBatis 注解或 XML 文件配置数据库操作（后端）。
6. 在 `backend/src/main/java/service` 目录中编写你的服务类，实现业务逻辑（后端）。
7. 在 `backend/src/main/java/controller` 目录中编写你的控制器类，处理请求和返回响应（后端）。
8. 在 `frontend/src` 目录中编写你的组件、视图、状态管理等，实现前端业务逻辑（前端）。
9. 在 `frontend/src/assets` 目录中编写你的静态资源，例如图片、CSS、JS、字体等（前端）。
```

## 主要功能模块

该项目包括以下功能模块：

### 1. 判题模块

- 提交代码进行判题
- 判题结果查询

### 2. 题目模块

- 题目的增删改查
- 题目分类的增删改查

### 3. 用户模块

- 用户注册、登录、退出登录
- 用户信息修改、查询

## 运行流程

> ## 开发环境要求
> - 📌 Node.js：请确保你的Node.js版本在16.x以上。
> - 📌 NPM：请确保你的NPM版本在9.x以上。

### 1. 前端

克隆或下载该项目后，进入项目根目录，执行以下命令来安装依赖：

#### 1.1. 安装依赖：

```shell
npm install
```

#### 2. 启动开发服务器：

```shell
npm run dev
```

#### 3. 在浏览器中打开 [http://localhost:3170](http://localhost:3170) 进行开发。

#### 4. 构建项目：

```shell
npm run build
```

#### 5. 构建完成后，可以在`dist`目录中找到构建后的文件。

## 2.后端

#### 2.1 去确保安装了JDK和Maven，没有安装自行官网下载安装

## 环境注意事项

- 前端部分需要安装最新版本的Node.js和npm,并保证node版本大于16.x，npm版本大于9.x。
- 后端部分需要安装最新版本的JDK和Maven。
- 本项目使用MySQL数据库，请确保本地已经安装了MySQL，并且创建了相应的数据库和表。
- 本项目使用Redis数据库，请确保本地已经安装了Redis。
- 在运行本项目前，请确保已经正确配置了相关的环境变量和配置文件。

## 最后
本项目后端Java设计基本按照阿里巴巴Java开发手册进行设计，前端Vue设计基本按照阿里巴巴前端开发手册进行设计，如有不足之处请多多指教。
本项目附上阿里巴巴Java开发手册，详情请自行查看项目根路径下的assets文件夹。

以上是关于本判题全栈项目的说明文档，如有问题请联系站长邮箱3024067144@qq.com。