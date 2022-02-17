package com.example.demo.domain.entity.world;

import lombok.Getter;
import lombok.Setter;

/**
 * selectPopulatedCityエンティティクラス
 * @author 510
 * @since 2022/02/13
 */
@Getter
@Setter
public class SelectPopulatedCityEntity {
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
