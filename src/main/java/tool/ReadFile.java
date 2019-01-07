package tool;

import org.apache.log4j.Logger;

import java.io.*;

public class ReadFile {
    private static Logger LOGGER = Logger.getLogger(ReadFile.class);

    private static String datasetRoot=System.getProperty("user.dir")+"\\dataset\\";


//    ===Two types to read file====================================================================
    public static final void readF1(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        for (String line = br.readLine(); line != null; line = br.readLine()) {
//            System.out.println(line);

        }
        br.close();
    }

    public static final void readF2(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader bufferedreader = new BufferedReader(fr);
        String instring;
        while ((instring = bufferedreader.readLine().trim()) != null) {
            if (0 != instring.length()) {
//                System.out.println(instring);
            }
        }
        fr.close();
    }


}
