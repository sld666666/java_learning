package charper03.demo01;

/**
 * Created by diwu.sld on 2016/3/24.
 */
public class StudentDao extends AbstractDao {

    @Override
    public void doExcute() {
        System.out.println("doExcute");
    }


    public  static void main(String args[]){
        StudentDao dao = new StudentDao();
        dao.excute();
    }
}
