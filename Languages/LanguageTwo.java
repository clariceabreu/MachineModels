package clariceabreu.machinemodels.Language;

import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.TransitionFunction.*;

import java.util.List;
import java.util.ArrayList;

public class LanguageTwo implements LanguageStrategy {
    public static final String id = "2";
    public static final String description = "(a^n)(b^n)(c^n)";
    public static final String symbols = "{ a, b, c }";

    private State initialState;
    private State accpetanceState;
    private State rejectionState;
    private List<State> transitionStates;

    private List<TransitionFunction> functions;

    public LanguageTwo() {
        createStates();
        createTransitionFunctions();
    }

    private void createStates() {
        transitionStates = new ArrayList<>();

        initialState = new State(StateType.INITIAL);
        accpetanceState = new State(StateType.ACCEPTANCE);
        rejectionState = new State(StateType.REJECTION);

        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
        transitionStates.add(new State(StateType.TRANSITION));
    }

    private void createTransitionFunctions() {
        functions = new ArrayList<>();

        functions.add(new TransitionFunction(initialState, transitionStates.get(0), new Character('a'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, rejectionState, new Character('b'), new Character('b'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, rejectionState, new Character('c'), new Character('c'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, accpetanceState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(0), new Character('a'), new Character('a'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(1), new Character('x'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(2), new Character('b'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(1), transitionStates.get(1), new Character('x'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), transitionStates.get(2), new Character('b'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(2), transitionStates.get(2), new Character('b'), new Character('b'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(2), transitionStates.get(3), new Character('x'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(2), transitionStates.get(4), new Character('c'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(2), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(2), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(3), transitionStates.get(3), new Character('x'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(3), transitionStates.get(4), new Character('c'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(3), rejectionState, new Character('b'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(3), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(3), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(4), transitionStates.get(6), new Character('c'), new Character('c'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(4), transitionStates.get(5), null, null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(4), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(4), rejectionState, new Character('b'), null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(5), transitionStates.get(5), new Character('x'), new Character('x'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(5), accpetanceState, null, null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(5), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(5), rejectionState, new Character('b'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(5), rejectionState, new Character('c'), null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(6), transitionStates.get(6), new Character('x'), new Character('x'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(6), transitionStates.get(7), new Character('b'), new Character('b'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(6), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(6), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(6), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(7), transitionStates.get(7), new Character('b'), new Character('b'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(7), transitionStates.get(8), new Character('x'), new Character('x'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(7), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(7), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(7), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(8), transitionStates.get(8), new Character('x'), new Character('x'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(8), transitionStates.get(9), new Character('a'), new Character('a'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(8), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(8), rejectionState, new Character('b'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(8), rejectionState, null, null, Direction.RIGHT));

        functions.add(new TransitionFunction(transitionStates.get(9), transitionStates.get(9), new Character('a'), new Character('a'), Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(9), initialState, new Character('x'), new Character('x'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(9), rejectionState, new Character('b'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(9), rejectionState, new Character('c'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(9), rejectionState, null, null, Direction.RIGHT));
    }

    @Override
    public List<TransitionFunction> getTransitionFunctions() {
        if (functions == null) {
            createTransitionFunctions();
        }
        return this.functions;
    }

    @Override
    public State getInitialState() {
        return this.initialState;
    }
}