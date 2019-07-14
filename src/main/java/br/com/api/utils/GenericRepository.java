package br.com.api.utils;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author guilherme
 *
 * @param <T>
 * @param <ID>
 * 
 */
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, Serializable>{
	
	/**
	 * 
	 * @return
	 * The metode is reponsable for recover
	 */
	default List<T> findAllObjects() {
		return findAll();
	}
	
	default T findOneObject(ID id) {
		return getOne(id);
	}
}
