package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.dto.ResponceDemoApplicationDto;

/**
 * WorldInfoService�C���^�[�t�F�[�X�N���X
 * @author 510
 * @since 2022/02/13
 */
public interface WorldInfoService {
	/**
	 * 
	 * @param nameList
	 * @return ResponceDemoApplicationDto
	 */
	public ResponceDemoApplicationDto getWorldInfo(List<String> nameList);
}