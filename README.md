**日本語での説明は[こちら▼](#demoapi%E3%81%A3%E3%81%A6%E4%BD%95)**

# What is DemoAPI ?
- Created by 622-122 (=R.F)
- IF I would like to tell my basic creating API skills, I present this.
- And, my written article's demo.
  * Please check my written: https://qiita.com/622-122
- Design
  * please look the spreadsheet: https://docs.google.com/spreadsheets/d/1x3sa6rUVtkWRfz-9Tpa0WrfrSEEjT1liQ9LjLNC1uL8/edit#gid=705193169

# Please check this API
If you have a few time, I hope you would run this API.<br>
But when you busy, please read this page so that you could understand about this.

## Functions in this API
- Restful
  * Using Spring boot. Requests and Responses by JSON.
  * Library is Spring Boot2.
  * Using annotation on Spring.
- Connecting Multiple DBs
  * Using two Datasource and connecting two DBs.
  * Library is MyBatis2 and JDBC.
  * SELECT Query use on each DBs. 

## Otfer point of would like to you check
- Declaring memory conscious variables.
  * If use variable in `for`, declare the variable above the `for`.
  * Thinking difference between new instance and declare null.
- Consciding performance.
  * use only `add` and `for`, using `LinkedList`.

## Try to run
### Requirements
- Java over 11
- Docker and Docker-Compose
### How to start
1. **Prepare MySQL**<br>
MySql called in this API, so MySql container by Docker-Compose or same needed.<br>
If you have Docker-Compose, please use file by directory `DockerCompose` in my project.<br>
On the directory of `./DockerCompose/mysql_user`and `./DockerCompose/mysql_world`, please enter the following command on the command line.

```bash
Docker-Compose build
Docker-Compose up -d
```

2. **Run the file of jar**<br>
I builded DemoAPI and stored DemoAPI.jar in `./build/libs`.
When enter this command there on the command line, that boot up.

```bash
java -jar DemoAPI.jar
```

3. **Call DemoAPI**<br>
The command there is will call it and return the response.
```bash
curl -X POST      -H 'Content-Type:application/json'      -d '{
         "name": ["Masami", "Haruhisa", "Saaya"]
     }' http://localhost:8080/
```
# End
Thank you for your looking.

<br>
<br>
<hr>
<br>

# DemoAPIって何？
- このAPIは622-122 （R.F）が作成したAPIです。
- 私がJavaAPIを作成する基本的能力として提示する必要がある際に使用します。
- 趣味で書いている記事の例として利用することもあります。
  * もしよろしければ私の書いた記事もご覧ください。<br>
https://qiita.com/622-122
- 設計
  * インターフェースなどはスプレッドシートにまとめておりますので、此方をご覧ください。<br>
https://docs.google.com/spreadsheets/d/1x3sa6rUVtkWRfz-9Tpa0WrfrSEEjT1liQ9LjLNC1uL8/edit#gid=705193169

# APIについて
もしお時間があれば実行してみて頂けると大変うれしく思います。<br>
お忙しい場合は、APIの特徴をまとめましたので其方をご覧ください。

## APIの機能
- Restful
  * Spring bootを利用しており、JSONにてインターフェースされます。
  * バージョンはSpring Boot2.6.3を利用しています。
  * また、Springアノテーションを利用しています。
- 複数DBへの接続
  * 2つのデータソースを定義し、それぞれ別のDBに接続しています。
  * また、それぞれに対してSELECT文でデータを取得する処理を作成しています。
  * O/RマッパーとしてはMyBatis2.2.2を利用しています。 

## 特徴
- メモリを意識した変数の利用
  * `for`文の中で変数を利用する場合、その外で宣言するように心がけています。
  * インスタンスの作成とnullでの宣言について、意識して使い分けています。
- その他性能の考慮
  * `add`や`for`でしか利用しない場合、`ArrayList`ではなく`LinkedList`を利用しています。

## APIを動かす
### 動作環境
- Java11以上
- Docker & Docker-Compose
### 実行方法
1. **MySQLの準備**<br>
このAPIではMySQLの呼び出しをしており、Docker-Composeでコンテナ化されたMySQLを呼ぶ想定となっています。<br>
もしご自身のPCにDocker-Composeが入っていればこのプロジェクト内のDockerCompose用定義ファイルで簡単にコンテナを作成することが出来ます。<br>
`./DockerCompose/mysql_user`と`./DockerCompose/mysql_world`で以下のコマンドを叩いてください。

```bash
Docker-Compose build
Docker-Compose up -d
```

2. **APIの実行**<br>
ビルドしたAPIを`./build/libs`に格納しています。<br>
その場所で以下のコマンドを叩くことで実行開始します。

```bash
java -jar DemoAPI.jar
```

3. **APIの呼び出し**<br>
コマンドラインで以下のリクエストを投げることで、レスポンスを取得することが出来ます。

```bash
curl -X POST      -H 'Content-Type:application/json'      -d '{
         "name": ["Masami", "Haruhisa", "Saaya"]
     }' http://localhost:8080/
```
# おわり
以上です。ご覧いただきありがとうございました。
