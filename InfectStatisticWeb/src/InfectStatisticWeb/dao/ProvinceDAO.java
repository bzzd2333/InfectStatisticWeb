package InfectStatisticWeb.dao;

import java.io.IOException;
import java.util.HashMap;

import InfectStatisticWeb.pojo.Province;

public interface ProvinceDAO 
{
    
    public HashMap<String,Province> init();
   
    public HashMap<String,Province> deal(String date) throws IOException;
 
    public void dealOneLine(HashMap<String,Province> map, String[] array);
    
    //public void allStatistic();
}
