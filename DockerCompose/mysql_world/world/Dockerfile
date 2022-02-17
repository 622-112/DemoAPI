# MySQL8を構築
FROM mysql:8

# 3306番ポートを利用
EXPOSE 3306

# my.cnfの設定を更新
ADD ./my.cnf /etc/mysql/conf.d/my.cnf

# mysqldを実行
CMD ["mysqld"]
