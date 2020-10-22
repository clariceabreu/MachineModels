package clariceabreu.machinemodels.CreateMachineModel;

import clariceabreu.machinemodels.TransitionFunction.*;
import clariceabreu.machinemodels.MachineImplementation.*;
import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.Language.*;

import java.util.List;
import java.util.ArrayList;
import java.lang.Character;

public class CreateTuringMachine {
    private static List<TransitionFunction> functions;
    private static State initialState;
    private static LanguageStrategy language;

    public static void main(String[] args) {
        String chosenLanguage = args[0];

        String input = new String();
        if (args.length > 1) {
            input = args[1];
        }

        switch (chosenLanguage) {
            case LanguageOne.id:
                language = new LanguageOne();
                break;
            case LanguageTwo.id:
                language = new LanguageTwo();
                break;
            case LanguageThree.id:
                language = new LanguageThree();
                break;
        }

        TuringMachine machine = new TuringMachine(language.getInitialState(), language.getTransitionFunctions());
        MachineResponse response = machine.isInputAcceptable(input);

        System.out.println(response.toString());
    }
}