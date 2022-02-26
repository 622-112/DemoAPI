package com.example.demo.repository.mapper.users;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.entity.users.ReqSelectUserCountryCodeEntity;
import com.example.demo.repository.entity.users.ResSelectUserCountryCodeEntity;

/**
 * UsersDbMapper.xmlで定義したSQLのインターフェースクラス
 */
@Mapper
@Transactional(transactionManager = "usersTxManager")
public interface UsersDbMapper {
	/**
	 * 引数で指定した名前に対応する国コードを取得する。
	 * @param reqSelectUserCountryCodeEntity selectUserCountryCodeエンティティクラス（リクエスト）
	 * @return List<ResSelectUserCountryCodeEntity> selectUserCountryCodeエンティティクラスリスト（レスポンス）
	 */
	List<ResSelectUserCountryCodeEntity> selectUserCountryCode(ReqSelectUserCountryCodeEntity reqSelectUserCountryCodeEntity);
}
