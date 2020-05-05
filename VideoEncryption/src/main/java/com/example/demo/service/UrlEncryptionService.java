package com.example.demo.service;

import java.io.File;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 视频加密接口
 * @author 熊宇坤
 */
public interface UrlEncryptionService {

	void encryption(HttpServletRequest request,HttpServletResponse response,URL url);
}
