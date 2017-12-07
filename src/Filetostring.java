import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Nathan on 12/4/2017.
 */
public class Filetostring {


   public String Filetostring(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
