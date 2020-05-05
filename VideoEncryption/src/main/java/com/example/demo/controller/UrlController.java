package com.example.demo.controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.UrlEncryptionService;
import com.example.demo.service.impl.VideoUrlEncryptionServiceImpl;

@Controller
@RequestMapping("url")
public class UrlController {
	
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired
	private UrlEncryptionService videoUrlEncryp;

	@RequestMapping(value = "playVideo",method = RequestMethod.GET)
	public String getVideoBlob() {
		return "videoPlay";
	}
	
	@RequestMapping(value = "playVideo",method = RequestMethod.POST)
	public void getVideoBlob(String url,HttpServletRequest request,HttpServletResponse response) {
		try {
			videoUrlEncryp.encryption(request, response, new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
