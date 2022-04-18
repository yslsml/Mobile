package mobile.read;

import mobile.entity.Brand;
import mobile.entity.Mobile;
import mobile.exception.BadMobileException;
import mobile.exception.BadReadMobileException;
import mobile.valid.ValidMobileProperties;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

public class ReadMobile {
    public static Mobile ReadFromConsole(InputStream scan) throws IllegalArgumentException, BadReadMobileException, BadMobileException {
        Mobile mobile;

        Scanner scanner = new Scanner(scan);

        String brand;
        String model;
        double price;
        double diagonalScreenSize;
        double ppi;
        int ram;
        boolean hasExternalMemoryCard;

        System.out.println("\nEnter mobile info. \nEnter a mobile brand (Apple, Lenovo, Samsung, Huawei, Xiaomi) :");
        String tmp = scanner.nextLine();
        if (ValidMobileProperties.isValidMobileBrand(tmp)) {
            brand = tmp;
        } else {
            throw new BadReadMobileException("Entering a brand exception!");
        }

        System.out.print("Enter a model: ");
        model = scanner.nextLine();

        System.out.print("Enter a price ( 150 <= value ): ");
        if (scanner.hasNextFloat()) {
            price = scanner.nextFloat();
        } else {
            throw new BadReadMobileException("Entering a price exception!");
        }

        System.out.print("Enter a diagonal screen size ( 2 <= value <= 10 ): ");
        if (scanner.hasNextFloat()) {
            diagonalScreenSize = scanner.nextFloat();
        } else {
            throw new BadReadMobileException("Entering a diagonalScreenSize exception!");
        }

        System.out.print("Enter a ppi value ( 200 <= value <= 600 ): ");
        if (scanner.hasNextFloat()) {
            ppi = scanner.nextFloat();
        } else {
            throw new BadReadMobileException("Entering a ppi exception!");
        }

        System.out.print("Enter a ram value ( 64, 128, 256, 512, 1024 ): ");
        if (scanner.hasNextInt()) {
            ram = scanner.nextInt();
        } else {
            throw new BadReadMobileException("Entering a ram exception!");
        }

        System.out.print("Is there an external memory card? ( \"true\" or \"false\" ) : ");
        if (scanner.hasNextBoolean()) {
            hasExternalMemoryCard = scanner.nextBoolean();
        } else {
            throw new BadReadMobileException("Entering a hasExternalMemoryCard Exception!");
        }

        Mobile.Properties pr = new Mobile().new Properties(diagonalScreenSize, ppi, ram, hasExternalMemoryCard);
        mobile = new Mobile(Brand.valueOf(brand.toUpperCase(Locale.ROOT)), model, pr, price);

        return mobile;
    }
}
