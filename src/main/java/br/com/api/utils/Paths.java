package br.com.api.utils;

/**
 * @author guilherme
 */
import org.springframework.http.MediaType;

public interface Paths{

	  static final String PATH_ROUTER = "/assistent";
	  
	  static final String PRIVATE_ACESS = "/private".concat(PATH_ROUTER);
	  
	  static final String ADM = "/adm".concat(PRIVATE_ACESS);
	 
	  static final String FREE_ACESS = "/free".concat(PATH_ROUTER);
	  
	  static final String BASIC_ACESS = "/basic".concat(PRIVATE_ACESS);
	  
	  static final String INTERMEDIUN_ACESS = "/inter".concat(PRIVATE_ACESS);
	  
	  static final String ROOT_ACESS = "/root".concat(ADM);
	  
	  static final String ADVANCED_ACCESS = "/advanced".concat(PRIVATE_ACESS);
	  	
}
