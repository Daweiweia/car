package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int car_id;
    private String car_type;
    private String car_name;
    private String car_color;
    private int car_stock;
    private String manufactor_name;
    private Date manufactor_date;
    private String manufactor_price;
    private String car_image;
}
