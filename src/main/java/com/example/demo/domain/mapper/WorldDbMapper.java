package com.example.demo.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.entity.world.SelectPopulatedCityEntity;

/**
 * WorldDbMapper.xmlで定義したSQLのインターフェースクラスです。
 * @author 510
 * @since 2022/02/13
 */
public interface WorldDbMapper {
	/**
	 * 引数で指定した国の人口が多い都市上位3件を取得する。
	 * @param listCounrtyCode 国コードリスト
	 * @return SelectContinentEntity SelectPopulatedCityエンティティクラス
	 */
	List<SelectPopulatedCityEntity> selectPopulatedCity(@Param("listCounrtyCode") List<String> listCounrtyCode);
}
