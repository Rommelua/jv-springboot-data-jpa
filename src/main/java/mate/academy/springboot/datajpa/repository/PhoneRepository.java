package mate.academy.springboot.datajpa.repository;

import java.math.BigDecimal;
import java.util.List;

import mate.academy.springboot.datajpa.model.Manufacturer;
import mate.academy.springboot.datajpa.model.Phone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>,
        JpaSpecificationExecutor<Phone> {
    List<Phone> findAllByPriceBetween(@NonNull BigDecimal from, BigDecimal to, Pageable pageable);

    List<Phone> findAllByPriceBetween(@NonNull BigDecimal from, BigDecimal to);
}
