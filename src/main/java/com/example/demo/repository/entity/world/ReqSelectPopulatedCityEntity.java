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
	 * ユーザ国リスト
	 */
	List<UserCountry> listUserCountry;
}
