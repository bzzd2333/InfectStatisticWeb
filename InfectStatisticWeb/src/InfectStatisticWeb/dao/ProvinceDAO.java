package InfectStatisticWeb.dao;

import java.util.*;
import java.io.IOException;

import InfectStatisticWeb.pojo.Province;

public interface ProvinceDAO 
{
    //初始化
    public HashMap<String,Province> init();
    //处理全国一天的情况
    public List<Province> dealOneDay(String date) throws IOException;
    //处理指定省份从疫情开始以来每天的情况
    public HashMap<String, List<Province>> dealOneProvince(String date,String province) throws IOException;;
    //处理日志中的一行
    public void dealOneLine(HashMap<String,Province> map, String[] array);
    //统计全国数据
    public void allStatistic(HashMap<String,Province> map);
    //获取全国数据
    public Province getCountry();
    //HashMap转换为List
    public List<Province> mapToList(HashMap<String,Province> map);
}
