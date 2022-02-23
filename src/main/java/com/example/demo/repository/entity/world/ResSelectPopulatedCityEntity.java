package com.example.demo.repository.entity.world;

import lombok.Getter;
import lombok.Setter;

/**
 * selectPopulatedCityエンティティクラス（レスポンス）
 */
@Getter
@Setter
public class ResSelectPopulatedCityEntity {
	/*
	 * 名前
	 */
	String name;
	/*
	 * 国
	 */
	String countryName;
	/*
	 * 市
	 */
	String cityName;
	/*
	 * 人口
	 */
	String cityPopulation;
}
