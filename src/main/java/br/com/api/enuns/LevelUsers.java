package br.com.api.enuns;

public enum LevelUsers {

	F("free"),
	B("basic"),
	I("intermedium"),
	P("premium"),
	A("administrator"),
	R("root");
	
	private String levelUser;
	
	 LevelUsers (String levelUser) {
		this.levelUser = levelUser;
	}
}
