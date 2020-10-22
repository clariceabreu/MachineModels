package clariceabreu.machinemodels.Language;

import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.TransitionFunction.*;

import java.util.List;
import java.util.ArrayList;

public class LanguageOne implements LanguageStrategy {
    public static final String id = "1";
    public static final String description = "a*b*";
    public static final String symbols = "{ a, b }";

    private State initialState;
    private State accpetanceState;
    private State rejectionState;
    private List<State> transitionStates;

    private List<TransitionFunction> functions;

    public LanguageOne() {
        createStates();
        createTransitionFunctions();
    }

    private void createStates() {
        transitionStates = new ArrayList<>();

        initialState = new State(StateType.INITIAL);
        accpetanceState = new State(StateType.ACCEPTANCE);
        rejectionState = new State(StateType.REJECTION);

        transitionStates.add(new State(StateType.TRANSITION));
    }

    private void createTransitionFunctions() {
        functions = new ArrayList<>();

        functions.add(new TransitionFunction(initialState, initialState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, accpetanceState, null, null, Direction.LEFT));
        functions.add(new TransitionFunction(initialState, transitionStates.get(0), new Character('b'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, new Character('a'), null, Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), accpetanceState, null, null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(0), new Character('b'), null, Direction.RIGHT));
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