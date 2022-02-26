**日本語での説明は[こちら▼](#demoapi%E3%81%A3%E3%81%A6%E4%BD%95)**

# Changes ver.1 to ver.2
- MySQL to PostgreSQL
 * To use Window Functions
- DemoAPI work with Docker
 * API and ALL DBs with components by Docker
- Responses to three per person
- DB is called outside the loop

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
  * If it use only `add` and `for`, using `LinkedList`.
  * Calling the DB is done outside the `for`.

## Try to run
### Requirements
- Docker and Docker-Compose
### How to start
1. **Prepare MySQL**<br>
MySql called in this API, so MySql container by Docker-Compose or same needed.<br>
If you have Docker-Compose, please use file by directory `DockerCompose` in my project.<br>
On the directory of `./DockerCompose`, please enter the following command on the command line.

```bash
Docker-Compose build
Docker-Compose up -d
```

2. **Run the API**<br>
Once the container is created, you can run the API.
Enter the following command.

```bash
docker exec -it demoapi bash -p
```

```bash
./gradlew bootRun
```

3. **Call DemoAPI**<br>
The command there is will call it and return the response.
```bash
curl -X POST      -H 'Content-Type:application/json'      -d '{
         "name": ["Masami", "Haruhisa", "Saaya"]
     }' http://localhost:8080/
```

4. **API stop**<br>
If you would like to stop the API, you can use `Ctrl + C` to do so.
Containers can be removed with the following command.

```docker-compose down --rmi all --volumes --remove-orphans```

# End
Thank you for your looking.

<br>
<br>
<hr>
<br>

# ver.1から2への変更点
- MySQLをPostgreSQLに
 * Window関数を使うため変更
- DemoAPIをDockerで動かす
 * APIとDBをすべてDockerのコンポーネントで動かすよう変更しました
- 1人あたり3件までのレスポンスを返却するよう修正
- DBをループ外で呼び出すよう変更しました

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
  * DBを`for`文の外で呼び出すように設計しています。

## APIを動かす
### 動作環境
- Docker & Docker-Compose
### 実行方法
1. **コンテナの準備**<br>
このAPIはDockerコンテナで運用されます。<br>
もしご自身のPCにDocker-Composeが入っていればこのプロジェクト内のDockerCompose用定義ファイルで簡単にコンテナを作成することが出来ます。<br>
`./DockerCompose`配下で以下のコマンドを叩いてください。

```bash
Docker-Compose build
Docker-Compose up -d
```

2. **APIの実行**<br>
コンテナが作成出来たら、以下のコマンドを叩くことでAPIを実行することが出来ます。

```bash
docker exec -it demoapi bash -p
```

```bash
./gradlew bootRun
```

3. **APIの呼び出し**<br>
コマンドラインで以下のリクエストを投げることで、レスポンスを取得することが出来ます。

```bash
curl -X POST      -H 'Content-Type:application/json'      -d '{
         "name": ["Masami", "Haruhisa", "Saaya"]
     }' http://localhost:8080/
```

4. **APIの停止**<br>
APIの停止をしたいときは`Ctri + C`で停止することが出来ます。
コンテナは以下のコマンドで削除することが可能です。

```docker-compose down --rmi all --volumes --remove-orphans```

# おわり
以上です。ご覧いただきありがとうございました。
