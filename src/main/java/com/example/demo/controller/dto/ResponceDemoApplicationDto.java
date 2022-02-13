package com.example.demo.controller.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * DemoApplicationレスポンスマッピング用Dto
 * @author 510
 * @since 2022/02/13
 */
@Setter
@Getter
public class ResponceDemoApplicationDto {
	Map<String, List<WorldInfo>> responceDemoApprilcation;
}
