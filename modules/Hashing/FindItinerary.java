package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
public class FindItinerary {

    static class Route {
        String source;
        String destination;

        public Route(String start, String destination) {
            this.source = start;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return  source  + " --> " + destination ;
        }
    }

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        System.out.println(getItinerary(dataSet));
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

}
