package com.cts.dependencies;

public enum Route {

	PUNE ("0"),
	MUMBAI ("200"),
	BANGALORE ("1000"),
	DELHI ("2050"),
	CHENNAI ("1234.5");
	
	private final String distance;

    private Route(String distance) {
        this.distance = distance;
    }
    
    public String getDistance(){
    	return this.distance;
    }
        
}