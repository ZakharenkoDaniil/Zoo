package zoo;


public class Main {

    public static void main(String[] argv) {
        CommandLineArgsParser parser = new CommandLineArgsParser(argv);
        try {
            parser.parse();
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        String filePath = parser.getFilePath();
        FileType type = parser.getType();
        // Create zoo
        Zoo zoo = new Zoo();
        // Add animals to the zoo
        if(type.equals(FileType.XML)){
            zoo.addAnimalsByXml(filePath);
        }
        else{
            zoo.addAnimalsByJson(filePath);
        }

        // Create user action trigger
        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
//        trigger.visit(carnivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.watered(herbivore);
        zoo.printAllStates();

        trigger.rain();
        zoo.printAllStates();
    }
}