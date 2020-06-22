package proj4;
/**
 * CLIENT CLASS
 * Create a new Converter and convert.
 * @author Jordan An
 * @version 05/28/2020
 */

public class Client
{

    public static void main(String[] args)
    {
        Converter c = new Converter("src/proj4/proj4_input.txt");
        c.convert();
    }
}
