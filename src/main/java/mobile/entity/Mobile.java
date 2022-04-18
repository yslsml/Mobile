package mobile.entity;

import mobile.exception.BadMobileException;
import mobile.valid.ValidMobileProperties;

import java.util.Objects;

// Создать класс Mobile с внутренним классом,
// с помощью объектов которого можно хранить информацию о моделях телефонов и их свойствах.
public class Mobile {
    private Brand brand;
    private String model;
    private double price;
    private Properties properties;

    public Mobile () {
        this.brand = Brand.APPLE;
        this.model = "iPhone 13";
        this.price = ValidMobileProperties.MIN_PRICE;
    }

    public Mobile(Brand brand, String model, Properties properties, double price) {
        this.brand = brand;
        this.model = model;
        this.properties = properties;
        this.price = price;
    }

    public Mobile(Brand brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setBrand(String brand) {
        if(ValidMobileProperties.isValidMobileBrand(brand)) {
            this.brand = Brand.valueOf(brand);
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPrice(double price) throws BadMobileException {
        if (ValidMobileProperties.isValidPrice(price)) {
            this.price = price;
        }
        else throw new BadMobileException("The price is invalid!");
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Properties getProperties() {
        return properties;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return Double.compare(mobile.getPrice(), getPrice()) == 0 &&
                getBrand() == mobile.getBrand() && Objects.equals(getModel(), mobile.getModel()) &&
                Objects.equals(getProperties(), mobile.getProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getProperties(), getPrice());
    }

    @Override
    public String toString() {
        return "\nMobile {" +
                "\nbrand = " + brand +
                "\nmodel = " + model +
                "\nproperties = " + properties +
                "\nprice = " + String.format("%.2f", price) + "$" +
                "\n}";
    }


    public class Properties {
        private double diagonalScreenSize;
        private double ppi;
        private int ram;
        private boolean hasExternalMemoryCard;

        public Properties(double diagonalScreenSize, double ppi, int ram, boolean hasExternalMemoryCard) throws BadMobileException {
            setDiagonalScreenSize(diagonalScreenSize);
            setPpi(ppi);
            setRam(ram);
            setHasExternalMemoryCard(hasExternalMemoryCard);
        }

        public void setDiagonalScreenSize(double diagonalScreenSize) throws BadMobileException {
            if (ValidMobileProperties.isValidDiagonalScreenSize(diagonalScreenSize)) {
                this.diagonalScreenSize = diagonalScreenSize;
            }
            else throw new BadMobileException("The diagonal screen size is invalid!");
        }

        public void setPpi(double ppi) throws BadMobileException {
            if (ValidMobileProperties.isValidPpi(ppi)) {
                this.ppi = ppi;
            }
            else throw new BadMobileException("The ppi is invalid!");
        }

        public void setRam(int ram) throws BadMobileException {
            if (ValidMobileProperties.isValidRam(ram)) {
                this.ram = ram;
            }
            else throw new BadMobileException("The ram is invalid!");
        }

        public void setHasExternalMemoryCard(boolean hasExternalMemoryCard) {
            this.hasExternalMemoryCard = hasExternalMemoryCard;
        }

        public double getDiagonalScreenSize() {
            return diagonalScreenSize;
        }

        public double getPpi() {
            return ppi;
        }

        public double getRam() {
            return ram;
        }

        public boolean getHasExternalMemoryCard() {
            return hasExternalMemoryCard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Properties that = (Properties) o;
            return Double.compare(that.diagonalScreenSize, diagonalScreenSize) == 0 &&
                    Double.compare(that.ppi, ppi) == 0 && Double.compare(that.ram, ram) == 0 &&
                    hasExternalMemoryCard == that.hasExternalMemoryCard;
        }

        @Override
        public int hashCode() {
            return Objects.hash(diagonalScreenSize, ppi, ram, hasExternalMemoryCard);
        }


        @Override
        public String toString() {
            return "[" +
                    " diagonalScreenSize = " + String.format("%.2f", diagonalScreenSize) + "\""+
                    ", ppi = " + String.format("%.2f", ppi) +
                    ", ram = " + ram + " GB" +
                    ", hasExternalMemoryCard = " + hasExternalMemoryCard +
                    " ]";
        }
    }

}

