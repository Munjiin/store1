package com.company.domain;
//database에 맞춰서
//tbl_review테이블 컬럼에 맞춰서 작성했음
//파라미터나 리턴타입으로 쓰려고 VO만듦

import java.util.Date;

public class ReviewVO {

    private int rno, mno;
    private String mid;
    private double score;
    private Date reviewDate;
    private String cmt;

    @Override
    public String toString() {
        return "ReviewVO{" +
                "rno=" + rno +
                ", mno=" + mno +
                ", mid='" + mid + '\'' +
                ", score=" + score +
                ", reviewDate=" + reviewDate +
                ", cmt='" + cmt + '\'' +
                '}';
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
}
