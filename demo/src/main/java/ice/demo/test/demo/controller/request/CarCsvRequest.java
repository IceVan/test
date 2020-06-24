package ice.demo.test.demo.controller.request;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.sql.Date;


public class CarCsvRequest {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String nazwa;

    @CsvBindByPosition(position = 2)
    private String dataZakupu;

    @CsvBindByPosition(position = 3)
    private String color;

    public CarCsvRequest(){}

    public CarCsvRequest(String id, String nazwa, String dataZakupu, String color) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataZakupu = dataZakupu;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(String dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
