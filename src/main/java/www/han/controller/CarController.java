package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import www.han.pojo.Car;
import www.han.pojo.FileUp;
import www.han.service.CarService;
import www.han.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping("/carList")
    @ResponseBody
    public String carList(@RequestParam("currentPageNo") int currentPageNo,
                          @RequestParam("pageSize") int pageSize) throws JsonProcessingException {
        int start = 0;//查询开始位置
        int pageCount;//总页面数
        int count = carService.getCarCount();//数据总行数

        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        if (currentPageNo > pageCount) {
            start = pageCount;
        } else {
            start = (currentPageNo - 1) * pageSize;
        }
        JsonUtil carJson = new JsonUtil<Car>();
        carJson.setCode(0);
        carJson.setCount(count);
        carJson.setMsg("");
        carJson.setData(carService.carListLimit(start, pageSize));

        String cars = new ObjectMapper().writeValueAsString(carJson);
//        System.out.println(staffs);
        return cars;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCar(int carId){
        int i = carService.deleteCar(carId);
        if (i > 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateCar(String carStr) throws JsonProcessingException {
        Car car = new ObjectMapper().readValue(carStr, Car.class);
        int i = carService.updateCar(car);
        if (i > 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addCar(String addCarStr) throws JsonProcessingException {
        System.out.println(addCarStr);
        Car car = new ObjectMapper().readValue(addCarStr, Car.class);
        Car car1 = carService.selectCarById(car.getCar_id());
        System.out.println("---------有无车辆信息-------------"+car1);
        if (car1 != null){
            return "fail";
        }else {
            int i = carService.addCar(car);
            if (i>0){
                return "success";
            }else {
                return "fail";
            }
        }
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") CommonsMultipartFile file,@RequestParam("carId") int carId, HttpServletRequest request, Model model) throws IOException {
        JsonUtil<FileUp> fileJson = new JsonUtil<FileUp>();
        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(file+"id是"+carId);
        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，返回失败！
        if ("".equals(uploadFileName)){
            fileJson.setCode(1);
            return objectMapper.writeValueAsString(fileJson);
        }
        //获取上传文件名的后缀
        String[] splitStr = uploadFileName.split("\\.");
        String suffix = splitStr[splitStr.length - 1];
//        System.out.println("文件后缀是："+suffix);
        String fileName = System.currentTimeMillis() + "." + suffix;
//        System.out.println("filename=="+fileName);

        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/car_images");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
//        System.out.println("上传文件保存地址："+realPath);
        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(realPath,fileName));

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        int i = carService.addFile(carId, fileName);
        if (i >0){
            fileJson.setCode(0);
            return objectMapper.writeValueAsString(fileJson);
        }else {
            fileJson.setCode(1);
            return objectMapper.writeValueAsString(fileJson);
        }
    }
}
