# Gradle_JWT_Init

## 【版本】

* Java：8
* SpringBoot：2.7.10
* Database：MySQL-8.0.23

## 【API 文件】

* Postman：[Gradle_Init.postman_collection.json](__doc%2FGradle_Init.postman_collection.json)
* Swagger：http://localhost:8080/gradle_Init/swagger-ui.html

## 【Idea 設定】

* Smart Tomcat：[idea_tomcat_setup.png](__doc%2Fidea_tomcat_setup.png)
* Unit Test：[Run_Tests_Using_IntelliJ.jpg](__doc%2FRun_Tests_Using_IntelliJ.jpg)
* Datasource：[application.properties](src%2Fmain%2Fresources%2Fapplication.properties)

## 【使用範例】
1. clone 專案
3. 調整 settings.gradle 名稱
4. 調整 src.main.java 的 package 名稱
5. 調整 Gradle_InitApplication.java 名稱
6. 調整 Datasource 配置
7. 配置 smart tomcat
8. 調整 Unit Test 設定
9. 使用 Postman 或 Swagger 測試 (測試資料表：[test.sql](__doc%2Fsql%2Ftest.sql))
10. 創建新的 git 倉庫
11. idea clone 專案，將原本調整好的資料夾檔案全部轉移到新的倉庫
```text
git init
git add -f README.md
git add .
git status
git commit -m "[feat] 新增 Gradle 專案配置"
git push
```   

## 產生自簽 SSL 憑證
1. 新增 [openssl.cnf](openssl.cnf) 檔案
2. 生成 Private Key 指令：openssl genpkey -algorithm RSA -out private_key.pem
3. 生成 CSR (Certificate Signing Request) 指令：openssl req -new -x509 -key private_key.pem -out certificate.pem -days
   365 -config D:\springboot-mall/openssl.cnf

## 替換 SSL 憑證
1. 重新生成 Private Key 與 Certificate Signing Request 後，放在 [Config.java](src%2Fmain%2Fjava%2Fcom%2Fhao%2FGradle_JWT_Init%2Fconfig%2FConfig.java) 檔