package th.ac.tu.cs.GeneralRequestForm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import th.ac.tu.cs.GeneralRequestForm.model.subjectForm;

// Extend CrudRepository with the entity type and primary key type
@Repository
public interface requestFormRepository extends CrudRepository<subjectForm, Long> {
    // You can add custom query methods here if needed
}
