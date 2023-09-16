package Simplify360;

import java.util.*;

class BouquetStore {
    private Map<String, String> flowerColorToBouquet;

    public BouquetStore() {
        flowerColorToBouquet = new HashMap<>();
    }

    public void addBouquet(String bouquetName, Map<String, Set<String>> flowers) {
        for (Map.Entry<String, Set<String>> entry : flowers.entrySet()) {
            String flower = entry.getKey();
            for (String color : entry.getValue()) {
                String key = flower + "_" + color;
                flowerColorToBouquet.put(key, bouquetName);
            }
        }
    }

    public String findBouquet(String flower, String color) {
        String key = flower + "_" + color;
        return flowerColorToBouquet.getOrDefault(key, "None");
    }

    public static void main(String[] args) {
        BouquetStore store = new BouquetStore();

        // Adding bouquets
        Map<String, Set<String>> bouquet1 = new HashMap<>();
        bouquet1.put("Rose", new HashSet<>(Arrays.asList( "White", "Yellow")));
        bouquet1.put("Lily", new HashSet<>(Collections.singletonList("White")));
        bouquet1.put("Tulip", new HashSet<>(Arrays.asList("White", "Purple")));
        store.addBouquet("Bouquet1", bouquet1);

        Map<String, Set<String>> bouquet2 = new HashMap<>();
        bouquet2.put("Rose", new HashSet<>(Arrays.asList("Pink", "Orange")));
        bouquet2.put("Chrysanthemum", new HashSet<>(Collections.singletonList("Yellow")));
        bouquet2.put("Balsam", new HashSet<>(Collections.singletonList("Pink")));
        store.addBouquet("Bouquet2", bouquet2);

        Map<String, Set<String>> bouquet3 = new HashMap<>();
        bouquet3.put("Rose", new HashSet<>(Collections.singletonList("Red")));
        store.addBouquet("Bouquet1, Bouquet2", bouquet3);

        // Searching for bouquets
        String inputFlower1 = "Rose";
        String inputColor1 = "Red";
        String outputBouquet1 = store.findBouquet(inputFlower1, inputColor1);
        System.out.println("Output 1: " + outputBouquet1);

        Scanner scanner = new Scanner(System.in);
        String inputFlower2 = scanner.nextLine();;
        String inputColor2 = scanner.nextLine();;
        String outputBouquet2 = store.findBouquet(inputFlower2, inputColor2);
        System.out.println("Output 2: " + outputBouquet2);
    }
}
