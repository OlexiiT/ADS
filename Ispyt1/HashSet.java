package ispyt1;

import java.util.ArrayList;

public class HashSet<K> {

    private HashMap<K, Integer> map = new HashMap();

    public void add(K data) {
        map.put(data, 0);
    }
    
    public void remove(K data) {
        map.delete(data);
    }

    public boolean hasObject(K data) {
        Integer i = map.get(data);
        if (i == null) {
            return false;
        }
        return true;
    }
    
    public int getSize() {
        return map.getSize();
    }
    
    public ArrayList getIntersection(HashSet set) {
        ArrayList res = new ArrayList();
        ArrayList list = map.toArraylist();
        ArrayList list2 = set.map.toArraylist();
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list2.size(); j++) {
                if (list.get(i).equals(list2.get(j))) {
                    res.add(((HashMapNode) (list.get(i))).getKey());
                }
            }
        }
        return res;
    }

}
