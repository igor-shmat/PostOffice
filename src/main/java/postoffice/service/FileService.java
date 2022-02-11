package postoffice.service;

import postoffice.exceptions.FileNotFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileService {


    public ArrayList<ArrayList<String>> readFile() {
        ArrayList<ArrayList<String>> commands = new ArrayList<>();
        InputStream is = getClass().getResourceAsStream("/input.txt");
        if (is == null) {
            throw new FileNotFoundException("!!!File not found!!!");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            int index = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                ArrayList<String> data = new ArrayList<>();
                String[] split = line.split("#");
                for (int i = 0; i < split.length; i++) {
                    data.add(split[i]);
                }
                commands.add(index, data);
                line = bufferedReader.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commands;
    }
}
