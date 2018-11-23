package com.cts.expenseCalculate;

import com.cts.contract.CalculateVehicleCost;
import com.cts.dependencies.VehicleCharges;

public class CalculateVehicleCostImpl implements CalculateVehicleCost{

	@Override
	public int getVehicleCost(String vehicleType) {

		VehicleCharges charges[] = VehicleCharges.values();
		for(VehicleCharges vehicle : charges){
			if(vehicleType.equalsIgnoreCase(vehicle.name())){
				return Integer.valueOf(vehicle.getCost());
			}
		}
		
		return 0;
	}
	
}