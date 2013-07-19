package Examples;

import java.io.IOException;
import Secretary.AppianSecretary;

public class Operations {
    
    private AppianSecretary mySecretary; 
    private int counter = 0;
    public Operations() throws IOException {
        mySecretary = new AppianSecretary("src/Files/");
    }
    
    public void checkWidth(String line) throws IOException {
        counter++;
        String[] elements = line.split(" ");
        if (Integer.parseInt(elements[elements.length - 1]) > 500) {
            mySecretary.write("Error! Width exceeds 500 at Chart: " + counter);
        }
        mySecretary.saveSession("checkWidth.txt");
    }
    
    
}
