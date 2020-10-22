package clariceabreu.machinemodels.TransitionFunction;

import clariceabreu.machinemodels.State.*;

import java.lang.Character;

public class TransitionFunction {
  private String id;
  private State currentState;
  private State nextState;
  private Character inputSymbol;
  private Character outputSymbol;
  private Direction direction;

  public TransitionFunction(State currentState, State nextState, Character inputSymbol, Character outputSymbol, Direction direction) {
    this.currentState = currentState;
    this.nextState = nextState;
    this.inputSymbol = inputSymbol;
    this.outputSymbol = outputSymbol;
    this.direction = direction;
    this.id = generateFunctionId(this.currentState, this.inputSymbol);
  }

  public Character getInputSymbol() {
    return this.inputSymbol;
  }

  public Character getOutputSymbol() {
    return this.outputSymbol;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public State getNextState() {
    return this.nextState;
  }

  public String getId() {
    return this.id;
  }

  public static String generateFunctionId(State state, Character symbol) {
    String id = state.getId().toString();
    if (symbol == null) {
      id += "null";
    } else {
      id += symbol.toString();
    }
    return id;
  }
}