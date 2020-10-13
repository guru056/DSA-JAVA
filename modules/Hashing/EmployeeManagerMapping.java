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
        System.out.println(getManagerEmployeeMap(map)); // better and cleaner
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

        List<String> directEmployees = map.get(manager);

        for (String employee: directEmployees) {
            resultList.add(employee);
            resultList.addAll(getEmployeesForManager(employee, map));
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

    public static Map<String, List<String>> getManagerEmployeeMap(Map<String, String> employeeManagerMap) {
        Map<String, List<String>> directManagerEmployeeMap = new HashMap<>();

        for (Map.Entry<String, String> entry: employeeManagerMap.entrySet()) {
            if (entry.getValue().compareTo(entry.getKey()) == 0 || entry.getValue() == null) continue;
            directManagerEmployeeMap.putIfAbsent(entry.getValue(), new ArrayList<>());
            directManagerEmployeeMap.get(entry.getValue()).add(entry.getKey());
        }

        Map<String, List<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry: directManagerEmployeeMap.entrySet()) {
            getEmployeesForManagerV3(entry.getKey(), directManagerEmployeeMap, resultMap);
        }
        return resultMap;
    }

    private static List<String> getEmployeesForManagerV3(String manager, Map<String, List<String>> directManagerEmployeeMap, Map<String, List<String>> resultMap) {
        List<String> resultList = new ArrayList<>();
        if (!directManagerEmployeeMap.containsKey(manager)) {
            resultMap.put(manager, resultList);
            return resultList;
        }
        if (resultMap.containsKey(manager)) { // DP
            return resultMap.get(manager);
        }

        List<String> directEmployees = directManagerEmployeeMap.get(manager);
        for (String directEmployee: directEmployees) {
            resultList.add(directEmployee);
            resultList.addAll(getEmployeesForManagerV3(directEmployee, directManagerEmployeeMap, resultMap));
        }

        resultMap.put(manager, resultList);
        return resultList;
    }
}
