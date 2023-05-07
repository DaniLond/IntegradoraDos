package model;

public enum Category {
    BOOKS, ELECTRONICS, CLOTHES_AND_ACCESSORIES, FOOD_AND_DRINKS, STATIONERY, SPORTS, BEAUTY_AND_PERSONALCARE, TOYS_AND_GAMES;

    public int valueCategory(Category category){
        if (category== Category.BOOKS){
            return 0;
        } else if (category == Category.ELECTRONICS) {
            return 1;
        } else if (category == Category.CLOTHES_AND_ACCESSORIES) {
            return 2;
        }else if (category == Category.FOOD_AND_DRINKS){
            return 3;
        } else if (category == Category.STATIONERY) {
            return 4;
        } else if (category == Category.SPORTS) {
            return 5;
        } else if (category== Category.BEAUTY_AND_PERSONALCARE) {
            return 6;
        } else if (category== Category.TOYS_AND_GAMES) {
            return 7;
        }
        return -1;
    }
}
