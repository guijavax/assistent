package br.com.api.utils;

public enum ServiceType {
	
	ROOT("root"),
	CLIENT("client"),
	USER("user");
	
	private String tipoServico;
	
	ServiceType(String tipoServico) {
		tipoServico = this.tipoServico;
	}	
}
