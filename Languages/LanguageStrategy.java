package clariceabreu.machinemodels.Language;

import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.TransitionFunction.*;

import java.util.List;

public interface LanguageStrategy {
    State getInitialState();
    List<TransitionFunction> getTransitionFunctions();
}