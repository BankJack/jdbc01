package test3;

import utils.DBUitls;

import java.util.List;

public class Test1 extends DBUitls {

    public void remove(){
        String sql = "delete from examstudent where flow_id = ?";

        int row = super.executeUpdate(sql,1);
        System.out.println(row);
    }

    public void insert(){
        String sql = "insert into examstudent (type,id_card,exam_card,student_name,location,grade) values (?,?,?,?,?,?)";
        Object[] params = {6,"342824195263214584","200523164754002","杨丽","北京",95};

        int row = super.executeUpdate(sql, params);
        System.out.println(row);
    }

    public void testQuery(){
        //当数据库的列名和javaBean的属性名不一致时，无法查询出数据
        String sql = "select t.flow_id flowId,t.type,t.student_name studentName, t.exam_card examCard,t.grade,t.id_card idCard,t.location from examstudent t"
                + " where t.grade < ?";
        List<ExamStudent> list = super.queryList(ExamStudent.class, sql,60);
        //System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            ExamStudent examStudent =  list.get(i);
            System.out.println(examStudent);
        }
    }

    public void testOne(){
        String sql = "select t.flow_id flowId,t.type,t.student_name studentName, t.exam_card examCard,t.grade,t.id_card idCard,t.location from examstudent t"
                + " where t.flow_id = ?";
        ExamStudent examStudent = super.queryOne(ExamStudent.class, sql, 5);//查询flow_id为5的数据
        System.out.println(examStudent);
    }

    public static void main(String[] args) {
        //删除操作
        Test1 t = new Test1();
        //t.remove();
        //t.insert();
        //t.testQuery();
        t.testOne();
    }
}
