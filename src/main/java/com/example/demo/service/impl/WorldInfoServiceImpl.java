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
 * WorldInfoService�����N���X
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
			// �����Ŗ��O�ɍ��v���鍑�R�[�h���擾����SQL���Ă�
			// ���̌��ʂ̍��R�[�h�Ł��̏���������
			List<SelectPopulatedCityEntity> listSelectPopulatedCityEntity = worldDbMapper.selectPopulatedCity(nameList);
			mapWorldInfo.put(name, this.setWorldInfo(listSelectPopulatedCityEntity));
		});
		return responceDemoApplicationDto;
	}

	/**
	 * WorldInfo���X�g�ݒ胁�\�b�h
	 * @param listSelectPopulatedCityEntity selectPopulatedCity�G���e�B�e�B�N���X���X�g
	 * @return List<WorldInfo> DemoApplication���X�|���X�}�b�s���O�pDto���X�g
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
