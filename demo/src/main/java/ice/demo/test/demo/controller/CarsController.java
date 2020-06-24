package ice.demo.test.demo.controller;

import ice.demo.test.demo.controller.response.CarsControllerSaveCarsResponse;
import ice.demo.test.demo.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;


    @PostMapping("/saveCars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsControllerSaveCarsResponse saveCarsFromCvsFilteredByColor(@RequestParam(name = "csv_file") MultipartFile file, @RequestParam(name = "color") String color){
        return carsService.saveCars(file, color);
    }
}
