package clariceabreu.machinemodels.MachineImplementation;

import clariceabreu.machinemodels.TransitionFunction.*;
import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.Tape.*;

import java.util.HashMap;
import java.util.List;
import java.lang.Character;

public class TuringMachine {
  private Tape tape;
  private List<TransitionFunction> functions;
  private HashMap<String, TransitionFunction> functionsMap;
  private State currentState;

  public TuringMachine(State initialState, List<TransitionFunction> functions) {
    if (initialState.getType().equals(StateType.INITIAL)) {
      currentState = initialState;
    }

    mapFunctions(functions);
  }

  public MachineResponse isInputAcceptable(String input) {
    if (this.currentState == null) {
      return MachineResponse.ERROR;
    }

    tape = new Tape(input);

    while (!isCurrentStateAStopState()) {
      this.currentState = getNewState();
    }

    if (this.currentState == null) {
      return MachineResponse.ERROR;
    }

    StateType type = this.currentState.getType();
    if (type.equals(StateType.ACCEPTANCE)) {
      return MachineResponse.ACCEPTED;
    } else if (type.equals(StateType.REJECTION)) {
      return MachineResponse.REJECTED;
    }

    return MachineResponse.ERROR;
  }

  private void mapFunctions (List<TransitionFunction> functions) {
    functionsMap = new HashMap<>();
    for (TransitionFunction f : functions) {
      this.functionsMap.put(f.getId(), f);
    }
  }

  private boolean isCurrentStateAStopState() {
    return this.currentState == null || this.currentState.getType().equals(StateType.ACCEPTANCE) || this.currentState.getType().equals(StateType.REJECTION);
  }

  private State getNewState() {
    String id = TransitionFunction.generateFunctionId(this.currentState, this.tape.getValue());

    if (functionsMap.containsKey(id)) {
      TransitionFunction function = functionsMap.get(id);
      this.tape.setValue(function.getOutputSymbol());
      this.tape.slide(function.getDirection());
      return function.getNextState();
    }

    return null;
  }
}