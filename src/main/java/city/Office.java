package city;

public class Office extends Building {

    private final String company;
    private final int numberOfTablesPerLevel;

    public Office(double area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (isTablesValid(numberOfTablesPerLevel)) {
            throw new IllegalArgumentException("invalid tables");
        } else {
            this.company = company;
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }
    }

    private boolean isTablesValid(int numberOfTablesPerLevel) {
        double areaPerTables = getArea() / numberOfTablesPerLevel;
        return areaPerTables < 2 || areaPerTables > 5;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
