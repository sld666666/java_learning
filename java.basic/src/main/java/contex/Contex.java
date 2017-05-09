package contex;

import java.util.Map;

import contex.define.IComponentModel;
import lombok.Data;

/**
 * Created by diwu.sld on 2017/5/4.
 */

@Data
public class Contex {
    Map<String, IComponentModel> entity;
}
