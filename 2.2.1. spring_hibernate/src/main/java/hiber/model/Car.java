package hiber.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Car {

    @Column(name = "user_car_model")
    private String model;
    @Column(name = "user_car_series")
    private int series;

    public Car(){}

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
