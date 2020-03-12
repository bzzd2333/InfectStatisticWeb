package InfectStatisticWeb.pojo;

public class Province 
{
    //ʡ������
    private String name;
    //ʡ������
    private String date;
    //����ȷ��
    private int infection;
    //�ۼ�ȷ��
    private int allInfection;
    //��������
    private int suspected;    
    //�ۼ�����
    private int cure;
    //�ۼ�����
    private int dead;
    
    public Province(String n)
    {
        setName(n);
    }
    
    public Province(Province source)
    {
        this.name = source.name;
        this.date = source.date;
        this.infection = source.infection;
        this.allInfection = source.allInfection;
        this.suspected = source.suspected;
        this.cure = source.cure;
        this.dead = source.dead;
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
    
    //���ƻ�������
    public void addSp(String str)
    {
        str = str.substring(0, str.length()-1);
        suspected += Integer.parseInt(str);
    }
    //����ȷ�ﻼ������
    public void addIp(String str)
    {
        str = str.substring(0, str.length()-1);
        infection += Integer.parseInt(str);
    }   
    //���ƻ��߼���
    public void removeSp(String str)
    {
        str = str.substring(0, str.length()-1);
        suspected -= Integer.parseInt(str);
    }
    //ȷ�ﻼ�߼���
    public void removeIp(String str)
    {
        str = str.substring(0, str.length()-1);
        infection -= Integer.parseInt(str);
    }
    //������������
    public void cure(String str)
    {
        str = str.substring(0, str.length()-1);
        cure += Integer.parseInt(str);
        infection -= Integer.parseInt(str);
    }   
    //������������
    public void dead(String str)
    {
        str = str.substring(0, str.length()-1);
        dead += Integer.parseInt(str);
        infection -= Integer.parseInt(str);
    }  
    //�ۼ�ȷ������
    public void addAllIp(String str)
    {
        str = str.substring(0, str.length()-1);
        allInfection += Integer.parseInt(str);
    }
    //ͳ��ȫ�������
    public void allAdd(Province p)
    {
        this.infection += p.infection;
        this.allInfection += p.allInfection;
        this.suspected += p.suspected;
        this.cure += p.cure;
        this.dead += p.dead;
    }
    
    public int[] getData()
    {
        int[] data = new int[]{infection,suspected,allInfection,cure,dead};
        return data;
    }
    
    //�����ʡ���
    public void output()
    {
            System.out.println(name + " �ۼ�ȷ��" + allInfection + "�� "
                + "����ȷ�� " + infection + "�� "
                + "���ƻ��� " + suspected + "�� "
                + "���� " + cure + "�� "
                + "���� " + dead + "��");            
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
