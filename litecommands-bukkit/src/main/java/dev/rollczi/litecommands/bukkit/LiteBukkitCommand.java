package dev.rollczi.litecommands.bukkit;

import dev.rollczi.litecommands.LiteInvocation;
import dev.rollczi.litecommands.platform.LiteSenderCreator;
import dev.rollczi.litecommands.scope.ScopeMetaData;
import dev.rollczi.litecommands.platform.Executor;
import dev.rollczi.litecommands.platform.Suggester;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class LiteBukkitCommand extends Command {

    private final ScopeMetaData scope;
    private final Executor executor;
    private final Suggester suggester;
    private final LiteSenderCreator<CommandSender> creator;

    public LiteBukkitCommand(ScopeMetaData scope, Executor executor, Suggester suggester, LiteSenderCreator<CommandSender> creator) {
        super(scope.getName(), "", "/" + scope.getName(), new ArrayList<>(scope.getAliases()));
        this.scope = scope;
        this.executor = executor;
        this.suggester = suggester;
        this.creator = creator;
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        executor.execute(new LiteInvocation(scope.getName(), alias, creator.create(sender), args));
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (Suggester.NONE.equals(suggester)) {
            return super.tabComplete(sender, alias, args);
        }

        return suggester.suggest(new LiteInvocation(scope.getName(), alias, creator.create(sender), args));
    }

}
