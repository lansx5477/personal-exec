package creational.builder.components;

/**
 * @Author: xiaoyl
 * @Date: 2023/07/03/15:08
 * @Description: 汽车该产品的特征之一
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}