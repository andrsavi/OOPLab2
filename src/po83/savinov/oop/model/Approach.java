package po83.savinov.oop.model;

public class Approach {
    private  int duration; // продолжительность выполнения
    private  double weight; // вес снаряда
    private int numOfRepetitions; // число повторов

    public  Approach() // конструктор, инициализирующий поля числовыми значениями
    {
        this.weight = 0;
        this.duration = 2;
        this.numOfRepetitions = 12;
    }

    public  Approach(int duration, double weight, int numOfRepetitions) // конструктор, принимающий три параметра
    {
        this.duration = duration;
        this.weight = weight;
        this.numOfRepetitions = numOfRepetitions;
    }

    public double getWeight()
    {
        return  weight;
    }

    public void  setWeight(double weight)
    {
        this.weight = weight;
    }

    public  int getDuration()
    {
        return  duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getNumOfRepetitions()
    {
        return numOfRepetitions;
    }

    public  void setNumOfRepetitions(int numOfRepetitions)
    {
        this.numOfRepetitions = numOfRepetitions;
    }

}
