package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import mate.academy.springboot.datajpa.model.Phone;
import mate.academy.springboot.datajpa.repository.PhoneRepository;
import mate.academy.springboot.datajpa.repository.specification.SpecificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final SpecificationManager<Phone> productSpecificationManager;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository,
                            SpecificationManager<Phone> productSpecificationManager) {
        this.phoneRepository = phoneRepository;
        this.productSpecificationManager = productSpecificationManager;
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone getById(Long id) {
        return phoneRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<Phone> findAll(PageRequest pageRequest) {
        return phoneRepository.findAll(pageRequest).toList();
    }

    @Override
    public List<Phone> findAllByPriceBetween(BigDecimal from, BigDecimal to) {
        return phoneRepository.findAllByPriceBetween(from, to);
    }

    @Override
    public List<Phone> findAllByParams(Map<String, String> params) {
        Specification<Phone> specification = null;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            Specification<Phone> sp = productSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null
                    ? Specification.where(sp)
                    : specification.and(sp);
        }
        return phoneRepository.findAll(specification);
    }
}
