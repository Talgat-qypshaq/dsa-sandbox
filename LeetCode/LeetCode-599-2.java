class Solution
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        Map<String, EachString> lists = new HashMap<String, EachString>();
        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        int length = (list1.length > list2.length) ? list1.length : list2.length;
        for(int i = 0; i < length; i++)
        {
            if(i < list1.length)
            {
                if(lists.containsKey(list1[i]))
                    lists.put(list1[i], new EachString (true, lists.get( list1[i] ).getIndex() + i ) );
                else
                {
                    lists.put(list1[i], new EachString (false, i));
                }
            }
            if(i < list2.length)
            {
                if(lists.containsKey(list2[i]))
                    lists.put(list2[i], new EachString (true, lists.get(list2[i]).getIndex() + i ));
                else
                {
                    lists.put(list2[i], new EachString (false, i));
                }
            }
        }

        for(Map.Entry<String, EachString> list : lists.entrySet())
        {
            if(list.getValue().getCommon())
            {
                boolean needToClear = false;
                boolean needToAdd = true;
                if(resultMap.size() > 0)
                {
                    for(Map.Entry<String, Integer> rm : resultMap.entrySet())
                    {
                        if(list.getValue().getIndex() < rm.getValue())
                        {
                            needToClear = true;
                            break;
                        }
                        if(list.getValue().getIndex() > rm.getValue())
                            needToAdd = false;
                    }
                }
                if(needToClear)
                    resultMap.clear();
                if(needToAdd)
                    resultMap.put(list.getKey(), list.getValue().getIndex());
            }
        }
        return resultMap.keySet().toArray(new String[resultMap.keySet().size()]);
    }
}

public class EachString
{
    public boolean common;
    public int index;
    EachString(boolean common, int index)
    {
        this.common = common;
        this.index = index;
    }
    public boolean getCommon()
    {
        return common;
    }
    public int getIndex()
    {
        return index;
    }
}
