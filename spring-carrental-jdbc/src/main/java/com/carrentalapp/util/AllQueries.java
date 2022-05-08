package com.carrentalapp.util;

public class AllQueries {

	// For adding and updating cars
	public static final String ADDQUERY = "insert into car values(?,?,?,?,?,?)";
	public static final String DELETEQUERY = "delete from car where carNumber = ?";
	public static final String UPDATEQUERY = "update car set pricePerHour = ? where carNumber = ?";
	
	// For retrieving cars
	public static final String ALLQUERY = "select * from car";
	public static final String SINGLECAR = "select * from car where carNumber = ?";
	public static final String BRANDANDSEATSQUERY = "select * from car where brand = ? and noOfSeats = ?";
	public static final String MILEAGEQUERY = "select * from car where mileage = ?";
	public static final String PRICEQUERY = "select * from car where pricePerHour = ?";
	
	//For adding customers
	public static final String BOOKINGQUERY = "insert into booking values(?,?,?,?,?,?,?,?,?,?) ";
	public static final String IDQUERY = "select * from booking where bookingId = ?";
	public static final String DATEQUERY = "select * from booking where date = ?";
	public static final String PAYMENTQUERY = "select * from booking where paymentDone = ?";
	public static final String LESSERPRICEQUERY = "select * from booking where totalCost < ?";
	
	//For total cost
	public static final String TOTALCOSTQUERY = "select pricePerHour from car c where c.carNumber =?";
	
	
}
