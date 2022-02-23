package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.dto.ReqDemoApplicationDto;
import com.example.demo.controller.dto.ResDemoApplicationDto;
import com.example.demo.controller.dto.WorldInfo;
import com.example.demo.repository.entity.user.ReqSelectUserCountryCodeEntity;
import com.example.demo.repository.entity.user.ResSelectUserCountryCodeEntity;
import com.example.demo.repository.entity.world.ReqSelectPopulatedCityEntity;
import com.example.demo.repository.entity.world.ResSelectPopulatedCityEntity;
import com.example.demo.repository.mapper.user.UserDbMapper;
import com.example.demo.repository.mapper.world.WorldDbMapper;
import com.example.demo.service.WorldInfoService;
import com.google.gson.Gson;

/**
 * WorldInfoService実装クラス
 */
@Service
public class WorldInfoServiceImpl implements WorldInfoService {

	@Autowired WorldDbMapper worldDbMapper;
	@Autowired UserDbMapper userDbMapper;
	@Autowired Gson gson;

	private static final Logger logger = LoggerFactory.getLogger(WorldInfoServiceImpl.class);

	@Override
	public ResDemoApplicationDto getWorldInfo(ReqDemoApplicationDto reqDemoApplicationDto) {
		// 変数宣言
		ResDemoApplicationDto responceDemoApplicationDto = new ResDemoApplicationDto();
		Map<String, List<WorldInfo>> mapWorldInfo = new HashMap<>();
		List<WorldInfo> listWorldInfo = null;
		List<String> listCountryCode = null;
		ReqSelectUserCountryCodeEntity reqSelectUserCountryCodeEntity = new ReqSelectUserCountryCodeEntity();
		ReqSelectPopulatedCityEntity reqSelectPopulatedCityEntity = new ReqSelectPopulatedCityEntity();
		List<ResSelectUserCountryCodeEntity> listResSelectUserCountryCodeEntity = null;
		List<ResSelectPopulatedCityEntity> listResSelectPopulatedCityEntity = null;

		logger.info("reqDemoApplicationDto: " + gson.toJson(reqDemoApplicationDto));

		// リクエストが存在する場合、リクエストの名前分処理を実行
		if (Objects.nonNull(reqDemoApplicationDto.getName())) {
			for (String name : reqDemoApplicationDto.getName()) {
				listResSelectUserCountryCodeEntity = null;

				// リクエストのnameから国コードを取得
				reqSelectUserCountryCodeEntity.setName(name);
				listResSelectUserCountryCodeEntity = userDbMapper.selectUserCountryCode(reqSelectUserCountryCodeEntity);
				logger.debug("resSelectUserCountryCodeEntity: " + gson.toJson(listResSelectUserCountryCodeEntity));

				// 国コードリストが取得できた場合、処理を実行
				if (Objects.nonNull(listResSelectUserCountryCodeEntity)) {
					listCountryCode = new LinkedList<>();

					// 取得した国コードリストをリストに詰めなおす
					for (ResSelectUserCountryCodeEntity resSelectUserCountryCodeEntity : listResSelectUserCountryCodeEntity) {
						listCountryCode.add(resSelectUserCountryCodeEntity.getCountryCode());
					}
					listWorldInfo = new LinkedList<>();
					listResSelectPopulatedCityEntity = null;

					// 国コードリストに対応する都市名を取得する
					reqSelectPopulatedCityEntity.setListCountryCode(listCountryCode);
					listResSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(reqSelectPopulatedCityEntity);

					logger.debug("listSelectPopulatedCityEntity: " + gson.toJson(listResSelectPopulatedCityEntity));

					// selectPopulatedCityの返却をWorldInfoリストに変換し、mapに設定
					mapWorldInfo.put(name, this.setWorldInfo(listResSelectPopulatedCityEntity));
				}
			}
		}

		logger.info(gson.toJson(mapWorldInfo));

		// 結果返却
		responceDemoApplicationDto.setResponceDemoApprilcation(mapWorldInfo);
		return responceDemoApplicationDto;
	}

	/**
	 * WorldInfoリスト設定メソッド
	 * エンティティリストをWorldInfoリストに変換する
	 * @param listSelectPopulatedCityEntity selectPopulatedCityエンティティクラスリスト
	 * @return List<WorldInfo> DemoApplicationレスポンスマッピング用Dtoリスト
	 */
	private List<WorldInfo> setWorldInfo(List<ResSelectPopulatedCityEntity> listSelectPopulatedCityEntity) {
		List<WorldInfo> listWorldInfo = new LinkedList<>();

		if (Objects.nonNull(listSelectPopulatedCityEntity)) {
			Iterator<ResSelectPopulatedCityEntity> iterator = listSelectPopulatedCityEntity.iterator();
	
			while(iterator.hasNext()) {
				ResSelectPopulatedCityEntity selectPopulatedCityEntity = iterator.next();
				WorldInfo worldInfo = new WorldInfo();
	
				worldInfo.setCountryName(selectPopulatedCityEntity.getCountryName());
				worldInfo.setCityName(selectPopulatedCityEntity.getCityName());
				worldInfo.setCityPopulation(selectPopulatedCityEntity.getCityPopulation());
	
				listWorldInfo.add(worldInfo);
			}
		}
		return listWorldInfo;
	}
}
