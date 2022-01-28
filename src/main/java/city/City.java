package city;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class City {

    private final String name;
    private final long fullArea;
    private final List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(comparingInt(Building::getLevels))
                .orElseThrow(() -> new IllegalStateException("no buildings in the city"));
    }

    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream()
                .filter(building -> building.getAddress().getStreet().equals(street))
                .toList();
    }

    public boolean isThereBuildingWithMorePeopleThan(int number) {
        return buildings.stream()
                .anyMatch(building -> building.calculateNumberOfPeopleCanFit() > number);
    }

    public void addBuilding(Building building) {
        if (getAreaOfBuildings() + building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    private double getAreaOfBuildings() {
        return buildings.stream()
                .mapToDouble(Building::getArea)
                .sum();
    }


    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return List.copyOf(buildings);
    }
}
