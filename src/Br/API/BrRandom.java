/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Bryan_lzh
 */
public class BrRandom {

    Random R;
    //        数字   权重
    HashMap<Integer, Integer> Weights;
    int MAX;

    public BrRandom() {
        this.R = new Random();
        this.Weights = new HashMap<>();
        this.MAX = 0;
    }

    //                       数字    权重
    public void setWeights(int i, int weight) {
        if (this.Weights.containsKey(i)) {
            this.Weights.remove(i);
        }
        this.Weights.put(i, weight);
        WeightsLoad();
    }

    private void WeightsLoad() {
        this.MAX = 0;
        for(Integer in : this.Weights.keySet()){
            int v = this.Weights.get(in);
            this.MAX += v;
            
        }
    }

    public int Random() {
        int result = this.R.nextInt(this.MAX) + 1;
        return 0;
    }
}
