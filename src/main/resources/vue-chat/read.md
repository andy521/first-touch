
第一步：
npm install webpack -g
npm install vue-cli -g
vue init webpack-simple hive-vue

第二步：
npm install --save bootstrap-vue
npm install vue-resource --save
npm install css-loader style-loader --save-dev


npm install file-loader url-loader -D

添加到：webpack.config.js
  {
    test: /\.css$/, // Only .css files
    use: [
        { loader: "style-loader" },
        { loader: "css-loader" },
      ]
  }

第三步：
To get started:
    cd hive-vue
    npm install
    npm run dev.