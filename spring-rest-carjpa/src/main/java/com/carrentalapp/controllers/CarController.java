package com.carrentalapp.controllers;

import com.carrentalapp.model.Car;
import com.carrentalapp.service.ICarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car-api")
public class CarController {
    ICarService iCarService;

    public CarController(ICarService iCarService) {

        this.iCarService = iCarService;
    }

    //http://localhost:8080/car-api/cars
    @PostMapping("/cars")
    public void addCar(@RequestBody Car car){
        System.out.println(car);
        iCarService.addCar(car);
    }

    //http://localhost:8080/car-api/cars
    @PutMapping("/cars")
    public void updateCar(@RequestBody Car car){
        System.out.println(car);
        iCarService.updateCar(car);
    }

    //http://localhost:8080/car-api/cars/carNumber/
    @DeleteMapping("/cars/carNumber/{carNumber}")
    public void deleteCar(@PathVariable("carNUmber") int carNUmber){
        iCarService.deleteCar(carNUmber);
    }

    //http://localhost:8080/car-api/cars
    @GetMapping("/cars")
    public List<Car> showCar(){
        return iCarService.getAll();
    }

    //http://localhost:8080/car-api/cars/carNumber
    @GetMapping("/cars/carNumber/{carNumber}")
    public Car showByCarNumber(@PathVariable("carNumber") int carNumber){
        return iCarService.getById(carNumber);
    }

    //http://localhost:8080/car-api/cars/brand/value/model/value
    @GetMapping("/cars/brand/{brand}/model/{model}")
    public List<Car> showByBrandAndModel(@PathVariable("brand") String brand,@PathVariable("model") String model ){
        return iCarService.getByBrandAndModel(brand,model);
    }

    //http://localhost:8080/car-api/cars/mileage/value
    @GetMapping("/cars/mileage/{mileage}")
    public List<Car> showByMileage(@PathVariable("mileage") int mileage){
        return iCarService.getByMileage(mileage);
    }

    //http://localhost:8080/car-api/cars/pricePerHour/value
    @GetMapping("/cars/pricePerHour/{pricePerHour}")
    public List<Car> showByPricePerHourLessThan(@PathVariable("pricePerHour") double pricePerHour){
        return iCarService.getByPricePerHourLessThan(pricePerHour);
    }

    //http://localhost:8080/car-api/cars/noOfSeats/value
    @GetMapping("/cars/noOfSeats/{noOfSeats}")
    public List<Car> showByNoOfSeats(@PathVariable("noOfSeats") int noOfSeats){
        return iCarService.getByNoOfSeats(noOfSeats);
    }

    //http://localhost:8080/car-api/cars/color/value/rating/value
    @GetMapping("/cars/color/{color}/rating/{rating}")
    public List<Car> showByColorAndRating(@PathVariable("color") String color,@PathVariable("rating") double rating){
        return iCarService.getByColorAndRating(color,rating);
    }


    //http://localhost:8080/car-api/cars/rating/value/mileage/value
    @GetMapping("/cars/rating/{rating}/mileage/{mileage}")
    public List<Car> showByRatingAndMileage(@PathVariable("rating") double rating,@PathVariable("mileage") int mileage){
        return iCarService.getByRatingAndMileage(rating,mileage);
    }

    //http://localhost:8080/car-api/cars/kmsDriven/value/fuelType/value
    @GetMapping("/cars/kmsDriven/{kmsDriven}/fuelType/{fuelType}")
    public List<Car> showByDistanceAndFuel(@PathVariable("kmsDriven") double kmsDriven,@PathVariable("fuelType") String fuelType){
        return iCarService.getByDistanceAndFuel(kmsDriven,fuelType);
    }


    //http://localhost:8080/car-api/cars/transmission/value/isInsuranced/value
    @GetMapping("/cars/transmission/{transmission}/isInsuranced/{isInsuranced}")
    public List<Car> showByTransAndInsurance(@PathVariable("transmission") String transmission,@PathVariable("isInsuranced") boolean isInsuranced){
        return iCarService.getByTransAndInsurance(transmission,isInsuranced);
    }

    //http://localhost:8080/car-api/cars/noOfSeats/value/pickupType/value
    @GetMapping("/cars/noOfSeats/{noOfSeats}/pickupType/{pickupType}")
    public List<Car> showBySeatsAndPickup(@PathVariable("noOfSeats") int noOfSeats,@PathVariable("pickupType") String pickupType){
        return iCarService.getBySeatsAndPickup(noOfSeats,pickupType);
    }

    //http://localhost:8080/car-api/cars/carType/value/pricePerHour/value
    @GetMapping("/cars/carType/{carType}/pricePerHour/{pricePerHour}")
    public List<Car> showByTypeAndPrice(@PathVariable("carType") String carType,@PathVariable("pricePerHour") double pricePerHour){
        return iCarService.getByTypeAndPrice(carType,pricePerHour);
    }

    //http://localhost:8080/car-api/cars/brand/value/pickupType/value/noOfSeats/value
    @GetMapping("/cars/brand/{brand}/pickupType/{pickupType}/noOfSeats/{noOfSeats}")
    public List<Car> showByBrandAndPickupAndSeats(@PathVariable("brand") String brand,@PathVariable("pickupType") String pickupType,@PathVariable("noOfSeats") int noOfSeats){
        return iCarService.getByBrandAndPickupAndSeats(brand,pickupType,noOfSeats);
    }

    //http://localhost:8080/car-api/cars/mileage/value/rating/value/carType/value
    @GetMapping("/cars/mileage/{mileage}/rating/{rating}/carType/{carType}")
    public List<Car> showByMileageAndRatingAndType(@PathVariable("mileage") int mileage,@PathVariable("rating") double rating,@PathVariable("carType") String carType){
        return iCarService.getByMileageAndRatingAndType(mileage,rating,carType);
    }

}
