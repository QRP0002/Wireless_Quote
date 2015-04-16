package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/15/2015.
 */
public class BuildInformation extends RealmObject {
    private String mBuilding;
    private String mUnits;
    private String mRooms;
    private String mFloors;

    public String getmBuilding() {
        return mBuilding;
    }

    public void setmBuilding(String mBuilding) {
        this.mBuilding = mBuilding;
    }

    public String getmUnits() {
        return mUnits;
    }

    public void setmUnits(String mUnits) {
        this.mUnits = mUnits;
    }

    public String getmRooms() {
        return mRooms;
    }

    public void setmRooms(String mRooms) {
        this.mRooms = mRooms;
    }

    public String getmFloors() {
        return mFloors;
    }

    public void setmFloors(String mFloors) {
        this.mFloors = mFloors;
    }
}
