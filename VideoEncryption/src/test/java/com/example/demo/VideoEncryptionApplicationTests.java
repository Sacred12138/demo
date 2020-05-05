package com.example.demo;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@SpringBootTest
class VideoEncryptionApplicationTests {

	@Test
	void contextLoads() {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
			BitMatrix bitMatrix = qrCodeWriter.encode("www.baidu.com", BarcodeFormat.QR_CODE, 100, 100);
			Path path = FileSystems.getDefault().getPath("D:\\filerupdate\\"+System.currentTimeMillis()+".png");
					
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
