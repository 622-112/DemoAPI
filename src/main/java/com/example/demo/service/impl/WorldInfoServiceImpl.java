package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.dto.ReqDemoApplicationDto;
import com.example.demo.controller.dto.ResDemoApplicationDto;
import com.example.demo.controller.dto.WorldInfo;
import com.example.demo.repository.entity.world.ReqSelectPopulatedCityEntity;
import com.example.demo.repository.entity.world.ResSelectPopulatedCityEntity;
import com.example.demo.repository.mapper.WorldDbMapper;
import com.example.demo.service.WorldInfoService;
import com.google.gson.Gson;

/**
 * WorldInfoService実装クラス
 */
@Service
public class WorldInfoServiceImpl implements WorldInfoService {

	@Autowired WorldDbMapper worldDbMapper;
	@Autowired Gson gson;

	private static Logger logger = LoggerFactory.getLogger(WorldInfoServiceImpl.class);

	@Override
	public ResDemoApplicationDto getWorldInfo(ReqDemoApplicationDto reqDemoApplicationDto) {

		ResDemoApplicationDto responceDemoApplicationDto = new ResDemoApplicationDto();
		Map<String, List<WorldInfo>> mapWorldInfo = new HashMap<>();
		List<String> names = reqDemoApplicationDto.getName();

		logger.info(gson.toJson(names));
//		if (Objects.isNull(names)) {
//			names.forEach(name -> {
//				// ここで名前に合致する国コードを取得するSQLを呼ぶ
//				// その結果の国コードで↓の処理をする
//				List<ResSelectPopulatedCityEntity> listSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(names);
//				mapWorldInfo.put(name, this.setWorldInfo(listSelectPopulatedCityEntity));
//			});
//		}
		ReqSelectPopulatedCityEntity reqSelectPopulatedCityEntity = new ReqSelectPopulatedCityEntity();
		reqSelectPopulatedCityEntity.setListCountryCode(names);
		List<ResSelectPopulatedCityEntity> listSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(reqSelectPopulatedCityEntity);
		mapWorldInfo.put("are", this.setWorldInfo(listSelectPopulatedCityEntity));

		logger.info(gson.toJson(mapWorldInfo));
		return responceDemoApplicationDto;
	}

	/**
	 * WorldInfoリスト設定メソッド
	 * @param listSelectPopulatedCityEntity selectPopulatedCityエンティティクラスリスト
	 * @return List<WorldInfo> DemoApplicationレスポンスマッピング用Dtoリスト
	 */
	private List<WorldInfo> setWorldInfo(List<ResSelectPopulatedCityEntity> listSelectPopulatedCityEntity) {

		List<WorldInfo> listWorldInfo = new LinkedList<>();
		Iterator<ResSelectPopulatedCityEntity> iterator = listSelectPopulatedCityEntity.iterator();

		while(iterator.hasNext()) {
			ResSelectPopulatedCityEntity selectPopulatedCityEntity = iterator.next();
			WorldInfo worldInfo = new WorldInfo();

			worldInfo.setCountryName(selectPopulatedCityEntity.getCountryName());
			worldInfo.setCityName(selectPopulatedCityEntity.getCityName());
			worldInfo.setCityPopulation(selectPopulatedCityEntity.getCityPopulation());

			listWorldInfo.add(worldInfo);
		}
		return listWorldInfo;
	}
}
