package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import java.text.DecimalFormat;

/**
 * Created by Quinn on 4/26/2015.
 */
public class TotalCost {

    public double equipmentOneCost(String equipmentIn) {
        String equipmentOneOne = "Ruckus Wireless R300 $395.00";
        String equipmentOneTwo = "Ruckus Wireless R500 $645.00";

        if(equipmentIn.equals(equipmentOneOne)) {
            return 395.00;
        } else if (equipmentIn.equals(equipmentOneTwo)) {
            return 645.00;
        } else {
            return 1495.00;
        }
    }

    public double equipmentTwoCost(String equipmentIn) {
        String equipmentTwoOne = "TrendNet Unmanaged Housing Switch $19.95";
        String equipmentTwoTwo = "Cisco SG 300-10P10 PoE Managed Switch $344.95";

        if(equipmentIn.equals(equipmentTwoOne)) {
            return 19.95;
        } else if(equipmentIn.equals(equipmentTwoTwo)) {
            return 344.95;
        } else {
            return 733.95;
        }
    }

    public double equipmentThreeCost(String equipmentIn) {
        String equipmentThreeOne = "Binary 1M CAT6 patch cables $5.95";

        if (equipmentIn.equals(equipmentThreeOne)) {
            return 5.95;
        } else {
            return 7.95;
        }
    }

    public String calculateTotal(double equipmentOneIn, double equipmentTwoIn, double equipmentThreeIn ) {
        double totalCostDouble = equipmentOneIn + equipmentTwoIn + equipmentThreeIn + 13678.00;
        DecimalFormat dc = new DecimalFormat("$###,##0.00");
        return dc.format(totalCostDouble);
    }
}
