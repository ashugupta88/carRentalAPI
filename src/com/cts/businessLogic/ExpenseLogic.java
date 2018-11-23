package com.cts.businessLogic;

import com.cts.constants.Constants;
import com.cts.contract.DependencyInjector;
import com.cts.contract.TripExpenseConsumer;
import com.cts.customException.ExpenseException;
import com.cts.dependencies.VehicleTypes;
import com.cts.expenseCalculate.CalculateVehicleCostImpl;
import com.cts.expenseCalculate.DistanceCalculator;
import com.cts.expenseCalculate.TripExpenseOfDieselInject;
import com.cts.expenseCalculate.TripExpenseOfPetrolInject;

public class ExpenseLogic {

	public Float getExpenseInfo(String inputParameters) throws ExpenseException{
		
		//Input validation
		validateInput(inputParameters);
		
		DependencyInjector injector = null;
		TripExpenseConsumer consumer = null;
		
		Boolean isAc = false;
		Boolean hasDiscount = false;
		String vehicleType = "";//It can be CAR,SUV,VAN,BUS etc.
		Float vehicleCost;
		Float totalDistance;
		String emission = "";//It can be either Petrol,Diesel
				
		//parse input
		//the input can be fetched from command line arguments, a web page etc.
		String values[] = inputParameters.split(",");
		String route = values[3];
		
		//parse route
		String routes[] = route.split("-");
				
		//since the route always starts from Pune, calculate total distance
		totalDistance = new DistanceCalculator().getDistance(routes[1]);
		
		if(values[2].equals(Constants.AC)){
			isAc = true;
		}
		
		//Calculate cost of the vehicle based on car type and isAc flag
		vehicleType = values[0];
		emission = values[1];
		
		//SUV is always an AC and runs on diesel
		if(vehicleType.equals(VehicleTypes.SUV.name())){
			isAc = true;
			emission = Constants.EMISSION_DIESEL;
		} else if (vehicleType.equals(VehicleTypes.BUS.name())){
			//2% discount for hiring bus
			hasDiscount = true;
		}
		
		VehicleTypes vehicleTypes[] = VehicleTypes.values();
		for(VehicleTypes type: vehicleTypes){
			//SUV,BUS,VAN always run on diesel
			if(vehicleType.equals(type.name())){
				emission = Constants.EMISSION_DIESEL;
				vehicleType = Constants.VEHICLETYPE_DIESEL;
			}
		}
		
		if(vehicleType.equals(Constants.VEHICLETYPE_DIESEL)){
			//Vehicle identified as BUS,VAN,SUV which is always diesel
			if(isAc == true){
				vehicleType = Constants.VEHICLETYPE_DIESELAC;
			} else {
				vehicleType = Constants.VEHICLETYPE_DIESEL;
			}
		} else {
			//Vehicle identifies is standard that can be petrol or diesel
			if(isAc == true){
				if(emission.equals(Constants.EMISSION_PETROL)){
					vehicleType = Constants.VEHICLETYPE_PETROLAC;
				} else {
					vehicleType = Constants.VEHICLETYPE_DIESELAC;
				}
			} else {
				if(emission.equals(Constants.EMISSION_DIESEL)){
					vehicleType = Constants.VEHICLETYPE_DIESEL;
				} else {
					vehicleType = Constants.VEHICLETYPE_PETROL;
				}
			}
		}
		
		vehicleCost = Float.valueOf(String.valueOf(
				new CalculateVehicleCostImpl().getVehicleCost(vehicleType)));
		
		if(hasDiscount){
			vehicleCost = Float.valueOf(String.valueOf(vehicleCost)) - 
					(float)Integer.valueOf(Constants.DISCOUNT)/100*vehicleCost;
		}
		
		if(emission.equals(Constants.EMISSION_PETROL)){
			injector = new TripExpenseOfPetrolInject();
		} else {
			injector = new TripExpenseOfDieselInject();
		}
		
		consumer = injector.getTripExpenseConsumer();
		
		return consumer.getTotalTripCost((totalDistance*2), vehicleCost);
	}
	
	public void validateInput(String inputParameters) throws ExpenseException{
	
		String inputValues[] = inputParameters.split(",");
		String emission = inputValues[1];
		String isAc = inputValues[2];
		String route = inputValues[3];
		
		if(!(emission.equalsIgnoreCase(Constants.EMISSION_PETROL) || 
				emission.equalsIgnoreCase(Constants.EMISSION_DIESEL))){
			throw new ExpenseException("Emission could be Petrol or Diesel");
		}
		
		if(!(isAc.equals(Constants.AC) || isAc.equals(Constants.NONAC))){
			throw new ExpenseException("Must be AC or NON AC");
		}
		
		String routes[] = route.split("-");
		if(routes.length != 3){
			throw new ExpenseException("Must be defined properly in format Pune-XYZ-Pune");
		}
		
	}
}
