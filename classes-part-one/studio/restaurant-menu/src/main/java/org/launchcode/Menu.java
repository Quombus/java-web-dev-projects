package org.launchcode;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private ArrayList<MenuItem> menuItemList;
    private Date lastUpdated;

    public Menu(ArrayList<MenuItem> menuItemList, Date lastUpdated) {
        this.menuItemList = menuItemList;
        this.lastUpdated = lastUpdated;
    }

    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void updateMenu(MenuItem item, Date date) {
        if (item.isNew()) {
            item.setNew(false);
            this.menuItemList.add(item);
            this.lastUpdated = date;
        }
    }
}
