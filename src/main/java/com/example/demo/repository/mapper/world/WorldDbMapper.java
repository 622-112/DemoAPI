package com.example.demo.repository.mapper.world;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.entity.world.ReqSelectPopulatedCityEntity;
import com.example.demo.repository.entity.world.ResSelectPopulatedCityEntity;

/**
 * WorldDbMapper.xmlで定義したSQLのインターフェースクラス
 */
@Mapper
@Transactional(transactionManager = "worldTxManager")
public interface WorldDbMapper {
	/**
	 * 引数で指定した国の人口が多い都市上位3件を取得する。
	 * @param reqSelectPopulatedCityEntity SelectPopulatedCityエンティティクラス（リクエスト）
	 * @return ResSelectPopulatedCityEntity SelectPopulatedCityエンティティクラス（レスポンス）
	 */
	List<ResSelectPopulatedCityEntity> selectPopulatedCity(ReqSelectPopulatedCityEntity reqSelectPopulatedCityEntity);
}
