package chaper04;

import org.apache.ibatis.annotations.Select;

/**
 * Created by diwu.sld on 2016/3/25.
 */
public interface StudentMapper {
    public StudentEntity selectStudent(Long id);
}
