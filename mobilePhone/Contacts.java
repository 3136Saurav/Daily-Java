package mobilePhone;

public class Contacts {
    private String name;
    private String mobileNumber;

    public Contacts(String name, String mobileNumber){
        setName(name);
        setMobileNumber(mobileNumber);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public static Contacts createNewContact(String name, String mobileNumber){
        return new Contacts(name, mobileNumber);
    }
}
