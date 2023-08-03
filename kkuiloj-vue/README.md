# Vue Template 🚀

该项目是一个基于Vue 3.0的前端模板，使用了以下技术和工具进行开发和构建。

## 技术栈

- 💚 Vue 3.0：使用最新版本的Vue进行开发。
- 📝 Typescript：使用强类型的Typescript语言。
- 📦 Vite：使用Vite作为打包构建工具，提供快速的开发环境和热更新。
- 🌐 Vue Router：使用Vue Router进行路由管理。
- 🏗️ Pinia：使用Pinia进行状态管理。
- 🎨 SCSS：使用SCSS作为CSS预处理器。
- 📜 Git：使用Git进行版本控制。
- 🎣 Git Hooks：使用Git Hooks进行代码提交前的钩子操作。
- 🌐 Axios：使用Axios进行网络请求。
- 📚 Lodash：使用Lodash库提供更多实用的工具函数。
- 🎨 Tailwind CSS：使用Tailwind CSS进行快速的样式开发。
- 🚦 Eslint：使用Eslint进行代码检查。
- ✨ Prettier：使用Prettier进行代码美化。

![vue](https://img.shields.io/badge/vue-3.0-brightgreen)
![typescript](https://img.shields.io/badge/typescript-5.1.6-blue)
![vite](https://img.shields.io/badge/vite-4.4.6-orange)
![vue-router](https://img.shields.io/badge/vue--router-4.2.4-lightblue)
![pinia](https://img.shields.io/badge/pinia-2.1.4-green)
![scss](https://img.shields.io/badge/scss-1.37.5-pink)
![git](https://img.shields.io/badge/git-2.33.0-red)
![husky](https://img.shields.io/badge/husky-7.0.4-yellow)
![axios](https://img.shields.io/badge/axios-1.4.0-purple)
![lodash](https://img.shields.io/badge/lodash-4.17.21-lightgrey)
![tailwindcss](https://img.shields.io/badge/tailwindcss-3.0-blueviolet)
![eslint](https://img.shields.io/badge/eslint-8.45.0-brightgreen)
![prettier](https://img.shields.io/badge/prettier-3.0.0-orange)

## 开发环境要求

- 📌 Node.js：请确保你的Node.js版本在16.x以上。
- 📌 NPM：请确保你的NPM版本在9.x以上。

## 初始化项目

克隆或下载该项目后，进入项目根目录，执行以下命令来安装依赖：

```shell
npm install
```

## 目录树形结构

```
├── dist/                          # 构建输出目录
├── public/                        # 静态资源目录
│   ├── favicon.ico                # 网站图标
├── src/                           # 源代码目录
│   ├── assets/                    # 静态资源
│   ├── components/                # 公共组件
│   ├── router/                    # 路由配置
│   ├── store/                     # 状态管理
│   ├── styles/                    # 全局样式
│   ├── utils/                     # 工具函数
│   ├── views/                     # 页面视图
│   ├── App.vue                    # 根组件
│   └── main.ts                    # 入口文件
├── .editorconfig                  # 编辑器配置
├──  index.html                    # HTML模板
├── .eslintrc.js                   # Eslint配置
├── .gitignore                     # Git忽略文件配置
├── .prettierrc.js                 # Prettier配置
├── package.json                   # 项目配置
└── vite.config.ts                 # Vite配置
```
## 使用流程

1. 初始化项目（参考上述步骤）。
2. 开发你的应用，根据需要修改或添加组件、视图、样式等。
3. 在 `src/router` 目录中配置你的路由。
4. 在 `src/store` 目录中使用 Pinia 进行状态管理。
5. 在 `src/styles` 目录中编写你的样式文件，支持 SCSS 预处理器。
6. 使用 axios 发起请求，具体使用方式请参考 [axios 文档](https://axios-http.com/docs/intro)。
7. 使用 lodash 进行数据操作和处理，具体使用方式请参考 [lodash 文档](https://lodash.com/docs)。
8. 使用 tailwindcss
   提供的工具类和样式进行页面布局和设计，具体使用方式请参考 [tailwindcss 文档](https://tailwindcss.com/docs)。
9. 使用 ESLint 进行代码检查，确保代码质量，具体配置请参考 `.eslintrc.js` 文件。
10. 使用 Prettier 进行代码美化，确保代码风格统一，具体配置请参考 `.prettierrc.js` 文件。
11. 在开发过程中使用 Git 进
    行版本控制，确保代码的可追踪性和团队协作。具体使用方式请参考 [Git 文档](https://git-scm.com/doc)。

12. 在开发过程中，可以使用 Git Hooks 进行钩子操作，例如在提交代码前进行代码格式化和代码检查，具体配置请参考 `.husky`
    目录下的钩子脚本。

13. 在完成开发后，可以使用 Vite 打包构建工具进行项目的构建。具体使用方式请参考 Vite 的官方文档。

## 开发注意事项

- 确保你的项目使用了 Vue 3.0 版本。
- 使用 Typescript 进行开发，提高代码的可读性和维护性。
- 在开发过程中，推荐使用 VS Code 编辑器，并安装相关插件，例如 Vetur、ESLint、Prettier，以提升开发效率。
- 遵循 Git 的代码提交规范，使用语义化的提交信息，方便版本管理和发布。

## 使用方法

1. 安装依赖：

```shell
npm install
```

2. 启动开发服务器：

```shell
npm run dev
```

3. 在浏览器中打开 [http://localhost:3000](http://localhost:3000) 进行开发。

4. 构建项目：

```shell
npm run build
```

5. 构建完成后，可以在`dist`目录中找到构建后的文件。

## 贡献

欢迎贡献代码，提出问题和建议。请在提交代码前确保通过了 ESLint 的代码检查。

## 许可证

本项目基于 MIT 许可证开源。

## 鸣谢

感谢以下开源项目的贡献：

- [Vue](https://vuejs.org/)
- [Typescript](https://www.typescriptlang.org/)
- [Vite](https://vitejs.dev/)
- [vue-router](https://router.vuejs.org/)
- [pinia](https://pinia.esm.dev/)
- [axios](https://axios-http.com/)
- [lodash](https://lodash.com/)
- [tailwindcss](https://tailwindcss.com/)
- [ESLint](https://eslint.org/)
- [Prettier](https://prettier.io/)

---

🚀 现在你可以开始使用 Vue-Template 进行前端项目的开发啦！如果有任何问题或建议，请随时提出。祝你编码愉快！