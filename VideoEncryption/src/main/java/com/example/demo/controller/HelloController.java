package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

	@RequestMapping("/toHello")
	public Map<String, Object> toHello(String params){
		Map<String, Object> result = new HashMap<>();
		result.put("params", params);
		return result;
	}
}
