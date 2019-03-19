package com.example.dragonball.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dragonball")
public class DragonApiProperty {
	
	private String originPermitida = "http://186.214.191.23";
	
	private final Seguranca seguranca = new Seguranca();
	
		
	public String getOriginPermitida() {
		return originPermitida;
	}


	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}



	public Seguranca getSeguranca() {
		return seguranca;
	}



	public static class Seguranca{
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
		
	}
}
