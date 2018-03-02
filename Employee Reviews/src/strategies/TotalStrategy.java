package strategies;

import rankings.Review;

import java.util.List;

public class TotalStrategy implements IStrategy {


    @Override
    public int getScore(int year, List<Review> reviews) {
        int reviewTotal = 0;

        for (Review review : reviews) {
            if(review.getYear() == year) {
                int[] kpis = review.getKpis();
                for (int i = 0; i < kpis.length; i ++){
                    reviewTotal += kpis[i];
                }
            }
        }
        return reviewTotal;
    }
}
