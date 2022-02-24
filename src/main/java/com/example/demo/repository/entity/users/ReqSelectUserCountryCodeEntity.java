package com.example.demo.repository.entity.users;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * selectUserCountryCodeエンティティクラス（リクエスト）
 */
@Getter
@Setter
public class ReqSelectUserCountryCodeEntity {
	/*
	 * 名前
	 */
	List<String> listName;
}
