package com.kuroneko.furupon.controller;

public enum Site {
	API_INTERNAL("API(内向き)","/api/internal",false),
	API_EXTERNAL("API(外向き)","api/external",false),
	SCREEN_ADMIN("管理画面","/admin",true),
	SCREEN_USER("ユーザー画面","",true);
	
	private String label;
	private String baseUrl;
	private Boolean protectCsrf;
	
	private Site(String label, String baseUrl, Boolean protectCsrf) {
		this.label = label;
		this.baseUrl = baseUrl;
		this.protectCsrf = protectCsrf;
	}

	public static Site of(String url) {
		if( url == null ){
			return SCREEN_USER;
		}
		
		for( Site location : values() ){
			if( url.startsWith(location.baseUrl) ){
				return location;
			}
		}
		return SCREEN_USER;
	}

	public String getLabel() {
		return label;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public Boolean getProtectCsrf() {
		return protectCsrf;
	}
	
}
