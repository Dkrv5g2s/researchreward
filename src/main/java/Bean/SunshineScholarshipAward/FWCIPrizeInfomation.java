package Bean.SunshineScholarshipAward;

public class FWCIPrizeInfomation {


    private String UnderOnePointThreePrize;
    private String UnderOnePointFivePrize;
    private String UnderOnePointEightPrize;
    private String UnderTwoPointTwoPrize;
    private String OverTwoPointTwoPrize;

    public FWCIPrizeInfomation(String underOnePointThreePrize, String underOnePointFivePrize, String underOnePointEightPrize, String underTwoPointTwoPrize, String overTwoPointTwoPrize) {
        UnderOnePointThreePrize = underOnePointThreePrize;
        UnderOnePointFivePrize = underOnePointFivePrize;
        UnderOnePointEightPrize = underOnePointEightPrize;
        UnderTwoPointTwoPrize = underTwoPointTwoPrize;
        OverTwoPointTwoPrize = overTwoPointTwoPrize;
    }
    public FWCIPrizeInfomation() {

    }


    public String getUnderOnePointThreePrize() {
        return UnderOnePointThreePrize;
    }

    public void setUnderOnePointThreePrize(String underOnePointThreePrize) {
        UnderOnePointThreePrize = underOnePointThreePrize;
    }

    public String getUnderOnePointFivePrize() {
        return UnderOnePointFivePrize;
    }

    public void setUnderOnePointFivePrize(String underOnePointFivePrize) {
        UnderOnePointFivePrize = underOnePointFivePrize;
    }

    public String getUnderOnePointEightPrize() {
        return UnderOnePointEightPrize;
    }

    public void setUnderOnePointEightPrize(String underOnePointEightPrize) {
        UnderOnePointEightPrize = underOnePointEightPrize;
    }

    public String getUnderTwoPointTwoPrize() {
        return UnderTwoPointTwoPrize;
    }

    public void setUnderTwoPointTwoPrize(String underTwoPointTwoPrize) {
        UnderTwoPointTwoPrize = underTwoPointTwoPrize;
    }

    public String getOverTwoPointTwoPrize() {
        return OverTwoPointTwoPrize;
    }

    public void setOverTwoPointTwoPrize(String overTwoPointTwoPrize) {
        OverTwoPointTwoPrize = overTwoPointTwoPrize;
    }

    @Override
    public String toString() {
        return "FWCIPrizeInfomation{" +
                "UnderOnePointThreePrize='" + UnderOnePointThreePrize + '\'' +
                ", UnderOnePointFivePrize='" + UnderOnePointFivePrize + '\'' +
                ", UnderOnePointEightPrize='" + UnderOnePointEightPrize + '\'' +
                ", UnderTwoPointTwoPrize='" + UnderTwoPointTwoPrize + '\'' +
                ", OverTwoPointTwoPrize=" + OverTwoPointTwoPrize +  '\'' +
                '}';
    }

}
