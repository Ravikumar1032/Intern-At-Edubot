import java.util.EnumMap;

class Ex2_MyCities {
    enum City {
        TOKYO(421048),
        NEW_YORK(8537673),
        JAPAN(3987482);

        private final int population;

        City(int population) {
            this.population = population;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static void main(String[] args) {
        EnumMap <City, Integer> cityPopulationMap = new EnumMap<>(City.class);
        for (City city : City.values()) {
            cityPopulationMap.put(city, city.getPopulation());
            System.out.println("The population of " + city.name().toLowerCase().replace("_", " ") +
                    " is " + city.getPopulation());
        }
    }
}
