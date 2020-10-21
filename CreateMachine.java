import java.util.List;
import java.util.ArrayList;
import java.lang.Character;

public class Main {
    private static final String language1 = "1"; //This language represents the language a*b*
    private static final String language2 = "2"; //This language represents the language (a^n)(b^n)(c^n)

    private static List<TransitionFunction> functions;
    private static State initialState;

    public static void main(String[] args) {
        String language = args[0];

        String input = new String();
        if (args.length > 1) {
            input = args[1];
        }

        switch (language) {
            case language1:
                createTransicionFunctionsForLanguage1();
                break;
            case language2:
                createTransicionFunctionsForLanguage2();
                break;
        }

        TuringMachine machine = new TuringMachine(initialState, functions);
        MachineResponse response = machine.isInputAcceptable(input);

        System.out.println(response.toString());
    }

    private static void createTransicionFunctionsForLanguage1 () {
        initialState = new State(StateType.INITIAL);
        State transictionState = new State(StateType.TRANSITION);
        State accpetanceState = new State(StateType.ACCEPTANCE);
        State rejectionState = new State(StateType.REJECTION);

        TransitionFunction function1 = new TransitionFunction(initialState, initialState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function2 = new TransitionFunction(initialState, accpetanceState, null, null, Direction.LEFT);
        TransitionFunction function3 = new TransitionFunction(initialState, transictionState, new Character('b'), null, Direction.RIGHT);

        TransitionFunction function4 = new TransitionFunction(transictionState, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function5 = new TransitionFunction(transictionState, accpetanceState, null, null, Direction.LEFT);
        TransitionFunction function6 = new TransitionFunction(transictionState, transictionState, new Character('b'), null, Direction.RIGHT);

        functions = new ArrayList<>();
        functions.add(function1);
        functions.add(function2);
        functions.add(function3);
        functions.add(function4);
        functions.add(function5);
        functions.add(function6);
    }

    private static void createTransicionFunctionsForLanguage2 () {
        initialState = new State(StateType.INITIAL);
        State transictionState1 = new State(StateType.TRANSITION);
        State transictionState2 = new State(StateType.TRANSITION);
        State transictionState3 = new State(StateType.TRANSITION);
        State transictionState4 = new State(StateType.TRANSITION);
        State transictionState5 = new State(StateType.TRANSITION);
        State transictionState6 = new State(StateType.TRANSITION);
        State transictionState7 = new State(StateType.TRANSITION);
        State transictionState8 = new State(StateType.TRANSITION);
        State transictionState9 = new State(StateType.TRANSITION);
        State transictionState10 = new State(StateType.TRANSITION);
        State accpetanceState = new State(StateType.ACCEPTANCE);
        State rejectionState = new State(StateType.REJECTION);

        TransitionFunction function1 = new TransitionFunction(initialState, transictionState1, new Character('a'), new Character('x'), Direction.RIGHT);
        TransitionFunction function2 = new TransitionFunction(initialState, rejectionState, new Character('b'), new Character('b'), Direction.RIGHT);
        TransitionFunction function3 = new TransitionFunction(initialState, rejectionState, new Character('c'), new Character('c'), Direction.RIGHT);
        TransitionFunction function4 = new TransitionFunction(initialState, accpetanceState, null, null, Direction.RIGHT);

        TransitionFunction function5 = new TransitionFunction(transictionState1, transictionState1, new Character('a'), new Character('a'), Direction.RIGHT);
        TransitionFunction function6 = new TransitionFunction(transictionState1, transictionState2, new Character('x'), new Character('x'), Direction.RIGHT);
        TransitionFunction function7 = new TransitionFunction(transictionState1, transictionState3, new Character('b'), new Character('x'), Direction.RIGHT);
        TransitionFunction function8 = new TransitionFunction(transictionState1, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function9 = new TransitionFunction(transictionState1, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function10 = new TransitionFunction(transictionState2, transictionState2, new Character('x'), new Character('x'), Direction.RIGHT);
        TransitionFunction function11 = new TransitionFunction(transictionState2, transictionState3, new Character('b'), new Character('x'), Direction.RIGHT);
        TransitionFunction function12 = new TransitionFunction(transictionState2, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function13 = new TransitionFunction(transictionState2, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function14 = new TransitionFunction(transictionState2, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function15 = new TransitionFunction(transictionState3, transictionState3, new Character('b'), new Character('b'), Direction.RIGHT);
        TransitionFunction function16 = new TransitionFunction(transictionState3, transictionState4, new Character('x'), new Character('x'), Direction.RIGHT);
        TransitionFunction function17 = new TransitionFunction(transictionState3, transictionState5, new Character('c'), new Character('x'), Direction.RIGHT);
        TransitionFunction function18 = new TransitionFunction(transictionState3, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function19 = new TransitionFunction(transictionState3, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function20 = new TransitionFunction(transictionState4, transictionState4, new Character('x'), new Character('x'), Direction.RIGHT);
        TransitionFunction function21 = new TransitionFunction(transictionState4, transictionState5, new Character('c'), new Character('x'), Direction.RIGHT);
        TransitionFunction function22 = new TransitionFunction(transictionState4, rejectionState, new Character('b'), null, Direction.RIGHT);
        TransitionFunction function23 = new TransitionFunction(transictionState4, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function24 = new TransitionFunction(transictionState4, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function25 = new TransitionFunction(transictionState5, transictionState7, new Character('c'), new Character('c'), Direction.LEFT);
        TransitionFunction function26 = new TransitionFunction(transictionState5, transictionState6, null, null, Direction.LEFT);
        TransitionFunction function27 = new TransitionFunction(transictionState5, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function28 = new TransitionFunction(transictionState5, rejectionState, new Character('b'), null, Direction.RIGHT);

        TransitionFunction function29 = new TransitionFunction(transictionState6, transictionState6, new Character('x'), new Character('x'), Direction.LEFT);
        TransitionFunction function30 = new TransitionFunction(transictionState6, accpetanceState, null, null, Direction.LEFT);
        TransitionFunction function31 = new TransitionFunction(transictionState6, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function32 = new TransitionFunction(transictionState6, rejectionState, new Character('b'), null, Direction.RIGHT);
        TransitionFunction function33 = new TransitionFunction(transictionState6, rejectionState, new Character('c'), null, Direction.RIGHT);

        TransitionFunction function34 = new TransitionFunction(transictionState7, transictionState7, new Character('x'), new Character('x'), Direction.LEFT);
        TransitionFunction function35 = new TransitionFunction(transictionState7, transictionState8, new Character('b'), new Character('b'), Direction.LEFT);
        TransitionFunction function36 = new TransitionFunction(transictionState7, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function37 = new TransitionFunction(transictionState7, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function38 = new TransitionFunction(transictionState7, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function39 = new TransitionFunction(transictionState8, transictionState8, new Character('b'), new Character('b'), Direction.LEFT);
        TransitionFunction function40 = new TransitionFunction(transictionState8, transictionState9, new Character('x'), new Character('x'), Direction.LEFT);
        TransitionFunction function41 = new TransitionFunction(transictionState8, rejectionState, new Character('a'), null, Direction.RIGHT);
        TransitionFunction function42 = new TransitionFunction(transictionState8, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function43 = new TransitionFunction(transictionState8, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function44 = new TransitionFunction(transictionState9, transictionState9, new Character('x'), new Character('x'), Direction.LEFT);
        TransitionFunction function45 = new TransitionFunction(transictionState9, transictionState10, new Character('a'), new Character('a'), Direction.LEFT);
        TransitionFunction function46 = new TransitionFunction(transictionState9, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function47 = new TransitionFunction(transictionState9, rejectionState, new Character('b'), null, Direction.RIGHT);
        TransitionFunction function48 = new TransitionFunction(transictionState9, rejectionState, null, null, Direction.RIGHT);

        TransitionFunction function49 = new TransitionFunction(transictionState10, transictionState10, new Character('a'), new Character('a'), Direction.LEFT);
        TransitionFunction function50 = new TransitionFunction(transictionState10, initialState, new Character('x'), new Character('x'), Direction.RIGHT);
        TransitionFunction function51 = new TransitionFunction(transictionState10, rejectionState, new Character('b'), null, Direction.RIGHT);
        TransitionFunction function52 = new TransitionFunction(transictionState10, rejectionState, new Character('c'), null, Direction.RIGHT);
        TransitionFunction function53 = new TransitionFunction(transictionState10, rejectionState, null, null, Direction.RIGHT);


        functions = new ArrayList<>();
        functions.add(function1);
        functions.add(function2);
        functions.add(function3);
        functions.add(function4);
        functions.add(function5);
        functions.add(function6);
        functions.add(function7);
        functions.add(function8);
        functions.add(function9);
        functions.add(function10);
        functions.add(function11);
        functions.add(function12);
        functions.add(function13);
        functions.add(function14);
        functions.add(function15);
        functions.add(function16);
        functions.add(function17);
        functions.add(function18);
        functions.add(function19);
        functions.add(function20);
        functions.add(function21);
        functions.add(function22);
        functions.add(function23);
        functions.add(function24);
        functions.add(function25);
        functions.add(function26);
        functions.add(function27);
        functions.add(function28);
        functions.add(function29);
        functions.add(function30);
        functions.add(function31);
        functions.add(function32);
        functions.add(function33);
        functions.add(function34);
        functions.add(function35);
        functions.add(function36);
        functions.add(function37);
        functions.add(function38);
        functions.add(function39);
        functions.add(function40);
        functions.add(function41);
        functions.add(function42);
        functions.add(function43);
        functions.add(function44);
        functions.add(function45);
        functions.add(function46);
        functions.add(function47);
        functions.add(function48);
        functions.add(function49);
        functions.add(function50);
        functions.add(function51);
        functions.add(function52);
        functions.add(function53);
    }

}