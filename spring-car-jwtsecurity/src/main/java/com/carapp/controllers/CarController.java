package com.carapp.controllers;


import com.carapp.model.Car;
import com.carapp.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-api")
public class CarController {

    ICarService iCarService;

    @Autowired
    public void setiCarService(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> addCar(@RequestBody Car car){
        iCarService.addCar(car);
        return  ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @PutMapping("/cars")
    public ResponseEntity<Void> updateCar(@RequestBody Car car){
        iCarService.updateCar(car);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
    @DeleteMapping("/cars/carNumber/{carNumber}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carNumber") int carNumber){
        iCarService.deleteCar(carNumber);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one car by car number "+carNumber);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = iCarService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting all cars");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);

    }

    @GetMapping("/cars/carNumber/{carNumber}")
    public ResponseEntity<Car> getById(@PathVariable("carNumber") int carNumber){
        Car car = iCarService.getById(carNumber);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting one car by car number "+carNumber);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(car);

    }

    // derived methods
    @GetMapping("/cars/brand/{brand}/model/{model}")
    public ResponseEntity<List<Car>> getByBrandAndModel(@PathVariable("brand") String brand,@PathVariable("model") String model){
        List<Car> cars = iCarService.getByBrandAndModel(brand,model);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by brand "+brand+" and model "+model);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);

    }
    @GetMapping("/cars/mileage/{mileage}")
    public ResponseEntity<List<Car>> getByMileage(@PathVariable("mileage")int mileage){
        List<Car> cars = iCarService.getByMileage(mileage);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by mileage "+mileage);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/pricePerHour/{pricePerHour}")
    public ResponseEntity<List<Car>> getByPricePerHourLessThan(@PathVariable("pricePerHour")double pricePerHour){
        List<Car> cars = iCarService.getByPricePerHourLessThan(pricePerHour);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by price per hour less than "+pricePerHour);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/noOfSeats/{noOfSeats}")
    public ResponseEntity<List<Car>> getByNoOfSeats(@PathVariable("noOfSeats") int noOfSeats){
        List<Car> cars = iCarService.getByNoOfSeats(noOfSeats);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by no of seats "+noOfSeats);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/color/{color}/rating/{rating}")
    public ResponseEntity<List<Car>>  getByColorAndRating(@PathVariable("color") String color,@PathVariable("rating") double rating){
        List<Car> cars = iCarService.getByColorAndRating(color,rating);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by color "+color+" and rating "+rating);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/rating/{rating}/mileage/{mileage}")
    public ResponseEntity<List<Car>> getByRatingAndMileage(@PathVariable("rating") double rating,@PathVariable("mileage") int mileage){
        List<Car> cars = iCarService.getByRatingAndMileage(rating,mileage);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by rating "+rating+" and mileage "+mileage);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }


    // custom queries
    @GetMapping("/cars/kmsDriven/{kmsDriven}/fuelType/{fuelType}")
    public ResponseEntity<List<Car>> getByDistanceAndFuel(@PathVariable("kmsDriven") double kmsDriven,@PathVariable("fuelType") String fuelType){
        List<Car> cars = iCarService.getByDistanceAndFuel(kmsDriven,fuelType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by kms driven "+kmsDriven+" and fuel type "+fuelType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/transmission/{transmission}/insuranced/{insuranced}")
    public ResponseEntity<List<Car>> getByTransAndInsurance(@PathVariable("transmission") String transmission,@PathVariable("insuranced") boolean insuranced){
        List<Car> cars = iCarService.getByTransAndInsurance(transmission,insuranced);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by transmission "+transmission+" and insurance "+insuranced);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/noOfSeats/{noOfSeats}/pickupType/{pickupType}")
    public ResponseEntity<List<Car>>  getBySeatsAndPickup(@PathVariable("noOfSeats") int noOfSeats,@PathVariable("pickupType") String pickupType){
        List<Car> cars = iCarService.getBySeatsAndPickup(noOfSeats,pickupType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by no of seats "+noOfSeats+" and pickup type "+pickupType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/carType/{carType}/pricePerHour/{pricePerHour}")
    public ResponseEntity<List<Car>>  getByTypeAndPrice(@PathVariable("carType") String carType,@PathVariable("pricePerHour")double pricePerHour){
        List<Car> cars = iCarService.getByTypeAndPrice(carType,pricePerHour);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by car type "+carType+" and price per hour "+pricePerHour);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/brand/{brand}/pickupType/{pickupType}/noOfSeats/{noOfSeats}")
    public ResponseEntity<List<Car>> getByBrandAndPickupAndSeats(@PathVariable("brand") String brand,@PathVariable("pickupType") String pickupType,@PathVariable("noOfSeats")int noOfSeats){
        List<Car> cars = iCarService.getByBrandAndPickupAndSeats(brand,pickupType,noOfSeats);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by brand "+brand+" , pickup type "+pickupType+" and no of seats "+noOfSeats);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/mileage/{mileage}/rating/{rating}/carType/{carType}")
    public ResponseEntity<List<Car>> getByMileageAndRatingAndType(@PathVariable("mileage") int mileage,@PathVariable("rating") double rating,@PathVariable("carType") String carType){
        List<Car> cars = iCarService.getByMileageAndRatingAndType(mileage,rating,carType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by mileage "+mileage+" ,rating "+rating+" and car type "+carType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
}
