package mobile.action;

import mobile.entity.Mobile;
import mobile.exception.BadMobileException;
import mobile.valid.ValidMobileProperties;

import java.util.ArrayList;
import java.util.Locale;

public class MobileAction {

    public static Mobile[] chooseBrand(Mobile[] array, String brand) {
        ArrayList<Mobile> arrayList = new ArrayList<Mobile>();
        for (Mobile mobile : array) {
            if (mobile.getBrand().toString().equals(brand.toUpperCase(Locale.ROOT))) {
                arrayList.add(mobile);
            }
        }
        Mobile res[] = new Mobile[arrayList.size()];
        res = arrayList.toArray(res);
        return res;
    }

    public static Mobile[] findByPrice(Mobile[] array, double minPrice, double maxPrice) throws BadMobileException {
        if( ValidMobileProperties.isValidPrice(minPrice) &&
            ValidMobileProperties.isValidPrice(maxPrice) &&
            minPrice <= maxPrice) {
            ArrayList<Mobile> arrayList = new ArrayList<Mobile>();
            for (Mobile mobile : array) {
                if (mobile.getPrice() <= maxPrice && mobile.getPrice() >= minPrice) {
                    arrayList.add(mobile);
                }
            }
            Mobile res[] = new Mobile[arrayList.size()];
            res = arrayList.toArray(res);
            return res;
        }
        else throw new BadMobileException("Incorrect arguments!");
    }
}
