class Solution
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        Map<String, Integer> lists = new HashMap<String, Integer>();
        Map<String, Integer> listsCommon = new HashMap<String, Integer>();
        int listMinimum = 2001;

        int length = (list1.length > list2.length) ? list1.length : list2.length;
        for(int i = 0; i < length; i++)
        {
            if(i < list1.length)
            {
                if(lists.containsKey(list1[i]))
                {
                    if(listMinimum >= lists.get(list1[i]) + i)
                    {
                        if(listMinimum > lists.get(list1[i]) + i)
                        {
                            listMinimum = lists.get(list1[i]) + i;
                            listsCommon.clear();
                        }
                        listsCommon.put(list1[i], listMinimum);
                    }
                }
                else
                {
                    lists.put(list1[i],i);
                }
            }
            if(i < list2.length)
            {
                if(lists.containsKey(list2[i]))
                {
                    if(listMinimum >= lists.get(list2[i]) + i)
                    {
                        if(listMinimum > lists.get(list2[i]) + i)
                        {
                            listMinimum = lists.get(list2[i]) + i;
                            listsCommon.clear();
                        }
                        listsCommon.put(list2[i], listMinimum);
                        }
                }
                else
                {
                    lists.put(list2[i],i);
                }
            }
        }
        return listsCommon.keySet().toArray(new String[listsCommon.keySet().size()]);
    }
}
