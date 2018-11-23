package com.cts.expenseCalculate;

import com.cts.contract.TripExpense;
import com.cts.contract.TripExpenseConsumer;

public class TripExpenseConsumerImpl implements TripExpenseConsumer{
	
	TripExpense tripExpense;
	
	TripExpenseConsumerImpl(TripExpense tripExpense){
		this.tripExpense = tripExpense;
	}

	@Override
	public Float getTotalTripCost(Float distance, Float cost) {
		return this.tripExpense.getTotalTripCost(distance, cost);
	}
	
}