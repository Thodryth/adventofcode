package adventofcode;

import java.util.List;
import java.util.stream.Collectors;

public class ElfService {

    int highestNumber = 0;

    public int findHighestTonnage(List<Elf> elfList) {

        highestNumber = elfList.get(0).getTotalTonnage();

        elfList.forEach(elf -> {
            if (elf.getTotalTonnage() > highestNumber)
                highestNumber = elf.getTotalTonnage();
        });

        return highestNumber;
    }

    public List<Integer> getTonnagesAsSortedList(List<Elf> elfList) {
        return elfList.stream().map(Elf::getTotalTonnage).sorted().collect(Collectors.toList());
    }

    public int getHighestThree(List<Integer> values) {
        return values.get(values.size() - 1) + values.get(values.size() - 2) + values.get(values.size() - 3);
    }
}
