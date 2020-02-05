package com.deepak.memorysize;

import java.lang.instrument.Instrumentation;

/**
 * @author - deepak-pt3107
 * @createdOn - 03-02-2020
 */
public class InstrumentationAgent {

    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }

}
