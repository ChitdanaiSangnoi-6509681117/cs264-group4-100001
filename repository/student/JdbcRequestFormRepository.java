package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.RequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class JdbcRequestFormRepository implements RequestFormRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int saveRequestForm(RequestForm requestForm){
        if(Objects.equals(requestForm.getType(), "other")){
            String studentID = "6509999999";
            insertRequest(requestForm,studentID);
        }
        else if(Objects.equals(requestForm.getType(), "tuitionFee")){
            String studentID = "6509999999";
            insertRequest(requestForm,studentID);
        }
        else if(Objects.equals(requestForm.getType(), "withdrawal")){
            String studentID = "6509999999";
            insertRequest(requestForm,studentID);
        }
        else if(Objects.equals(requestForm.getType(), "resignation")){
            String studentID = "6509999999";
            insertRequest(requestForm,studentID);
        }

        return 0;
    }
    private void insertRequest(RequestForm requestForm,String studentID){
        String sql = "INSERT INTO requestForm(studentID,type,reason,term,year,paidMonth,paidYear," +
                "debtOption,dept,amount,gradeOption,course,courseNumber,section,add_withdraw,"+
                        "fileName1,fileSize1,fileName2,fileSize2,fileName3,fileSize3,fileName4,fileSize4,fileName5,fileSize5)\n"+
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);\n";

        List<Object> params = new ArrayList<>();
        params.add(studentID);
        params.add(requestForm.getType());
        params.add(requestForm.getReason());
        params.add(requestForm.getTerm());
        params.add(requestForm.getYear());
        params.add(requestForm.getPaidMonth());
        params.add(requestForm.getPaidYear());
        params.add(requestForm.getDebtOption());
        params.add(requestForm.getDept());
        params.add(requestForm.getAmount());
        params.add(requestForm.getGradeOption());
        params.add(requestForm.getCourse());
        params.add(requestForm.getCourseNumber());
        params.add(requestForm.getSection());
        params.add(requestForm.getAdd_withdraw());

        for (int i = 0; i < 5; i++) {
            if ((i < requestForm.getFile().length) && (requestForm.getFile()[i] != null)) {
                params.add(requestForm.getFile()[i].getName());
                params.add(requestForm.getFile()[i].getSize());
            } else {
                // If the file is null or array index is out of bounds, set corresponding columns to null
                params.add(null);
                params.add(null);
            }
        }
        jdbcTemplate.update(sql, params.toArray());
    }
    private void insertRequestOther(RequestForm requestForm,String studentID){
        String sql = "INSERT INTO requestForm(studentID,type,reason,term,year,paidMonth,paidYear," +
                "debtOption,dept,amount,gradeOption,course,courseNumber,section,add_withdraw,"+
                "fileName1,fileSize1,fileName2,fileSize2,fileName3,fileSize3,fileName4,fileSize4,fileName5,fileSize5)\n"+
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);\n";

        List<Object> params = new ArrayList<>();
        params.add(studentID);
        params.add(requestForm.getType());
        params.add(requestForm.getReason());
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);
        params.add(null);


        for (int i = 0; i < 5; i++) {
            if (i < requestForm.getFile().length && requestForm.getFile()[i] != null) {
                params.add(requestForm.getFile()[i].getName());
                params.add(requestForm.getFile()[i].getSize());
            } else {
                // If the file is null or array index is out of bounds, set corresponding columns to null
                params.add(null);
                params.add(null);
            }
        }
        jdbcTemplate.update(sql, params.toArray());
    }

    @Override
    public List<RequestForm> findRequestFormAll() {
        return null;
    }
}
