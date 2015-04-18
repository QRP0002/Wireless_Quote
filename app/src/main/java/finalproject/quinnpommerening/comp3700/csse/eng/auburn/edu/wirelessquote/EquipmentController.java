package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/15/2015.
 */
public class EquipmentController extends RealmObject {
    private String equipmentOne;
    private String equipmentTwo;
    private String equipmentThree;

    public String getEquipmentOne() {
        return equipmentOne;
    }

    public void setEquipmentOne(String equipmentOne) {
        this.equipmentOne = equipmentOne;
    }

    public String getEquipmentTwo() {
        return equipmentTwo;
    }

    public void setEquipmentTwo(String equipmentTwo) {
        this.equipmentTwo = equipmentTwo;
    }

    public String getEquipmentThree() {
        return equipmentThree;
    }

    public void setEquipmentThree(String equipmentThree) {
        this.equipmentThree = equipmentThree;
    }
}
