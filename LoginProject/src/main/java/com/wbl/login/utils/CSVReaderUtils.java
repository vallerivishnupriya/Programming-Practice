package com.wbl.login.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.wbl.login.dataobjects.DataSheet;

public class CSVReaderUtils {
	final static Logger logger = Logger.getLogger(CSVReaderUtils.class);
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static List<DataSheet> getCSVValues(String filePath)
	{
		CsvToBean csv = new CsvToBean();
	    CSVReader csvReader;
		try {
			csvReader = new CSVReader(new FileReader(filePath), ',', '\'', 1);
			List<DataSheet> list = csv.parse(setColumMapping(), csvReader);
			return list;
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}
	    
		
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private static ColumnPositionMappingStrategy setColumMapping()
	   {
	      ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
	      strategy.setType(DataSheet.class);
	      String[] columns = new String[] {"username","password"};
	      strategy.setColumnMapping(columns);
	      return strategy;
	   }
	

}
