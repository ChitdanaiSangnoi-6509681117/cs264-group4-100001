package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.RequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class JdbcRequestFormRepository implements RequestFormRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int saveRequestForm(RequestForm requestForm){
        if(Objects.equals(requestForm.getType(), "other")){
            insertRequestOther(requestForm);
        }
        else if(Objects.equals(requestForm.getType(), "tuitionFee")){
            insertRequestTuitionFee(requestForm);
        }


        return 0;
    }
    private void insertRequestOther(RequestForm requestForm){
        jdbcTemplate.update("INSERT INTO requestForm(type,reason,term,year,paidMonth,paidYear)\n"+
                        "VALUES (?,?,?,?,?,?);\n",
                new Object[]{requestForm.getType(),requestForm.getReason(),null,
                        null,null,null});
    }
    private void insertRequestTuitionFee(RequestForm requestForm){
        jdbcTemplate.update("INSERT INTO requestForm(type,reason,term,year,paidMonth,paidYear)\n"+
                        "VALUES (?,?,?,?,?,?);\n",
                new Object[]{requestForm.getType(),null, requestForm.getTerm(),
                        requestForm.getYear(), requestForm.getPaidMonth(), requestForm.getPaidYear()});
    }

    @Override
    public List<RequestForm> findRequestFormAll() {
        return null;
    }
}
