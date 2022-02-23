# MySQL8を構築
FROM mysql:8

# 3305番ポートを利用
EXPOSE 3305

# my.cnfの設定を更新
ADD ./my.cnf /etc/mysql/conf.d/my.cnf

# mysqldを実行
CMD ["mysqld"]
