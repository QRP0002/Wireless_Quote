package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/15/2015.
 */
public class CustomerInformation extends RealmObject {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String middleI;
    private String companyName;
    private String companyAddress;
    private BuildInformation bi;
    private EquipmentController ec;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EquipmentController getEc() {
        return ec;
    }

    public void setEc(EquipmentController ec) {
        this.ec = ec;
    }

    public BuildInformation getBi() {
        return bi;
    }

    public void setBi(BuildInformation bi) {
        this.bi = bi;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMiddleI() {
        return middleI;
    }

    public void setMiddleI(String middleI) {
        this.middleI = middleI;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
