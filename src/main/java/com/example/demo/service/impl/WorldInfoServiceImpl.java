package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.mapper.WorldDbMapper;
import com.example.demo.service.WorldInfoService;
import com.example.demo.service.dto.WorldInfoServiceDto;

public class WorldInfoServiceImpl implements WorldInfoService{

	@Autowired WorldDbMapper worldDbMapper;

	@Override
	public WorldInfoServiceDto getWorldInfo(List<String> list) {
		worldDbMapper.selectPopulatedCity(null);
		return null;
	}
}