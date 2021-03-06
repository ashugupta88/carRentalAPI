package com.cts.expenseCalculate;

import com.cts.contract.DependencyInjector;
import com.cts.contract.TripExpenseConsumer;

public class TripExpenseOfDieselInject implements DependencyInjector{

	@Override
	public TripExpenseConsumer getTripExpenseConsumer() {
		return new TripExpenseConsumerImpl(new TripExpenseOfDiesel());
	}

}