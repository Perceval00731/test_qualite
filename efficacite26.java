package iut.sae.algo;


public class efficacite26{
    public static String RLE(String in){
        // Provide your algo here
        if (in.isEmpty()) {
            return "";
        }
        StringBuilder chaineSortie = new StringBuilder();

        int nbCar = 1;
        int taille = in.length();
        for (int i=1; i<taille; i++) {
            if (in.charAt(i) == in.charAt(i-1)) {
                nbCar++;
                if (nbCar == 9) {
                    chaineSortie.append(nbCar);
                    chaineSortie.append(in.charAt(i-1));
                    nbCar = 0;
                }
            } else {
                chaineSortie.append(nbCar);
                chaineSortie.append(in.charAt(i-1));
                nbCar = 1;
            }
        }
        // Ajout du dernier groupe
        chaineSortie.append(nbCar);
        chaineSortie.append(in.charAt(taille-1));

        return chaineSortie.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        String chaineCompresse = RLE(in);
        for (int i = 1; i < iteration; i++) {
            chaineCompresse = RLE(chaineCompresse);
        }
        return chaineCompresse;
    }

    public static String unRLE(String in) throws AlgoException{
        // Provide your algo here
        if (in.isEmpty()) {
            return "";
        }
        StringBuilder chaineSortie = new StringBuilder();

        int taille = in.length();
        for (int i=1; i < taille; i+=2) {
            int nbCar = Character.getNumericValue(in.charAt(i-1));
            char car = in.charAt(i);

            chaineSortie.append(String.valueOf(car).repeat(nbCar));
        }
        return chaineSortie.toString();

    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        String chaineCompresse = unRLE(in);
        for (int i = 1; i < iteration; i++) {
            chaineCompresse = unRLE(chaineCompresse);
        }
        return chaineCompresse;
    }
}

