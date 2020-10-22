package clariceabreu.machinemodels.CreateMachineModel;

import clariceabreu.machinemodels.TransitionFunction.*;
import clariceabreu.machinemodels.MachineImplementation.*;
import clariceabreu.machinemodels.State.*;
import clariceabreu.machinemodels.Language.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Character;

public class CreateTuringMachine {
    private static String chosenLanguage;
    private static String input;
    private static boolean continueLoop;

    public static void main(String[] args) {
        printWellcome();
        printAvailableMachines();

        do {
            scanInputs();

            LanguageStrategy language;
            switch (chosenLanguage) {
                case LanguageTwo.id:
                    language = new LanguageTwo();
                    break;
                case LanguageThree.id:
                    language = new LanguageThree();
                    break;
                default:
                    language = new LanguageOne();
            }

            TuringMachine machine = new TuringMachine(language.getInitialState(), language.getTransitionFunctions());
            MachineResponse response = machine.isInputAcceptable(input);

            printResult(response);
            scanShouldContinue();
        } while (continueLoop);
    }

    private static void printWellcome() {
        System.out.println("=================================");
        System.out.println("");
        System.out.println("Welcome to MACHINE MODELS program");
        System.out.println("In this program, you will be able to choose a machine model and language that it supports.");
        System.out.println("Then, you can insert a string and validates if this string belongs to the chosen language");
        System.out.println("");
        System.out.println("=================================");
        System.out.println("");
    }

    private static void printAvailableMachines() {
        System.out.println("Currently we only support Turing Machine, but new ones are coming soon!");
        System.out.println("");
    }

    private static void printAvailableLanguages() {
        System.out.println("Available languagues:");
        System.out.println(LanguageOne.id + " - " + LanguageOne.description + " - alphabet ∑ = " + LanguageOne.symbols);
        System.out.println("");
        System.out.println(LanguageTwo.id + " - " + LanguageTwo.description + " - alphabet ∑ = " + LanguageTwo.symbols);
        System.out.println("");
        System.out.println(LanguageThree.id + " - " + LanguageThree.description + " - alphabet ∑ = " + LanguageThree.symbols);
        System.out.println("");
    }

    private static void scanInputs() {
        Scanner scan = new Scanner(System.in);
        while (!isInputtedLanguageValid()){
            printAvailableLanguages();
            System.out.println("Type the language id you want to validade and press enter:");
            chosenLanguage = scan.nextLine();
        }
        System.out.println("Type the string you want to validate if it belongs to the chosen language and press enter:");
        input = scan.nextLine();
        System.out.println("");
    }

    private static boolean isInputtedLanguageValid() {
        return chosenLanguage != null
            && (chosenLanguage.equals(LanguageOne.id) || chosenLanguage.equals(LanguageTwo.id) || chosenLanguage.equals(LanguageThree.id));
    }

    private static void printResult(MachineResponse response) {
        System.out.println("=================================");
        System.out.println("");
        System.out.println("Result: " + response.toString());
        System.out.println("");
        System.out.println("=================================");
        System.out.println("");
    }

    private static void scanShouldContinue(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you want to valide another string? Type 0 for no or 1 for yes then press enter:");
        String shouldContinue = scan.nextLine();

        if (shouldContinue.equals("0")) {
            continueLoop = false;
            return;
        }  else {
            continueLoop = true;
        }

        System.out.println("Do you want to change the language? Type 0 for no or 1 for yes then press enter:");
        String changeLanguage = scan.nextLine();
        System.out.println("");

        if (changeLanguage.equals("1")) {
            chosenLanguage = null;
        }
    }
}