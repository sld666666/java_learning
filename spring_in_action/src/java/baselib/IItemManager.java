package baselib;

import java.util.List;

/**
 * Created by diwu.sld on 2016/5/31.
 */
public interface IItemManager {

    public List<Item> query(QueryConfig config);
    public boolean update(Item item);
    public boolean delete(Item item);
}
