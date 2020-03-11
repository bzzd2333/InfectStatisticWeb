package InfectStatisticWeb.pojo;

public class Province 
{
    //ʡ������
    private String name;
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
    
    //�����ʡ���
    public void output()
    {
            System.out.println(name + " �ۼ�ȷ��" + allInfection + "�� "
                + "����ȷ�� " + infection + "�� "
                + "���ƻ��� " + suspected + "�� "
                + "���� " + cure + "�� "
                + "���� " + dead + "��");            
    }
}
