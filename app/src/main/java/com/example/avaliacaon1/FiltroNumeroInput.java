package com.example.avaliacaon1;

import android.text.InputFilter;
import android.text.Spanned;

public class FiltroNumeroInput implements InputFilter {

    private int minValue;
    private int maxValue;

    public FiltroNumeroInput() {
        this.minValue = Integer.MIN_VALUE;
        this.maxValue = Integer.MAX_VALUE;
    }

    public FiltroNumeroInput(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {

            String inputText = dest.subSequence(0, dstart) + source.toString() + dest.subSequence(dend, dest.length());

            int value = Integer.parseInt(inputText);
            if (value >= minValue && value <= maxValue) {
                return null;
            }
        } catch (NumberFormatException ignored) {
        }

        return "";
    }
}
