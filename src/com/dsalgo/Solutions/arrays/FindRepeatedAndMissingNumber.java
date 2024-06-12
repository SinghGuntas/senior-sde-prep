package com.dsalgo.Solutions.arrays;

import com.dsalgo.Solutions.Solution;

public class FindRepeatedAndMissingNumber extends Solution {

    private final String questionDescription;

    public FindRepeatedAndMissingNumber(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    @Override
    public void run() {
        System.out.println("Running " + this.questionDescription);
        int[] input = {5,1,2,5,3};

        int xr = 0;

        for(int i = 0; i < input.length; i++) {
            xr = xr ^ input[i];
            xr = xr ^ (i + 1);
        }

        int differentiatingLastBitNumber = xr^(xr - 1);

        int zerosGroupXr = 0;
        int onesGroupXr = 0;
        for(int i = 0; i < input.length; i++) {
            if ((input[i] & differentiatingLastBitNumber) == 0) {
                zerosGroupXr ^= input[i];
            } else {
                onesGroupXr ^= input[i];
            }
        }

        for(int i = 1; i <= input.length; i++) {
            if ( (i & differentiatingLastBitNumber) == 0) {
                zerosGroupXr ^= i;
            } else {
                onesGroupXr ^= i;
            }
        }

        int missing = 0, repeated = 0;

        for(int i = 0; i < input.length; i++) {
            if (input[i] == zerosGroupXr) {
                repeated = input[i];
                missing = onesGroupXr;
                break;
            }

            if (input[i] == onesGroupXr) {
                repeated = onesGroupXr;
                missing = zerosGroupXr;
                break;
            }
        }

        System.out.println("Missing " + missing + ". Repeated " + repeated);
    }
}
