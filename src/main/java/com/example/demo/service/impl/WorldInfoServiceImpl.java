package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.dto.ResponceDemoApplicationDto;
import com.example.demo.controller.dto.WorldInfo;
import com.example.demo.domain.entity.world.SelectPopulatedCityEntity;
import com.example.demo.domain.mapper.WorldDbMapper;
import com.example.demo.service.WorldInfoService;

/**
 * WorldInfoService実装クラス
 * @author 510
 * @since 2022/02/13
 */
public class WorldInfoServiceImpl implements WorldInfoService{

	@Autowired WorldDbMapper worldDbMapper;

	@Override
	public ResponceDemoApplicationDto getWorldInfo(List<String> nameList) {

		ResponceDemoApplicationDto responceDemoApplicationDto = new ResponceDemoApplicationDto();
		Map<String, List<WorldInfo>> mapWorldInfo = new HashMap<>();

		nameList.forEach(name -> {
			// ここで名前に合致する国コードを取得するSQLを呼ぶ
			// その結果の国コードで↓の処理をする
			List<SelectPopulatedCityEntity> listSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(nameList);
			mapWorldInfo.put(name, this.setWorldInfo(listSelectPopulatedCityEntity));
		});
		return responceDemoApplicationDto;
	}

	/**
	 * WorldInfoリスト設定メソッド
	 * @param listSelectPopulatedCityEntity selectPopulatedCityエンティティクラスリスト
	 * @return List<WorldInfo> DemoApplicationレスポンスマッピング用Dtoリスト
	 */
	private List<WorldInfo> setWorldInfo(List<SelectPopulatedCityEntity> listSelectPopulatedCityEntity) {

		List<WorldInfo> listWorldInfo = new LinkedList<>();
		Iterator<SelectPopulatedCityEntity> iterator = listSelectPopulatedCityEntity.iterator();

		while(iterator.hasNext()) {
			SelectPopulatedCityEntity selectPopulatedCityEntity = iterator.next();
			WorldInfo worldInfo = new WorldInfo();

			worldInfo.setCountryName(selectPopulatedCityEntity.getCountryName());
			worldInfo.setCityName(selectPopulatedCityEntity.getCityName());
			worldInfo.setCityPopulation(selectPopulatedCityEntity.getCityPopulation());

			listWorldInfo.add(worldInfo);
		}
		return listWorldInfo;
	}
}
