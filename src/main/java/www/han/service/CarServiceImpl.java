package www.han.service;

import org.springframework.beans.factory.annotation.Autowired;
import www.han.mapper.CarMapper;
import www.han.pojo.Car;

import java.util.HashMap;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;
    @Override
    public List<Car> carListLimit(int start, int pageSize) {
        return carMapper.catListLimit(start,pageSize);
    }

    @Override
    public int getCarCount() {
        return carMapper.getCarCount();
    }

    @Override
    public int deleteCar(int carId) {
        return carMapper.deleteCar(carId);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateCar(car);
    }

    @Override
    public int addCar(Car car) {
        return carMapper.addCar(car);
    }

    @Override
    public Car selectCarById(int carId) {
        return carMapper.selectCarById(carId);
    }

    @Override
    public int addFile(int car_id, String car_image) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("car_id",car_id);
        map.put("car_image",car_image);
        return carMapper.addFile(map);
    }

}
