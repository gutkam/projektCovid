package pl.sdacademy;

public class Province {
    private Province province;

    public Province(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
