package com.cts.expenseCalculate;

import com.cts.contract.Distance;
import com.cts.dependencies.Route;

public class DistanceCalculator implements Distance{

	@Override
	public Float getDistance(String route) {

		Route routeValues[] = Route.values();
		for(Route getRoute : routeValues){
			if(route.equalsIgnoreCase(getRoute.name())){
				return Float.valueOf(getRoute.getDistance());
			}
		}
		
		return null;
	}

}
