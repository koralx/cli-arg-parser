package com.yetanother;

public class DefaultParser implements CommandLineParser {

    @Override
    public CommandLine parse(Options options, String[] args) {
        CommandLine commandLine = new CommandLine();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i].trim();

            // Пропускаем пустые строки
            if (arg.isEmpty()) continue;

            // Обработка справки
            if (arg.equals("--help")) {
                commandLine.addOption("help");
                printHelp(options);
                return commandLine;
            }

            // Проверка, является ли аргумент опцией
            if (arg.startsWith("-")) {
                Option option = findOption(arg, options);

                if (option != null) {
                    commandLine.addOption(option.getFullArgName());

                    // Обработка значений опций
                    if (option.hasValue() && i + 1 < args.length) {
                        String value = args[i + 1].trim();
                        if (!value.startsWith("-")) { // Проверка, что это значение, а не новая опция
                            commandLine.addOption(option.getFullArgName(), value);
                            i++; // Пропускаем значение
                        }
                    }
                }
            }
        }

        return commandLine;
    }

    // Метод для поиска опции по короткому или полному имени
    private Option findOption(String arg, Options options) {
        for (Option option : options.getOptions()) {
            if (arg.equals("-" + option.getShortArgName()) || arg.equals("--" + option.getFullArgName())) {
                return option;
            }
        }
        return null;
    }

    // Метод для вывода справки
    private void printHelp(Options options) {
        for (Option option : options.getOptions()) {
            String shortArg = "  ";
            String fullArg = option.getFullArgName();
            String desc = option.getDescription();
            if (!option.getShortArgName().isEmpty())  {
                shortArg = "-" + option.getShortArgName();
            }
            if (!fullArg.isEmpty())  {
                fullArg = "--" + fullArg;
            }
            int width = 35;
            //System.out.println(shortArg + " " + fullArg + " : " + option.getDescription());
            System.out.printf("%s %-"+ width + "s %s\r\n", shortArg, fullArg, desc);
        }
    }
}
