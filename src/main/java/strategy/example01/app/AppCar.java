package strategy.example01.app;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import decoratorNew.stream.csv.CSVInputStream;
import strategy.example01.model.Car;
import strategy.example01.reader.CSVCarReader;
import strategy.example01.reader.CarReader;
import strategy.example01.stock.CarStock;
import strategy.example01.stock.Stock;

public class AppCar 
{
	private Stock<Car> carStock;
	
	//-------------------------------------------------------------------------------------
	public AppCar (Stock<Car> carStock) throws IOException
	{
		this.carStock = carStock;
		this.carStock.load();	
	}
	
	
	//-------------------------------------------------------------------------------------
	static private
	CarReader createCarReader(String csvCarFile) throws IOException
	{
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(csvCarFile);
		assert (inputStream != null) : "File Not Found: " + csvCarFile;
	
		CSVInputStream csvInputStream   = new CSVInputStream(inputStream);
		CarReader carReader = new CSVCarReader(csvInputStream);
		
		return  carReader;		
	}
	
	//-------------------------------------------------------------------------------------
	public final void printAllCars() {
//		carStock.getAll().forEach(car -> System.out.println(car));
//		carStock.getAll().forEach(System.out::println);
		carStock.stream().forEach(System.out::println);
    }
	
	//-------------------------------------------------------------------------------------
	public final void printAllCarsOrderedByYear() {
//		carStock.stream().sorted().forEach(System.out::println);
		carStock.stream()
				.sorted((carA, carB) -> (carA.getYear() - carB.getYear()))
				.forEach(System.out::println);
    }
	//-------------------------------------------------------------------------------------
	public final void printAllCarsByBrand(String brand) {
//		for(Car car : carStock.getAll()) {
//			if(car.getBrand().equals(brand)) {
//				System.out.println(car);
//			}
//		}
//		carStock.stream().forEach(car -> {
//			if(car.getBrand().equals(brand)) {
//				System.out.println(car);
//			}
//		});
		carStock.stream()
				.filter(car -> brand.equalsIgnoreCase(car.getBrand()))
				.forEach(car -> System.out.println(car));
	}
	//-------------------------------------------------------------------------------------
	public final void printAllOldCars(int years) {
		int currentYear = LocalDate.now().getYear();
		
		carStock.stream()
				.filter(car -> (currentYear - car.getYear()) > years)
				.forEach(System.out::println);
	}
	//-------------------------------------------------------------------------------------
	public final void printAllNewerCars(int years) {
		int currentYear = LocalDate.now().getYear();
		
		carStock.stream()
				.filter(car -> (currentYear - car.getYear()) < years)
				.forEach(System.out::println);
	}
	//-------------------------------------------------------------------------------------
	public final void printAllOldCarsInAscendingOrder(int years) {
		int currentYear = LocalDate.now().getYear();
		
		carStock.stream()
				.filter(car -> (currentYear - car.getYear()) > years)
				.sorted((carA, carB) -> (carA.getYear() - carB.getYear()))
				.forEach(System.out::println);;
	}
	//-------------------------------------------------------------------------------------
	public final void printAllNewerCarsInDescendingOrder(int years) {
		int currentYear = LocalDate.now().getYear();
		
		carStock.stream()
				.filter(car -> (currentYear - car.getYear()) < years)
				.sorted((carA, carB) -> (carB.getYear() - carA.getYear()))
				.forEach(System.out::println);;
	}
	//-------------------------------------------------------------------------------------
	public final void printAllOldCarsOfBrandInAscendingOrder(int years, String brand) {
		int currentYear = LocalDate.now().getYear();
		
		carStock.stream()
				.filter(car -> (currentYear - car.getYear()) > years)
				.filter(car -> brand.equalsIgnoreCase(car.getBrand()))
				.sorted((carA, carB) -> (carA.getYear() - carB.getYear()))
				.forEach(System.out::println);;
	}
	//-------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		String carsFile = "CSVCarStockData.csv";
		
		CarReader carReader = createCarReader(carsFile);
		Stock<Car> carStock = new CarStock(carReader);
		
		AppCar app = new AppCar(carStock);
		
//		app.printAllCars();
//		app.printAllCarsOrderedByYear();
//		app.printAllCarsByBrand("Chevrolet");
//		app.printAllOldCars(1);
//		app.printAllNewerCars(4);
//		app.printAllOldCarsInAscendingOrder(5);
//		app.printAllNewerCarsInDescendingOrder(5);
		app.printAllOldCarsOfBrandInAscendingOrder(2, "Fiat");
	}
	
}