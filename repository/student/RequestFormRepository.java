package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.RequestForm;

import java.util.List;

public interface RequestFormRepository {
    int saveRequestForm(RequestForm requestForm);
    List<RequestForm> findRequestFormAll();
}
