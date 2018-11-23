package com.cts.dependencies;

public enum VehicleCharges {

	STANDARDV (15),
	STANDARDVAC (17),
	DIESELV (14),
	DIESELVAC (16);
	
	private final int cost;

    private VehicleCharges(int cost) {
        this.cost = cost;
    }
    
    public int getCost(){
    	return this.cost;
    }
    
}