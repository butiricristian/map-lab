import controllers.Controller;
import models.ADTs.*;
import models.PrgState;
import models.expressions.ArithmExpression;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import models.statements.AssignStatement;
import models.statements.CompoundStatement;
import models.statements.IStatement;
import models.statements.PrintStatement;
import repositories.IPrgRepository;
import repositories.PrgRepository;
import views.Menu;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class main {
    public static void main(String[] args){
        IPrgRepository prgRepo1 = new PrgRepository(new MyList<>(new ArrayList<>()), "file1.txt");
        Controller ctrl1 = new Controller(prgRepo1);

        IPrgRepository prgRepo2 = new PrgRepository(new MyList<>(new ArrayList<>()), "file2.txt");
        Controller ctrl2 = new Controller(prgRepo2);

        IPrgRepository prgRepo3 = new PrgRepository(new MyList<>(new ArrayList<>()), "file3.txt");
        Controller ctrl3 = new Controller(prgRepo3);

        Controller[] ctrls = {ctrl1, ctrl2, ctrl3};
        Menu m = new Menu(ctrls);
        m.show();
    }
}
