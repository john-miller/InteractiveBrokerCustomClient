package com.miller.ibcc.gui.injector;

/**
 * Injects form content into application frame
 *
 * Created On May 30, 2016
 * @author Jonathan Miller
 * @param <T>
 */
public interface ContentInjector<T> {

	public void injectContent(T object);
	
}
