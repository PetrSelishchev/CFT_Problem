
package cft.internship.selishchev.parserCLI;

import cft.internship.selishchev.options.Options;


public interface ParserCLI {
    Options parseCommandLine(String[] commandLine);
}

