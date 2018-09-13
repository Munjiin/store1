package com.company.domain;

public class ScoreVO {

    private int score;
    private int cnt;
    private int pnt;

    @Override
    public String toString() {
        return "ScoreVO{" +
                "score=" + score +
                ", cnt=" + cnt +
                ", pnt=" + pnt +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPnt() {
        return pnt;
    }

    public void setPnt(int pnt) {
        this.pnt = pnt;
    }
}
