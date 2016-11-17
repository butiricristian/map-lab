package models.expressions;
import models.ADTs.MyIDictionary;

public abstract class Expression {
    public abstract Integer eval(MyIDictionary<String, Integer> symTable) throws Exception;

}
