package Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;


public class CsvDataProviders {
    @DataProvider(name="csvReader")
    public static Iterator<Object[]> csvReader(Method method){
        List<Object[]> list = new ArrayList<Object[]>();
        String pathName = "src" + File.separator + "main" + File.separator + "resouces" + File.separator
          + "DataProvider" + File.separator + method.getDeclaringClass().getSimpleName() + method.getName() + ".csv";
        File file = new File(pathName);
            try {
                CSVReader reader = new CSVReader(new FileReader(file));
                String[] keys = reader.readNext();
                if(keys != null){
                    String[] dataParts;
                    while ((dataParts=reader.readNext()) != null){
                        Map<String, String> testData = new HashMap<String, String>();
                        for (int i =0; i< keys.length; i++){
                            testData.put(keys[i], dataParts[i]);
                        }
                        list.add(new Object[]{testData});
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File " + pathName + " was not found.\n" + e.getStackTrace().toString());
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
            }
            return list.iterator();
    }
}
