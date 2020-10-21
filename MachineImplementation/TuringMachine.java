package br.com.clariceabreu.machinemodels.MachineImplementation;

import br.com.clariceabreu.machinemodels.TransitionFunction.*;
import br.com.clariceabreu.machinemodels.State.*;
import br.com.clariceabreu.machinemodels.Tape.*;

import java.util.HashMap;
import java.util.List;
import java.lang.Character;

public class TuringMachine {
  private TapeNode tapePostion;
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

    createTape(input);

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

  private void createTape(String input) {
    TapeNode node = new TapeNode();
    if (input.length() == 0) {
      this.tapePostion = node;
      return;
    }

    TapeNode firstNode = node;

    for (Character c : input.toCharArray()) {
      node.setRightNode(new TapeNode(c));
      TapeNode lastNode = node;
      node = node.right();
      node.setLeftNode(lastNode);
    }

    this.tapePostion = firstNode.right();
  }

  private boolean isCurrentStateAStopState() {
    return this.currentState == null || this.currentState.getType().equals(StateType.ACCEPTANCE) || this.currentState.getType().equals(StateType.REJECTION);
  }

  private State getNewState() {
    String id = TransitionFunction.generateFunctionId(this.currentState, this.tapePostion.getValue());

    if (functionsMap.containsKey(id)) {
      TransitionFunction function = functionsMap.get(id);
      this.tapePostion.setValue(function.getOutputSymbol());
      moveTapePostion(function.getDirection());
      return function.getNextState();
    }

    return null;
  }

  private void moveTapePostion(Direction direction) {
    if (direction.equals(Direction.LEFT)) {
      if (this.tapePostion.left() == null) {
        TapeNode newNode = new TapeNode();
        newNode.setRightNode(this.tapePostion);
        this.tapePostion.setLeftNode(newNode);
      }
      this.tapePostion = tapePostion.left();
    } else if (direction.equals(Direction.RIGHT)) {
      if (this.tapePostion.right() == null) {
        TapeNode newNode = new TapeNode();
        newNode.setLeftNode(this.tapePostion);
        this.tapePostion.setRightNode(newNode);
      }
      this.tapePostion = tapePostion.right();
    }
  }

}