package core;

import java.util.HashMap;
import java.util.Map;

public class ArtManager {

    // The dictionary that maps a character's name to their ASCII art
    private static final Map<String, String> gallery = new HashMap<>();

    static {
        gallery.put("BlackJack In Wonderlands",
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" +
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" +
                "$$$                                                                    $$$ \n" +
                "$$$      $$$$$  $$     $$$   $$$$ $$ $$    $$$  $$$   $$$$ $$ $$       $$$ \n" +
                "$$$      $$  $$ $$    $$ $$ $$    $$$$      $$ $$ $$ $$    $$$$        $$$ \n" +
                "$$$      $$$$$  $$    $$$$$ $$    $$$       $$ $$$$$ $$    $$$         $$$ \n" +
                "$$$      $$  $$ $$    $$ $$ $$    $$$$  $$  $$ $$ $$ $$    $$$$        $$$ \n" +
                "$$$      $$$$$  $$$$$ $$ $$  $$$$ $$ $$  $$$$  $$ $$  $$$$ $$ $$       $$$ \n" +
                "$$$                                                                    $$$ \n" +
                "$$$                         ~ IN WONDERLANDS ~                         $$$ \n" +
                "$$$                                                                    $$$ \n" +
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" +
                "\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\" \n"
);

        gallery.put("The Mad Hatter",
                        " ,------------.                ,.--\"\"-._ \n" +
                        " |   Blackjack `.            __/         `. \n" +
                        " |      in       |      _,**\"   \"*-.        `. \n" +
                        " |  Wonderland   |   ,'            `.        \\ \n" +
                        " `---------------'  ;    _,.---._    \\  ,'\\  \\ \n" +
                        "                    :   ,'   ,-.. `.   \\'   \\ : \n" +
                        "  The Mad Hatter   |  ;_\\  (___)`  `-..__  : | \n" +
                        "                   ;-'`*'\"  `*'    `--._ ` | ; \n" +
                        "                  /,-'/  -.        `---.`  |\" \n" +
                        "                  /_,'`--='.        `-.._,-\" _ \n" +
                        "                   (/\\\\,--. \\    ___-.`:   //___ \n" +
                        "                      /\\'''\\ '  |   |-`|  ( -__,' \n" +
                        "                     '. `--'    ;   ;  ; ;/_/ \n" +
                        "                       `. `.__,/   /_,' /`.~; \n" +
                        "                       _.-._|_/_,'.____/   / \n" +
                        "                  ..--\" /  =/  \\=  \\      / \n" +
                        "                 /  ;._.\\_.-`--'-._/ ____/ \n" +
                        "                 \\ /   /._/|.\\      .\" \n" +
                        "                  `*--'._ \"-.:     : \n" +
                        "                       |   |.  `.  : \n" +
                        "                       ;   |.    `. \\ \n"
        );

        gallery.put("The Cheshire Cat",
                        "  ,------------.                 .'\\   /`. \n" +
                        "  |   Blackjack `.             .'.-.`-'.-.`. \n" +
                        "  |      in       |       ..._:   .-. .-.   :_... \n" +
                        "  |  Wonderland   |     .'    '-.(o ) (o ).-'    `. \n" +
                        "  `---------------'    :  _    _ _`~(_)~`_ _    _  : \n" +
                        "                      :  /:   ' .-=_   _=-. `   ;\\  : \n" +
                        "  The Mad Hatter      :   :|-.._  '     `  _..-|:   : \n" +
                        "                       :   `:| |`:-:-.-:-:'| |:'   : \n" +
                        "                        `.   `.| | | | | | |.'   .' \n" +
                        "                          `.   `-:_| | |_:-'   .' \n" +
                        "                            `-._   ````    _.-' \n" +
                        "                               ``-------'' \n"
        );


        gallery.put("Queen of Hearts",
                        " ,------------.              o\n" +
                        " |   Blackjack `.          o^\\^o\n" +
                        " |      in       |    o\\*`'.\\|/.'`*/o\n" +
                        " |  Wonderland   |     \\\\\\\\\\\\|//////\n" +
                        " `---------------'      {><><@><><}\n" +
                        "                       }}} _   _ {{{\n" +
                        "  Queen of Hearts    }}}}  6   6  {{{\n" +
                        "                    {{{{{    ^    }}}}}\n" +
                        "                   {{{{{{\\  -=-  /}}}}}}\n" +
                        "                   {{{{{{{;.___.;}}}}}}}\n" +
                        "                    {{{{{{{)   (}}}}}}}'\n" +
                        "                     `\"\"'\"':   :'\"'\"'`\n" +
                        "                            `@`\n" +
                        "------------------------------------------------\n"
        );
    }

    /**
     * Retrieves the ASCII art for a given character name.
     * @param name The exact name of the character (e.g., "Mad Hatter").
     * @return The ASCII string, or a placeholder if not found.
     */
    public static String getArt(String name) {
        // We ask the gallery to get the art for 'name'.
        // If 'name' doesn't exist, it returns the default error string.
        return gallery.getOrDefault(name, "\n[ NO ART FOUND FOR " + name + " ]\n");
    }
}