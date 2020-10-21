package br.com.clariceabreu.machinemodels.State;

public class State {
  private Integer id;
  private StateType type;

  public static int countStates = 0;

  public State (StateType type) {
    this.id = countStates;
    this.type = type;

    countStates++;
  }

  public Integer getId () {
    return this.id;
  }

  public StateType getType () {
    return this.type;
  }
}