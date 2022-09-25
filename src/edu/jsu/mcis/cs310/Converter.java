package edu.jsu.mcis.cs310;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {

    /*

        Consider the following CSV data:

        "ID","Total","Assignment 1","Assignment 2","Exam 1"
        "111278","611","146","128","337"
        "111352","867","227","228","412"
        "111373","461","96","90","275"
        "111305","835","220","217","398"
        "111399","898","226","229","443"
        "111160","454","77","125","252"
        "111276","579","130","111","338"
        "111241","973","236","237","500"

        The corresponding JSON data would be similar to the following (tabs and
        other whitespace have been added for clarity).  Note the curly braces,
        square brackets, and double-quotes!  These indicate which values should
        be encoded as strings and which values should be encoded as integers, as
        well as the overall structure of the data!

        {
            "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160",
            "111276","111241"],
            "data":[[611,146,128,337],
                    [867,227,228,412],
                    [461,96,90,275],
                    [835,220,217,398],
                    [898,226,229,443],
                    [454,77,125,252],
                    [579,130,111,338],
                    [973,236,237,500]
            ]
        }

        Your task for this program is to complete the two conversion methods in
        this class, "csvToJson()" and "jsonToCsv()", so that the CSV data shown
        above can be converted to JSON format, and vice-versa.  Both methods
        should return the converted data as strings, but the strings do not need
        to include the newlines and whitespace shown in the examples; again,
        this whitespace has been added only for clarity.

        NOTE: YOU SHOULD NOT WRITE ANY CODE WHICH MANUALLY COMPOSES THE OUTPUT
        STRINGS!!!  Leave ALL string conversion to the two data conversion
        libraries we have discussed, OpenCSV and JSON.simple.  See the "Data
        Exchange" lecture notes for more details, including examples.

    */

    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {

        String results = "";

        try {

            // Initialize CSV Reader and Iterator

            CSVReader reader = new CSVReader(new StringReader(csvString));
            List<String[]> full = reader.readAll();
            Iterator<String[]> iterator = full.iterator();


            /* INSERT YOUR CODE HERE */

           

            
            String[] record;
            String jsonString = "";
            JSONArray colHeaders = new JSONArray();


            String[] Headers = iterator.next();
            for(String s: Headers) {
                colHeaders.add(s);
            }
          
             JSONArray rowHeaders = new JSONArray();
            String[] rowHeaders1 = iterator.next();
            String ID1;
            ID1 = rowHeaders1[0];
            rowHeaders.add(ID1);

             JSONArray dataNumber1 = new JSONArray();
            for(int i = 1; i < rowHeaders1.length; i++) {
              int s =  Integer.valueOf(rowHeaders1[i]);
                dataNumber1.add(s);
            }

            String[] rowHeaders2 = iterator.next();
            String ID2;
            ID2 = rowHeaders2[0];
            rowHeaders.add(ID2);

            JSONArray dataNumber2 = new JSONArray();
            for(int i = 1; i < rowHeaders2.length; i++) {
              int s =  Integer.valueOf(rowHeaders2[i]);
                dataNumber2.add(s);
            }

            String[] rowHeaders3 = iterator.next();
            String ID3;
            ID3 = rowHeaders3[0];
            rowHeaders.add(ID3);

            JSONArray dataNumber3 = new JSONArray();
            for(int i = 1; i < rowHeaders3.length; i++) {
              int s =  Integer.valueOf(rowHeaders3[i]);
                dataNumber3.add(s);
            }

            String[] rowHeaders4 = iterator.next();
            String ID4;
            ID4 = rowHeaders4[0];
            rowHeaders.add(ID4);

            JSONArray dataNumber4 = new JSONArray();
            for(int i = 1; i < rowHeaders4.length; i++) {
              int s =  Integer.valueOf(rowHeaders4[i]);
                dataNumber4.add(s);
            }

            String[] rowHeaders5 = iterator.next();
            String ID5;
            ID5 = rowHeaders5[0];
            rowHeaders.add(ID5);

            JSONArray dataNumber5 = new JSONArray();
            for(int i = 1; i < rowHeaders5.length; i++) {
              int s =  Integer.valueOf(rowHeaders5[i]);
                dataNumber5.add(s);
            }

            String[] rowHeaders6 = iterator.next();
            String ID6;
            ID6 = rowHeaders6[0];
            rowHeaders.add(ID6);

            JSONArray dataNumber6 = new JSONArray();
            for(int i = 1; i < rowHeaders6.length; i++) {
              int s =  Integer.valueOf(rowHeaders6[i]);
                dataNumber6.add(s);
            }

            String[] rowHeaders7 = iterator.next();
            String ID7;
            ID7 = rowHeaders7[0];
            rowHeaders.add(ID7);

            JSONArray dataNumber7 = new JSONArray();
            for(int i = 1; i < rowHeaders7.length; i++) {
              int s =  Integer.valueOf(rowHeaders7[i]);
                dataNumber7.add(s);
            }

            String[] rowHeaders8 = iterator.next();
            String ID8;
            ID8 = rowHeaders8[0];
            rowHeaders.add(ID8);

            JSONArray dataNumber8 = new JSONArray();
            for(int i = 1; i < rowHeaders8.length; i++) {
              int s =  Integer.valueOf(rowHeaders8[i]);
                dataNumber8.add(s);
            }
           
              JSONArray data = new JSONArray();
              data.add(dataNumber1);
              data.add(dataNumber2);
              data.add(dataNumber3);
              data.add(dataNumber4);
              data.add(dataNumber5);
              data.add(dataNumber6);
              data.add(dataNumber7);
              data.add(dataNumber8);

              JSONObject types = new JSONObject();
              types.put("rowHeaders", rowHeaders);
              types.put("data", data);
              types.put("colHeaders", colHeaders);





          jsonString = JSONValue.toJSONString(types);
          results = jsonString;

        }
        catch(Exception e) { e.printStackTrace(); }

        // Return JSON String

        return results.trim();

    }

    public static String jsonToCsv(String jsonString) {

        String results = "";
        StringBuilder csvFile= new StringBuilder();
        try {

            // Initialize JSON Parser and CSV Writer

            JSONParser parser = new JSONParser();
            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\\', "\n");



            /* INSERT YOUR CODE HERE */

        JSONObject jsonObject = (JSONObject)parser.parse(jsonString);
        JSONArray colHeaders = new JSONArray();
        colHeaders = (JSONArray) jsonObject.get("colHeaders");
        //JSONArray colHeaders = (JSONArray) jsonObject.get("colHeaders");
        String[] headers = new String[5];
        for(int i = 0;i < colHeaders.size(); i++) {
            headers[i] = colHeaders.get(i).toString();
        }
        csvWriter.writeNext(headers);
        
        JSONArray rowHeaders = new JSONArray();
        rowHeaders = (JSONArray) jsonObject.get("rowHeaders");
        String[] ids = new String[8];
        for(int i = 0; i < ids.length; i++) {
            ids[i] = rowHeaders.get(i).toString();
        }
        
        JSONArray data = new JSONArray();
        data = (JSONArray) jsonObject.get("data");
        String[] data1 = new String[8];
        for(int i = 0; i < data.size(); i++){
            data1[i] =  data.get(i).toString();
        }
        
        
        JSONArray datavalues = new JSONArray();
        for(int i =0;i < data1.length;i++){
             datavalues = (JSONArray)parser.parse(data1[i]);
             
             String[] student = new String[5];
             student[0] = ids[i];
             student[1] =  datavalues.get(0).toString();
             student[2] =  datavalues.get(1).toString();
             student[3] =  datavalues.get(2).toString();
             student[4] =  datavalues.get(3).toString();
             csvWriter.writeNext(student);
        }
     

        String csvString = writer.toString();
        
        results = csvString;
       
    }
        catch(Exception e) { e.printStackTrace(); }

        // Return CSV String

        return results.trim();
        }
    }

