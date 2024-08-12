package strategy.example01.app;

import java.io.IOException;
import java.io.InputStream;

import decoratorNew.stream.csv.CSVInputStream;
import strategy.example01.reader.CSVCarReader;
import strategy.example01.reader.CarReader;
import strategy.example01.stock.CarStock;

public class AppCar 
{
	private CarStock carStock;
	
	//-------------------------------------------------------------------------------------
	public AppCar (CarStock carStock) throws IOException
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
	public static void main(String[] args) throws IOException
	{
		String carsFile = "CSVCarStockData.csv";
		
		CarReader carReader = createCarReader(carsFile);
		CarStock carStock = new CarStock(carReader);
		
		AppCar app = new AppCar(carStock);
	}
	
}
