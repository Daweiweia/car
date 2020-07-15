package www.han.service;

import www.han.pojo.Car;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.Han
 * @description:
 * @date:2020/7/14
 */
public interface CarService {
    List<Car> carListLimit(int start,int pageSize);
    int getCarCount();
    int deleteCar(int carId);
    int updateCar(Car car);
    int addCar(Car car);
    Car selectCarById(int carId);
    int addFile(int car_id,String car_image);
}
