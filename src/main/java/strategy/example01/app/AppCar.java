package strategy.example01.app;

import java.io.IOException;
import java.io.InputStream;

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
	public static void main(String[] args) throws IOException
	{
		String carsFile = "CSVCarStockData.csv";
		
		CarReader carReader = createCarReader(carsFile);
//		CarStock carStock = new CarStock(carReader);
		Stock<Car> carStock = new CarStock(carReader);
		
		AppCar app = new AppCar(carStock);
		
//		app.printAllCars();
		app.printAllCarsOrderedByYear();
	}
	
}
