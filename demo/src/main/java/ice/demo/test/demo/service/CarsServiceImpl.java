package ice.demo.test.demo.service;

import ice.demo.test.demo.controller.response.CarsControllerSaveCarsResponse;
import ice.demo.test.demo.dao.CarRepository;
import ice.demo.test.demo.model.Car;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Log
@Service
public class CarsServiceImpl implements CarsService {

    private CarRepository carRepository;

    @Autowired
    public CarsServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public CarsControllerSaveCarsResponse saveCars(MultipartFile file, String color) {
        CarsControllerSaveCarsResponse response = new CarsControllerSaveCarsResponse();
        response.setSuccess(false);

        BufferedReader br;
        String line = "";
        String cvsSplitBy=",";

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try{
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                String utfLine = new String(line.getBytes(), StandardCharsets.UTF_8);
                String[] car = utfLine.split(cvsSplitBy);

                if(car.length == 4 && car[0] != null && !car[0].isEmpty() && car[3] != null && car[3].equalsIgnoreCase(color)){
                    Date date =new Date(format.parse ( car[2] ).getTime());
                    Car carEntity = new Car(Long.valueOf(car[0]),car[1],date,car[3]);
                    carRepository.save(carEntity);
                    response.addCar(carEntity);
                }
            }
            response.setSuccess(true);

        }catch (Exception e){
            log.severe(e.getMessage());
        }
        return response;
    }
}
