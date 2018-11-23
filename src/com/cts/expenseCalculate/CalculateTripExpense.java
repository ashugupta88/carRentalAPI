package com.cts.expenseCalculate;

import com.cts.businessLogic.ExpenseLogic;
import com.cts.customException.ExpenseException;

public class CalculateTripExpense {

	public static void main(String[] args) throws ExpenseException {

		String sampleInput = "Swift,Diesel,NON AC,Pune-Mumbai-Pune";
		System.out.println(new ExpenseLogic().getExpenseInfo(sampleInput));
		
	}
}