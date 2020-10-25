package unsw.backend;

public class Market extends Infrastructure{
    private String type = "Market";
    static private double baseCost = 15000;
    static private double upgradeCost = 6000;
    static private int maxUpgrade = 5;

    public Market() {
        super(2, baseCost, upgradeCost, maxUpgrade);
    }

    public void upgradeMarket() {
        int temp = super.getLevel();
        if (temp < 5) {
            super.levelUp();
        }
    }

    public String getType() {
        return type;
    }
}