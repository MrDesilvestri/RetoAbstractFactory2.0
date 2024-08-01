package org.example.af.familiarest;

import org.example.servicios.IServiciosArticulos;
import org.example.servicios.IServiciosEmpleados;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImplementacionRestArticulos implements IServiciosArticulos {

    @Override
    public String[] getArticulos() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            return new String[]{content.toString()};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
