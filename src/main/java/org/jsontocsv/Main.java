package org.jsontocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Writer;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsontocsv.parser.JSONFlattener;
import org.jsontocsv.writer.CSVWriter;

public class Main {

    public static void main(String[] args)  {
    	
    	if(args!=null&&args.length!=2) {
    		System.out.println("JAVA -JAR DENEME.JAR sourcefile.JSON  destinationfile.CSV ");
    		System.out.println("file of json and file of jar should be same packages. ");
    		return;
    	}
    	BufferedReader br = null;
    	FileReader fr = null;
        System.out.println("1");
    	String inputFile=args[0];
    	System.out.println("2"+args[0]);
    	String outputFile=args[1];
    	System.out.println("3"+args[1]);
//    	inputFile =  "simple.json";
//    	outputFile = "sample_file.csv";
		String sCurrentLine = null;
    	try {
    		fr = new FileReader(inputFile);
    		br = new BufferedReader(fr);
    

    		while ((sCurrentLine = br.readLine()) != null) {
    			System.out.println("json okundu."+sCurrentLine);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    	
    	List<Map<String, String>>  flatJson = null;   
    	try {
    		
    		flatJson = JSONFlattener.parseJson(new File(inputFile), "UTF-8");
//    		flatJson = JSONFlattener.parseJson(new File(inputFile), "UTF-8");
//    		flatJson = JSONFlattener.parseJson(new File('"'+inputFile+'"'), "UTF-8");
    		System.out.println("try :"+flatJson);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	try {
//    		CSVWriter.writeToFile(CSVWriter.getCSV(flatJson, ";"),"'outputFile'");
//    		CSVWriter.writeToFile(CSVWriter.getCSV(flatJson, ";"),"outputFile");
    		CSVWriter.writeToFile(CSVWriter.getCSV(flatJson, ";"),outputFile);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        

        /*
         *  Parse JSON from URL and convert it to CSV
//         */
//        flatJson = JSONFlattener.parseJson(new URI("http://echo.jsontest.com/firstname/Brahim/lastName/Arkni"));
//        // Using '\t' as separator
//        CSVWriter.writeToFile(CSVWriter.getCSV(flatJson, "\t"), "files/sample_uri.csv");
    //
    /*
         *  Parse a Large JSON File and convert it to CSV
         */
//        flatJson = JSONFlattener.parseJson(new File("files/sample_large.json"), "UTF-8");
        // Using ';' as separator
//        Set<String> header = CSVWriter.collectOrderedHeaders(flatJson);
        // the intention is generate a csv file with specific headers - not all
//        CSVWriter.writeLargeFile(flatJson, ";", "files/sample_largeFile.csv", header);  

    	
    	

    	
    }

//    private static String jsonString() {
//        return  "[" +
//                "    {" +
//                "        \"studentName\": \"Foo\"," +
//                "        \"Age\": \"12\"," +
//                "        \"subjects\": [" +
//                "            {" +
//                "                \"name\": \"English\"," +
//                "                \"marks\": \"40\"" +
//                "            }," +
//                "            {" +
//                "                \"name\": \"History\"," +
//                "                \"marks\": \"50\"" +
//                "            }" +
//                "        ]" +
//                "    }" +
//                "]";
//    }


}