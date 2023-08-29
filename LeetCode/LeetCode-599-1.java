class Solution
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        Map<String, Integer> resultMap1 = new HashMap<String, Integer>();
        Map<String, Integer> resultMap2 = new HashMap<String, Integer>();
        Map<String, Integer> resultMap3 = new HashMap<String, Integer>();

        int length = (list1.length > list2.length) ? list1.length : list2.length;
        for(int i = 0; i < length; i++)
        {
            if(i < list1.length)
            {
                if(resultMap1.containsKey(list1[i]))
                {
                    resultMap1.put(list1[i], 2);
                    resultMap2.put(list1[i], resultMap2.get(list1[i]) + i);
                }
                else
                {
                    resultMap1.put(list1[i], 1);
                    resultMap2.put(list1[i], i);
                }
            }
            if(i < list2.length)
            {
                if(resultMap1.containsKey(list2[i]))
                {
                    resultMap1.put(list2[i], 2);
                    resultMap2.put(list2[i], resultMap2.get(list2[i]) + i);
                }
                else
                {
                    resultMap1.put(list2[i], 1);
                    resultMap2.put(list2[i], i);
                }
            }
        }

        for(Map.Entry<String, Integer> rm1 : resultMap1.entrySet())
        {
            if(rm1.getValue() == 2)
            {
                for(Map.Entry<String, Integer> rm2 : resultMap2.entrySet())
                {
                    if(rm1.getKey().equals(rm2.getKey()))
                    {
                        boolean needToClear = false;
                        boolean needToAdd = true;
                        if(resultMap3.size() > 0)
                        {
                            for(Map.Entry<String, Integer> rm3 : resultMap3.entrySet())
                            {
                                if(rm2.getValue() < rm3.getValue())
                                {
                                    needToClear = true;
                                    break;
                                }
                                if(rm2.getValue() > rm3.getValue())
                                    needToAdd = false;
                            }
                        }
                        if(needToClear)
                           resultMap3.clear();
                        if(needToAdd)
                            resultMap3.put(rm2.getKey(), rm2.getValue());
                    }
                }
            }
        }
        String[] result = resultMap3.keySet().toArray(new String[resultMap3.keySet().size()]);
        return result;
    }
}
