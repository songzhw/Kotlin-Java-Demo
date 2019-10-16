package generics.java.variant;

import generics.java.data.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class City implements IEntityInfo{
    @Override
    public List<IEntityInfo> getChildren() {
        return null;
    }
}

class Province implements IEntityInfo {
    List<City> cities;

    public Province(List<City> in) {
        this.cities = in;
    }

    @Override
    public List<? extends IEntityInfo> getChildren() {// change here
        return this.cities;
    }
}

interface IEntityInfo {
    List<? extends IEntityInfo> getChildren(); // change here
}


class RecyclerViewAdapter {
    List<IEntityInfo> data;

    public void setData(List<? extends IEntityInfo> raw) {
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

// ================================
class AdPet extends Animal{}
class Adapter2 {
    List<Animal> data;

    public void setData(List<? extends Animal> raw){
        raw.add(0, new AdPet());
        // ....
        // ....
    }
}