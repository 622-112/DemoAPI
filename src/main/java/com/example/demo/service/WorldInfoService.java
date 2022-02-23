package com.example.demo.service;

import com.example.demo.controller.dto.ReqDemoApplicationDto;
import com.example.demo.controller.dto.ResDemoApplicationDto;

/**
 * WorldInfoServiceインターフェースクラス
 */
public interface WorldInfoService {
	/**
	 * 国情報取得
	 * リクエストから渡された名前にしたがって国情報を取得する
	 * @param reqDemoApplicationDto
	 * @return ResDemoApplicationDto
	 */
	public ResDemoApplicationDto getWorldInfo(ReqDemoApplicationDto reqDemoApplicationDto);
}