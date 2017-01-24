import controllers.Controller;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.ADTs.*;
import models.PrgState;
import models.expressions.*;
import models.statements.*;
import repositories.IPrgRepository;
import repositories.PrgRepository;

import java.io.BufferedReader;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIInterpreter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        IStatement[] prg = new IStatement[10];

        //PROGRAM 1
        IPrgRepository prgRepo1 = new PrgRepository(new MyList<>(new ArrayList<>()), "file1.txt");
        Controller ctrl1 = new Controller(prgRepo1);
        prg[1] = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
        PrgState prgState1 = null;
        try {
            prgState1 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg[1]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl1.clearRepo();
        ctrl1.addToRepo(prgState1);



        //PROGRAM 2
        IPrgRepository prgRepo2 = new PrgRepository(new MyList<>(new ArrayList<>()), "file2.txt");
        Controller ctrl2 = new Controller(prgRepo2);
        prg[2] = new CompoundStatement(
                new CompoundStatement(
                        new AssignStatement("a",
                                new ArithmExpression("+",
                                        new ConstExpression(2),
                                        new ArithmExpression("*",
                                                new ConstExpression(3),
                                                new ConstExpression(5)))),
                        new AssignStatement("b",
                                new ArithmExpression("+",
                                        new VarExpression("a"),
                                        new ConstExpression(1)))),
                new PrintStatement(new VarExpression("b")));
        PrgState prgState2 = null;
        try {
            prgState2 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg[2]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl2.clearRepo();
        ctrl2.addToRepo(prgState2);




        //PROGRAM 3
        IPrgRepository prgRepo3 = new PrgRepository(new MyList<>(new ArrayList<>()), "file3.txt");
        Controller ctrl3 = new Controller(prgRepo3);
        prg[3]= new CompoundStatement(
                new OpenRFile("var_f", "test.in"),
                new CompoundStatement(
                        new ReadFile(new VarExpression("var_f"), "var_c"),
                        new CompoundStatement(
                            new PrintStatement(new VarExpression("var_c")),
                            new CompoundStatement(
                                    new IfStatement(new VarExpression("var_c"),
                                            new CompoundStatement(
                                                    new ReadFile(new VarExpression("var_f"), "var_c"),
                                                    new PrintStatement(new VarExpression("var_c"))
                                            ),
                                            new PrintStatement(new ConstExpression(0))
                                    ),
                                    new CloseRFile(new VarExpression("var_f"))
                            )
                        )
                )
        );
        PrgState prgState3 = null;
        try {
            prgState3 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl3.clearRepo();
        ctrl3.addToRepo(prgState3);




        //PROGRAM 4
        IPrgRepository prgRepo4 = new PrgRepository(new MyList<>(new ArrayList<>()), "file4.txt");
        Controller ctrl4 = new Controller(prgRepo4);
        prg[4] = new CompoundStatement(
                new OpenRFile("var_f", "test.in"),
                new CompoundStatement(
                        new ReadFile(new ArithmExpression("+", new VarExpression("var_f"), new ConstExpression(2)), "var_c"),
                        new CompoundStatement(
                                new PrintStatement(new VarExpression("var_c")),
                                new CompoundStatement(
                                        new IfStatement(new VarExpression("var_c"),
                                                new CompoundStatement(
                                                        new ReadFile(new VarExpression("var_f"), "var_c"),
                                                        new PrintStatement(new VarExpression("var_c"))
                                                ),
                                                new PrintStatement(new ConstExpression(0))
                                        ),
                                        new CloseRFile(new VarExpression("var_f"))
                                )
                        )
                )
        );
        PrgState prgState4 = null;
        try {
            prgState4 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl4.clearRepo();
        ctrl4.addToRepo(prgState4);




        //PROGRAM 5
        IPrgRepository prgRepo5 = new PrgRepository(new MyList<>(new ArrayList<>()), "file5.txt");
        Controller ctrl5 = new Controller(prgRepo5);
        prg[5] = new CompoundStatement(
                new CompoundStatement(
                new AssignStatement("v", new ConstExpression(10)),
                new CompoundStatement(
                        new HeapNew("v", new ConstExpression(20)),
                        new CompoundStatement(
                                new HeapNew("a", new ConstExpression(22)),
                                new CompoundStatement(
                                        new WriteHeap("a", new ConstExpression(30)),
                                        new CompoundStatement(
                                             new PrintStatement(new VarExpression("a")),
                                             new CompoundStatement(
                                                     new PrintStatement(new ReadHeap("a")),
                                                     new AssignStatement("a", new ConstExpression(0))
                                             )
                                        )
                                )
                        )
                )
            ),
                new CompoundStatement(
                        new AssignStatement("v", new ConstExpression(0)),
                        new CompoundStatement(
                                new WhileStatement(new BooleanExpression("<", new VarExpression("v"), new ConstExpression(5)),
                                        new AssignStatement("v",
                                                new ArithmExpression("+", new VarExpression("v"), new ConstExpression(1))
                                        )
                                ),
                                new PrintStatement(new VarExpression("v"))
                        )
                )
        );
        PrgState prgState5 = null;
        try {
            prgState5 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg[5]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl5.clearRepo();
        ctrl5.addToRepo(prgState5);


        //PROGRAM 6
        IPrgRepository prgRepo6 = new PrgRepository(new MyList<>(new ArrayList<>()), "file6.txt");
        Controller ctrl6 = new Controller(prgRepo6);
        prg[6] = new CompoundStatement(
                new AssignStatement("v", new ConstExpression(0)),
                new CompoundStatement(
                    new WhileStatement(new BooleanExpression("<", new VarExpression("v"), new ConstExpression(5)),
                            new AssignStatement("v",
                                new ArithmExpression("+", new VarExpression("v"), new ConstExpression(1))
                            )
                    ),
                    new PrintStatement(new VarExpression("v"))
                )
        );
        PrgState prgState6 = null;
        try {
            prgState6 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg[6]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl6.clearRepo();
        ctrl6.addToRepo(prgState6);



        //Program 7
        IPrgRepository prgRepo7 = new PrgRepository(new MyList<>(new ArrayList<>()), "file7.txt");
        Controller ctrl7 = new Controller(prgRepo7);
        prg[7] = new CompoundStatement(
                new AssignStatement("v", new ConstExpression(10)),
                new CompoundStatement(
                        new HeapNew("a", new ConstExpression(22)),
                        new CompoundStatement(
                                new ForkStatement(new CompoundStatement(
                                        new WriteHeap("a", new ConstExpression(30)),
                                        new CompoundStatement(
                                                new AssignStatement("v", new ConstExpression(32)),
                                                new CompoundStatement(
                                                        new PrintStatement(new VarExpression("v")),
                                                        new PrintStatement(new ReadHeap("a"))
                                                )
                                        )
                                )),
                                new CompoundStatement(
                                        new PrintStatement(new VarExpression("v")),
                                        new PrintStatement(new ReadHeap("a"))
                                )
                        ))
                );
        PrgState prgState7 = null;
        try {
            prgState7 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg[7]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl7.clearRepo();
        ctrl7.addToRepo(prgState7);




        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 500, 500);
        stage.setTitle("Toy Language Interpreter");
        stage.setScene(scene);
        stage.show();

        ListView lvPrograms = new ListView(FXCollections.observableArrayList());
        lvPrograms.getItems().addAll(prg[1].toString(), prg[2].toString(), prg[3].toString(),
                prg[4].toString(), prg[5].toString(), prg[6].toString(), prg[7].toString());
        bp.setCenter(lvPrograms);

//        lvPrograms.getSelectionModel().selectedItemProperty().addListener(
//                new ChangeListener() {
//                    @Override
//                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                        int i = lvPrograms.getSelectionModel().getSelectedIndex();
//                        openNextWindow(prg[i+1], stage);
//                        stage.hide();
//                    }
//                }
//        );

        Button choose = new Button("Choose");
        choose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int i = lvPrograms.getSelectionModel().getSelectedIndex();
                if(i>=0 && i<=6) {
                    openNextWindow(prg[i + 1], stage);
                    stage.hide();
                }
            }
        });

        bp.setBottom(choose);
    }

    public void openNextWindow(IStatement prg, Stage prevStage){
        IPrgRepository prgRepo = new PrgRepository(new MyList<>(new ArrayList<>()), "file1.txt");
        Controller ctrl = new Controller(prgRepo);
        PrgState prgState = null;
        try {
            prgState = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl.clearRepo();
        ctrl.addToRepo(prgState);





        GridPane root = new GridPane();
        root.setHgap(10);
        Scene scene = new Scene(root, 1000 , 500);
        Stage stage = new Stage();
        stage.setTitle("Toy Language Interpreter");
        stage.setScene(scene);
        stage.show();

        TextField tf = new TextField("Number of Program States: 1");
        tf.setDisable(true);
        tf.setMinWidth(180);
        root.add(tf, 0, 0);

        VBox boxHeap = new VBox();

        TableView tvHeap = new TableView();
        TableColumn<Map.Entry<Integer, Integer>, String> tcAddress = new TableColumn<>("Address");
        TableColumn<Map.Entry<Integer, Integer>, String> tcValue = new TableColumn<>("Value");

        tcAddress.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String> p){
                return new SimpleStringProperty(p.getValue().getKey().toString());
            }
        });
        tcValue.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String> p){
                return new SimpleStringProperty(p.getValue().getValue().toString());
            }
        });

        tvHeap.getColumns().addAll(tcAddress, tcValue);

        ObservableList<Map.Entry<Integer, Integer>> heap = FXCollections.observableArrayList(prgState.getHeap().getContent().entrySet());
        tvHeap.setItems(heap);
        Label lHeap = new Label("Heap");
        boxHeap.getChildren().addAll(lHeap, tvHeap);

        root.add(boxHeap, 0, 1);



        VBox boxOut = new VBox();

        ListView<Integer> lvOut = new ListView<>();
        ObservableList<Integer> out = FXCollections.observableArrayList(prgState.getOut().getContent());
        lvOut.setItems(out);

        Label lOut = new Label("Out");
        boxOut.getChildren().addAll(lOut, lvOut);
        root.add(boxOut, 1, 1);


        VBox boxFileTable = new VBox();

        TableView tvFileTable = new TableView();
        TableColumn<Map.Entry<Integer, MyITuple>, String> tcFileId = new TableColumn<>("Identifier");
        TableColumn<Map.Entry<Integer, MyITuple>, String> tcFileName = new TableColumn<>("File Name");

        tcFileId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, MyITuple>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, MyITuple>, String> p){
                return new SimpleStringProperty(p.getValue().getKey().toString());
            }
        });
        tcFileName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, MyITuple>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, MyITuple>, String> p){
                return new SimpleStringProperty(p.getValue().getValue().getFirst().toString());
            }
        });

        tvFileTable.getColumns().addAll(tcFileId, tcFileName);

        ObservableList<Map.Entry<Integer, MyITuple<String, BufferedReader>>> fileTable = FXCollections.observableArrayList(prgState.getFileTable().getContent().entrySet());
        tvFileTable.setItems(fileTable);
        Label lFileTable = new Label("File Table");
        boxFileTable.getChildren().addAll(lFileTable, tvFileTable);

        root.add(boxFileTable, 2, 1);





        VBox boxPrgStates = new VBox();

        ListView<Integer> lvPrgStates = new ListView<>();
        ObservableList<Integer> prgStates = FXCollections.observableArrayList(prgState.getId());
        lvPrgStates.setItems(prgStates);

        Label lPrgStates = new Label("Prg States");
        boxPrgStates.getChildren().addAll(lPrgStates, lvPrgStates);
        root.add(boxPrgStates, 3, 1);







        VBox boxSymTable = new VBox();

        TableView tvSymTable = new TableView();
        TableColumn<Map.Entry<String, Integer>, String> tcSymbol = new TableColumn<>("Variable Name");
        TableColumn<Map.Entry<String, Integer>, String> tcSymValue = new TableColumn<>("Value");

        tcSymbol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String> p){
                return new SimpleStringProperty(p.getValue().getKey().toString());
            }
        });
        tcSymValue.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String> p){
                return new SimpleStringProperty(p.getValue().getValue().toString());
            }
        });

        tvSymTable.getColumns().addAll(tcSymbol, tcSymValue);

        ObservableList<Map.Entry<String, Integer>> symTable = FXCollections.observableArrayList(prgState.getSymTable().getContent().entrySet());
        tvSymTable.setItems(symTable);
        Label lSymTable = new Label("Symbol Table");
        boxSymTable.getChildren().addAll(lSymTable, tvSymTable);

        root.add(boxSymTable, 4, 1);




        VBox boxExeStack = new VBox();

        ListView<IStatement> lvExeStack = new ListView<>();
        lvExeStack.setCellFactory(new Callback<ListView<IStatement>, ListCell<IStatement>>() {
            @Override
            public ListCell<IStatement> call(ListView<IStatement> param) {
                ListCell<IStatement> listCell = new ListCell<IStatement>(){
                    @Override
                    protected void updateItem(IStatement s, boolean empty){
                        super.updateItem(s, empty);
                        if(s!=null){
                            setText(s.toString());
                        }
                        else{
                            setText("");
                        }
                    }
                };
                return listCell;
            }
        });
        ObservableList<IStatement> exeStack = FXCollections.observableArrayList(prgState.getExeStack().getContent());
        lvExeStack.setItems(exeStack);

        Label lExeStack = new Label("Exe Stack");
        boxExeStack.getChildren().addAll(lExeStack, lvExeStack);
        root.add(boxExeStack, 5, 1);



        HBox buttons = new HBox();
        Button backBtn = new Button("Back");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                prevStage.show();
            }
        });

        Button btnOneStep = new Button("One Step");
        btnOneStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ctrl.allStepGUI();
                    ArrayList<PrgState> prgs = ctrl.getPrgStates().getContent();
                    ArrayList<Integer> prgIds = new ArrayList<>();
                    for(PrgState p : prgs) {
                        if (!p.getExeStack().isEmpty()) {
                            prgIds.add(p.getId());
                        }
                    }
                    prgStates.setAll(prgIds);
                    heap.setAll(prgs.get(0).getHeap().getContent().entrySet());
                    out.setAll(prgs.get(0).getOut().getContent());
                    fileTable.setAll(prgs.get(0).getFileTable().getContent().entrySet());
                    symTable.setAll(prgs.get(0).getSymTable().getContent().entrySet());
                    exeStack.setAll(prgs.get(0).getExeStack().getContent());
                    tf.setText("Number of program states: " + Integer.toString(prgIds.size()));
                    lvPrgStates.getSelectionModel().select(0);
                    if(prgIds.size() == 0){
                        Alert done = new Alert(Alert.AlertType.INFORMATION);
                        done.setTitle("Info");
                        done.setContentText("The program has finished");
                        done.showAndWait();
                    }
                }
                catch(Exception e) {
                    ArrayList<Integer> prgIds = new ArrayList<>();
                    prgStates.setAll(prgIds);
                    Alert done = new Alert(Alert.AlertType.INFORMATION);
                    done.setTitle("Info");
                    done.setContentText("The program has finished");
                    done.showAndWait();
                }
            }
        });

        buttons.getChildren().addAll(backBtn, btnOneStep);
        root.add(buttons, 0, 2);

        lvPrgStates.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                        ArrayList<PrgState> prgs = ctrl.getPrgStates().getContent();
                        Integer x = lvPrgStates.getSelectionModel().getSelectedIndex();
                        if(x>=0) {
                            symTable.setAll(prgs.get(x).getSymTable().getContent().entrySet());
                            tvSymTable.refresh();
                            exeStack.setAll(prgs.get(x).getExeStack().getContent());
                        }
                    }
                }
        );

    }

    public static void main(String[] args){
        launch(args);
    }
}
