package com.cts.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cts.businessLogic.ExpenseLogic;
import com.cts.customException.ExpenseException;

public class TestJunit {

	//Test case to validate vehicle cost for PETROL/NON AC
	@Test
	public void testStandardNonAcVehicleCost() throws NumberFormatException, ExpenseException {
		String str = "Swift,Petrol,NON AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6000"));

	}

	//Test case to validate vehicle cost for PETROL/AC
	@Test
	public void testStandardAcVehicleCost() throws NumberFormatException, ExpenseException {
		String str = "Swift,Petrol,AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6800"));

	}

	//Test case to validate vehicle cost for DIESEL/NON AC
	@Test
	public void testDieselNonAcVehicleCost() throws NumberFormatException, ExpenseException {
		String str = "Swift,Diesel,NON AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("5600"));

	}

	//Test case to validate vehicle cost for DIESEL/AC
	@Test
	public void testDieselAcVehicleCost() throws NumberFormatException, ExpenseException {
		String str = "Swift,Diesel,AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6400"));

	}

	//Test case to validate vehicle cost for SUV-Always DIESEL and AC
	@Test
	public void testVehicleCostSUV() throws NumberFormatException, ExpenseException {
		String str = "SUV,Petrol,NON AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6400"));

	}

	//Test case to validate vehicle cost for BUS-Discounted price of 2%
	@Test
	public void testVehicleCostBUS() throws NumberFormatException, ExpenseException {
		String str = "BUS,Diesel,AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6272"));

	}

	//Test case to validate vehicle cost for BUS,SUV,VAN-Always DIESEL
	@Test
	public void testVehicleCostHeavyVehicle() throws NumberFormatException, ExpenseException {
		String str = "VAN,Petrol,AC,Pune-Mumbai-Pune";
		ExpenseLogic expenseLogic = new ExpenseLogic();
		assertEquals(expenseLogic.getExpenseInfo(str), Float.valueOf("6400"));

	}

}
