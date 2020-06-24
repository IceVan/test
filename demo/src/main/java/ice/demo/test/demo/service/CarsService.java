package ice.demo.test.demo.service;

import ice.demo.test.demo.controller.response.CarsControllerSaveCarsResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CarsService {

    CarsControllerSaveCarsResponse saveCars(MultipartFile file, String color);
}
