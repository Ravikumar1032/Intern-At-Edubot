public class Ex2_MyArrays {
    public static void main(String[] args) {
        // Creating and initializing the Bollywood array
        String[] bollywood = {"Shah Rukh Khan", "Amitabh Bachchan", "Deepika Padukone", "Priyanka Chopra"};

        // Printing each element of the Bollywood array using separate statements
        System.out.println("Printing Bollywood array:");
        for (int i = 0; i < bollywood.length; i++) {
            System.out.println(bollywood[i]);
        }

        // Adding a new element to the Bollywood array
        String newActor = "Salman Khan";
        String[] updatedBollywood = new String[bollywood.length + 1];
        System.arraycopy(bollywood, 0, updatedBollywood, 0, bollywood.length);
        updatedBollywood[bollywood.length] = newActor;

        // Searching for an element in the Bollywood array and printing its location
        String searchActor = "Deepika Padukone";
        for (int i = 0; i < updatedBollywood.length; i++) {
            if (updatedBollywood[i].equals(searchActor)) {
                System.out.println(searchActor + " found at index " + i);
                break;
            }
        }

        // Sorting and printing the updated Bollywood array using a FOR loop
        System.out.println("Sorted Bollywood array:");
        for (int i = 0; i < updatedBollywood.length - 1; i++) {
            for (int j = i + 1; j < updatedBollywood.length; j++) {
                if (updatedBollywood[i].compareTo(updatedBollywood[j]) > 0) {
                    String temp = updatedBollywood[i];
                    updatedBollywood[i] = updatedBollywood[j];
                    updatedBollywood[j] = temp;
                }
            }
            System.out.println(updatedBollywood[i]);
        }
        System.out.println(updatedBollywood[updatedBollywood.length - 1]); // Print the last element
        
        // Creating and initializing the Ages array
        int[] ages = {25, 30, 35, 40, 45};

        // Printing the Ages array using a FOR loop
        System.out.println("Printing Ages array:");
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

        // Sorting and printing the Ages array using a FOR loop
        System.out.println("Sorted Ages array:");
        for (int i = 0; i < ages.length - 1; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (ages[i] > ages[j]) {
                    int temp = ages[i];
                    ages[i] = ages[j];
                    ages[j] = temp;
                }
            }
            System.out.println(ages[i]);
        }
        System.out.println(ages[ages.length - 1]); // Print the last value
    }
}