package mobile.run;

import mobile.action.MobileAction;
import mobile.entity.Brand;
import mobile.entity.Mobile;
import mobile.exception.BadMobileException;
import mobile.exception.BadReadMobileException;
import mobile.read.ReadMobile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger log = LogManager.getLogger();
    public static void main(String[] args)  {
        try {
            int size = 5;
            Mobile[] mobiles = new Mobile[size];

            for (int i = 0; i < 1; i++) {
                mobiles[i] = ReadMobile.ReadFromConsole(System.in);
            }
            log.log(Level.INFO, "Array of mobiles (reading):");
            for (int j = 0; j < 1; j++) {
                log.log(Level.INFO, mobiles[j]);
            }

            Mobile.Properties pr0 = new Mobile().new Properties(4, 440, 256, false);
            Mobile.Properties pr1 = new Mobile().new Properties(6, 338, 64, true);
            Mobile.Properties pr2 = new Mobile().new Properties(9.2, 512, 128, false);
            Mobile.Properties pr3 = new Mobile().new Properties(8, 350, 512, true);
            Mobile.Properties pr4 = new Mobile().new Properties(5.6, 490, 256, true);

            mobiles[0] = new Mobile(Brand.LENOVO, "K13 Note", pr0, 200);
            mobiles[1] = new Mobile(Brand.HUAWEI, "P20 Light", pr1, 320);
            mobiles[2] = new Mobile(Brand.APPLE, "iPhone 12", pr2, 450);
            mobiles[3] = new Mobile(Brand.APPLE, "iPhone 13", pr3, 550);
            mobiles[4] = new Mobile(Brand.XIAOMI, "Mi 8 Light", pr4, 230);

            log.log(Level.INFO, "Array of mobiles:");
            for (int j = 0; j < size; j++) {
                log.log(Level.INFO, mobiles[j]);
            }

            String brand = "apple";
            Mobile[] mobilesOfBrand = MobileAction.chooseBrand(mobiles, brand);
            log.log(Level.INFO, "Array of mobiles which brand is " + brand);
            for (Mobile mobile : mobilesOfBrand) {
                log.log(Level.INFO, mobile);
            }

            double minPrice = 350;
            double maxPrice = 500;
            Mobile[] mobilesByPrice = MobileAction.findByPrice(mobiles, minPrice, maxPrice);
            log.log(Level.INFO, "Array of mobiles with price between " + minPrice + " and " + maxPrice);
            for (Mobile mobile : mobilesByPrice) {
                log.log(Level.INFO, mobile);
            }

        }
        catch (BadMobileException e) {
            log.log(Level.ERROR, "Bad values of mobile exception!!!");
        }

        catch (BadReadMobileException e) {
            log.log(Level.ERROR, e.getMessage());
        }
    }
}
