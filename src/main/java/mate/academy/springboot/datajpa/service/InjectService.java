package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import mate.academy.springboot.datajpa.model.Manufacturer;
import mate.academy.springboot.datajpa.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectService {
    private final ManufacturerService manufacturerService;
    private final PhoneService phoneService;

    @Autowired
    public InjectService(ManufacturerService manufacturerService, PhoneService phoneService) {
        this.manufacturerService = manufacturerService;
        this.phoneService = phoneService;
    }

    public String inject() {
        Manufacturer manufacturerA = new Manufacturer();
        manufacturerA.setName("Category A");
        manufacturerA = manufacturerService.save(manufacturerA);
        Manufacturer manufacturerB = new Manufacturer();
        manufacturerB.setName("Category B");
        manufacturerB = manufacturerService.save(manufacturerB);

        Phone phone = new Phone();
        phone.setTitle("Product 01");
        phone.setPrice(new BigDecimal(10));
        phone.setManufacturer(manufacturerA);
        phoneService.save(phone);

        phone = new Phone();
        phone.setTitle("Product 02");
        phone.setPrice(new BigDecimal(15));
        phone.setManufacturer(manufacturerA);
        phoneService.save(phone);

        phone = new Phone();
        phone.setTitle("Product 03");
        phone.setPrice(new BigDecimal(20));
        phone.setManufacturer(manufacturerA);
        phoneService.save(phone);

        phone = new Phone();
        phone.setTitle("Product 04");
        phone.setPrice(new BigDecimal(25));
        phone.setManufacturer(manufacturerB);
        phoneService.save(phone);

        phone = new Phone();
        phone.setTitle("Product 05");
        phone.setPrice(new BigDecimal(30));
        phone.setManufacturer(manufacturerB);
        phoneService.save(phone);

        return "Injected 5 products";
    }
}
