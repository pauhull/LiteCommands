package dev.rollczi.litecommands.contextual;

import dev.rollczi.litecommands.command.Invocation;
import panda.std.Result;

@FunctionalInterface
public interface Contextual<SENDER, T> {

    Result<T, ?> extract(SENDER sender, Invocation<SENDER> invocation);

}
