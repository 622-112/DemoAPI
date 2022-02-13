package com.example.demo.controller.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DemoApplicationリクエストマッピング用Dto
 * @author 510
 * @since 2022/02/12
 */
@NoArgsConstructor
@Setter
@Getter
public class RequestDemoApplicationDto {
	List<String> name;
}
