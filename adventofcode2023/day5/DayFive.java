package adventofcode2023.day5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO finish and unbroken this
 */
public class DayFive {

    static int seedToSoilMapStartLineIdx = 0;
    static int soilToFertilizerMapStartLineIdx = 0;
    static int fertilizerToWaterMapStartLineIdx = 0;
    static int waterToLightMapStartLineIdx = 0;
    static int lightToTemperatureStartLineIdx = 0;
    static int temperatureToHumidityStartLineIdx = 0;
    static int humidityToLocationStartLineIdx = 0;

    static List<StepData> seedToSoilMapList = null;
    static List<StepData> soilToFertilizerMapList = null;
    static List<StepData> fertilizerToWaterMapList = null;
    static List<StepData> waterToLightMapList = null;
    static List<StepData> lightToTemperatureMapList = null;
    static List<StepData> temperatureToHumidityMapList = null;
    static List<StepData> humidityToLocationMapList = null;

    record StepData(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
    }

    public static void main(String[] args) throws Exception {
        long result = run();
        System.out.println("Task 1" + result);
        System.out.println("Task 2" + " is missing");
    }

    private static long run() throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("adventofcode2023/day5/puzzleInput"),
                StandardCharsets.UTF_8);

        final List<Long> seeds = new ArrayList<>();
        Arrays.stream(lines.get(0).split(": ")[1].split(" "))
                .forEach(v -> seeds.add(Long.parseLong(v)));

        findIndexesOfTypes(lines);

        fillStepData(lines);

        final List<Long> soils = new ArrayList<>();
        seeds.forEach(s -> soils.add(map(s, seedToSoilMapList)));
        // seedsRange(seeds);
        final List<Long> fertilizers = new ArrayList<>();
        soils.forEach(s -> fertilizers.add(map(s, soilToFertilizerMapList)));

        final List<Long> waters = new ArrayList<>();
        fertilizers.forEach(f -> waters.add(map(f, fertilizerToWaterMapList)));

        final List<Long> lights = new ArrayList<>();
        waters.forEach(w -> lights.add(map(w, waterToLightMapList)));

        final List<Long> temperatures = new ArrayList<>();
        lights.forEach(l -> temperatures.add(map(l, lightToTemperatureMapList)));

        final List<Long> humidities = new ArrayList<>();
        temperatures.forEach(t -> humidities.add(map(t, temperatureToHumidityMapList)));

        final List<Long> locations = new ArrayList<>();
        humidities.forEach(h -> locations.add(map(h, humidityToLocationMapList)));

        long result = locations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            if (locations.get(i) < result) {
                result = locations.get(i);
            }
        }
        return result;
    }

    private static void fillStepData(final List<String> lines) {
        seedToSoilMapList = new ArrayList<>();
        for (int i = seedToSoilMapStartLineIdx + 1; i < soilToFertilizerMapStartLineIdx - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            seedToSoilMapList.add(new StepData(values[0], values[1], values[2]));
        }

        soilToFertilizerMapList = new ArrayList<>();
        for (int i = soilToFertilizerMapStartLineIdx + 1; i < fertilizerToWaterMapStartLineIdx
                - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            soilToFertilizerMapList.add(new StepData(values[0], values[1], values[2]));
        }

        fertilizerToWaterMapList = new ArrayList<>();
        for (int i = fertilizerToWaterMapStartLineIdx + 1; i < waterToLightMapStartLineIdx
                - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            fertilizerToWaterMapList.add(new StepData(values[0], values[1], values[2]));
        }

        waterToLightMapList = new ArrayList<>();
        for (int i = waterToLightMapStartLineIdx + 1; i < lightToTemperatureStartLineIdx - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            waterToLightMapList.add(new StepData(values[0], values[1], values[2]));
        }

        lightToTemperatureMapList = new ArrayList<>();
        for (int i = lightToTemperatureStartLineIdx + 1; i < temperatureToHumidityStartLineIdx
                - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            lightToTemperatureMapList.add(new StepData(values[0], values[1], values[2]));
        }

        temperatureToHumidityMapList = new ArrayList<>();
        for (int i = temperatureToHumidityStartLineIdx + 1; i < humidityToLocationStartLineIdx
                - 1; i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            temperatureToHumidityMapList.add(new StepData(values[0], values[1], values[2]));
        }

        humidityToLocationMapList = new ArrayList<>();
        for (int i = humidityToLocationStartLineIdx + 1; i < lines.size(); i++) {
            long[] values =
                    Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
            humidityToLocationMapList.add(new StepData(values[0], values[1], values[2]));
        }
    }

    private static void findIndexesOfTypes(final List<String> lines) {
        for (int i = 2; i < lines.size(); i++) {
            if (lines.get(i).equals("seed-to-soil map:")) {
                seedToSoilMapStartLineIdx = i;
            } else if (lines.get(i).equals("soil-to-fertilizer map:")) {
                soilToFertilizerMapStartLineIdx = i;
            } else if (lines.get(i).equals("fertilizer-to-water map:")) {
                fertilizerToWaterMapStartLineIdx = i;
            } else if (lines.get(i).equals("water-to-light map:")) {
                waterToLightMapStartLineIdx = i;
            } else if (lines.get(i).equals("light-to-temperature map:")) {
                lightToTemperatureStartLineIdx = i;
            } else if (lines.get(i).equals("temperature-to-humidity map:")) {
                temperatureToHumidityStartLineIdx = i;
            } else if (lines.get(i).equals("humidity-to-location map:")) {
                humidityToLocationStartLineIdx = i;
            }
        }
    }

    private static long map(final long source, final List<StepData> maps) {
        for (final var map : maps) {
            if (map.sourceRangeStart() <= source
                    && map.sourceRangeStart() + map.rangeLength() > source) {
                final long diff = source - map.sourceRangeStart();
                return map.destinationRangeStart() + diff;
            }
        }

        return source;
    }

    private static List<Long> seedsRange(List<Long> seeds) {
        List<Long> seedsRange = new ArrayList<>();
        seedsRange.addAll(seeds);
        Long[][] pairs = new Long[seeds.size() / 2][2];
        for (int i = 0; i < seeds.size() / 2; i++) {
            pairs[i][0] = seeds.get(i);
            pairs[i][1] = seeds.get(i + 1);
        }

        for (Long[] pair : pairs) {
            for (int i = 1; i < pair[1]; i++) {
                System.out.println(pair[i]);
                seedsRange.add(i + pair[1]);
            }
        }


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executorService);
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        return seedsRange;
    }
}

