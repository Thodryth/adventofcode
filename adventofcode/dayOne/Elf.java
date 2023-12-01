package adventofcode.dayOne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Elf {

    private int lefId;

    private List<Integer> packs = new ArrayList<>();

    public List<Integer> getPacks() {
        return packs;
    }

    public void addAPack(String pack) {
        this.packs.add(Integer.valueOf(pack));
    }

    public int getTotalTonnage() {
        return packs.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public int getLefId() {
        return lefId;
    }

    public void setLefId(int lefId) {
        this.lefId = lefId;
    }

}
