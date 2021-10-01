package ru.job4j.design.isp;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, List<UserAction> actions, MemStore rootStore, MemStore currentStore) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            out.println("-------------------------");
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            currentStore.setLst(rootStore.getLst());
            UserAction action = actions.get(select);
            out.println(action.name());
            run = action.execute(input, rootStore, currentStore);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("-------------------------");
        out.println("         Menu");
        out.println("-------------------------");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        MemStore rootStore = new MemStore();
        MemStore currentStore = new MemStore();
        List<UserAction> actions = List.of(
                new AddItem(output),
                new ShowAll(output),
                new DeleteItem(output),
                new SelectItem(output),
                new ExitProgram(output)
        );
        new StartUI(output).init(input, actions, rootStore, currentStore);
    }
}
