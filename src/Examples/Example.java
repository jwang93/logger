package Examples;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Secretary.AppianSecretary;


public class Example1_AS {

    private AppianSecretary mySecretary; 
    List<Chart> chartList = new ArrayList<Chart>();
   
    public Example1_AS() throws IOException {
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

    private void loadSession () throws SecurityException, IllegalArgumentException, NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        mySecretary.loadSession("test.txt", "checkWidth", new Operations());
    }

    public static void main (String[] args) throws IOException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Example1_AS test = new Example1_AS();
        test.writeCharts();
        test.saveSession();
        test.loadSession();
    }
}
