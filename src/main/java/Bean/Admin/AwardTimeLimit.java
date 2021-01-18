package Bean.Admin;

import java.sql.Date;

public class AwardTimeLimit {
    private Date s1 = new Date(System.currentTimeMillis());
    private Date s2 = new Date(System.currentTimeMillis());
    private Date s3 = new Date(System.currentTimeMillis());
    private Date s4 = new Date(System.currentTimeMillis());
    private Date s5 = new Date(System.currentTimeMillis());
    private Date s6 = new Date(System.currentTimeMillis());
    private Date s7 = new Date(System.currentTimeMillis());
    private Date s8 = new Date(System.currentTimeMillis());
    private Date l1 = new Date(System.currentTimeMillis());
    private Date l2 = new Date(System.currentTimeMillis());
    private Date l3 = new Date(System.currentTimeMillis());
    private Date l4 = new Date(System.currentTimeMillis());
    private Date l5 = new Date(System.currentTimeMillis());
    private Date l6 = new Date(System.currentTimeMillis());
    private Date l7 = new Date(System.currentTimeMillis());
    private Date l8 = new Date(System.currentTimeMillis());
    private double fwci;
    private String userNumber;

    public AwardTimeLimit(Date s1, Date s2, Date s3, Date s4, Date s5, Date s6, Date s7, Date s8, Date l1, Date l2, Date l3, Date l4, Date l5, Date l6, Date l7, Date l8, double fwci , String userNumber) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5 = l5;
        this.l6 = l6;
        this.l7 = l7;
        this.l8 = l8;
        this.fwci = fwci;
        this.userNumber = userNumber;
    }

    public AwardTimeLimit() {

    }

    public double getFwci() {
        return fwci;
    }

    public void setFwci(double fwci) {
        this.fwci = fwci;
    }

    public Date getS1() {
        return s1;
    }

    public void setS1(Date s1) {
        this.s1 = s1;
    }

    public Date getS2() {
        return s2;
    }

    public void setS2(Date s2) {
        this.s2 = s2;
    }

    public Date getS3() {
        return s3;
    }

    public void setS3(Date s3) {
        this.s3 = s3;
    }

    public Date getS4() {
        return s4;
    }

    public void setS4(Date s4) {
        this.s4 = s4;
    }

    public Date getS5() {
        return s5;
    }

    public void setS5(Date s5) {
        this.s5 = s5;
    }

    public Date getS6() {
        return s6;
    }

    public void setS6(Date s6) {
        this.s6 = s6;
    }

    public Date getS7() {
        return s7;
    }

    public void setS7(Date s7) {
        this.s7 = s7;
    }

    public Date getS8() {
        return s8;
    }

    public void setS8(Date s8) {
        this.s8 = s8;
    }

    public Date getL1() {
        return l1;
    }

    public void setL1(Date l1) {
        this.l1 = l1;
    }

    public Date getL2() {
        return l2;
    }

    public void setL2(Date l2) {
        this.l2 = l2;
    }

    public Date getL3() {
        return l3;
    }

    public void setL3(Date l3) {
        this.l3 = l3;
    }

    public Date getL4() {
        return l4;
    }

    public void setL4(Date l4) {
        this.l4 = l4;
    }

    public Date getL5() {
        return l5;
    }

    public void setL5(Date l5) {
        this.l5 = l5;
    }

    public Date getL6() {
        return l6;
    }

    public void setL6(Date l6) {
        this.l6 = l6;
    }

    public Date getL7() {
        return l7;
    }

    public void setL7(Date l7) {
        this.l7 = l7;
    }

    public Date getL8() {
        return l8;
    }

    public void setL8(Date l8) {
        this.l8 = l8;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
