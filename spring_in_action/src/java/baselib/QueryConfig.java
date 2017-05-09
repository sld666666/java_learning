package baselib;

/**
 * Created by diwu.sld on 2016/5/31.
 */
public class QueryConfig {
    public  String title;
    public boolean quantityInLimit;
    public  String locaiton;
    public boolean isFreeShip;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isQuantityInLimit() {
        return quantityInLimit;
    }

    public void setQuantityInLimit(boolean quantityInLimit) {
        this.quantityInLimit = quantityInLimit;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }
}
