package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.FileInfo;
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
            insertRequestOther(requestForm,studentID);
            insertRequestFile(requestForm.getFile(),studentID);

        }
        else if(Objects.equals(requestForm.getType(), "tuitionFee")){
            String studentID = "6509999999";
            insertRequestTuitionFee(requestForm,studentID);
            insertRequestFile(requestForm.getFile(),studentID);

        }

        return 0;
    }
    private void insertRequestOther(RequestForm requestForm,String studentID){
        jdbcTemplate.update("INSERT INTO requestForm(studentID,type,reason,term,year,paidMonth,paidYear)\n"+
                        "VALUES (?,?,?,?,?,?,?);\n",
                new Object[]{studentID,requestForm.getType(),requestForm.getReason(),null,
                        null,null,null});
    }
    private void insertRequestTuitionFee(RequestForm requestForm,String studentID){
        jdbcTemplate.update("INSERT INTO requestForm(studentID,type,reason,term,year,paidMonth,paidYear)\n"+
                        "VALUES (?,?,?,?,?,?,?);\n",
                new Object[]{studentID,requestForm.getType(),null, requestForm.getTerm(),
                        requestForm.getYear(), requestForm.getPaidMonth(), requestForm.getPaidYear()});
    }
    private void insertRequestFile(FileInfo[] file,String studentID){
        String sql = "INSERT INTO files(studentID,fileName1,fileSize1,fileName2,fileSize2,fileName3,fileSize3,fileName4,fileSize4,fileName5,fileSize5)\n"
        +"VALUES (?,?,?,?,?,?,?,?,?,?,?);\n";
       List<Object> params = new ArrayList<>();
        params.add(studentID);

        for (int i = 0; i < 5; i++) {
            if (i < file.length && file[i] != null) {
                params.add(file[i].getName());
                params.add(file[i].getSize());
            } else {
                // If the file is null or array index is out of bounds, set corresponding columns to null
                params.add(null);
                params.add(null);
            }
        }
        jdbcTemplate.update(sql, params.toArray());
        return;
    }

    @Override
    public List<RequestForm> findRequestFormAll() {
        return null;
    }
}
