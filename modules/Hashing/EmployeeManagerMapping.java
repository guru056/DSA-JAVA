package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
public class EmployeeManagerMapping {

    static Map<String,List<String>> resultMap = new HashMap<>();
    public static void main(String[] args) {
        Map<String, String> map = getMockEmployeeManagerMap();
        System.out.println(getManagerEmployeeHierarchy(map));
    }

    /**
     * Find number of Employees Under every Employee
     * { "A", "C" },
     * { "B", "C" },
     * { "C", "F" },
     * { "D", "E" },
     * { "E", "F" },
     * { "F", "F" }
     *
     * @param map
     * @return
     */
    public static Map<String,List<String>> getManagerEmployeeHierarchy(Map<String,String> map)
    {
        Map<String, List<String>> reverseMap = new HashMap<>();

        for (Map.Entry<String,String> e: map.entrySet()) {
            String key = e.getKey();
            String val = e.getValue();

            if (key.compareTo(val) == 0) continue;

            List<String> list;
            if (!reverseMap.containsKey(val)) {
                list = new ArrayList<>();
            } else {
                list = reverseMap.get(val);
            }
            list.add(key);
            reverseMap.put(val, list);
        }
        return mergeMapsUtil(reverseMap);
    }

    public static Map<String,List<String>> mergeMapsUtil(Map<String,List<String>> map)
    {
        for (Map.Entry<String, List<String>> e: map.entrySet()){
            String manager = e.getKey();
            map.put(manager, getEmployeesForManagerV2(manager, map));
        }
        return resultMap;
    }

    public static List<String> getEmployeesForManager(String manager, Map<String,List<String>> map)
    {
        List<String> resultList = new ArrayList<>();
        if (!map.containsKey(manager)) {
            return resultList;
        }

        List<String> list = map.get(manager);

        for (String employee: list) {
            resultList.add(employee);
            List<String> newList = getEmployeesForManager(employee, map);
            if (!newList.isEmpty()){
                resultList.addAll(newList);
            }
        }
        return resultList;
    }

    public static List<String> getEmployeesForManagerV2(String manager, Map<String,List<String>> map)
    {
        List<String> resultList = new ArrayList<>();
        if (!map.containsKey(manager)) {
            resultMap.put(manager, resultList);
            return resultList;
        }
        if (resultMap.containsKey(manager))
            return resultMap.get(manager);

        List<String> list = map.get(manager);

        for (String employee: list) {
            resultList.add(employee);
            List<String> newList = getEmployeesForManagerV2(employee, map);
            if (!newList.isEmpty()){
                resultList.addAll(newList);
            }
        }
        resultMap.put(manager, resultList);
        return resultList;
    }

    /**
     * { "A", "C" },
     * { "B", "C" },
     * { "C", "F" },
     * { "D", "E" },
     * { "E", "F" },
     * { "F", "F" }
     *
     * @return
     */
    private static Map<String,String> getMockEmployeeManagerMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("A","C");
        map.put("B","C");
        map.put("C","F");
        map.put("D","E");
        map.put("E","F");
        map.put("F","F");

        return map;
    }
}
