package com.buzinasgeekbrains.newcalculator;


import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public enum CalcOperation {
    EMPTY {
        @Override
        public @NotNull String toString() {
            return "";
        }
    },
    PLUS {
        @Override
        public @NotNull String toString() {
            return "+";
        }
    },
    MINUS{
        @Override
        public @NotNull String toString() {
            return "-";
        }
    },
    DIVISION{
        @Override
        public @NotNull String toString() {
            return "/";
        }
    },
    MULTIPLY{
        @Override
        public @NotNull String toString() {
            return "*";
        }
    }
}
