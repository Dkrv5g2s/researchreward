package Bean.SpecialOutstandingResearcher;

import java.util.Date;

public class ReviewSupportingInformation {

    private String contract_name ;
    private String technology_transfer_unit ;
    private Date contract_date ;
    private String actually_received_technology_transfer_funds ;
    private Date technical_transfer_funds_include_date ;


    public ReviewSupportingInformation(String contract_name, String technology_transfer_unit, Date contract_date, String actually_received_technology_transfer_funds, Date technical_transfer_funds_include_date) {
        this.contract_name = contract_name;
        this.technology_transfer_unit = technology_transfer_unit;
        this.contract_date = contract_date;
        this.actually_received_technology_transfer_funds = actually_received_technology_transfer_funds;
        this.technical_transfer_funds_include_date = technical_transfer_funds_include_date;
    }

    public ReviewSupportingInformation() {
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getTechnology_transfer_unit() {
        return technology_transfer_unit;
    }

    public void setTechnology_transfer_unit(String technology_transfer_unit) {
        this.technology_transfer_unit = technology_transfer_unit;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public String getActually_received_technology_transfer_funds() {
        return actually_received_technology_transfer_funds;
    }

    public void setActually_received_technology_transfer_funds(String actually_received_technology_transfer_funds) {
        this.actually_received_technology_transfer_funds = actually_received_technology_transfer_funds;
    }

    public Date getTechnical_transfer_funds_include_date() {
        return technical_transfer_funds_include_date;
    }

    public void setTechnical_transfer_funds_include_date(Date technical_transfer_funds_include_date) {
        this.technical_transfer_funds_include_date = technical_transfer_funds_include_date;
    }
}
