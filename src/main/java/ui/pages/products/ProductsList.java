package ui.pages.products;

public enum ProductsList {
    STYLISH_DRESS,
    BLUE_TOP,
    HALF_SLEEVES_TOP_SCHIFFLI_DETAILING_PINK;

    @Override
    public String toString(){
        String[] words = this.name().split("_");
        StringBuilder formatted = new StringBuilder();

        for(int i = 0; i < words.length; i++){
            String word = capitalize(words[i]);

            if(i == words.length - 1 && isColor(word)){
                formatted.append(" - ").append(word);
            } else {
                if (i > 0 && !(i == words.length - 1 && isColor(word))){
                    formatted.append(" ");
                }
                formatted.append(word);
            }
        }
        return formatted.toString();
    }

    private String capitalize(String word){
        word = word.toLowerCase();
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    private boolean isColor(String word){
        String[] colors = {"White", "Pink", "Blue & Pink", "Multi", "Sky Blue", "Blue"};
        for(String color : colors){
            if(color.equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }
}
