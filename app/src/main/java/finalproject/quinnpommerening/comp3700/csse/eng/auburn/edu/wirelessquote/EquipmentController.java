package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/15/2015.
 */
public class EquipmentController extends RealmObject {
   private String mEquipmentOne;
   private String mEquipmentTwo;
   private String mEquipmentThree;

    public String getmEquipmentOne() {
        return mEquipmentOne;
    }

    public void setmEquipmentOne(String mEquipmentOne) {
        this.mEquipmentOne = mEquipmentOne;
    }

    public String getmEquipmentTwo() {
        return mEquipmentTwo;
    }

    public void setmEquipmentTwo(String mEquipmentTwo) {
        this.mEquipmentTwo = mEquipmentTwo;
    }

    public String getmEquipmentThree() {
        return mEquipmentThree;
    }

    public void setmEquipmentThree(String mEquipmentThree) {
        this.mEquipmentThree = mEquipmentThree;
    }
}
