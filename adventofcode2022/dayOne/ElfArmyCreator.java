package adventofcode2022.dayOne;

import java.util.ArrayList;
import java.util.List;

public class ElfArmyCreator {

    public List<Elf> createElfArmy(String[] list) {

        var elfList = new ArrayList<Elf>();

        int elfNumber = 1;
        int i = 0;
        var elf = new Elf();
        while (i < list.length) {
            elf.setLefId(elfNumber);
            if (!list[i].equals("")) {
                elf.addAPack(list[i]);
            }
            if (list[i].equals("")) {
                elfList.add(elf);
                elf = new Elf();
                elfNumber++;
            }
            i++;
        }
        return elfList;
    }

}
