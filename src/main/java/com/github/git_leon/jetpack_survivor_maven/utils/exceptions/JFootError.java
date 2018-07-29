package com.github.git_leon.jetpack_survivor_maven.utils.exceptions;

public class JFootError extends Error {
    public JFootError(Throwable throwable) {
        this(throwable, null);
    }
    public JFootError(Throwable throwable, String errorMessage, Object... args) {
        super(String.format(errorMessage, args), throwable);
    }
}
