package baselib;

import java.util.List;

/**
 * Created by diwu.sld on 2016/5/31.
 */
public interface IStorage {
    List<String>    getAllIds();
    Item            getItem(final String clientId);
    boolean         updateItem(final Item item);
}
