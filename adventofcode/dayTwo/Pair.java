package adventofcode.dayTwo;

public class Pair {
    String enemy;
    String mine;
    String totalString;
    int minePoints;
    int totalPoints;

    public Pair(String pairing) {
        var values = pairing.split(" ");
        this.totalString = pairing;
        this.setEnemy(values[0]);
        this.setMine(values[1]);
        this.setMinePoints(this.calculateDirectPoints(this.getMine()));
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getMine() {
        return mine;
    }

    public void setMine(String mine) {
        this.mine = mine;
    }

    public int getMinePoints() {
        return minePoints;
    }

    public void addToMinePoints(int points) {
        this.minePoints += points;
    }

    public void setMinePoints(int minePoints) {
        this.minePoints = minePoints;
    }

    private int calculateDirectPoints(String character) {
        var points = 0;

        switch (character) {
            case ("X"):
                points = 1;
                break;
            case ("Y"):
                points = 2;
                break;
            case ("Z"):
                points = 3;
                break;
            default:
                points = 0;
        }
        return points;
    }

    /*
     * X Papier
     * Y Scheere
     * Z Stein
     * 
     * A Stein
     * B Paper
     * C Scheere
     */
    private int calculateBattlePoints() {
        int totalPoints = this.getMinePoints();

        switch (this.totalString) {
            case ("A X"):

                break;
            case ("A Y"):

                break;
            case ("A Z"):
                break;

            case ("B X"):

                break;
            case ("B Y"):

                break;
            case ("B Z"):

                break;
            case ("C X"):

                break;
            case ("C Y"):

                break;
            case ("C Z"):

            default:
                break;
        }

        return totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

}
