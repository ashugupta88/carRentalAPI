package com.cts.expenseCalculate;

import com.cts.contract.TripExpense;

public class TripExpenseOfDiesel implements TripExpense{

	@Override
	public Float getTotalTripCost(Float distance, Float cost) {
		//Some more business logic can be added in future specific to diesel vehicles
		return (distance*cost);
	}
	
}