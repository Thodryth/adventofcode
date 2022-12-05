package adventofcode.dayTwo;

public class Pair {
    String enemy;
    String mine;
    int minePoints;

    public Pair(String pairing) {
        var values = pairing.split(" ");
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

}
