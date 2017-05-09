package contex.service;

import java.util.Map;

import contex.define.IComponentModel;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public interface ISubmitService {

    boolean submit(Map<String, IComponentModel> entity);
}
