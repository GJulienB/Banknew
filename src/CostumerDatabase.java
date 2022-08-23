import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CustomerDatabase {
    public static ArrayList<ArrayList<String>> getCustomerData() {
        String path = "C:\\Users\\BedrichJ\\Desktop\\Kundenliste\\kunden.csv";
        String line = "";
        BufferedReader br;

        ArrayList<ArrayList<String>> customer = new ArrayList<>();

            try {
                br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\n");
                    for (String index : values){
                        String[] customerPartsString = index.split(";");
                        ArrayList<String> customerPartsArrayList = new ArrayList<>();
                       //for(String datapoint : customerPartsString){
                         //customerPartsArrayList.add(datapoint);
                        //}
                        Collections.addAll(customerPartsArrayList, customerPartsString);
                        customer.add(customerPartsArrayList);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }
            return customer;
        }


    }
