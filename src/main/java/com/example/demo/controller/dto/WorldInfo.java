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
	String countryName;
	String cityName;
	String cityPopulation;
}
