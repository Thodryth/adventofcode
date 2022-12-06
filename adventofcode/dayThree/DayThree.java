package adventofcode.dayThree;

public class DayThree {
    public static void main(String[] args) {
        PrioritiseService prioritiseService = new PrioritiseService();
        var map = prioritiseService.createCharToAsciiMap();
        System.out.println(map.get("Z"));
    }
}
