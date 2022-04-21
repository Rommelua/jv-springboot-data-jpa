package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import mate.academy.springboot.datajpa.model.Phone;
import org.springframework.data.domain.PageRequest;

public interface PhoneService {

    Phone save(Phone phone);

    Phone getById(Long id);

    void delete(Long id);

    List<Phone> findAll(PageRequest pageRequest);

    List<Phone> findAllByPriceBetween(BigDecimal from, BigDecimal to);

    List<Phone> findAllByParams(Map<String, String> params);
}
