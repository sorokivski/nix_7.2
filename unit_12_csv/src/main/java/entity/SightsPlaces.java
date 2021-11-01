package entity;

import annotation.CsvPropertyKey;

public class SightsPlaces {
    @CsvPropertyKey(value = "id")
    public int id;
    @CsvPropertyKey(value = "name")
    public String name;
    @CsvPropertyKey(value = "coordinates")
    public String coordinates;
    @CsvPropertyKey(value = "country")
    public String country;
    @CsvPropertyKey(value = "century")
    public int yearOfFoundation;

    public String toString() {
        return "\nPlace to visit number:  " + id + "\nname of place:  " + name +
                "\ncountry:  " + country
                + "\ngps coordinates:  " + coordinates
                + "\ncen4ury of foundation : " + yearOfFoundation + "\n";
    }

}
