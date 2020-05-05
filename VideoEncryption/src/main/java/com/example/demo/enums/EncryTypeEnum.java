package com.example.demo.enums;

public enum EncryTypeEnum {
	视频("mp4",""),
	音频("mp3",""),
	图片("jpg","");
	
	private String key;
	
	private String value;
	
	EncryTypeEnum(){}
	
	EncryTypeEnum(String key,String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
