package mate.academy.springboot.datajpa.service;

import mate.academy.springboot.datajpa.model.Manufacturer;
import mate.academy.springboot.datajpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer getById(Long id) {
        return manufacturerRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
