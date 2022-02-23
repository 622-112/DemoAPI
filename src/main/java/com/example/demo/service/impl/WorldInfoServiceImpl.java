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
import com.example.demo.repository.entity.world.UserCountry;
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
		logger.info("reqDemoApplicationDto: " + gson.toJson(reqDemoApplicationDto));
		ResDemoApplicationDto responceDemoApplicationDto = new ResDemoApplicationDto();
		Map<String, List<WorldInfo>> mapWorldInfo = new HashMap<>();

		// リクエストが存在する場合、処理を実行
		if (Objects.nonNull(reqDemoApplicationDto)) {
			ReqSelectUserCountryCodeEntity reqSelectUserCountryCodeEntity = new ReqSelectUserCountryCodeEntity();
			List<ResSelectUserCountryCodeEntity> listResSelectUserCountryCodeEntity = null;

			// リクエストのnameから国コードを取得
			reqSelectUserCountryCodeEntity.setListName(reqDemoApplicationDto.getName());
			listResSelectUserCountryCodeEntity = userDbMapper.selectUserCountryCode(reqSelectUserCountryCodeEntity);
			logger.debug("resSelectUserCountryCodeEntity: " + gson.toJson(listResSelectUserCountryCodeEntity));

			// 国コードリストが取得できた場合、処理を実行
			if (Objects.nonNull(listResSelectUserCountryCodeEntity)) {
				List<UserCountry> listUserCountry = new LinkedList<>();
				UserCountry userCountry = null;
				ReqSelectPopulatedCityEntity reqSelectPopulatedCityEntity = new ReqSelectPopulatedCityEntity();
				List<ResSelectPopulatedCityEntity> listResSelectPopulatedCityEntity = null;

				// 取得した国コードリストをリストに詰めなおす
				for (ResSelectUserCountryCodeEntity resSelectUserCountryCodeEntity : listResSelectUserCountryCodeEntity) {
					userCountry = new UserCountry();
					userCountry.setName(resSelectUserCountryCodeEntity.getName());
					userCountry.setCountryCode(resSelectUserCountryCodeEntity.getCountryCode());
					listUserCountry.add(userCountry);
				}

				// 国コードリストに対応する都市名を取得する
				reqSelectPopulatedCityEntity.setListUserCountry(listUserCountry);
				listResSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(reqSelectPopulatedCityEntity);

				logger.debug("listSelectPopulatedCityEntity: " + gson.toJson(listResSelectPopulatedCityEntity));

				// selectPopulatedCityの返却をWorldInfoリストに変換し、mapに設定
				this.setWorldInfo(mapWorldInfo, listResSelectPopulatedCityEntity);
			}
		}

		logger.info(gson.toJson(mapWorldInfo));

		// 結果返却
		responceDemoApplicationDto.setResponceDemoApprilcation(mapWorldInfo);
		return responceDemoApplicationDto;
	}

	/**
	 * WorldInfoリスト設定メソッド
	 * エンティティリストをWorldInfoリストマップに変換する
	 * @param mapWorldInfo 返却用世界情報リスト
	 * @param listSelectPopulatedCityEntity selectPopulatedCityエンティティクラスリスト
	 */
	private void setWorldInfo(Map<String, List<WorldInfo>> mapWorldInfo, List<ResSelectPopulatedCityEntity> listSelectPopulatedCityEntity) {
		if (Objects.nonNull(listSelectPopulatedCityEntity)) {
			Iterator<ResSelectPopulatedCityEntity> iterator = listSelectPopulatedCityEntity.iterator();
			List<WorldInfo> listWorldInfo = null;
			String name = null;

			// selectPopulatedCityの返却分、ループ処理
			while(iterator.hasNext()) {
				ResSelectPopulatedCityEntity selectPopulatedCityEntity = iterator.next();
				WorldInfo worldInfo = new WorldInfo();
				name = selectPopulatedCityEntity.getName();

				worldInfo.setCountryName(selectPopulatedCityEntity.getCountryName());
				worldInfo.setCityName(selectPopulatedCityEntity.getCityName());
				worldInfo.setCityPopulation(selectPopulatedCityEntity.getCityPopulation());

				// 現在レコードの名前がmapに存在しない場合はインスタンス作成してworldInfoを追加
				// 存在する場合はlistにworldInfoを追加
				if (Objects.isNull(mapWorldInfo.get(name))) {
					listWorldInfo = new LinkedList<>();
				} else {
					listWorldInfo = mapWorldInfo.get(name);
				}
				listWorldInfo.add(worldInfo);
				mapWorldInfo.put(name, listWorldInfo);
			}
		}
	}
}
