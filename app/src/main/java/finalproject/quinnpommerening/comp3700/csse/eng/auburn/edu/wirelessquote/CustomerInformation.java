package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/15/2015.
 */
public class CustomerInformation extends RealmObject {
    private String mUsername;
    private String mPassword;
    private String mFirstName;
    private String mLastName;
    private String mMiddleI;
    private String mCompanyName;
    private String mCompanyAddress;
    private BuildInformation mBi;
    private EquipmentController mEc;

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmMiddleI() {
        return mMiddleI;
    }

    public void setmMiddleI(String mMiddleI) {
        this.mMiddleI = mMiddleI;
    }

    public String getmCompanyName() {
        return mCompanyName;
    }

    public void setmCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public String getmCompanyAddress() {
        return mCompanyAddress;
    }

    public void setmCompanyAddress(String mCompanyAddress) {
        this.mCompanyAddress = mCompanyAddress;
    }

    public BuildInformation getmBi() {
        return mBi;
    }

    public void setmBi(BuildInformation mBi) {
        this.mBi = mBi;
    }

    public EquipmentController getmEc() {
        return mEc;
    }

    public void setmEc(EquipmentController mEc) {
        this.mEc = mEc;
    }
}
