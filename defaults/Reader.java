package defaults;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    public String[] loadFileToArray(String fileName) {

        var listOfStrings = new ArrayList<String>();
        String[] array = null;

        try (var bf = new BufferedReader(new FileReader(fileName))) {

            var line = bf.readLine();

            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }

            array = listOfStrings.toArray(new String[0]);

        } catch (Exception e) {
            System.out.println("That went wrong my dude");
            System.out.println(e);
        }

        return array;
    }

    public String[] loadFileToArrayWithoutEmptyLines(String fileName) {

        var listOfStrings = new ArrayList<String>();
        String[] array = null;

        try (var bf = new BufferedReader(new FileReader(fileName))) {

            var line = bf.readLine();

            while (line != null) {
                if (line.length() > 0) {
                    listOfStrings.add(line);
                }
                line = bf.readLine();
            }

            array = listOfStrings.toArray(new String[0]);

        } catch (Exception e) {
            System.out.println("That went wrong my dude");
            System.out.println(e);
        }

        return array;
    }
}
