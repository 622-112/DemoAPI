package com.example.demo.service;

import java.util.List;
import com.example.demo.service.dto.WorldInfoServiceDto;

/**
 * WorldInfoService�C���^�[�t�F�[�X�N���X
 * @author 510
 * @since 2022/02/13
 */
public interface WorldInfoService {
	/**
	 * 
	 * @param list
	 * @return WorldInfoServiceDto
	 */
	public WorldInfoServiceDto getWorldInfo(List<String> list);
}