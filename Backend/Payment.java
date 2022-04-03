/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/

/*
 * change log
 * added accessor functions
 * added mutator functions
 * removed cardName function. No use. Replaced with cvv
 */
public class Payment {
	private String cardName;
    private String cardType;
    private String accountNumber;
    private String cardHolderName;
    private String expireDate;
    private int cvv;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;

    public Payment(String cardName, String cardType, String accountNumber, String cardHolderName, String expireDate, int cvv, String address1, String address2, String city, String state, int zip) {
        this.cardName = cardName;
    	this.cardType = cardType;
        this.accountNumber = accountNumber;
        this.cardHolderName = cardHolderName;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    public Payment(String accountNumber, String cardHolderName, String expireDate, int cvv) {
    	this.accountNumber = accountNumber;
    	this.cardHolderName = cardHolderName;
    	this.expireDate = expireDate;
    	this.cvv = cvv;
    }
    
    public String getCardName() {
    	return this.cardName;
    }
    
    public void setCardName(String cardName) {
    	this.cardName = cardName;
    }
    
    public String getCardType() {
    	return cardType;
    }
    
    public void setCardType(String cardtype) {
    	this.cardType = cardtype;
    }
    
    public String getAccountNumber() {
    	return accountNumber;
    }
    
    public void setAccountNumber(String accNum) {
    	this.accountNumber = accNum;
    }
    
    public String getCardHolderName() {
    	return cardHolderName;
    }
    
    public void setCardHolderName(String cardHolderName) {
    	this.cardHolderName = cardHolderName;
    }
    
    public String getExpireDate() {
    	return expireDate;
    }
    
    public void setExpireDate(String expireDate) {
    	this.expireDate = expireDate;
    }
    
    public int getCVV() {
    	return cvv;
    }
    
    public void setCVV(int cvv) {
    	this.cvv = cvv;
    }
    
    public String getAddressOne() {
    	return address1;
    }
    
    public void setAddressOne(String addressOne) {
    	this.address1 = addressOne;
    }
    
    public String getAddressTwo() {
    	return address2;
    }
    
    public void setAddressTwo(String addressTwo) {
    	this.address2 = addressTwo;
    }
    
    public String getCity() {
    	return city;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    public int getZIP() {
    	return zip;
    }
    
    public void setZIP(int zip) {
    	this.zip = zip;
    }
}
