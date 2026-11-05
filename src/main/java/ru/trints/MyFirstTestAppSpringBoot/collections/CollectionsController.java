package ru.trints.MyFirstTestAppSpringBoot.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CollectionsController {
    private ArrayList<String> arrayList;
    private HashMap<Integer, String> hashMap;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("s") String s) {
        if (arrayList == null) arrayList = new ArrayList<>();
        arrayList.add(s);

        return "Value added to ArrayList";
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("s") String s) {
        if (hashMap == null) hashMap = new HashMap<>();
        hashMap.put(hashMap.size(), s);

        return "Value added to HashMap";
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    @GetMapping({"/show-all-length", "/show-all-lenght"})
    public String showAllLength() {
        var arraySize = arrayList == null ? 0 : arrayList.size();
        var mapSize = hashMap == null ? 0 : hashMap.size();

        return "ArrayList contains " + arraySize + " elements; HashMap contains " + mapSize + " elements.";
    }
}
