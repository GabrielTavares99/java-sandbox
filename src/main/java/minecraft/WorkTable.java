package minecraft;

import lombok.var;

public class WorkTable<T> {

    public Item createItem(Item<T>[][] items) {
        String item = "";
        for (int i = 0; i < items.length; i++) {
            for (var j = 0; j < items[i].length; j++) {
                System.out.println(items[i][j]);
            }
        }
        return null;
    }
}
