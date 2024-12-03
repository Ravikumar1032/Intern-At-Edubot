public class Ex1_ArrayDecs {
    public static void main(String[] args) {
        // Declaration for cityPopulation
        int[] cityPopulation = new int[20]; // Holds the current population of the 20 largest cities in the world

        // Declaration for squad
        String[] squad = new String[11]; // Refers to 11 players on a cricket team

        // Declaration and initialization for planets array with the names of the planets
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"}; // Represents the nine planets, including Pluto
	for(int i=0; i<planets.length; i++){
	    System.out.println(planets[i]);
	}
    }
}