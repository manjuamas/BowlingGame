public class Frame {

    int score;
    int pinsFirstAttempt;
    int pinsSecondAttempt;
    int totalPinsInAFrame;

    public Frame(int totalPinsInAFrame) {
        pinsFirstAttempt = 0;
        pinsSecondAttempt = 0;
        score = 0;
        this.totalPinsInAFrame = totalPinsInAFrame;
    }

    public boolean isAStrike() {
        return pinsFirstAttempt == totalPinsInAFrame;
    }

    public boolean isASpare() {
        return (pinsFirstAttempt + pinsSecondAttempt) == totalPinsInAFrame;
    }

    public void setScore(int extra1, int extra2) {
        this.score = pinsFirstAttempt + pinsSecondAttempt + extra1 + extra2;
    }

    public int getScore() {
        return score;
    }
}
