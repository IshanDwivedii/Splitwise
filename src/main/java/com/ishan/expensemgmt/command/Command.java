package com.ishan.expensemgmt.command;

public interface Command  {
    boolean matches(String input);
    void execute(String input);
}
