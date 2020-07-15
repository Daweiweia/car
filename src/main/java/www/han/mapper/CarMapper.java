package www.han.mapper;

import org.apache.ibatis.annotations.Param;
import www.han.pojo.Car;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.Han
 * @description:
 * @date:2020/7/14
 */
public interface CarMapper {
    List<Car> catListLimit(@Param("start") int start, @Param("pageSize") int pageSize);
    int getCarCount();
    int deleteCar(int carId);
    int updateCar(Car car);
    int addCar(Car car);
    Car selectCarById(int carId);
    int addFile(Map<String,Object> map);
}
