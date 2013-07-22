package Examples;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Secretary.AppianSecretary;

/**
 * <b>AppianSecretary Demo</b> <br>
 * We generate 50 charts with random heights and widths. 
 * Using, AppianSecretary, we write these charts to a file, and then 
 * check whether their heights and widths are within a certain size.
 * @author Jay Wang
 *
 */
public class Chart_Example {

    private AppianSecretary mySecretary; 
    List<Chart> chartList = new ArrayList<Chart>();
   
    public Chart_Example() throws IOException {
        mySecretary = new AppianSecretary("src/Files/");
        generateCharts(51);
    }
    
    private void generateCharts(int numberToGenerate) {
        Random rand = new Random();
        for (int i = 0; i < numberToGenerate; i++) {
            chartList.add(new Chart((int)(rand.nextDouble()*1000), (int)(rand.nextDouble()*1000)));
        }
    }
    
    private void writeCharts() throws IOException {
        for (int i = 1; i < chartList.size(); i++) {
            mySecretary.write("Chart " + i + " : height: " + chartList.get(i).chartHeight + " , width: " + chartList.get(i).chartWidth);
        }
    }
    
    private void saveSession () throws IOException {
        mySecretary.saveSession("test.txt");
    }

    private void checkWidth() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        Operations myOperations = new Operations();
        mySecretary.loadSession("test.txt", "checkWidth", myOperations);
    }
    
    private void checkHeight() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        Operations myOperations = new Operations();
        mySecretary.loadSession("test.txt", "checkHeight", myOperations);
    }

    public static void main (String[] args) throws IOException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Chart_Example test = new Chart_Example();
        test.writeCharts();
        test.saveSession();
        test.checkWidth();
        test.checkHeight();
    }
}
