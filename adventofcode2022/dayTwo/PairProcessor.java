package adventofcode2022.dayTwo;

public class PairProcessor {
    String enemy;
    String mine;
    String totalString;
    int minePoints;
    int totalPoints;

    public PairProcessor(String pairing) {
        var values = pairing.split(" ");
        this.totalString = pairing;
        this.setEnemy(values[0]);
        this.setMine(values[1]);
        this.setMinePoints(this.calculateDirectPoints(this.getMine()));
        this.setTotalPoints(this.calculateBattlePoints());
    }

    public PairProcessor(String pairing, boolean success) {
        if (!success) {
            System.out.println("LOST");
        } else {

            var values = pairing.split(" ");
            this.totalString = pairing;
            this.setEnemy(values[0]);
            this.setMine(values[1]);
            this.createPerfectAnswer(this.getMine());
            this.setMinePoints(this.calculateDirectPoints(this.getMine()));
            this.setTotalPoints(this.calculateBattlePoints());
        }
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

    private void createPerfectAnswer(String myChar) {
        switch (myChar) {
            case ("X"):
                this.createLose();
                break;
            case ("Y"):
                this.createDraw();
                break;
            case ("Z"):
                this.createWin();
                break;
            default:
                break;

        }
    }

    private int calculateBattlePoints() {
        int score = this.getMinePoints();

        switch (this.enemy + " " + this.mine) {
            case ("A X"):
                score += 3;
                break;
            case ("A Y"):
                score += 6;
                break;
            case ("B Y"):
                score += 3;
                break;
            case ("B Z"):
                score += 6;
                break;
            case ("C X"):
                score += 6;
                break;
            case ("C Z"):
                score += 3;
                break;
            default:
                break;
        }

        return score;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void createDraw() {
        switch (getEnemy()) {
            case ("A"):
                setMine("X");
                break;
            case ("B"):
                setMine("Y");
                break;
            case ("C"):
                setMine("Z");
                break;
            default:
                break;
        }
    }

    public void createWin() {
        switch (getEnemy()) {
            case ("A"):
                setMine("Y");
                break;
            case ("B"):
                setMine("Z");
                break;
            case ("C"):
                setMine("X");
                break;
            default:
                break;
        }
    }

    public void createLose() {
        switch (getEnemy()) {
            case ("A"):
                setMine("Z");
                break;
            case ("B"):
                setMine("X");
                break;
            case ("C"):
                setMine("Y");
                break;
            default:
                break;
        }
    }
}
