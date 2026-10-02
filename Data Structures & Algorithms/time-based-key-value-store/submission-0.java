class TimeMap {

    private HashMap<String, ArrayList<Object[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Object[]{timestamp, value});
    }
    
    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Object[]> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int midTimestamp = (int) list.get(mid)[0];

            if (midTimestamp <= timestamp) {
                result = (String) list.get(mid)[1];

                // valid mila, aur better/latest ke liye right jao
                left = mid + 1;
            } 
            else {
                // timestamp bada hai, left jao
                right = mid - 1;
            }
        }

        return result;
    }
}