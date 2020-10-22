package clariceabreu.machinemodels.Language;

import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.TransitionFunction.*;

import java.util.List;
import java.util.ArrayList;

public class LanguageThree implements LanguageStrategy {
    public static final String id = "3";
    public static final String description = "propositional formulas";
    public static final String symbols = "{ p, q, ¬, , V, ∧ }";

    private State initialState;
    private State accpetanceState;
    private State rejectionState;
    private List<State> transitionStates;

    private List<TransitionFunction> functions;

    public LanguageThree() {
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
    }

    private void createTransitionFunctions() {
        functions = new ArrayList<>();

        functions.add(new TransitionFunction(initialState, initialState, new Character(' '), new Character(' '), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, transitionStates.get(0), new Character('¬'), new Character('¬'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, transitionStates.get(1), new Character('p'), new Character('p'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, transitionStates.get(1), new Character('q'), new Character('q'), Direction.RIGHT));
        functions.add(new TransitionFunction(initialState, rejectionState, new Character('V'), null, Direction.LEFT));
        functions.add(new TransitionFunction(initialState, rejectionState, new Character('∧'), null, Direction.LEFT));
        functions.add(new TransitionFunction(initialState, rejectionState, null, null, Direction.LEFT));

        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(0), new Character(' '), new Character(' '), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(1), new Character('p'), new Character('p'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), transitionStates.get(1), new Character('q'), new Character('q'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, new Character('¬'), null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, new Character('V'), null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, new Character('∧'), null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(0), rejectionState, null, null, Direction.LEFT));

        functions.add(new TransitionFunction(transitionStates.get(1), transitionStates.get(1), new Character(' '), new Character(' '), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), initialState, new Character('V'), new Character('V'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), initialState, new Character('∧'), new Character('∧'), Direction.RIGHT));
        functions.add(new TransitionFunction(transitionStates.get(1), accpetanceState, null, null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, new Character('p'), null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, new Character('q'), null, Direction.LEFT));
        functions.add(new TransitionFunction(transitionStates.get(1), rejectionState, new Character('¬'), null, Direction.LEFT));
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