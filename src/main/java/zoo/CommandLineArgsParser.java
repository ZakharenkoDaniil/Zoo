package zoo;

public class CommandLineArgsParser {
    private String argv0;
    private String filePath;
    private FileType type;

    CommandLineArgsParser(String[] argv){
        argv0=String.join(" ", argv);
    }

    public void parse() throws IllegalArgumentException{
        String[] args;
        args = argv0.split("-configfile=", 2);
        args = args[1].split(" -configtype=", 2);
        filePath = args[0];
        try{
            if(args[1].equals("XML")){
                type = FileType.XML;
            }
            else if(args[1].equals("JSON")){
                type = FileType.JSON;
            }
            else{
                throw new IllegalArgumentException("Unsupported file format.");
            }
        }catch (IndexOutOfBoundsException ex){
            throw new IllegalArgumentException("Expected file format after file path.");
        }
    }

    String getFilePath(){
        return filePath;
    }

    FileType getType(){
        return type;
    }
}
