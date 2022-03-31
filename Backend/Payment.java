/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/
public class Payment {
    private String cardName;
    private String cardType;
    private String accountNumber;
    private String cardHolderName;
    private String expireDate;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;

    public Payment(String cardName, String cardType, String accountNumber, String cardHolderName, String expireDate, String address1, String address2, String city, String state, int zip) {
        this.cardName = cardName;
        this.cardType = cardType;
        this.accountNumber = accountNumber;
        this.cardHolderName = cardHolderName;
        this.expireDate = expireDate;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCardName() {
        return this.cardName;
    }
}