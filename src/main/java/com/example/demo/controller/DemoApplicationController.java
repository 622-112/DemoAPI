package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.RequestDemoApplicationDto;
import com.example.demo.controller.dto.ResponceDemoApplicationDto;
import com.example.demo.service.WorldInfoService;

/**
 * DemoApplicationコントローラクラス
 * @author 510
 * @since 2022/02/13
 */
@RestController
public class DemoApplicationController {

	@Autowired WorldInfoService worldInfoService;

	@RequestMapping("/")
	public ResponceDemoApplicationDto getDemoApplication(RequestDemoApplicationDto requestDemoApplicationDto) {
		worldInfoService.getWorldInfo(requestDemoApplicationDto.getName());
		return null;
	}
}
