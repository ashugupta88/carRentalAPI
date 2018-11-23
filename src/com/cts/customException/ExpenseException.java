package com.cts.customException;

@SuppressWarnings("serial")
public class ExpenseException extends Exception{

	public ExpenseException(String message){
		super(message);
	}
}
