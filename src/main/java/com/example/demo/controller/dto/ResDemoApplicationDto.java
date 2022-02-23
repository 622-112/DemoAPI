package com.example.demo.controller.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * DemoApplicationレスポンスマッピング用Dto
 */
@Setter
@Getter
public class ResDemoApplicationDto {
	Map<String, List<WorldInfo>> responceDemoApprilcation;
}
