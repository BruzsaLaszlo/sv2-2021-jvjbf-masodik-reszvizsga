package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private final String name;
    private final long fullArea;
    private final List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public Building findHighestBuilding() {
        Building highest = buildings.get(0);
        for (Building building : buildings) {
            if (highest.getLevels() < building.getLevels()) {
                highest = building;
            }
        }
        return highest;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                result.add(building);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int number) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > number) {
                return true;
            }
        }
        return false;
    }

    public void addBuilding(Building building) {
        if (getAreaOfBuildings() + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    private double getAreaOfBuildings() {
        double sum = 0;
        for (Building building : buildings) {
            sum += building.getArea();
        }
        return sum;
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
