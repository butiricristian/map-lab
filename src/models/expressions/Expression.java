package models.expressions;
import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;

public abstract class Expression {
    public abstract Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception;

}
