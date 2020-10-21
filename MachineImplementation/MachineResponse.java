package br.com.clariceabreu.machinemodels.MachineImplementation;

public enum MachineResponse {
  ACCEPTED("This is string is accepted by the chosen language"),
  REJECTED("This is string is rejected by the chosen language"),
  ERROR("The machine can't read this input");

  private String value;

  private MachineResponse(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.getValue();
  }
}