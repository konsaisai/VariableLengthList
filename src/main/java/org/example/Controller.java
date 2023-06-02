package org.example;

import org.jetbrains.annotations.NotNull;

public class Controller {
    static boolean equals(@NotNull VariableLengthList source, @NotNull VariableLengthList destination) {
        //return (source.toString().equals(destination.toString()))だと全部の要素を比較してしまい効率が悪い
        if (source.count() != destination.count()) return false;
        for (int i = 0; i < source.count(); i++) {
            if (source.get(i) != destination.get(i)) {
                return false;
            }
        }
        return true;
    }

}
