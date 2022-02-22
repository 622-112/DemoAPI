package com.example.demo.service;

import com.example.demo.controller.dto.ReqDemoApplicationDto;
import com.example.demo.controller.dto.ResDemoApplicationDto;

/**
 * WorldInfoServiceインターフェースクラス
 */
public interface WorldInfoService {
	/**
	 * @param reqDemoApplicationDto
	 * @return ResDemoApplicationDto
	 */
	public ResDemoApplicationDto getWorldInfo(ReqDemoApplicationDto reqDemoApplicationDto);
}