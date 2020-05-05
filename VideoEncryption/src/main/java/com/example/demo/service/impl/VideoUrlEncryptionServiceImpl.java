package com.example.demo.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.service.UrlEncryptionService;

/**
 * 视频加密实现类
 * @author 熊宇坤
 */
@Service("videoUrlEncryp")
public class VideoUrlEncryptionServiceImpl implements UrlEncryptionService {
	
	String url = "http://video.mdedu.cn/sv/3ac92de0-16bfef17221/3ac92de0-16bfef17221.mp4";

	private static final Logger log = LoggerFactory.getLogger(VideoUrlEncryptionServiceImpl.class);

	@Override
	public void encryption(HttpServletRequest request, HttpServletResponse response, URL url) {
		String agent = request.getHeader("User-Agent").toUpperCase();
		
		try {
			InputStream inputStream = url.openStream();
			
			//获取格式
			String fileName = url.getFile();
			
			if(agent.indexOf("FIREFOX") != -1){//火狐浏览器
				response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"),"ISO-8859-1"));
		    }else{//其他浏览器
		    	response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
		    }
			//设置response编码
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Length", String.valueOf(inputStream.available()));
		    //设置输出文件类型
			response.setContentType("video/mpeg4");
			response.setHeader("Host", "video.mdedu.cn");
		    //获取response输出流
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
