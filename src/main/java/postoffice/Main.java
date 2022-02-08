package postoffice;

import postoffice.service.FileService;
import postoffice.service.MainCommandService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        MainCommandService mainCommandService = new MainCommandService();
        ArrayList<ArrayList<String>> commands = fileService.readFile();
        mainCommandService.mapCommand(commands);
    }
}
