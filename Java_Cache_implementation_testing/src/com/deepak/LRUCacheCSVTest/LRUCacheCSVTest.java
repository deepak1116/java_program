package com.deepak.LRUCacheCSVTest;

import au.com.bytecode.opencsv.CSVReader;
import com.deepak.LFUCacheCSV.LFUCacheCSVTest;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author - deepak-pt3107
 * @createdOn - 04-02-2020
 */
public class LRUCacheCSVTest {
    static String fileLocation= "E:\\pathTesting\\tryFolder\\supported_device.csv";
    static LRUCache CSVCache = new LRUCache(25000);

    public static void main(String args[]){
        LRUCacheCSVTest test = new LRUCacheCSVTest();
        Scanner sc = new Scanner(System.in);
        test.CSVToCache();

        while (true){
            System.out.print("Enter model no : ");
            String name = sc.nextLine();
            name = name.toLowerCase();
            JSONObject result = CSVCache.get(name);
            if(name.equalsIgnoreCase("12345")){
                CSVCache.listKeyValue();
            }else if(result.length() > 0 ){
                System.out.println("Match Found in cache"+ result);
            }else{
                result = test.searchModelNameInCsv(name);
                if(result.length() > 0){
                    System.out.println("Match found in csv "+ result);
                }else{
                    System.out.println("No model details available");
                }
            }

        }

    }

    public void CSVToCache(){
        CSVReader csvReader = null;
        try (FileInputStream fis = new FileInputStream(Paths.get(fileLocation).toString());
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_16LE);){

            csvReader = new CSVReader(isr);
            String[] nextLine;
            boolean flag = true;
            long count = 0;
            while (((nextLine = csvReader.readNext()) != null) && count <= 25000) {
                if(flag){                   // To skip the first line ("heading row") of csv file
                    flag = false;
                    continue;
                }
                String brand = null;
                String marketName = null;
                String device = null;
                String modelName = null;
                brand = nextLine[0];
                marketName = nextLine[1];
                device = nextLine[2];
                modelName = nextLine[3];
                count++;
                JSONObject modelDetailsToAppend= new JSONObject();
                modelDetailsToAppend.put("IndexNo",count);
                modelDetailsToAppend.put("Brand", brand);
                modelDetailsToAppend.put("MarketName", marketName);
                modelDetailsToAppend.put("DeviceName", device);
                modelDetailsToAppend.put("ModelName", modelName);
                CSVCache.put(modelName.toLowerCase(),modelDetailsToAppend);
                CSVCache.put(device.toLowerCase(),modelDetailsToAppend);
            }
            System.out.println("The csv file read completely");
        } catch (FileNotFoundException e) {
            System.out.println("File not found "+ e);
        } catch (IOException e) {
            System.out.println("IOexception "+ e);
        } catch (JSONException e) {
            System.out.println("Exception in JSON creation"+ e);
        } catch (Exception e) {
            System.out.println("Exception in csv file handling "+ e);
        } finally {
            try {
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (Exception e) {

            }
        }
    }

    public JSONObject searchModelNameInCsv(String modelNameToSearch){
        CSVReader csvReader = null;
        try(FileInputStream fis = new FileInputStream(Paths.get(fileLocation).toString());
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_16LE);) {

            csvReader = new CSVReader(isr);
            String[] nextLine;
            boolean flag = true;
            while(((nextLine = csvReader.readNext()) != null)){
                if(flag){                   // To skip the first line ("heading row") of csv file
                    flag = false;
                    continue;
                }
                String brand = null;
                String marketName = null;
                String device = null;
                String modelName = null;
                brand = nextLine[0];
                marketName = nextLine[1];
                device = nextLine[2];
                modelName = nextLine[3];
                if(modelNameToSearch.equalsIgnoreCase(modelName) ){
                    JSONObject modelDetailsToAppend= new JSONObject();
                    modelDetailsToAppend.put("Brand", brand);
                    modelDetailsToAppend.put("MarketName", marketName);
                    modelDetailsToAppend.put("DeviceName", device);
                    modelDetailsToAppend.put("ModelName", modelName);
                    CSVCache.put(modelName.toLowerCase(),modelDetailsToAppend);
                    return modelDetailsToAppend;
                }else if( modelNameToSearch.equalsIgnoreCase(device)){
                    JSONObject modelDetailsToAppend= new JSONObject();
                    modelDetailsToAppend.put("Brand", brand);
                    modelDetailsToAppend.put("MarketName", marketName);
                    modelDetailsToAppend.put("DeviceName", device);
                    modelDetailsToAppend.put("ModelName", modelName);
                    CSVCache.put(device.toLowerCase(),modelDetailsToAppend);
                    return modelDetailsToAppend;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}
