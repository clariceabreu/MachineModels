package clariceabreu.machinemodels.MachineImplementation;

public enum MachineResponse {
  ACCEPTED("This is string belongs to the chosen language"),
  REJECTED("This is string dosn't belong to the chosen language"),
  ERROR("The machine can't read this string");

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