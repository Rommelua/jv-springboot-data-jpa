package mate.academy.springboot.datajpa.service;

import mate.academy.springboot.datajpa.model.Manufacturer;

public interface ManufacturerService {

    Manufacturer save(Manufacturer manufacturer);

    Manufacturer getById(Long id);

    void delete(Long id);
}
