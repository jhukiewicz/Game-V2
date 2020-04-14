package Maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Locations {

    private static Map<Integer, Location> locations = new HashMap<>();


    public Locations() {
        initialize();
    }

    private void initialize() {

        try (Scanner scanner = new Scanner(new FileReader("locations.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                locations.put(loc, new Location(loc, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        try (BufferedReader exitReader = new BufferedReader(new FileReader("exits.txt"))) {

            String input;
            while ((input = exitReader.readLine()) != null) {

                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                Directions direction = convertToEnum(data[1]);
                int destination = Integer.parseInt(data[2]);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Directions convertToEnum(String s) {

        switch (s.toUpperCase()) {
            case "N":
                return Directions.N;
            case "S":
                return Directions.S;
            case "E":
                return Directions.E;
            case "W":
                return Directions.W;
        }
        return null;
    }

    public Map<Integer, Location> getLocations() {
        return locations;
    }

    public void setLocations(Map<Integer, Location> locations) {
        Locations.locations = locations;
    }
}
