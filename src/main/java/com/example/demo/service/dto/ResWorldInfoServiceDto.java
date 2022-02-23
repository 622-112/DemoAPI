package com.example.demo.service.dto;

import java.util.List;
import java.util.Map;

import com.example.demo.controller.dto.WorldInfo;

/**
 * WorldInfoService用Dto（レスポンス）
 */
public class ResWorldInfoServiceDto {
	/*
	 * KEY：名前
	 * VALUE：国情報リスト
	 */
	Map<String, List<WorldInfo>> worldInfo;
}
