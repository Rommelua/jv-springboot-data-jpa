package mate.academy.springboot.datajpa.controller;

import mate.academy.springboot.datajpa.dto.ManufacturerRequestDto;
import mate.academy.springboot.datajpa.dto.ManufacturerResponseDto;
import mate.academy.springboot.datajpa.dto.mapper.ManufacturerMapper;
import mate.academy.springboot.datajpa.model.Manufacturer;
import mate.academy.springboot.datajpa.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;
    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService,
                                  ManufacturerMapper manufacturerMapper) {
        this.manufacturerService = manufacturerService;
        this.manufacturerMapper = manufacturerMapper;
    }

    @PostMapping
    public ManufacturerResponseDto create(@RequestBody ManufacturerRequestDto requestDto) {
        Manufacturer manufacturer = manufacturerMapper.toModel(requestDto);
        manufacturer = manufacturerService.save(manufacturer);
        return manufacturerMapper.toResponseDto(manufacturer);
    }

    @GetMapping
    public ManufacturerResponseDto getById(@RequestParam Long id) {
        Manufacturer manufacturer = manufacturerService.getById(id);
        return manufacturerMapper.toResponseDto(manufacturer);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        manufacturerService.delete(id);
    }

    @PutMapping
    public ManufacturerResponseDto update(@RequestBody ManufacturerRequestDto requestDto,
                                          @RequestParam Long id) {
        Manufacturer manufacturer = manufacturerMapper.toModel(requestDto);
        manufacturer.setId(id);
        manufacturer = manufacturerService.save(manufacturer);
        return manufacturerMapper.toResponseDto(manufacturer);
    }
}
