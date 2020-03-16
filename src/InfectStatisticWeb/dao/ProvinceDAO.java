package InfectStatisticWeb.dao;

import java.util.*;
import java.io.IOException;

import InfectStatisticWeb.pojo.Province;

public interface ProvinceDAO 
{
    //��ʼ��
    public HashMap<String,Province> init();
    //����ȫ��һ������
    public List<Province> dealOneDay(String date) throws IOException;
    //����ָ��ʡ�ݴ����鿪ʼ����ÿ������
    public HashMap<String, List<Province>> dealOneProvince(String date,String province) throws IOException;;
    //������־�е�һ��
    public void dealOneLine(HashMap<String,Province> map, String[] array);
    //ͳ��ȫ������
    public void allStatistic(HashMap<String,Province> map);
    //��ȡȫ������
    public Province getCountry();
    //HashMapת��ΪList
    public List<Province> mapToList(HashMap<String,Province> map);
}
