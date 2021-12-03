package ueDoPliku;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args){

        try {

            URL url = new URL("https://ue.katowice.pl");
            BufferedReader readr =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("Download.html"));

            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();
            System.out.println("Operacja powiodła się");

        }

        catch (MalformedURLException mue) {
            System.out.println("Nie prawidłowy adres strony");
        }
        catch (IOException ie) {
            System.out.println("IOException");
        }


    }

}

