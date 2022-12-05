package adventofcode;

public class DayOne {

    public static void main(String[] args) {
        Reader reader = new Reader();
        ElfArmyCreator elfArmyCreator = new ElfArmyCreator();
        ElfService elfService = new ElfService();

        var fileAsArray = reader.loadFileToArray("day1");
        var elfArmy = elfArmyCreator.createElfArmy(fileAsArray);
        var highestNumber = elfService.findHighestTonnage(elfArmy);
        var sortedTonnages = elfService.getTonnagesAsSortedList(elfArmy);
        var threeHighest = elfService.getHighestThree(sortedTonnages);
        System.out.println("Highest: " + highestNumber);
        System.out.println("Highest three: " + threeHighest);
    }

}