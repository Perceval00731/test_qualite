package iut.sae.algo;

public class simplicite42 {
    public static String RLE(String in) {
        // Cas chaîne vide
        if (in.length() == 0)
            return "";

        char precedent = in.charAt(0);
        String ResultatCompresser = "";
        int iteration = 1;

        for (int i = 1; i < in.length(); i++) {
            // Cas caractère identique et nb iterations cohérent
            if (in.charAt(i) == precedent && iteration < 9) {
                iteration += 1;
                // Cas caractère différent ou nb itérations max atteint
            } else {
                ResultatCompresser += "" + iteration + precedent;
                iteration = 1;
            }
            // Prépare le caractère précédent pour comparaison
            precedent = in.charAt(i);
        }

        ResultatCompresser += "" + iteration + precedent;
        return ResultatCompresser.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException {
        // Tant qu'il "reste" des itérations, on applique à in RLE (considère les
        // valeurs négatives comme équivalentes à 0)
        while (iteration > 0) {
            in = RLE(in);
            iteration--;
        }
        return in;
    }

    public static String unRLE(String in) throws AlgoException {
        String ResultatDecompresser = "";
        // Les codage fonctionne par pair nombre/char donc on traite paire par paire
        for (int i = 0; i < in.length(); i += 2) {
            // Récupérè la valeur numérique du nombre de la pair
            int count = Character.getNumericValue(in.charAt(i));
            // Et ajoute le caractère de la pair ce nombre de fois au résultat
            for (int j = 0; j < count; j++) {
                ResultatDecompresser += "" + in.charAt(i + 1);
            }
        }
        return ResultatDecompresser.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException {
        // Tant qu'il "reste" des itérations, on applique à in unRLE (considère les
        // valeurs négatives comme équivalentes à 0)
        while (iteration > 0) {
            in = unRLE(in);
            iteration--;
        }
        return in;
    }
}
