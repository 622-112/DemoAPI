package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.dto.ReqDemoApplicationDto;
import com.example.demo.controller.dto.ResDemoApplicationDto;
import com.example.demo.service.WorldInfoService;

/**
 * DemoApplicationコントローラクラス
 */
@RestController
public class DemoApplicationController {

	@Autowired WorldInfoService worldInfoService;

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResDemoApplicationDto getDemoApplication(@RequestBody ReqDemoApplicationDto reqDemoApplicationDto) {
		return worldInfoService.getWorldInfo(reqDemoApplicationDto);
	}
}
