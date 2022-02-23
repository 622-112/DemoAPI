package com.example.demo.repository.entity.user;

import lombok.Getter;
import lombok.Setter;

/**
 * selectUserCountryCodeエンティティクラス（レスポンス）
 */
@Getter
@Setter
public class ResSelectUserCountryCodeEntity {
	/*
	 * 名前
	 */
	String name;
	/*
	 * 国コード
	 */
	String countryCode;
}
