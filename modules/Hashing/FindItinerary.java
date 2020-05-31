package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
class Route {
    String source;
    String destination;

    public Route(String start, String destination) {
        this.source = start;
        this.destination = destination;
    }
}
public class FindItinerary {

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        List<Route> result = getItinerary(dataSet);
        printRouteList(result);
    }
    /**
     *  Input:
     * "Chennai" -> "Banglore"
     * "Bombay" -> "Delhi"
     * "Goa"    -> "Chennai"
     * "Delhi"  -> "Goa"
     *
     * Output:
     * Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
     * @param map
     * @return
     */
    public static List<Route> getItinerary(Map<String, String> map)
    {
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String,String> e: map.entrySet()) {
            reverseMap.put(e.getValue(), e.getKey());
        }
        String source = null;

        for (Map.Entry<String,String> e: map.entrySet()) {
            if (!reverseMap.containsKey(e.getKey())){
                source = e.getKey();
                break;
            }
        }
        if (source == null) return null;

        List<Route> resultList = new ArrayList<>();
        String destination = map.get(source);

        while (destination != null) {
            resultList.add(new Route(source, destination));
            source = destination;
            destination = map.get(destination);
        }
        return resultList;
    }

    private static void printRouteList(List<Route> list)
    {
        for (Route r: list) {
            System.out.println(r.source + "  -> " + r.destination);
        }
    }
}
