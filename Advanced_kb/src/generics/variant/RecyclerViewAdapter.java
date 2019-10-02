package generics.variant;

import java.util.ArrayList;
import java.util.List;

class City {
}

class Province {
    List<City> cities;

    public Province(List<City> in) {
        this.cities = in;
    }
}

interface IEntityInfo {
    int type = 0;

    List<IEntityInfo> getChildren();
}


class RecyclerViewAdapter {
    List<IEntityInfo> data;

    public void setData(List<IEntityInfo> raw) {
        for (IEntityInfo parent : raw) {
            data.add(parent);
            for (IEntityInfo child : parent.getChildren()) {
                data.add(child);
            }
        }
    }
}


class Demo {
    public static void main(String[] args) {
        City london = new City();
        City toronto = new City();
        List<City> onCities = new ArrayList<>();
        onCities.add(london);
        onCities.add(toronto);
        Province on = new Province(onCities);

        List<Province> provinces = new ArrayList<>();
        provinces.add(on);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        adapter.setData(provinces);
    }
}