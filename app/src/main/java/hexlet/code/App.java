package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "Demo", mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {
@Override
public Integer call() throws Exception {
    return 0;
}


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App ()).execute(args);
        System.exit(exitCode);;
    }
}