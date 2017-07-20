package livestore;

import java.util.List;

public interface ItemDAO {

    int insert(ItemDTO itemDTO);

    ItemDTO get(int i);

    List<ItemDTO> getAll();

    void update(ItemDTO itemDTO);

    void delete(int i);
}
