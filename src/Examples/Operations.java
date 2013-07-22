package Examples;

import java.io.IOException;
import Secretary.AppianSecretary;

/**
 * This is where we write the methods we want to invoke on the chart data 
 * that gets written to our file by AppianSecretary. 
 * @author Jay Wang
 *
 */
public class Operations {
    
    private AppianSecretary mySecretary; 
    private int widthCounter = 0;
    private int heightCounter = 0;
    public Operations() throws IOException {
        mySecretary = new AppianSecretary("src/Files/");
    }
    
    /**
     * Checks whether the chart's width is < 500. If not, it writes 
     * that chart to an error file (checkWidth.txt). 
     * @param line (String)
     * @throws IOException
     */
    public void checkWidth(String line) throws IOException {
        widthCounter++;
        String[] elements = line.split(" ");
        if (Integer.parseInt(elements[elements.length - 1]) > 500) {
            mySecretary.write("Error! Width exceeds 500 at Chart: " + widthCounter);
        }
        mySecretary.saveSession("checkWidth.txt");
    }
    
    /**
     * Checks whether the chart's height is < 500. If not, it writes 
     * that chart to an error file (checkHeight.txt). 
     * @param line (String)
     * @throws IOException
     */
    public void checkHeight(String line) throws IOException {
        heightCounter++;
        String[] elements = line.split(" ");
        if (Integer.parseInt(elements[elements.length - 1]) > 800) {
            mySecretary.write("Error! Height exceeds 800 at Chart: " + heightCounter);
        }
        mySecretary.saveSession("checkHeight.txt");
    }
    
    
}
