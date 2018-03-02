package strategies;

import rankings.Review;

import java.util.List;

public class WeightedStrategy implements IStrategy{
    @Override
    public int getScore(int year, List<Review> reviews) {
        int reviewTotal = 0;

        for (Review review : reviews) {
            if(review.getYear() == year) {
                int[] kpis = review.getKpis();
                for (int i = 0; i < kpis.length; i ++){

                    if(i == 1){
                        reviewTotal += kpis[i] * 2;
                    }else if(i == 3){
                        reviewTotal += kpis[i] * 3;
                    }else{
                        reviewTotal += kpis[i];
                    }
                }
            }
        }
        return reviewTotal;
    }
}
