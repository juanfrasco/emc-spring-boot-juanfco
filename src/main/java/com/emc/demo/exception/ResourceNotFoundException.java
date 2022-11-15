package com.emc.demo.exception;

public class ResourceNotFoundException extends Exception{
	//Una excepció ha de ser serialitzable, per això afegim...
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
