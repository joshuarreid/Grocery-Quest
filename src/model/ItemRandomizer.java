package model;


public class ItemRandomizer {
    private String[] possibleItems;
    private int startingNumber;
    public ItemRandomizer() {
        possibleItems = new String[]{
            "CannedSoup", "CannedSoup",
            "CannedSoup", "CannedSoup",
            "CannedSoup", "CannedSoup",
            "ToiletPaper", "ToiletPaper",
            "ToiletPaper", "CannedSoup",
            "CannedSoup", "CannedSoup",
            "CannedSoup", "CannedSoup",
            "CannedSoup", "ToiletPaper",
            "ToiletPaper", "ToiletPaper",
            "N95Mask", "HandSanitizer"};
        startingNumber = 6;
    }

    public Collectable randomItem(int row, int col) {
        int prob = (int) Math.round(Math.random() * (possibleItems.length - 1));
        String itemSelected = possibleItems[prob];
        Collectable item;
        if (itemSelected.compareTo("N95Mask") == 0) {
            item = new N95(itemSelected + "_" + startingNumber, row, col, false, 1, 10);
        } else if (itemSelected.compareTo("HandSanitizer") == 0) {
            item = new HandSanitizer(itemSelected + "_" + startingNumber, row, col, false, 1);
        } else if (itemSelected.compareTo("ToiletPaper") == 0) {
            item = new Potion(itemSelected + "_" + startingNumber, row, col, false, 1, 2);
        } else {
            item = new Potion(itemSelected + "_" + startingNumber, row, col, false, 1, 1);
        }
        return item;
    }
}
