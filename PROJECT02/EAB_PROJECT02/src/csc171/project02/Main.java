package csc171.project02;

import csc171.project02.view.Cli;

public class Main {

    public static void main(String[] args) {
        Cli cli = Cli.withPopulatedBank();
        cli.interact();
    }
}
