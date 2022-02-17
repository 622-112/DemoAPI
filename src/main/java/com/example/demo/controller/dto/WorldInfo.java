package com.example.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DemoApplicationレスポンスマッピング用Dto(WorldInfo)
 * @author 510
 * @since 2022/02/13
 */
@Setter
@Getter
public class WorldInfo {

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
