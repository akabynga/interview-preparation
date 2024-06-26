package com.akabynga.patterns.state.gumballstate;

class WinnerState implements State {
    private final GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");
    }

    public void ejectQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");
    }

    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball!");
    }

    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(StateType.SOLD_OUT);
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(StateType.NO_QUARTER);
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(StateType.SOLD_OUT);
            }
        }
    }

    public String toString() {
        return "dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
    }
}
