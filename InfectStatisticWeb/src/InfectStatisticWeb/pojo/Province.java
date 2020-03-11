package InfectStatisticWeb.pojo;

public class Province 
{
    //省份名称
    private String name;
    //现有确诊
    private int infection;
    //累计确诊
    private int allInfection;
    //现有疑似
    private int suspected;    
    //累计治愈
    private int cure;
    //累计死亡
    private int dead;
    
    public Province(String n)
    {
        setName(n);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getInfection()
    {
        return infection;
    }

    public void setInfection(int infection)
    {
        this.infection = infection;
    }

    public int getAllInfection()
    {
        return allInfection;
    }

    public void setAllInfection(int allInfection)
    {
        this.allInfection = allInfection;
    }

    public int getSuspected()
    {
        return suspected;
    }

    public void setSuspected(int suspected)
    {
        this.suspected = suspected;
    }

    public int getCure()
    {
        return cure;
    }

    public void setCure(int cure)
    {
        this.cure = cure;
    }

    public int getDead()
    {
        return dead;
    }

    public void setDead(int dead)
    {
        this.dead = dead;
    }
    
    //疑似患者增加
    public void addSp(String str)
    {
        str = str.substring(0, str.length()-1);
        suspected += Integer.parseInt(str);
    }
    //现有确诊患者增加
    public void addIp(String str)
    {
        str = str.substring(0, str.length()-1);
        infection += Integer.parseInt(str);
    }   
    //疑似患者减少
    public void removeSp(String str)
    {
        str = str.substring(0, str.length()-1);
        suspected -= Integer.parseInt(str);
    }
    //确诊患者减少
    public void removeIp(String str)
    {
        str = str.substring(0, str.length()-1);
        infection -= Integer.parseInt(str);
    }
    //治愈患者增加
    public void cure(String str)
    {
        str = str.substring(0, str.length()-1);
        cure += Integer.parseInt(str);
        infection -= Integer.parseInt(str);
    }   
    //死亡患者增加
    public void dead(String str)
    {
        str = str.substring(0, str.length()-1);
        dead += Integer.parseInt(str);
        infection -= Integer.parseInt(str);
    }  
    //累计确诊增加
    public void addAllIp(String str)
    {
        str = str.substring(0, str.length()-1);
        allInfection += Integer.parseInt(str);
    }
    
    //输出本省情况
    public void output()
    {
            System.out.println(name + " 累计确诊" + allInfection + "人 "
                + "现有确诊 " + infection + "人 "
                + "疑似患者 " + suspected + "人 "
                + "治愈 " + cure + "人 "
                + "死亡 " + dead + "人");            
    }
}
