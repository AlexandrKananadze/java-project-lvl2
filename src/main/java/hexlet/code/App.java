package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference",
        mixinStandardHelpOptions = true)

public final class App implements Callable<String> {
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    // Option(names = {"-v", "--verbose"}, description = "version")
    // boolean verbose;

    public static void main(String[] args) {
        final var commandLineRunner = new CommandLine(new App());
        commandLineRunner.execute(args);
    }

    @Override
    public String call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return Differ.generate(filepath1, filepath2, format);
    }
//  ./build/install/app/bin/app --format plain src/test/resources/file1.yaml src/test/resources/file2.yaml
    // ./build/install/app/bin/app src/test/resources/Recursive1.yaml src/test/resources/Recursive2.yaml
    // ./build/install/app/bin/app src/test/resources/Recursive1.json src/test/resources/Recursive2.json
    //./build/install/app/bin/app  -f plain  src/test/resources/file1.yaml src/test/resources/file2.yaml

}
