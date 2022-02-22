package com.example.demo.controller.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DemoApplicationリクエストマッピング用Dto
 */
@NoArgsConstructor
@Setter
@Getter
public class ReqDemoApplicationDto {
	private List<String> name;
}
