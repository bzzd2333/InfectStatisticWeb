package InfectStatisticWeb.dao;

import java.io.IOException;
import java.util.HashMap;

import InfectStatisticWeb.pojo.Province;

public interface ProvinceDAO 
{
    //初始化
    public HashMap<String,Province> init();
    //处理日志
    public HashMap<String,Province> deal(String date) throws IOException;
    //处理日志中的一行
    public void dealOneLine(HashMap<String,Province> map, String[] array);
    //统计全国数据
    public void allStatistic(HashMap<String,Province> map);
    //获取全国数据
    public Province getCountry();
}
