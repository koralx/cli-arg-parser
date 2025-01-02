package com.koral;

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
            System.out.println("-" + option.getShortArgName() + " --" + option.getFullArgName() + " : " + option.getDescription());
        }
    }
}
