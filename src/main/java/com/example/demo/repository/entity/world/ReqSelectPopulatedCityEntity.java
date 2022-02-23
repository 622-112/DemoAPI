package com.example.demo.repository.entity.world;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * selectPopulatedCityエンティティクラス（リクエスト）
 */
@Getter
@Setter
public class ReqSelectPopulatedCityEntity {
	/*
	 * 国コード
	 */
	List<String> listCountryCode;
}
