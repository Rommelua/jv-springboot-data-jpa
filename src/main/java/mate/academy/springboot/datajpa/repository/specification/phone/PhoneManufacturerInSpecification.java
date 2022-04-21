package mate.academy.springboot.datajpa.repository.specification.phone;

import javax.persistence.criteria.CriteriaBuilder;
import mate.academy.springboot.datajpa.model.Phone;
import mate.academy.springboot.datajpa.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneManufacturerInSpecification implements SpecificationProvider<Phone> {
    private static final String FILTER_KEY = "manufacturerIn";
    private static final String FIELD_NAME = "manufacturer";

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }

    @Override
    public Specification<Phone> getSpecification(String[] params) {
        return ((root, query, cb) -> {
            CriteriaBuilder.In<Long> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : params) {
                predicate.value(Long.valueOf(value));
            }
            return cb.and(predicate);
        });
    }
}
